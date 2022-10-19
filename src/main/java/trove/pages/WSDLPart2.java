package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class WSDLPart2 extends Page {

    public WSDLPart2() {
        super("WSDLPart2", "WSDL Part 2");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/wsdl20-adjuncts/", "Web Services Description Language (WSDL) Version 2.0 Part 2: Adjuncts"));
    }
}
