package de.lordfoxifly.WynnMiataUtils;

public class ColorUtils {
    public static int rgbToARGB(int r, int g, int b) {
        return (r << 16) | (g << 8) | b;
    }

    public static Integer hexstringToInt(String hexString){

        return Integer.parseInt(hexString,16);
    }

    /**
     * Gets the RGB Values of String
     * @param hexString
     * @return
     */
    public static int[] hexStringToRGB(String hexString){
        if (hexString.length() != 6) {
            throw new IllegalArgumentException("Invalid hex string length");
        }

        // Convert hex string to RGB array
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            String hexPart = hexString.substring(i * 2, (i + 1) * 2);
            rgb[i] = Integer.parseInt(hexPart, 16);
        }

        return rgb;
    }

    /**
     * Gets the Red Value of a Hex String
     * @param hexString
     * @return
     */
    public static int hexStringToRed(String hexString){
        return Integer.parseInt(hexString.substring(0, 2), 16);
    }
    /**
     * Gets the Green Value of a Hex String
     * @param hexString
     * @return
     */
    public static int hexStringToGreen(String hexString){
        return Integer.parseInt(hexString.substring(2, 4), 16);
    }
    /**
     * Gets the Blue Value of a Hex String
     * @param hexString
     * @return
     */
    public static int hexStringToBlue(String hexString){
        return Integer.parseInt(hexString.substring(4, 6), 16);
    }
}
