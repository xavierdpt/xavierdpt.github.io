package com.github.xavierdpt.jvmspect.input.attributes.ic;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.flags.InnerClassAccessFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class InnerClass {
    private final int innerClassInfoIndex;
    private final int outerClassInfoIndex;
    private final int innerNameIndex;
    private final InnerClassAccessFlags innerClassAccessFlags;

    public InnerClass(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex,
                      InnerClassAccessFlags innerClassAccessFlags) {
        this.innerClassInfoIndex = innerClassInfoIndex;
        this.outerClassInfoIndex = outerClassInfoIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerClassAccessFlags = innerClassAccessFlags;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("innerClass");
        XML.constantAttribute(document, result, "innerClassInfo", constantResolver, innerClassInfoIndex);
        if (outerClassInfoIndex != 0) {
            XML.constantAttribute(document, result, "innerClassInfo", constantResolver, outerClassInfoIndex);
        }
        if (innerNameIndex != 0) {
            XML.constantElement(document, result, "innerClassInfo", constantResolver, innerNameIndex);
        }
        result.appendChild(innerClassAccessFlags.toXML(document));
        return result;
    }

}
