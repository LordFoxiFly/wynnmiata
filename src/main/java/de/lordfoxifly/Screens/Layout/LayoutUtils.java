package de.lordfoxifly.Screens.Layout;

public class LayoutUtils {

    /**
     * Returns the smaller Y.
     * @param y1
     * @param y2
     * @return
     */
    public static int getY(int y1, int y2){
        if (y1 < y2){
            return y1;
        }
        return y2;
    }

    /**
     * Returns the smaller X
     * @param x1
     * @param x2
     * @return
     */
    public static int getX(int x1, int x2){
        if (x1 < x2){
            return x1;
        }
        return x2;
    }

    public static int getWitdh(int x, int x1, int x2, int defaultwidth) {
        if (x1 < x2){
            return  x + defaultwidth  + (x2 - x1);
        }
        return x + defaultwidth + (x1 - x2);
    }

    public static int getHeight(int y, int y1, int y2, int defaultheight) {
        if (y1 < y2){
            return y + defaultheight  + (y2 - y1);
        }
        return y + defaultheight + (y1 - y2);
    }
}
