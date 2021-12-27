package pm;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonPropertyOrder({"title","intro","sections"})
public class Section {

    private final String title;
    private final List<Section> sections = new ArrayList<>();
    private String intro;

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Section sections(Section... sections) {
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

    public Section intro(String intro) {
        this.intro = intro;
        return this;
    }

    public String getIntro() {
        return intro;
    }
}
