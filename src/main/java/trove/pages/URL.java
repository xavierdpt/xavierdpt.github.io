package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class URL  extends Page {

    public URL() {
        super("URL", "URL: Uniform Resource Locator", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("URL: Uniform Resource Locator");
    }
}
