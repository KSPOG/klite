package com.kspog.klite.geflipper;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Delivers virtual key events directly to the key listeners registered on the
 * live KLite game canvas.
 *
 * <p>This does not use {@code Robot}, does not press the user's physical
 * keyboard, and does not require the KLite window to own operating-system
 * keyboard focus. The event sequence mirrors Microbot's proven keyboard path:
 * KEY_PRESSED, KEY_TYPED for printable keys, then KEY_RELEASED.</p>
 */
final class VirtualKeyboardBridge
{
    void pressEnter()
    {
        press(locateCanvas(), KeyEvent.VK_ENTER, '\n');
    }

    int pressEnter(Canvas canvas)
    {
        return press(requireCanvas(canvas), KeyEvent.VK_ENTER, '\n');
    }

    void pressEscape()
    {
        press(locateCanvas(), KeyEvent.VK_ESCAPE, (char) 27);
    }

    private static int press(Canvas canvas, int keyCode, char typedChar)
    {
        long when = System.currentTimeMillis();

        dispatchToListeners(canvas, new KeyEvent(
            canvas,
            KeyEvent.KEY_PRESSED,
            when,
            0,
            keyCode,
            typedChar));

        if (typedChar != KeyEvent.CHAR_UNDEFINED)
        {
            dispatchToListeners(canvas, new KeyEvent(
                canvas,
                KeyEvent.KEY_TYPED,
                when + 1L,
                0,
                KeyEvent.VK_UNDEFINED,
                typedChar));
        }

        dispatchToListeners(canvas, new KeyEvent(
            canvas,
            KeyEvent.KEY_RELEASED,
            when + 2L,
            0,
            keyCode,
            KeyEvent.CHAR_UNDEFINED));

        if (keyCode == KeyEvent.VK_ENTER)
        {
            dispatchToListeners(canvas, new KeyEvent(
                canvas,
                KeyEvent.KEY_TYPED,
                when + 10L,
                0,
                KeyEvent.VK_UNDEFINED,
                '\n'));
        }

        return canvas.getKeyListeners().length;
    }

    private static void dispatchToListeners(Canvas canvas, KeyEvent event)
    {
        for (KeyListener listener : canvas.getKeyListeners())
        {
            switch (event.getID())
            {
                case KeyEvent.KEY_PRESSED:
                    listener.keyPressed(event);
                    break;
                case KeyEvent.KEY_TYPED:
                    listener.keyTyped(event);
                    break;
                case KeyEvent.KEY_RELEASED:
                    listener.keyReleased(event);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Unsupported virtual key event type: " + event.getID());
            }
        }
    }

    private static Canvas requireCanvas(Canvas canvas)
    {
        if (canvas == null)
        {
            throw new IllegalStateException(
                "Flipping Copilot did not expose the live game canvas");
        }
        return canvas;
    }

    private static Canvas locateCanvas()
    {
        List<Canvas> candidates = new ArrayList<>();
        for (Window window : Window.getWindows())
        {
            if (window != null && window.isShowing())
            {
                collectCanvases(window, candidates);
            }
        }

        return candidates.stream()
            .filter(Component::isShowing)
            .max(Comparator.comparingLong(VirtualKeyboardBridge::area))
            .orElseThrow(() -> new IllegalStateException(
                "No visible KLite game canvas was found"));
    }

    private static void collectCanvases(Component component, List<Canvas> result)
    {
        if (component instanceof Canvas)
        {
            result.add((Canvas) component);
        }

        if (component instanceof Container)
        {
            for (Component child : ((Container) component).getComponents())
            {
                collectCanvases(child, result);
            }
        }
    }

    private static long area(Component component)
    {
        Dimension size = component.getSize();
        return (long) Math.max(0, size.width) * Math.max(0, size.height);
    }
}
