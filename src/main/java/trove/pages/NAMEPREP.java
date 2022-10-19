package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class NAMEPREP extends Page {

    public NAMEPREP() {
        super("NAMEPREP", "NAMEPREP");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc3490","Nameprep: A Stringprep Profile for  Internationalized Domain Names (IDN)"));
    }
}
