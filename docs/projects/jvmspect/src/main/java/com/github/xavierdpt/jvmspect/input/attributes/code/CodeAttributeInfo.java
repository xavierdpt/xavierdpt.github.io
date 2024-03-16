package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public final class CodeAttributeInfo extends AttributeInfo {
    private final int maxStack;
    private final int maxLocals;
    private final List<Instruction> parsedCode;
    private final ExceptionInfo[] exceptionInfos;
    private final AttributeInfo[] attributeInfos;

    public CodeAttributeInfo(
            int maxStack,
            int maxLocals,
            List<Instruction> parsedCode,
            ExceptionInfo[] exceptionInfos,
            AttributeInfo[] attributeInfos
    ) {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.parsedCode = parsedCode;
        this.exceptionInfos = exceptionInfos;
        this.attributeInfos = attributeInfos;
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("maxStack", String.valueOf(maxStack));
        result.setAttribute("maxLocals", String.valueOf(maxLocals));
        Element instructions = XML.createChild(document, result, "instructions");
        for (Instruction instruction : parsedCode) {
            instructions.appendChild(instruction.toXML(document, constantResolver));
        }
        if (exceptionInfos.length > 0) {
            Element exceptionTable = XML.createChild(document, result, "exceptionTable");
            for (ExceptionInfo exceptionInfo : exceptionInfos) {
                exceptionTable.appendChild(exceptionInfo.toXML(document));
            }
        }
        if (attributeInfos.length > 0) {
            Element attributes = XML.createChild(document, result, "attributes");
            for (AttributeInfo attributeInfo : attributeInfos) {
                attributes.appendChild(attributeInfo.toXML(document, constantResolver));
            }
        }
    }


}
