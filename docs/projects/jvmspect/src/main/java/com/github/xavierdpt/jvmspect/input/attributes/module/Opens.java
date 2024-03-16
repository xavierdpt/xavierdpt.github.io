package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.flags.OpensFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Opens {
    private final int opensIndex;
    private final OpensFlags opensFlags;
    private final int[] opensToIndexes;

    public Opens(int opensIndex, OpensFlags opensFlags, int[] opensToIndexes) {
        this.opensIndex = opensIndex;
        this.opensFlags = opensFlags;
        this.opensToIndexes = opensToIndexes;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("opens");
        result.appendChild(constantResolver.resolve(opensIndex).toXMLRef(document, constantResolver));
        result.appendChild(opensFlags.toXML(document));
        Element container = XML.createChild(document, result, "opensTo");
        for (int opensToIndex : opensToIndexes) {
                container.appendChild(constantResolver.resolve(opensToIndex).toXMLRef(document, constantResolver));
        }
        return result;
    }
}
