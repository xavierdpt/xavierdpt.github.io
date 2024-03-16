package com.github.xavierdpt.jvmspect.input.attributes.mp;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.flags.MethodParameterAccessFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MethodParameter {
    private final int nameIndex;
    private final MethodParameterAccessFlags accessFlags;

    public MethodParameter(int nameIndex, MethodParameterAccessFlags accessFlags) {
        this.nameIndex = nameIndex;
        this.accessFlags = accessFlags;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("methodParameter");
        if (nameIndex != 0) {
            XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
        }
        result.appendChild(accessFlags.toXML(document));
        return result;
    }
}
