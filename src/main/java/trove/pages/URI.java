package trove.pages;

import trove.Page;
import trove.RFCs;
import trove.RenderContext;
import trove.SyntaxToken;

import java.io.IOException;
import java.util.List;

public class URI extends Page {

    public URI() {
        super("URI", "URI: Uniform Resource Identifier", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {

        String rfcLinkHtml = RFCs.RFC3986.makeShortLinkHtml(this);
        String wpLinkHtml = externalLink("https://en.wikipedia.org/wiki/Uniform_Resource_Identifier", "Wikipedia");

        p("Uniform Resource Identifiers are defined in " + rfcLinkHtml + ".");
        sep();
        p("More information is also available on " + wpLinkHtml);
        sep();
        p("In this page, we will generate a variety of URI strings by following the rules of the grammar.");
        sep();
        p("The root production rule is the following:");
        p(toHtml(SyntaxToken.tokens("!scheme", "_:", "!hier-part", ".[", "_?", "!query", ".]", ".[", "_#", "!fragment", ".]")), false);
        sep();
        p("Let's expand the `scheme` rule.");
        p(toHtml(SyntaxToken.tokens("!ALPHA", ".*(", "!ALPHA", "./", "!DIGIT", "./", "_+", "./", "_-", "./", "_.",".)", "_:", "!hier-part", ".[", "_?", "!query", ".]", ".[", "_#", "!fragment", ".]")), false);
        sep();
        p("This means that the scheme must start with a letter, but then can continue with letters, digits, or '`+`', '`-`' or '`.`' characters.");
        p("For example, `http2+ftp-1-5.x.` would be a valid scheme according to this specification.");
        p("Let's use `myscheme` for now, which is equally valid.");
        p(toHtml(SyntaxToken.tokens("_myscheme:",  "!hier-part", ".[", "_?", "!query", ".]", ".[", "_#", "!fragment", ".]")), false);
        sep();
        p("Since `query` and `fragment` are optional, we can ignore them for now.");
        p(toHtml(SyntaxToken.tokens("_myscheme:",  "!hier-part")), false);
        p("For `hier-part`, we have four possibilities.");


    }
}
