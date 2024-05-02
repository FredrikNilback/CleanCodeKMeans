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
            case MyColors.PINK:
                return new Color(255, 20, 147);
            case MyColors.YELLOW:
                return new Color(255, 255, 0);
            case MyColors.ORANGE:
                return new Color(255, 140, 0);
            case MyColors.PURPLE:
                return new Color(128, 0, 128);
            case MyColors.CYAN:
                return new Color(0, 255, 255);
            default:
                return new Color(0,0,0);
        }
    }

    public static String getColorName(int color) {

        switch (color) {
            case MyColors.BLACK:
                return "Black";
            case MyColors.WHITE:
                return "White";
            case MyColors.RED:
                return "Red";
            case MyColors.GREEN:
                return "Green";
            case MyColors.BLUE:
                return "Blue";
            case MyColors.PINK:
                return "Pink";
            case MyColors.YELLOW:
                return "Yellow";
            case MyColors.ORANGE:
                return "Orange";
            case MyColors.PURPLE:
                return "Purple";
            case MyColors.CYAN:
                return "Cyan";
            default:
                return "8th color of the rainbow!";
        }
    }

    public static class MyColors {

        public static final int WHITE = 0;
        public static final int BLACK = 1;
        public static final int RED = 2;
        public static final int GREEN = 3;
        public static final int BLUE = 4;
        public static final int PINK = 5;
        public static final int YELLOW = 6;
        public static final int ORANGE = 7;
        public static final int PURPLE = 8;
        public static final int CYAN = 9;
    }
}
