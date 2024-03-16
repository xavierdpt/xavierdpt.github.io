package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class InnerClassAccessFlags extends AccessFlags {
    public InnerClassAccessFlags(int accessFlags) {
        super("innerClass", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("public", String.valueOf((accessFlags & 0x1) != 0));
        result.setAttribute("private", String.valueOf((accessFlags & 0x2) != 0));
        result.setAttribute("protected", String.valueOf((accessFlags & 0x4) != 0));
        result.setAttribute("static", String.valueOf((accessFlags & 0x8) != 0));
        result.setAttribute("final", String.valueOf((accessFlags & 0x10) != 0));
        result.setAttribute("interface", String.valueOf((accessFlags & 0x0200) != 0));
        result.setAttribute("abstract", String.valueOf((accessFlags & 0x400) != 0));
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
        result.setAttribute("annotation", String.valueOf((accessFlags & 0x2000) != 0));
        result.setAttribute("enum", String.valueOf((accessFlags & 0x4000) != 0));
    }
}
