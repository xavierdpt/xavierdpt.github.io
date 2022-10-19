package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ASCII extends Page {

    public ASCII() {
        super(makeLocation(CharacterEncodings.LOCATION, "ASCII"), "ASCII Essentials");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        String wikipedia = externalLink("https://en.wikipedia.org/wiki/ASCII", "Wikipedia");
        String manpage = externalLink("https://man7.org/linux/man-pages/man7/ascii.7.html", "Linux manual page");
        p("External links:");
        ul(List.of(
                "ASCII on " + wikipedia,
                "ASCII " + manpage
        ));

        section("Quick facts");
        ul(List.of(
                markdown("ASCII means American Standard Code for Information Exchange")
        ));
        p("ASCII is a character encoding standard that is the basis for most character encodings used in the world");
        sep();
        p("ASCII define 128 characters on 7 bits from #00 to #7F.");
        p("Control characters are defined from #00 to #1F (32 characters).");
        p("Digits are defined from #30 to #39 (10 characters).");
        p("Uppercase letters are defined from #41 to #5A (26 characters).");
        p("Lowercase letters are defined from #61 to #7A (26 characters).");
        p("Remain 34 characters.");
        sep();
        p("Between control characters and digits are 16 characters:");
        ul(Arrays.asList(
                markdown("'` `': Space"),
                markdown("'`!`': Exclamation mark"),
                markdown("'`\"`': Double quote"),
                markdown("'`#`': Number sign"),
                markdown("'`$`': Dollar sign"),
                markdown("'`%`': Percent sign"),
                markdown("'`&`': Ampersand"),
                markdown("'`'`': Apostrophe"),
                markdown("'`(`': Left parenthesis"),
                markdown("'`)`': Right parenthesis"),
                markdown("'`*`': Asterisk"),
                markdown("'`+`': Plus sign"),
                markdown("'`,`': Comma"),
                markdown("'`-`': Hyphen and minus sign"),
                markdown("'`.`': Period"),
                markdown("'`/`': Slash")

        ));
        p("Between digits and uppercase are 7 characters:");
        ul(Arrays.asList(
                markdown("'`:`': Colon"),
                markdown("'`;`': Semicolon"),
                markdown("'`\"`': Double quote"),
                markdown("'`#`': Number sign"),
                markdown("'`$`': Dollar sign"),
                markdown("'`%`': Percent sign"),
                markdown("'`&`': Ampersand"),
                markdown("'`'`': Apostrophe"),
                markdown("'`(`': Left parenthesis"),
                markdown("'`)`': Right parenthesis"),
                markdown("'`*`': Asterisk"),
                markdown("'`+`': Plus sign"),
                markdown("'`,`': Comma"),
                markdown("'`-`': Hyphen and minus sign"),
                markdown("'`.`': Period"),
                markdown("'`/`': Slash")

        ));
        p("Between uppercase and lowercase are 6 characters: '``', '``', '``', '``', '``', '``'.");
        p("After lowercase characters are 4 characters: '``', '``', '``', '``'.");

    }
}
