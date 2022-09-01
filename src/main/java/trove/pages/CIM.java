package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class CIM extends Page {

    public CIM() {
        super("CIM", "CIM: Common Information Model", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("This page is about the Common Information Model (CIM)");
        p(externalLink("https://www.dmtf.org/standards/cim/","DTMF CIM specification entry point"));
    }
}
