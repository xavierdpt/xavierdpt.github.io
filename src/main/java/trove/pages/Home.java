package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Home extends Page {
    public Home() {
        super("", null);
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {

        List<String> troves = renderContext.getAllPages().stream()
                .filter(page -> page.getLocation().split("/", -1).length == 1)
                .filter(page -> page.getSubTitle() != null)
                .sorted(Comparator.comparing(Page::getSubTitle))
                .map(page -> internalLink(page, true, renderContext))
                .toList();

        startRender(renderContext, List.of());
        pw.println("<p>Welcome to Xavier's Treasure Troves</p>");
        pw.println("<p>Here's a list of troves</p>");
        pw.println("<ul>");
        for (String trove : troves) {
            pw.println("<li>" + trove + "</li>");
        }
        pw.println("</ul>");
        finishRender(List.of());
    }
}
