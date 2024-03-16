package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantMethodHandle extends Constant {

    private final int referenceKind;
    private final int referenceIndex;

    public ConstantMethodHandle(int referenceKind, int referenceIndex) {
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    @Override
    protected String getTypeName() {
        return "MethodHandle";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("referenceKind", String.valueOf(referenceKind));
        result.setAttribute("referenceIndex", String.valueOf(referenceIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        String referenceKindStr = switch (referenceKind) {
            case 1 -> "getField";
            case 2 -> "getStatic";
            case 3 -> "putField";
            case 4 -> "putStatic";
            case 5 -> "invokeVirtual";
            case 6 -> "invokeStatic";
            case 7 -> "invokeSpecial";
            case 8 -> "newInvokeSpecial";
            case 9 -> "invokeInterface";
            default -> throw new IllegalStateException("Unexpected reference kind: " + referenceKind);
        };
        result.setAttribute("referenceKind", referenceKindStr);
        XML.constantAttribute(document, result, "reference", constantResolver, referenceIndex);
    }

}
