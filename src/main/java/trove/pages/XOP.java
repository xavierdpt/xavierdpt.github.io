package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class XOP extends Page {

    public XOP() {
        super("XOP", "XOP");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/xop10/", "XML-binary Optimized Packaging"));
    }
}
