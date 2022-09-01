package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;
import trove.annotations.EmptyPage;

import java.io.IOException;
import java.util.List;

@EmptyPage
public class GetNetAdapterPacketDirect extends Page {
    public GetNetAdapterPacketDirect() {
        super("powershell/Get-NetAdapterPacketDirect", "Get-NetAdapterPacketDirect", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterPacketDirect""");
        p("I had no results from this command on my system, so that page is still a TODO.");
        disclaimer();
    }
}
