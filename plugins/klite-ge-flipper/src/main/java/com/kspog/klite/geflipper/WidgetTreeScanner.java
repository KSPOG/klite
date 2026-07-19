package com.kspog.klite.geflipper;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import net.runelite.client.plugins.klite.api.KLiteInterfaceSnapshot;
import net.runelite.client.plugins.klite.api.KLiteWidgetAction;
import net.runelite.client.plugins.klite.api.KLiteWidgetSnapshot;
import net.runelite.client.plugins.klite.automation.AutomationContext;

final class WidgetTreeScanner
{
    private static final Duration CLIENT_TIMEOUT = Duration.ofSeconds(2);
    private static final int MAX_DEPTH = 8;
    private static final int MAX_WIDGETS = 400;

    private WidgetTreeScanner()
    {
    }

    static List<KLiteWidgetSnapshot> scan(AutomationContext context) throws Exception
    {
        KLiteInterfaceSnapshot rootSnapshot = context.await(
            context.client().interfaceSnapshot(), CLIENT_TIMEOUT);

        List<KLiteWidgetSnapshot> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        Set<Integer> expanded = new HashSet<>();

        for (KLiteWidgetSnapshot root : rootSnapshot.getRoots())
        {
            queue.add(new Node(root, 0));
        }

        while (!queue.isEmpty() && result.size() < MAX_WIDGETS)
        {
            Node node = queue.remove();
            KLiteWidgetSnapshot widget = node.widget;
            result.add(widget);

            if (node.depth >= MAX_DEPTH || !expanded.add(widget.getComponentId()))
            {
                continue;
            }

            List<KLiteWidgetSnapshot> children;
            try
            {
                children = context.await(
                    context.client().widgetChildren(widget.getComponentId()), CLIENT_TIMEOUT);
            }
            catch (Exception ignored)
            {
                continue;
            }

            for (KLiteWidgetSnapshot child : children)
            {
                queue.add(new Node(child, node.depth + 1));
            }
        }

        return result;
    }

    static KLiteWidgetSnapshot findText(List<KLiteWidgetSnapshot> widgets, String needle)
    {
        String wanted = needle.toLowerCase(Locale.ROOT);
        for (KLiteWidgetSnapshot widget : widgets)
        {
            String text = widget.getText();
            if (!widget.isHidden() && text != null && text.toLowerCase(Locale.ROOT).contains(wanted))
            {
                return widget;
            }
        }
        return null;
    }

    static KLiteWidgetSnapshot findAction(List<KLiteWidgetSnapshot> widgets, String option)
    {
        for (KLiteWidgetSnapshot widget : widgets)
        {
            if (widget.isHidden())
            {
                continue;
            }
            for (KLiteWidgetAction action : widget.getActions())
            {
                if (option.equalsIgnoreCase(action.getOption()))
                {
                    return widget;
                }
            }
        }
        return null;
    }

    private static final class Node
    {
        private final KLiteWidgetSnapshot widget;
        private final int depth;

        private Node(KLiteWidgetSnapshot widget, int depth)
        {
            this.widget = widget;
            this.depth = depth;
        }
    }
}
