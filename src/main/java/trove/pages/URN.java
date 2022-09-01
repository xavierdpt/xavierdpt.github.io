package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class URN extends Page {

    public URN() {
        super("URN", "URN: Uniform Resource Name", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("URN: Uniform Resource Name");
    }
}
