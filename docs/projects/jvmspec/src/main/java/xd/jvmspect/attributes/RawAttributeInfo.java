package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.constants.StringUtils;

import java.io.IOException;

public record RawAttributeInfo(int attributeNameIndex, byte[] info) {
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element root = document.createElement("attribute");

        String attributeName = constantResolver.resolveString(attributeNameIndex);

        try {
            IAttributeInfo result = tryParse(attributeName, info);
            if (result != null) {
                root.appendChild(result.toXML(document, constantResolver));
            } else {

                Element name = document.createElement("name");
                name.setAttribute("index", String.valueOf(attributeNameIndex));

                name.appendChild(document.createTextNode(attributeName));
                root.appendChild(name);

                Element rawData = document.createElement("rawData");
                rawData.appendChild(document.createTextNode(StringUtils.toXMLTextNodeContent(info)));
                root.appendChild(rawData);
            }
        } catch (IOException e) {
            Element exception = document.createElement("exception");
            exception.appendChild(document.createTextNode(e.getClass().getName() + ": " + e.getMessage()));
        }

        return root;
    }

    private static IAttributeInfo tryParse(String attributeName, byte[] bytes) throws IOException {
        return switch (attributeName) {
            case "Code" -> AttributeInfoFactory.parseCode(bytes);
            case "LineNumberTable" -> AttributeInfoFactory.parseLineNumberTable(bytes);
            case "LocalVariableTable" -> AttributeInfoFactory.parseLocalVariableTable(bytes);
            case "SourceFile" -> AttributeInfoFactory.parseSourceFile(bytes);
            case "NestHost" -> AttributeInfoFactory.parseNestHost(bytes);
            case "InnerClasses" -> AttributeInfoFactory.parseInnerClasses(bytes);
            default -> null;
        };
    }
}
