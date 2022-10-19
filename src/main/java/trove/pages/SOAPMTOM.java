package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class SOAPMTOM extends Page {

    public SOAPMTOM() {
        super("SOAPMTOM","SOAP MTOM");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/soap12-mtom/","SOAP Message Transmission Optimization Mechanism"));
    }
}
