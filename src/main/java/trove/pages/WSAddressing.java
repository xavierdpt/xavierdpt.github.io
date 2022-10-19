package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class WSAddressing extends Page {

    public WSAddressing() {
        super("WSAddressing","WS-Addressing");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/Submission/ws-addressing/","Web Services Addressing (WS-Addressing)"));
    }
}
