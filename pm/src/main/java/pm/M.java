package pm;

import java.io.IOException;
import java.util.List;

public class M {
    public static void main(String[] args) throws IOException {

        List<Book> books = Library.initBooks();
        Book book = BookHelper.getBook(books, BookCode.PMBOK_GUIDE);
//        Commands.openBook(book);
        Commands.dumpState(books);
    }
}
