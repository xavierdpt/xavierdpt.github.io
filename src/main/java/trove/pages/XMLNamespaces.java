package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XMLNamespaces extends Page {

    public XMLNamespaces() {
        super(makeLocation(XML.LOCATION,"Namespaces"), "XML Namespaces");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("The latest version of the XML Namespaces specification is available on the W3C website at " + externalLink("https://www.w3.org/TR/xml-names/"));
    }
}
