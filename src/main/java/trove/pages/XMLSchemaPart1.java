package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XMLSchemaPart1 extends Page {
    public XMLSchemaPart1() {
        super("XMLSchemaPart1", "XML Schema Part 1");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/xmlschema-1/","XML Schema Part 1: Structures Second Edition"));
    }
}
