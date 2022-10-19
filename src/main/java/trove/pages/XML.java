package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class XML extends Page {

    public static final String LOCATION = "XML";

    public XML() {
        super(LOCATION, "XML", List.of());
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        p("This page is about the XML specification.");
        p("Related topics are covered in the following subpages:");
        subpages(renderContext);
        p("The latest version of the XML specification is available on the W3C website at " + externalLink("https://www.w3.org/TR/xml/"));
        section("`S` rule");
        p("The `S` rule is the rule for whitespaces.");
        p("It defines that whitespace is made of any non-empty sequence of space, horizontal tab, carriage return, or new line characters.");
        p("The 'space' character is the well-known character that you get while typing when hitting the space bar.");
        p("The 'horizontal tab' character is an control character that you can get while typing using the space bar, but nowadays, it is often converted to multiple spaces or trigger some other actions such as focusing the user interface on the next field in a form.");
        p("The 'new line' character is what you get while typing when you hit the 'Enter' key, which creates a new line.");
        p("The 'carriage return' character is also related to newline, is allowed by the XML specification in input, but is transformed into 'new line' characters while processing.");
        section("Side note on 'new line' character vs. 'carriage return'");
        p("Some old typewriters distinguished two mechanical actions.");
        p("One mechanical action was 'go down one line', and this is encoded by the 'new line' character.");
        p("Another mechanical action was 'return the carriage to the beginning of the line', which is encoded by the 'carriage return' character.");
        p("Most often, this was combined a single action that move the carriage to the beginning of the next line.");
        p("This lead to different encoding of the same actions, some systems responded to each action individually, and required both the carriage return and the new line action.");
        p("Other systems were smarter and only need the 'new line' action.");
        p("Yet other systems only used the 'carriage return' action.");
        p("As a result, Linux systems only use the 'new line' character in text files, Mac systems only use the 'carriage return' in text files, and Windows systems use both 'carriage return' and 'new line' in that specific order.");

        section("`VersionNum` rule");
        p("This rule specified allowed values for XML versions strings.");
        p("The most widely used version of XML is version 1.0, but there is also a 1.1 version and there may be other versions in the future.");
        p("To leave room for these eventualities, XML versions must start with `1.`, but can have any number of digits after the dot.");




    }
}
