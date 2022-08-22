package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShell extends Page {

    public PowerShell() {
        super("powershell", "Powershell");
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {

        String powerShell = externalLink("https://docs.microsoft.com/en-us/powershell/", "Powershell");
        String powerShellFunctions = internalLink(PowerShellFunctions.class, true, renderContext);

        startRender(renderContext, List.of());
        pw.println("<p>Here are troves on " + powerShell + "</p>");
        pw.println("<ul>");
        pw.println("<li>" + powerShellFunctions + "</li>");
        pw.println("</ul>");
        finishRender(List.of());
    }
}
