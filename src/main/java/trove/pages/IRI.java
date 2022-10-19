package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class IRI extends Page {
    public IRI() {
        super("IRI", "IRI");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc3987", "Internationalized Resource Identifiers (IRIs)"));
    }
}
