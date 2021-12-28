package pm;

import java.io.IOException;
import java.util.List;

public class M {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<Book> books = Library.initBooks();
        Book book = BookHelper.getBook(books, BookCode.PMBOK_GUIDE);
//        Commands.openBook(book);
        Commands.dumpState(books);
        int columns = Integer.parseInt(System.getenv("COLUMNS"));
        int lines = Integer.parseInt(System.getenv("LINES"));
        ASCII.hideCursor();
        ASCII.clearScreen();
        ASCII.moveTo(columns / 2, lines / 2);
        for (String s : "hello".split("")) {
            System.out.print(s);
            Thread.sleep(300);
        }


        for (int i = 0; i < 200; ++i) {
            for (int y = 0; y <= lines; ++y) {
                ASCII.moveTo(0, y);
                for (int x = 0; x <= columns; ++x) {
                    System.out.print((x + y) % 2 == 0 ? (i % 2 == 0 ? "-" : "+") : " ");
                }
            }
            Thread.sleep(100);
        }
        ASCII.moveTo(0, lines);
        ASCII.showCursor();
    }
}
