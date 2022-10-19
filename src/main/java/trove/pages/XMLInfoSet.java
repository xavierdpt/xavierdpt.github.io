package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XMLInfoSet extends Page {


    public XMLInfoSet() {
        super(makeLocation(XML.LOCATION,"InfoSet"), "XML InfoSet");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("The latest version of the XML InfoSet specification is available on the W3C website at " + externalLink("https://www.w3.org/TR/xml-infoset/"));
        sep();
        p("This specification describes a summary of elements that are defined in the XML specification, with links to the respective parts of the XML specification.");

    }
}
