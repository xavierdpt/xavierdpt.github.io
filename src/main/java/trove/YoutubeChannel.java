package trove;

import java.util.Objects;

public final class YoutubeChannel {
    private final String title;

    private final String linkSuffix;


    public YoutubeChannel(String title, String code, YoutubeChannelType type) {
        this.title = title;
        linkSuffix = type.getUrlPart() + "/" + code;
    }

    public String getLinkSuffix() {
        return linkSuffix;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return linkSuffix.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof YoutubeChannel)) {
            return false;
        }
        return Objects.equals(linkSuffix, ((YoutubeChannel) obj).linkSuffix);
    }
}
