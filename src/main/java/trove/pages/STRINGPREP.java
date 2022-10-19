package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class STRINGPREP extends Page {

    public STRINGPREP() {
        super("STRINGPREP", "STRINGPREP");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://datatracker.ietf.org/doc/html/rfc3454","Preparation of Internationalized Strings (\"stringprep\")"));
    }
}
