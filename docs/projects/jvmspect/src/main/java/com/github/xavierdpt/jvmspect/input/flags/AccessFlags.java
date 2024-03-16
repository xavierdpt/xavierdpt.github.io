package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AccessFlags {

    private final String type;
    protected final int accessFlags;

    public AccessFlags(String type, int accessFlags) {
        this.type = type;
        this.accessFlags = accessFlags;
    }

    public final Element toXML(Document document) {
        Element result = document.createElement("accessFlags");
        result.setAttribute("type", type);
        fillXML(result);
        return result;
    }

    protected abstract void fillXML(Element result);

}
