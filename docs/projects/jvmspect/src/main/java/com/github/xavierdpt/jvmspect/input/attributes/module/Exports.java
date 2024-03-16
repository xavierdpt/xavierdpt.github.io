package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.flags.ExportsFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Exports {

    private final int exportsIndex;
    private final ExportsFlags exportsFlags;
    private final int[] exportsToIndexes;

    public Exports(int exportsIndex, ExportsFlags exportsFlags, int[] exportsToIndexes) {
        this.exportsIndex = exportsIndex;
        this.exportsFlags = exportsFlags;
        this.exportsToIndexes = exportsToIndexes;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("exports");
        result.setAttribute("exportsIndex", String.valueOf(exportsIndex));
        result.appendChild(exportsFlags.toXML(document));
        Element container = XML.createChild(document, result, "exportsTo");
        for (int exportsToIndex : exportsToIndexes) {
            container.appendChild(constantResolver.resolve(exportsToIndex).toXMLRef(document, constantResolver));
        }
        return result;
    }
}
