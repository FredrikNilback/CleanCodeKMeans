package View;

import java.awt.Color;

public class ColorSelector {

    public static Color getColor(int color) {

        switch (color) {
            case MyColors.BLACK:
                return new Color(0,0,0);
            case MyColors.WHITE:
                return new Color(255,255,255);
            case MyColors.RED:
                return new Color(255,0,0);
            case MyColors.GREEN:
                return new Color(0,255,0);
            case MyColors.BLUE:
                return new Color(0,0,255);
            default:
                return new Color(0,0,0);
        }
    }

    public static class MyColors {

        public static final int BLACK = 0;
        public static final int WHITE = 1;
        public static final int RED = 2;
        public static final int GREEN = 3;
        public static final int BLUE = 4;
    }
}
