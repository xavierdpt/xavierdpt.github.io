package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellRegexp extends Page {

    public PowerShellRegexp() {
        super("powershell/regexp", "Regular Expressions", List.of("powershell"));
    }

    @Override
    public void render(RenderContext renderContext) throws IOException {

        section("One char");
        code("powershell", """
                'powershell' -match 'w' # true
                'powershell' -match 'x' # false""");

        section("Several consecutive chars");
        code("powershell", """
                'powershell' -match 'power' # true
                'powershell' -match 'mega' # false""");

        section("Several chars");
        code("powershell", """
                'powershell' -match '[wxy]' # true
                'powershell' -match '[xyz]' # false""");

        section("Several chars or dash");
        pw.println("<p>Include the dash at the beginning or at the end</p>");
        code("powershell", """
                'power-shell' -match '[xyz-]' # true
                'power-shell' -match '[-xyz]' # true""");

        section("Range of chars");
        code("powershell", """
                'powershell 5' -match '[0-5]' # true
                'powershell 6' -match '[0-5]' # false""");

        section("Digits");
        code("powershell", """
                'powershell 5' -match '\\d' # true
                'powershell' -match '\\d' # false""");

        section("Non whitespace");
        code("powershell", """
                'powershell 5' -match '\\w' # true
                '    ' -match '\\w' # false""");

        section("One arbitrary char");
        code("powershell", """
                'powershell' -match 'power.hell' # true
                'power shell' -match 'power.hell' # false""");

        section("One arbitrary char");
        code("powershell", """
                'powershell' -match 'power.hell' # true
                'power shell' -match 'power.hell' # false""");

        section("Whitespace");
        code("powershell", """
                'powershell 5' -match '\\s' # true
                'powershell' -match '\\s' # false""");

        section("Zero or more");
        code("powershell", """
                'learn shell' -match 'learn (power)*shell' # true
                'learn powershell' -match 'learn (power)*shell' # true
                'learn powerpowershell' -match 'learn (power)*shell' # true
                'learn powerpowerpowershell' -match 'learn (power)*shell' # true""");

        section("One or more");
        code("powershell", """
                'learn shell' -match 'learn (power)+shell' # false
                'learn powershell' -match 'learn (power)+shell' # true
                'learn powerpowershell' -match 'learn (power)+shell' # true
                'learn powerpowerpowershell' -match 'learn (power)+shell' # true""");

        section("Zero or one");
        code("powershell", """
                'learn shell' -match 'learn (power)?shell' # true
                'learn powershell' -match 'learn (power)?shell' # true
                'learn powerpowershell' -match 'learn (power)?shell' # false
                'learn powerlearn powerpowershell' -match 'learn (power)?shell' # false""");

        section("Exactly 2");
        code("powershell", """
                'learn shell' -match 'learn (power){2}shell' # false
                'learn powershell' -match 'learn (power){2}shell' # false
                'learn powerpowershell' -match 'learn (power){2}shell' # true
                'learn powerpowerpowershell' -match 'learn (power){2}shell' # false""");

        section("More than 2");
        code("powershell", """
                'learn shell' -match 'learn (power){2,}shell' # false
                'learn powershell' -match 'learn (power){2,}shell' # false
                'learn powerpowershell' -match 'learn (power){2,}shell' # true
                'learn powerpowerpowershell' -match 'learn (power){2,}shell' # true
                'learn powerpowerpowerpowershell' -match 'learn (power){2,}shell' # true""");

        section("1, 2 or 3");
        code("powershell", """
                'learn shell' -match 'learn (power){1,3}shell' # false
                'learn powershell' -match 'learn (power){1,3}shell' # true
                'learn powerpowershell' -match 'learn (power){1,3}shell' # true
                'learn powerpowerpowershell' -match 'learn (power){1,3}shell' # true
                'learn powerpowerpowerpowershell' -match 'learn (power){1,3}shell' # false""");

        section("At start of line");
        code("powershell", """
                'powershell' -match '^powershell' # true
                'learn powershell' -match '^powershell' # false""");

        section("At end of line");
        code("powershell", """
                'learn' -match 'learn$' # true
                'learn powershell' -match 'learn$' # false""");

        section("Escape");
        pw.println("<p>Here, prevent the interpretation of the '.', same for other meta characters such as '^', '$', '*', '+', '?', ...</p>");
        code("powershell", """
                'power.shell' -match '\\.' # true
                'power|shell' -match '\\.' # false""");

        section("Compute escaped string with Powershell");
        pw.println("<p>Powershell can perform the escape for you, handy when you have to include untrusted input as a part of a regular expression.</p>");
        code("powershell", """
                $user="john.doe"
                $regex="Welcome $([regex]::escape($user))"
                $regex # Welcome john\\.doe""");

        section("Groups");
        code("powershell", """
                'learn powershell' -match 'learn (.*)'
                $what = $Matches[1]
                $what # powershell""");

        section("Named groups");
        code("powershell", """
                'learn powershell' -match 'learn (?<what>.*)'
                $Matches.what # powershell""");

        section("Replace");
        code("powershell", """
                'learn powershell' -replace 'learn','study'
                # study powershell""");

        section("Replace with groups");
        code("powershell", """
                'John Doe' -replace '(.*) (.*)','$2, $1'
                # Doe, John""");

        section("Replace with named groups");
        code("powershell", """
                'John Doe' -replace '(?<firstname>.*) (?<lastname>.*)','${firstname}, ${lastname}'
                # Doe, John""");

        section("Replace with variable in groups");
        code("powershell", """
                $msg="Welcome"
                'John Doe' -replace '(?<firstname>.*) (?<lastname>.*)',"$msg `${firstname}, `${lastname}"
                # Doe, John""");

        section("Replace and include literal $");
        code("powershell", """
                # With single quotes
                'John Doe' -replace '(?<firstname>.*) (?<lastname>.*)','$$ ${firstname}, ${lastname}'
                # With double quotes
                'John Doe' -replace '(?<firstname>.*) (?<lastname>.*)',"`$`$ `${firstname}, `${lastname}"
                # Doe, John""");

        section("References");
        code("powershell", """
                "hello" -replace 'l','($&)
                # he(l)(l)o""");

        section("Special chars");
        p("Matches tab, carriage return or newline");
        code("powershell", """
                "hello" -match '[\\t\\r\\n]' # false""");

    }
}
