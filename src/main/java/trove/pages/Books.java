package trove.pages;

import trove.Book;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Books extends Page {

    private List<Book> books = new ArrayList<>();

    public Books() {
        super("books", "Books");
        addBook("Managing Successful Projects with PRINCE2", "Stationery Office Books", "978-0113315338", "0113315333");
    }

    private void addBook(String title, String editor, String isbn13, String isbn10) {
        books.add(new Book(title, editor, isbn13, isbn10));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {
        startRender(renderContext, List.of());
        pw.println("<ul>");
        books.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(book -> {
                    pw.println("<li>" + book.getTitle());
            pw.println("<ul>");
            pw.println("</ul>");
                    pw.println("</li>");
                }
        );
        pw.println("</ul>");
        finishRender(List.of());
    }
}
