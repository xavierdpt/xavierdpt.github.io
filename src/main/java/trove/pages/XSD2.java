package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XSD2 extends Page {

    public XSD2() {
        super("XSD2", "XSD 2");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/xmlschema11-2/", "W3C XML Schema Definition Language (XSD) 1.1 Part 2: Datatypes"));
    }
}
