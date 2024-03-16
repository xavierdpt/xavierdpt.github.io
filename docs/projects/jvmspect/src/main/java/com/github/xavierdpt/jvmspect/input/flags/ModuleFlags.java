package com.github.xavierdpt.jvmspect.input.flags;

import org.w3c.dom.Element;

public final class ModuleFlags extends AccessFlags {
    public ModuleFlags(int accessFlags) {
        super("module", accessFlags);
    }

    @Override
    protected void fillXML(Element result) {
        result.setAttribute("open", String.valueOf((accessFlags & 0x20) != 0));
        result.setAttribute("synthetic", String.valueOf((accessFlags & 0x1000) != 0));
        result.setAttribute("mandated", String.valueOf((accessFlags & 0x8000) != 0));
    }
}
