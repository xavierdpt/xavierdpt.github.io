package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class OpensFlags extends AccessFlags {
    public OpensFlags(int accessFlags) {
        super("opens", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
        result.setAttribute("mandated", String.valueOf((accessFlags & 0x8000) != 0));
    }
}
