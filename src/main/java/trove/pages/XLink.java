package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class XLink extends Page {

    public XLink() {
        super(makeLocation(XML.LOCATION,"Link"), "XLink", List.of(Languages.XML));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("The latest version of the XML Linking Language specification is available on the W3C website at " + externalLink("https://www.w3.org/TR/xlink/"));


    }
}
