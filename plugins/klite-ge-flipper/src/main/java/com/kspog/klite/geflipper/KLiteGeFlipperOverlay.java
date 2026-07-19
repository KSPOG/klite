package com.kspog.klite.geflipper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Locale;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

final class KLiteGeFlipperOverlay extends Overlay
{
    private static final Dimension FALLBACK_SIZE = new Dimension(186, 260);
    private static final Color OUTER_BORDER = new Color(18, 15, 8, 245);
    private static final Color INNER_BORDER = new Color(151, 126, 55, 235);
    private static final Color PANEL_TOP = new Color(82, 72, 32, 244);
    private static final Color PANEL_BOTTOM = new Color(56, 50, 25, 244);
    private static final Color LABEL_COLOR = new Color(255, 190, 55);
    private static final Color VALUE_COLOR = new Color(255, 255, 255);
    private static final Color POSITIVE_COLOR = new Color(80, 255, 110);
    private static final Color NEGATIVE_COLOR = new Color(255, 85, 70);
    private static final Color NEUTRAL_COLOR = new Color(235, 220, 170);

    private final KLiteGeFlipperPlugin plugin;

    KLiteGeFlipperOverlay(KLiteGeFlipperPlugin plugin)
    {
        super(plugin);
        this.plugin = plugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(PRIORITY_HIGHEST);
        setMovable(false);
        setSnappable(false);
        setResizable(false);
        setPreferredSize(FALLBACK_SIZE);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        Rectangle inventory = plugin.overlayInventoryBounds();
        Dimension size = inventory == null
            ? FALLBACK_SIZE
            : new Dimension(inventory.width, inventory.height);

        if (inventory != null)
        {
            setPreferredLocation(new Point(inventory.x, inventory.y));
        }
        setPreferredSize(size);

        int width = Math.max(150, size.width);
        int height = Math.max(210, size.height);
        drawInventoryPanel(graphics, width, height);
        return new Dimension(width, height);
    }

    private void drawInventoryPanel(Graphics2D graphics, int width, int height)
    {
        graphics.setColor(PANEL_BOTTOM);
        graphics.fillRect(0, 0, width, height);

        int split = Math.max(1, height / 2);
        for (int y = 0; y < split; y++)
        {
            float ratio = y / (float) split;
            graphics.setColor(blend(PANEL_TOP, PANEL_BOTTOM, ratio));
            graphics.drawLine(1, y + 1, width - 2, y + 1);
        }

        graphics.setColor(new Color(255, 255, 255, 8));
        for (int y = 9; y < height; y += 12)
        {
            graphics.drawLine(3, y, width - 4, y);
        }
        graphics.setColor(new Color(0, 0, 0, 12));
        for (int x = 10; x < width; x += 18)
        {
            graphics.drawLine(x, 3, x - 7, height - 4);
        }

        graphics.setColor(OUTER_BORDER);
        graphics.drawRect(0, 0, width - 1, height - 1);
        graphics.drawRect(1, 1, width - 3, height - 3);
        graphics.setColor(INNER_BORDER);
        graphics.drawRect(3, 3, width - 7, height - 7);
        graphics.setColor(new Color(15, 12, 6, 210));
        graphics.drawRect(4, 4, width - 9, height - 9);

        Font titleFont = FontManager.getRunescapeBoldFont();
        Font textFont = FontManager.getRunescapeSmallFont();
        graphics.setFont(titleFont);
        drawCenteredShadowed(graphics, "KLite GE Flipper", width / 2, 22, LABEL_COLOR);

        graphics.setColor(new Color(15, 12, 6, 210));
        graphics.drawLine(8, 31, width - 9, 31);
        graphics.setColor(INNER_BORDER);
        graphics.drawLine(8, 32, width - 9, 32);

        graphics.setFont(textFont);
        drawRow(graphics, width, 54, "Run Time:", formatRuntime(plugin.overlayRuntimeMillis()), VALUE_COLOR);

        long profit = plugin.overlayProfitGp();
        drawRow(graphics, width, 78, "Profit:", formatGp(profit), valueColor(profit));

        long profitPerHour = plugin.overlayProfitPerHour();
        drawRow(graphics, width, 102, "Profit p/h:", formatGp(profitPerHour), valueColor(profitPerHour));

        drawCenteredShadowed(graphics, "Most profitable flip:", width / 2, 131, LABEL_COLOR);
        drawCenteredFitted(
            graphics,
            plugin.overlayMostProfitableFlip(),
            width / 2,
            151,
            width - 18,
            NEUTRAL_COLOR);

        graphics.setColor(new Color(15, 12, 6, 180));
        graphics.drawLine(8, 166, width - 9, 166);
        graphics.setColor(INNER_BORDER);
        graphics.drawLine(8, 167, width - 9, 167);

        drawCenteredShadowed(graphics, "Status:", width / 2, 187, LABEL_COLOR);
        drawCenteredWrapped(
            graphics,
            plugin.overlayStatus(),
            width / 2,
            205,
            width - 18,
            statusColor(plugin.overlayStatus(), plugin.overlayRunning()));

        if (height >= 245)
        {
            drawCenteredShadowed(
                graphics,
                "Realized profit - completed flips",
                width / 2,
                height - 14,
                new Color(190, 175, 125));
        }
    }

    private static void drawRow(
        Graphics2D graphics,
        int width,
        int baseline,
        String label,
        String value,
        Color valueColor)
    {
        drawShadowed(graphics, label, 10, baseline, LABEL_COLOR);
        FontMetrics metrics = graphics.getFontMetrics();
        String fitted = fitText(value, width - 86, metrics);
        int valueX = width - 10 - metrics.stringWidth(fitted);
        drawShadowed(graphics, fitted, Math.max(82, valueX), baseline, valueColor);
    }

    private static void drawCenteredWrapped(
        Graphics2D graphics,
        String text,
        int centerX,
        int firstBaseline,
        int maximumWidth,
        Color color)
    {
        FontMetrics metrics = graphics.getFontMetrics();
        String value = text == null || text.trim().isEmpty() ? "-" : text.trim();

        if (metrics.stringWidth(value) <= maximumWidth)
        {
            drawCenteredShadowed(graphics, value, centerX, firstBaseline, color);
            return;
        }

        String[] words = value.split("\\s+");
        StringBuilder first = new StringBuilder();
        int consumed = 0;
        for (; consumed < words.length; consumed++)
        {
            String candidate = first.length() == 0
                ? words[consumed]
                : first + " " + words[consumed];
            if (metrics.stringWidth(candidate) > maximumWidth)
            {
                break;
            }
            first.setLength(0);
            first.append(candidate);
        }

        if (first.length() == 0)
        {
            first.append(fitText(value, maximumWidth, metrics));
            consumed = words.length;
        }

        StringBuilder second = new StringBuilder();
        for (int index = consumed; index < words.length; index++)
        {
            if (second.length() > 0)
            {
                second.append(' ');
            }
            second.append(words[index]);
        }

        drawCenteredShadowed(graphics, first.toString(), centerX, firstBaseline, color);
        if (second.length() > 0)
        {
            drawCenteredShadowed(
                graphics,
                fitText(second.toString(), maximumWidth, metrics),
                centerX,
                firstBaseline + 15,
                color);
        }
    }

    private static void drawCenteredFitted(
        Graphics2D graphics,
        String text,
        int centerX,
        int baseline,
        int maximumWidth,
        Color color)
    {
        FontMetrics metrics = graphics.getFontMetrics();
        String fitted = fitText(text == null ? "-" : text, maximumWidth, metrics);
        drawCenteredShadowed(graphics, fitted, centerX, baseline, color);
    }

    private static void drawCenteredShadowed(
        Graphics2D graphics,
        String text,
        int centerX,
        int baseline,
        Color color)
    {
        FontMetrics metrics = graphics.getFontMetrics();
        int x = centerX - metrics.stringWidth(text) / 2;
        drawShadowed(graphics, text, x, baseline, color);
    }

    private static void drawShadowed(
        Graphics2D graphics,
        String text,
        int x,
        int baseline,
        Color color)
    {
        graphics.setColor(new Color(0, 0, 0, 220));
        graphics.drawString(text, x + 1, baseline + 1);
        graphics.setColor(color);
        graphics.drawString(text, x, baseline);
    }

    private static String fitText(String text, int maximumWidth, FontMetrics metrics)
    {
        if (text == null || text.trim().isEmpty())
        {
            return "-";
        }
        String value = text.trim();
        if (metrics.stringWidth(value) <= maximumWidth)
        {
            return value;
        }

        String suffix = "...";
        while (!value.isEmpty()
            && metrics.stringWidth(value + suffix) > maximumWidth)
        {
            value = value.substring(0, value.length() - 1);
        }
        return value + suffix;
    }

    private static String formatRuntime(long millis)
    {
        long totalSeconds = Math.max(0L, millis / 1_000L);
        long hours = totalSeconds / 3_600L;
        long minutes = (totalSeconds % 3_600L) / 60L;
        long seconds = totalSeconds % 60L;
        return hours > 0L
            ? String.format("%d:%02d:%02d", hours, minutes, seconds)
            : String.format("%02d:%02d", minutes, seconds);
    }

    private static String formatGp(long value)
    {
        String amount = String.format(Locale.US, "%,d", Math.abs(value));
        return (value >= 0L ? "+" : "-") + amount + " gp";
    }

    private static Color statusColor(String status, boolean running)
    {
        if (!running)
        {
            return NEUTRAL_COLOR;
        }

        String value = status == null ? "" : status.toLowerCase(Locale.ROOT);
        if (value.contains("unable")
            || value.contains("not found")
            || value.contains("no coins")
            || value.contains("not installed"))
        {
            return NEGATIVE_COLOR;
        }
        if (value.contains("waiting")
            || value.contains("walking")
            || value.contains("opening")
            || value.contains("checking")
            || value.contains("recovering"))
        {
            return LABEL_COLOR;
        }
        if (value.contains("setting")
            || value.contains("applying")
            || value.contains("selecting")
            || value.contains("confirming")
            || value.contains("modifying")
            || value.contains("aborting"))
        {
            return new Color(100, 220, 255);
        }
        return POSITIVE_COLOR;
    }

    private static Color valueColor(long value)
    {
        if (value > 0L)
        {
            return POSITIVE_COLOR;
        }
        if (value < 0L)
        {
            return NEGATIVE_COLOR;
        }
        return VALUE_COLOR;
    }

    private static Color blend(Color first, Color second, float ratio)
    {
        float clamped = Math.max(0f, Math.min(1f, ratio));
        int red = Math.round(first.getRed() + (second.getRed() - first.getRed()) * clamped);
        int green = Math.round(first.getGreen() + (second.getGreen() - first.getGreen()) * clamped);
        int blue = Math.round(first.getBlue() + (second.getBlue() - first.getBlue()) * clamped);
        int alpha = Math.round(first.getAlpha() + (second.getAlpha() - first.getAlpha()) * clamped);
        return new Color(red, green, blue, alpha);
    }
}
