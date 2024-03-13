package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record InnerClass(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
                         int innerClassAccessFlags) {
    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("innerClass");
        Element innerClass = XML.createChild(document, result, "innerClass");
        innerClass.appendChild(constantResolver.resolve(innerClassInfoIndex).toXMLForCode(document, constantResolver));
        if (outerClassInfoIndex!=0) {
            Element outerClass = XML.createChild(document, result, "outerClass");
            outerClass.appendChild(constantResolver.resolve(outerClassInfoIndex).toXMLForCode(document, constantResolver));
        }
        if (innerNameIndex!=0) {
            XML.createChild(document, result, "innerName", constantResolver.resolveString(innerNameIndex));
        }
        XML.createChild(document, result, "innerClassAccessFlags", String.valueOf(innerClassAccessFlags));
        return result;
    }
}
