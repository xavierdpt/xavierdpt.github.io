package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class RequiresFlags extends AccessFlags {
    public RequiresFlags(int accessFlags) {
        super("requires", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("transitive", String.valueOf((accessFlags & 0x20) != 0));
        result.setAttribute("staticPhase", String.valueOf((accessFlags & 0x40) != 0));
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
        result.setAttribute("mandated", String.valueOf((accessFlags & 0x8000) != 0));
    }
}
