package trove;

public class Book {
    private final String title;
    private final String editor;
    private final String isbn13;
    private final String isbn10;

    public Book(String title, String editor, String isbn13, String isbn10) {
        this.title = title;
        this.editor = editor;
        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
    }

    public String getTitle() {
        return title;
    }

    public String getEditor() {
        return editor;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }
}
