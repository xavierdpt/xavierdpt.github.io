package trove;

import trove.pages.Home;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Page {

    private static final String TITLE = "Xavier's Treasure Trove";

    private String location;
    private String subTitle;

    private String path;
    protected PrintWriter pw;
    private List<String> languages;

    protected Page(String location, String subTitle, List<String> languages) {
        this.location = location;
        this.subTitle = subTitle;
        this.languages = languages;
    }

    public String getLocation() {
        return location;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private void header(RenderContext renderContext) {
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang=\"en\">");
        pw.println("<head>");
        pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

        String fullTitle;
        if (subTitle != null && !"".equals(subTitle)) {
            fullTitle = subTitle + " | " + TITLE;
        } else {
            fullTitle = TITLE;
        }
        pw.println("<meta name=\"description\" content=\"" + fullTitle + "\">");
        pw.println("<title>" + fullTitle + "</title>");
        pw.println("<style>");
        pw.println("*, *::before { box-sizing:border-box;}");
        pw.println("p { line-height:48px;}");
        pw.println("a { padding: 5px; text-decoration:none; display:inline-block; min-height:48px; min-width:48px; vertical-align:middle; line-height:48px; background-color: #EEF; margin-bottom:2px; }");
        pw.println("li { vertical-align:middle; list-style-type:none; }");
        pw.println("</style>");
        if (!languages.isEmpty()) {
            pw.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.6.0/styles/default.min.css\">");
            pw.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.6.0/highlight.min.js\"></script>");
        }
        for (String language : languages) {
            pw.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.6.0/languages/" + language + ".min.js\"></script>");
        }
        pw.println("</head>");
        pw.println("<body>");
        if (!"".equals(location)) {
            String href = findRelativePath(location, "", renderContext);
            pw.println("<a href=\"" + href + "\">Home</a>");

            int lastSlash = location.lastIndexOf("/");
            if (lastSlash != -1) {
                String parentLocation = location.substring(0, lastSlash);
                Page parentPage = renderContext.getPage(parentLocation);
                if (parentPage != null) {
                    String href2 = findRelativePath(location, parentLocation, renderContext);
                    String parentSubtitle = parentPage.getSubTitle();
                    if (parentSubtitle != null && !"".equals(parentSubtitle)) {
                        pw.println(" > <a href=\"" + href2 + "\">" + parentSubtitle + "</a>");
                    }
                }
            }

        }
        if (subTitle != null && !"".equals(subTitle)) {
            pw.println("<h1>" + subTitle + "</h1>");
        } else {
            pw.println("<h1>" + TITLE + "</h1>");
        }


    }

    private void footer() {
        if (!languages.isEmpty()) {
            pw.println("<script>hljs.highlightAll();</script>");
        }
        pw.println("</body>");
        pw.println("</html>");
    }

    protected String externalLink(String href, String title) {
        return "<a href=\"" + href + "\" target=\"_blank\">" + title + "</a>";
    }

    protected String internalLink(Class<? extends Page> pageClass, boolean isTrove, RenderContext renderContext) {
        Page page = renderContext.getPageByClass(pageClass);
        return internalLink(page, isTrove, renderContext);
    }

    protected String internalLink(Page page, boolean isTrove, RenderContext renderContext) {
        String linkTitle = page.getSubTitle();
        if (isTrove) {
            linkTitle += " Trove";
        }
        String href = findRelativePath(this.getLocation(), page.getLocation(), renderContext);
        return "<a href=\"" + href + "\">" + linkTitle + "</a>";
    }

    private static String findRelativePath(String fromLocation, String toLocation, RenderContext renderContext) {
        String fromPath = renderContext.getPath(fromLocation);
        String toPath = renderContext.getPath(toLocation);
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

    protected void section(String title) {
        pw.println("<h2>" + title + "</h2>");
    }

    protected void p(String content) {
        pw.println("<p>" + content + "</p>");
    }

    protected void ul(List<String> items) {
        pw.println("<ul>");
        for (String item : items) {
            pw.println("<li>" + item + "</li>");
        }
        pw.println("</ul>");
    }


    protected void code(String language, String code) {
        code = code.replaceAll("&", "&amp;");
        code = code.replaceAll("<", "&lt;");
        code = code.replaceAll(">", "&gt;");
        pw.print("<pre><code class=\"language-" + language + " hljs\">");
        pw.println(code);
        pw.println("</code></pre>");
    }

    private void startRender(RenderContext renderContext) throws FileNotFoundException {
        pw = new PrintWriter(renderContext.getPath(getLocation()));
        header(renderContext);
    }

    public final void renderTop(RenderContext renderContext) throws IOException {
        startRender(renderContext);
        render(renderContext);
        finishRender();
    }

    private void finishRender() {
        footer();
        pw.close();
    }

    protected abstract void render(RenderContext renderContext) throws IOException;
}
