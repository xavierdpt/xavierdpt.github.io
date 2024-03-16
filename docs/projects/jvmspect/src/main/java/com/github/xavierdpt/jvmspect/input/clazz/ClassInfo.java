package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.flags.ClassAccessFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ClassInfo {

    private final int minorVersion;
    private final int majorVersion;
    private final Constant[] constantObjects;
    private final ConstantResolver constantResolver;
    private final ClassAccessFlags accessFlags;
    private final int thisClassIndex;
    private final int superClassIndex;
    private final int[] interfaceIndexes;
    private final FieldInfo[] fieldInfos;
    private final MethodInfo[] methodInfos;
    private final AttributeInfo[] attributeInfos;

    public ClassInfo(
            int minorVersion, int majorVersion,
            Constant[] constantObjects,
            ConstantResolver constantResolver, ClassAccessFlags accessFlags,
            int thisClass, int superClass,
            int[] interfaces, FieldInfo[] fieldInfos, MethodInfo[] methodInfos, AttributeInfo[] attributeInfos) {
        this.minorVersion = minorVersion;
        this.majorVersion = majorVersion;
        this.constantObjects = constantObjects;
        this.constantResolver = constantResolver;
        this.accessFlags = accessFlags;
        this.thisClassIndex = thisClass;
        this.superClassIndex = superClass;
        this.interfaceIndexes = interfaces;
        this.fieldInfos = fieldInfos;
        this.methodInfos = methodInfos;
        this.attributeInfos = attributeInfos;
    }

    public Document toXML() {
        Document document = XML.createDocument();
        Element result = XML.createRootElement(document, "root");
        Element versionXML = document.createElement("version");
        versionXML.setAttribute("minor", String.valueOf(minorVersion));
        versionXML.setAttribute("major", String.valueOf(majorVersion));
        result.appendChild(versionXML);
        Element constants = XML.createChild(document, result, "constants");
        for (int constantIndex = 0; constantIndex < constantObjects.length; constantIndex++) {
            Constant constantObject = constantObjects[constantIndex];
            if (constantObject == null) {
                continue;
            }
            constants.appendChild(constantObject.toXML(document, constantIndex + 1));
        }
        result.appendChild(accessFlags.toXML(document));
        XML.constantAttribute(document, result, "thisClass", this.constantResolver, thisClassIndex);
        if (superClassIndex != 0) {
            XML.constantAttribute(document, result, "superClass", this.constantResolver, superClassIndex);
        }
        Element interfacesXML = XML.createChild(document, result, "interfaces");
        for (int interfaceIndex : interfaceIndexes) {
            XML.constantAttribute(document, interfacesXML, "superClass", this.constantResolver, interfaceIndex);
        }
        Element fields = XML.createChild(document, result, "fields");
        for (FieldInfo fieldInfo : this.fieldInfos) {
            fields.appendChild(fieldInfo.toXML(document, this.constantResolver));
        }
        Element methods = XML.createChild(document, result, "methods");
        for (MethodInfo methodInfo : methodInfos) {
            methods.appendChild(methodInfo.toXML(document, this.constantResolver));
        }
        Element attributes = XML.createChild(document, result, "attributes");
        for (AttributeInfo attributeInfo : attributeInfos) {
            attributes.appendChild(attributeInfo.toXML(document, this.constantResolver));
        }
        return document;
    }

}
