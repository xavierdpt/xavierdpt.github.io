package com.github.xavierdpt.jvmspect.input.attributes.ln;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LineNumberTableAttributeInfo extends AttributeInfo {
    private final LineNumber[] lineNumbers;

    public LineNumberTableAttributeInfo(LineNumber[] lineNumbers) {
        this.lineNumbers = lineNumbers;
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (LineNumber lineNumber : lineNumbers) {
            result.appendChild(lineNumber.toXML(document));
        }
    }

}
