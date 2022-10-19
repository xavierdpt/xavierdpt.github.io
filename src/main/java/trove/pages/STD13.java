package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class STD13 extends Page {

    public STD13() {
        super("STD13","STD13");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc1034","DOMAIN NAMES - CONCEPTS AND FACILITIES"));
    }
}
