package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellRemoting extends Page {

    public PowerShellRemoting() {
        super("powershell/remoting", "Windows Remoting", List.of("powershell"));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {

        code("powershell", """
                Enable-PSRemoting
                """);

        code("powershell", """
                Enable-PSRemoting -SkipNetworkProfileCheck
                """);

    }
}
