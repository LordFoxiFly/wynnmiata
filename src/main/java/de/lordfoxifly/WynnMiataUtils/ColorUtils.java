package de.lordfoxifly.WynnMiataUtils;

public class ColorUtils {
    public static int rgbToARGB(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }
}