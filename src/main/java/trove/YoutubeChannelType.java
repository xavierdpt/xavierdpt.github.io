package trove;

public enum YoutubeChannelType {
    C("c"), CHANNEL("channel"), USER("user");

    private final String urlPart;

    YoutubeChannelType(String urlPart) {
        this.urlPart = urlPart;
    }

    public String getUrlPart() {
        return urlPart;
    }
}
