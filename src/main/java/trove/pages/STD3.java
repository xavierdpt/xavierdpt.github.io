package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class STD3 extends Page {
    public STD3() {
        super("STD3", "STD3");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc1123", "Requirements for Internet Hosts -- Application and Support"));
    }
}
