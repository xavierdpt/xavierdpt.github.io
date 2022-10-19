package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PUNYCODE extends Page {

    public PUNYCODE() {
        super("PUNYCODE","PUNYCODE");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {


        p(externalLink("https://datatracker.ietf.org/doc/html/rfc3492","Punycode: A Bootstring encoding of Unicode for Internationalized Domain Names in Applications (IDNA)"));
    }
}
