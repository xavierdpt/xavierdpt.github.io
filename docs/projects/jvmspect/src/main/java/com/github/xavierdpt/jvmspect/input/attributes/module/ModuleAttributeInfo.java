package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.flags.ModuleFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ModuleAttributeInfo extends AttributeInfo {
    private final int moduleNameIndex;
    private final ModuleFlags moduleFlags;
    private final int moduleVersionIndex;
    private final Requires[] requires;
    private final Exports[] exports;
    private final Opens[] opens;
    private final int[] usesIndexes;
    private final Provides[] provides;

    public ModuleAttributeInfo(int moduleNameIndex, ModuleFlags moduleFlags, int moduleVersionIndex, Requires[] requires, Exports[] exports, Opens[] opens, int[] usesIndexes, Provides[] provides) {
        this.moduleNameIndex = moduleNameIndex;
        this.moduleFlags = moduleFlags;
        this.moduleVersionIndex = moduleVersionIndex;
        this.requires = requires;
        this.exports = exports;
        this.opens = opens;
        this.usesIndexes = usesIndexes;
        this.provides = provides;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(moduleNameIndex).toXMLRef(document, constantResolver));
        result.appendChild(moduleFlags.toXML(document));
        if (moduleVersionIndex != 0) {
            XML.constantAttribute(document, result, "moduleVersion", constantResolver, moduleVersionIndex);
        }
        {
            Element container = XML.createChild(document, result, "requires");
            for (Requires require : requires) {
                container.appendChild(require.toXML(document, constantResolver));
            }
        }
        {
            Element container = XML.createChild(document, result, "exports");
            for (Exports export : exports) {
                container.appendChild(export.toXML(document, constantResolver));
            }
        }
        {
            Element container = XML.createChild(document, result, "opens");
            for (Opens open : opens) {
                container.appendChild(open.toXML(document, constantResolver));
            }
        }
        {
            Element container = XML.createChild(document, result, "uses");
            for (int usesIndex : usesIndexes) {
                container.appendChild(constantResolver.resolve(usesIndex).toXMLRef(document, constantResolver));
            }
        }
        {
            Element container = XML.createChild(document, result, "provides");
            for (Provides provide : provides) {
                container.appendChild(provide.toXML(document, constantResolver));
            }
        }
    }
}
