package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XSD1 extends Page {

    public XSD1() {
        super("XSD1", "XSD 1");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/xmlschema11-1/","W3C XML Schema Definition Language (XSD) 1.1 Part 1: Structures"));
    }
}
