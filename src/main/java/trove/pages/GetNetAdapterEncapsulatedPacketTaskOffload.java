package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;
import trove.annotations.EmptyPage;

import java.io.IOException;
import java.util.List;

@EmptyPage
public class GetNetAdapterEncapsulatedPacketTaskOffload extends Page {

    public GetNetAdapterEncapsulatedPacketTaskOffload() {
        super("powershell/Get-NetAdapterEncapsulatedPacketTaskOffload",
                "Get-NetAdapterEncapsulatedPacketTaskOffload", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterEncapsulatedPacketTaskOffload""");
        p("I had no results from this command on my system, so that page is still a TODO.");
        disclaimer();
    }
}
