package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Provides {
    private final int providesIndex;
    private final int[] providesWithIndexes;

    public Provides(int providesIndex, int[] providesWithIndexes) {
        this.providesIndex = providesIndex;
        this.providesWithIndexes = providesWithIndexes;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("provides");
        result.appendChild(constantResolver.resolve(providesIndex).toXMLRef(document, constantResolver));
        Element container = XML.createChild(document, result, "providesWith");
        for (int providesWithIndex : providesWithIndexes) {
            container.appendChild(constantResolver.resolve(providesWithIndex).toXMLRef(document, constantResolver));
        }
        return result;
    }
}
