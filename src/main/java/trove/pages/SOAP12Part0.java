package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class SOAP12Part0 extends Page {
    public SOAP12Part0() {
        super("SOAP/SOAP12-part0", "SOAP 1.2 - Part 0", List.of(Languages.XML));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/soap12-part0/", "SOAP Version 1.2 Part 0: Primer (Second Edition)"));
    }
}
