package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class ClassAccessFlags extends AccessFlags {
    public ClassAccessFlags(int accessFlags) {
        super("class", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("public", String.valueOf((accessFlags & 0x1) != 0));
        result.setAttribute("final", String.valueOf((accessFlags & 0x10) != 0));
        result.setAttribute("super", String.valueOf((accessFlags & 0x20) != 0));
        result.setAttribute("interface", String.valueOf((accessFlags & 0x0200) != 0));
        result.setAttribute("abstract", String.valueOf((accessFlags & 0x400) != 0));
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
        result.setAttribute("annotation", String.valueOf((accessFlags & 0x2000) != 0));
        result.setAttribute("enum", String.valueOf((accessFlags & 0x4000) != 0));
        result.setAttribute("module", String.valueOf((accessFlags & 0x8000) != 0));
    }
}
