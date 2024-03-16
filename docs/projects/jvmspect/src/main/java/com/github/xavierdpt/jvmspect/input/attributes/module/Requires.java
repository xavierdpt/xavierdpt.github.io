package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.flags.RequiresFlags;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Requires {
    private final int requiresIndex;
    private final RequiresFlags requiresFlags;
    private final int requiresVersionIndex;

    public Requires(int requiresIndex, RequiresFlags requiresFlags, int requiresVersionIndex) {
        this.requiresIndex = requiresIndex;
        this.requiresFlags = requiresFlags;
        this.requiresVersionIndex = requiresVersionIndex;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("requires");
        result.appendChild(constantResolver.resolve(requiresIndex).toXMLRef(document, constantResolver));
        result.appendChild(requiresFlags.toXML(document));
        if (requiresVersionIndex != 0) {
            result.setAttribute("requiresVersionIndex", constantResolver.resolveString(requiresVersionIndex));
        }

        return result;
    }
}
