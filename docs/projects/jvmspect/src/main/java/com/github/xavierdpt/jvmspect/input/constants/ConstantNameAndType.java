package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantNameAndType extends Constant {

    private final int nameIndex;
    private final int descriptorIndex;

    public ConstantNameAndType(int nameIndex, int descriptorIndex) {
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }

    @Override
    protected String getTypeName() {
        return "NameAndType";
    }

    @Override
    public void fillXml(Document document, Element constant) {
        constant.setAttribute("nameIndex", String.valueOf(nameIndex));
        constant.setAttribute("descriptorIndex", String.valueOf(descriptorIndex));
    }



    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
        XML.constantAttribute(document, result, "descriptor", constantResolver, descriptorIndex);
    }

}
