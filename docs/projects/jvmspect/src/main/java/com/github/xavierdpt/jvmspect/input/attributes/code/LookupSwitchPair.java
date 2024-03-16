package com.github.xavierdpt.jvmspect.input.attributes.code;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LookupSwitchPair {

    private final int match;
    private final int offset;

    public LookupSwitchPair(int match, int offset) {
        this.match = match;
        this.offset = offset;
    }

    public Element toXML(Document document) {
        Element result = document.createElement("pair");
        result.setAttribute("match", String.valueOf(match));
        result.setAttribute("offset", String.valueOf(offset));
        return result;
    }


}
