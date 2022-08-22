package trove;

public class YoutubeLink {
    private final String videoId;
    private final String title;

    public YoutubeLink(String videoId, String title) {

        this.videoId = videoId;
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }
}
