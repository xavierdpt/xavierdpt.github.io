package com.github.xavierdpt.jvmspect.input.attributes.record;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RecordAttributeInfo extends AttributeInfo {
    private final RecordComponentInfo[] recordComponentInfos;

    public RecordAttributeInfo(RecordComponentInfo[] recordComponentInfos) {
        this.recordComponentInfos = recordComponentInfos;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (RecordComponentInfo recordComponentInfo : recordComponentInfos) {
            result.appendChild(recordComponentInfo.toXML(document, constantResolver));
        }
    }
}
