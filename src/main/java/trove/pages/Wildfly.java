package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class Wildfly extends Page {

    public static String LOCATION = "wildfly";

    public Wildfly() {
        super(LOCATION, "Widfly", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.wildfly.org/", "Wildfly"));
    }
}
