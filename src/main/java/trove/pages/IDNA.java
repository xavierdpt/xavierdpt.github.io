package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class IDNA extends Page {

    public IDNA() {
        super("IDNA","IDNA");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc3490","Internationalizing Domain Names in Applications (IDNA)"));
    }
}
