package trove;

public class MusicLink {
    private final String author;
    private final String title;
    private final String youtubeId;

    public MusicLink(String author, String title, String youtubeId) {
        this.author = author;
        this.title = title;
        this.youtubeId = youtubeId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getYoutubeId() {
        return youtubeId;
    }
}
