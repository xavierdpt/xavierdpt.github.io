package com.github.xavierdpt.jvmspect.input.attributes.lvt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class LocalVariable {

    private final int startPc;
    private final int length;
    private final int nameIndex;
    private final int descriptorIndex;
    private final int index;

    public LocalVariable(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("localVariable");
        XML.createAttribute(document, result, "startPc", String.valueOf(startPc));
        XML.createChild(document, result, "length", String.valueOf(length));
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
        XML.constantAttribute(document, result, "descriptor", constantResolver, descriptorIndex);
        XML.createAttribute(document, result, "index", String.valueOf(index));
        return result;
    }

}
