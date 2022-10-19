package trove;

public class PageUtils {

    public static final String EXTERNAL_LINK_ICON = "docs/assets/images/link-external-small-ltr-progressive.svg";
    public static String externalLink(String href, String title, Page page) {
        String imagePath = findRelativePathToAsset(page.getLocation(), EXTERNAL_LINK_ICON, page.getRenderContext());
        String img = "<img src=\"" + imagePath + "\">";
        return "<a href=\"" + href + "\" target=\"_blank\" rel=\"nofollow\">" + title + img + "</a>";
    }

    public  static String findRelativePathToAsset(String location, String assetPath, RenderContext renderContext) {
        String fromPath = renderContext.getPath(location);
        return findRelativePath(fromPath,assetPath);
    }

    public static String findRelativePath(String fromPath, String toPath) {
        String[] fparts = fromPath.split("/", -1);
        String[] tparts = toPath.split("/", -1);
        int i = 0;
        while (i < fparts.length && i < tparts.length && fparts[i].equals(tparts[i])) {
            ++i;
        }
        String result = "";
        for (int j = i; j < tparts.length; ++j) {
            if ("".equals(result)) {
                result = tparts[j];
            } else {
                result = result + "/" + tparts[j];
            }
        }
        for (int k = i; k < fparts.length - 1; ++k) {
            result = "../" + result;
        }
        return result;
    }
}
