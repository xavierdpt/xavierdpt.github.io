package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class PowerShell extends Page {

    public PowerShell() {
        super("powershell", "Powershell", List.of());
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {

        List<Page> childPages = renderContext.getChildPages(getLocation());

        String powerShell = externalLink("https://docs.microsoft.com/en-us/powershell/", "Powershell");

        pw.println("<p>Here are troves on " + powerShell + "</p>");
        pw.println("<ul>");
        childPages.stream().sorted(Comparator.comparing(Page::getSubTitle)).forEach(page -> {
                    String htmlLink = internalLink(page, true, renderContext);
                    pw.println("<li>" + htmlLink + "</li>");
                }
        );
        pw.println("</ul>");
    }
}
