package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellGetNetAdapterBinding extends Page {

    public PowerShellGetNetAdapterBinding() {
        super("powershell/Get-NetAdapterBinding", "Get-NetAdapterBinding", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterBinding""");

        p("Coming soon...");
    }
}
