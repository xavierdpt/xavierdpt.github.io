package com.github.xavierdpt.jvmspect.input.attributes.lvtt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LocalVariableType {

    private final int startPc;
    private final int length;
    private final int nameIndex;
    private final int signatureIndex;
    private final int index;

    public LocalVariableType(int startPc, int length, int nameIndex, int signatureIndex, int index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.signatureIndex = signatureIndex;
        this.index = index;
    }

    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("localVariableType");
        result.setAttribute("startPc", String.valueOf(startPc));
        result.setAttribute("length", String.valueOf(length));
        result.setAttribute("name", constantResolver.resolveString(nameIndex));
        result.setAttribute("signature", constantResolver.resolveString(signatureIndex));
        result.setAttribute("index", String.valueOf(index));
        return result;
    }

}
