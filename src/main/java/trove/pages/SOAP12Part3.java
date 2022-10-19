package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class SOAP12Part3 extends Page {
    public SOAP12Part3() {
        super("SOAP/SOAP12-part3", "SOAP 1.2 - Part 3", List.of(Languages.XML));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p(externalLink("https://www.w3.org/TR/soap12-part3/", "SOAP 1.2 Part 3: One-Way MEP"));
        section("1");
        p("One-way MEP");
        section("1.1");
        section("2");
        section("2.1");
        p("Feature name: `\"http://www.w3.org/2006/08/soap/mep/one-way/\"`");
        section("2.2");
        section("2.3");
        p("Properties: `InboundMessage`, `OutboundMessage`, `ImmediateDestination`, `ImmediateSender`");
        section("2.4");
        section("3");
        section("3.1");
        section("3.2");
    }
}
