package trove;

public class PageUtils {
    public static String externalLink(String href, String title) {
        return "<a href=\"" + href + "\" target=\"_blank\">" + title + "</a>";
    }
}
