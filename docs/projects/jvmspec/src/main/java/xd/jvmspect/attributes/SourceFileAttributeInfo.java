package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record SourceFileAttributeInfo(int sourceFileIndex) implements IAttributeInfo {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("sourceFile");
        XML.createChild(document, result, "value", constantResolver.resolveString(sourceFileIndex));
        return result;
    }
}
