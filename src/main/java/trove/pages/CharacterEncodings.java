package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;

public class CharacterEncodings extends Page {

    public static String LOCATION = "CharacterEncodings";

    public CharacterEncodings() {
        super(LOCATION, "Character Encodings");
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        subpages(renderContext);
    }
}
