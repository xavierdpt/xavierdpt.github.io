package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class XMLSchemaPart2 extends Page {
    public XMLSchemaPart2() {
        super("XMLSchemaPart2", "XML Schema Part 2");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/xmlschema-2/","XML Schema Part 2: Datatypes Second Edition"));
    }
}
