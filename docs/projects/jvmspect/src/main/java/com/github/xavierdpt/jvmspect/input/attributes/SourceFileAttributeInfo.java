package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class SourceFileAttributeInfo extends AttributeInfo {
    private final int sourceFileIndex;

    public SourceFileAttributeInfo(int sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantText(document, result, "sourceFile", constantResolver, sourceFileIndex);
    }
}
