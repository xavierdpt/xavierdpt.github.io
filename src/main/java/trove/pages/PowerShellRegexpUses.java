package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Arrays;

public class PowerShellRegexpUses extends Page {

    public PowerShellRegexpUses() {
        super("powershell/regexp-uses", "Regular Expression Uses", Arrays.asList("powershell"));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("TODO");
        ul(Arrays.asList(
                "Select-String",
                "-split",
                "switch -regex",
                "Select-String -CaseSensitive",
                "switch -casesensitive",
                "-cmatch, -csplit, or -creplace"
        ));
    }
}
