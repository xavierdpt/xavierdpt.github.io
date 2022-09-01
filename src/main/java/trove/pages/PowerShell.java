package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class PowerShell extends Page {

    public static final String LOCATION = "powershell";

    public PowerShell() {
        super(LOCATION, "PowerShell", List.of());
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {

        List<Page> childPages = renderContext.getChildPages(getLocation());

        String powerShell = externalLink("https://docs.microsoft.com/en-us/powershell/", "PowerShell");

        pw.println("<p>Here are troves on " + powerShell + "</p>");
        pw.println("<ul>");
        childPages.stream().sorted(Comparator.comparing(p -> p.getSubTitle().toLowerCase())).forEach(page -> {
                    String htmlLink = internalLink(page, renderContext);
                    pw.println("<li>" + htmlLink + "</li>");
                }
        );
        pw.println("</ul>");
    }
}
