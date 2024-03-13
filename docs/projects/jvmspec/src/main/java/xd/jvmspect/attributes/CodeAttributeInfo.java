package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.ExceptionInfo;
import xd.jvmspect.bytecode.Instruction;
import xd.jvmspect.xml.XML;

public record CodeAttributeInfo(
        int maxStack,
        int maxLocals,
        byte[] code,
        java.util.List<Instruction> parsedCode,
        ExceptionInfo[] exceptionInfos,
        RawAttributeInfo[] attributeInfos
) implements IAttributeInfo {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element root = document.createElement("code");
        XML.createChild(document, root, "maxStack", String.valueOf(maxStack));
        XML.createChild(document, root, "maxLocals", String.valueOf(maxLocals));
        Element instructions = XML.createChild(document, root, "instructions");
        for (Instruction instruction : parsedCode) {
            instructions.appendChild(instruction.toXML(document, constantResolver));
        }
        if (exceptionInfos.length > 0) {
            Element exceptionTable = XML.createChild(document, root, "exceptionTable");
            for (ExceptionInfo exceptionInfo : exceptionInfos) {
                exceptionTable.appendChild(exceptionInfo.toXML(document));
            }
        }
        if (attributeInfos.length > 0) {
            Element attributes = XML.createChild(document, root, "attributes");
            for (RawAttributeInfo attributeInfo : attributeInfos) {
                attributes.appendChild(attributeInfo.toXML(document, constantResolver));
            }
        }
        return root;
    }
}
