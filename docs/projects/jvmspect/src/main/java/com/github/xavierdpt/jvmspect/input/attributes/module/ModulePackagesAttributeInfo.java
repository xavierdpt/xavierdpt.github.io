package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ModulePackagesAttributeInfo extends AttributeInfo {
    private final int[] packageIndexes;

    public ModulePackagesAttributeInfo(int[] packageIndexes) {
        this.packageIndexes = packageIndexes;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (int packageIndex : packageIndexes) {
            result.appendChild(constantResolver.resolve(packageIndex).toXMLRef(document, constantResolver));
        }
    }
}
