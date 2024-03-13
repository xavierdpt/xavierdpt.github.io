package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.attributes.RawAttributeInfo;
import xd.jvmspect.constants.ConstantObject;
import xd.jvmspect.xml.XML;

public record ClassInfo(
        ClassFileVersion version,
        xd.jvmspect.constants.ConstantObject[] constantObjects, AccessFlags accessFlags,
        int thisClass,
        int superClass,
        int[] interfaces,
        FieldInfo[] fieldInfos,
        MethodInfo[] methodInfos, RawAttributeInfo[] attributeInfos) {
    public Document toXML() {
        ConstantResolver constantResolver = new ConstantResolver(constantObjects);
        Document document = XML.createDocument();
        Element root = XML.createRootElement(document, "root");
        root.appendChild(version.toXML(document));
        root.appendChild(accessFlags.toXML(document));
        XML.createChild(document, root, "thisClass", String.valueOf(thisClass));
        XML.createChild(document, root, "superClass", String.valueOf(superClass));
        Element constants = XML.createChild(document, root, "constants");
        for (int constantIndex = 0; constantIndex < constantObjects.length; constantIndex++) {
            ConstantObject constantObject = constantObjects[constantIndex];
            if (constantObject==null) {
                continue;
            }
            constants.appendChild(constantObject.toXML(document, constantIndex + 1, constantResolver));
        }
        Element interfaces = XML.createChild(document, root, "interfaces");
        for (int anInterface : this.interfaces) {
            XML.createChild(document, interfaces, "interface", String.valueOf(anInterface));
        }
        Element fields = XML.createChild(document, root, "fields");
        for (FieldInfo fieldInfo : this.fieldInfos) {
            fields.appendChild(fieldInfo.toXML(document, constantResolver));
        }
        Element methods = XML.createChild(document, root, "methods");
        for (MethodInfo methodInfo : methodInfos) {
            methods.appendChild(methodInfo.toXML(document, constantResolver));
        }
        Element attributes = XML.createChild(document, root, "attributes");
        for (RawAttributeInfo attributeInfo : attributeInfos) {
            attributes.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        return document;
    }
}
