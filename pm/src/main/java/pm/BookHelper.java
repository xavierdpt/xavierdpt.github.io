package pm;

import java.util.List;
import java.util.Objects;

public class BookHelper {
    public static Book getBook(List<Book> books, BookCode bookCode) {
        for (Book book : books) {
            if (Objects.equals(bookCode, book.getCode())) {
                return book;
            }
        }
        return null;
    }
}
