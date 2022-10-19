package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XMLBase extends Page {

    public XMLBase() {
        super(makeLocation(XML.LOCATION,"Base"), "XML Base");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("The latest version of the XML Base specification is available on the W3C website at " + externalLink("https://www.w3.org/TR/xmlbase/"));
        sep();
        p("XML Base is an addition to XML that adds the `base` relative URI for use mainly with XLink.");
        sep();
        p("The goal is introduce the same mechanism as in HTML to resolve relative URIs");
    }
}
