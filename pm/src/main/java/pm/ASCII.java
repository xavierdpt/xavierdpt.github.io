package pm;

public class ASCII {
    public static final String BACKSPACE = "\u0008";
    public static final String ESCAPE = "\u001b";
    public static final String CLEAR_SCREEN = ESCAPE + "[2J";

    public static void moveTo(int column, int line) {
        System.out.print(ESCAPE + "[" + line + ";" + column + "H");
    }

    public static void clearScreen() {
        System.out.print(CLEAR_SCREEN);
    }


    public static void hideCursor() {
        System.out.print(ESCAPE+"[?25l");
    }

    public static void showCursor() {
        System.out.print(ESCAPE+"[?12;25h");
    }
}
