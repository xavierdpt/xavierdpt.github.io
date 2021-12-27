package pm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    private final BookCode code;
    private final String title;
    private final String path;
    private final List<Section> sections = new ArrayList<>();

    public Book(BookCode code, String title, String path) {
        this.code = code;
        this.title = title;
        this.path = path;
    }

    public BookCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public Book sections(Section... sections) {
        for (Section section : sections) {
            if (section != null) {
                this.sections.add(section);
            }
        }
        return this;
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }
}
