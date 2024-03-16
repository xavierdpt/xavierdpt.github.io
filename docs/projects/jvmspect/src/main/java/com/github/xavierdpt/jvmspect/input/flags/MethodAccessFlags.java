package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class MethodAccessFlags extends AccessFlags {
    public MethodAccessFlags(int accessFlags) {
        super("method", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("public", String.valueOf((accessFlags & 0x1) != 0));
        result.setAttribute("private", String.valueOf((accessFlags & 0x2) != 0));
        result.setAttribute("protected", String.valueOf((accessFlags & 0x4) != 0));
        result.setAttribute("static", String.valueOf((accessFlags & 0x8) != 0));
        result.setAttribute("final", String.valueOf((accessFlags & 0x10) != 0));
        result.setAttribute("synchronized", String.valueOf((accessFlags & 0x20) != 0));
        result.setAttribute("bridge", String.valueOf((accessFlags & 0x40) != 0));
        result.setAttribute("varargs", String.valueOf((accessFlags & 0x80) != 0));
        result.setAttribute("native", String.valueOf((accessFlags & 0x0100) != 0));
        result.setAttribute("abstract", String.valueOf((accessFlags & 0x400) != 0));
        result.setAttribute("strict", String.valueOf((accessFlags & 0x0800) != 0));
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
    }
}
