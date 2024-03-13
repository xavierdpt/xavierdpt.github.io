package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record LocalVariableTableAttributeInfo(LocalVariable[] localVariables) implements IAttributeInfo {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("localVariables");
        for (LocalVariable localVariable : localVariables) {
            result.appendChild(localVariable.toXML(document,constantResolver));
        }
        return result;
    }
}
