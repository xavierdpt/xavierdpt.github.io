package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Arrays;

public class PowerShellRegexpCaseSensitivity extends Page {

    public PowerShellRegexpCaseSensitivity() {
        super("powershell/regexp-casesensitivity", "Regular Expression Case Sensitivity", Arrays.asList("powershell"));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {


        section("Case insensitive match");
        code("powershell", """
                $string -match $regex""");

        section("Case sensitive match");
        code("powershell", """
                $string -cmatch $regex""");

        section("Case insensitive replace");
        code("powershell", """
                $string -replace $regex,$replacement""");

        section("Case sensitive replace");
        code("powershell", """
                $string -creplace $regex,$replacement""");

        section("Case insensitive split");
        code("powershell", """
                $string -split $regex""");

        section("Case sensitive split");
        code("powershell", """
                $string -csplit $regex""");

        section("Case insensitive Select-String");
        code("powershell", """
                $something | Select-String $regex""");

        section("Case sensitive Select-String");
        code("powershell", """
                $something | Select-String -CaseSensitie $regex""");

        p("The following items will be illustrated after the switch statement as been covered   ");
        ul(Arrays.asList(
                "switch -regex",
                "switch -casesensitive"
        ));

    }
}
