package com.github.xavierdpt.jvmspect.input;

import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.bm.BootstrapMethod;
import com.github.xavierdpt.jvmspect.input.attributes.bm.BootstrapMethodsAttributeInfo;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantString;
import com.github.xavierdpt.jvmspect.input.constants.ConstantUtf8;

public class ConstantResolver {
    private final Constant[] constantObjects;
    private BootstrapMethodsAttributeInfo bootstrapMethodsAttributeInfo;

    public ConstantResolver(Constant[] constantObjects) {
        this.constantObjects = constantObjects;
    }

    public String resolveString(int index) {
        Constant constantObject = constantObjects[index - 1];
        if (constantObject instanceof ConstantUtf8) {
            ConstantUtf8 constantUtf8 = (ConstantUtf8) constantObject;
            return constantUtf8.getUTF8String();
        } else if (constantObject instanceof ConstantString) {
            ConstantString constantString = (ConstantString) constantObject;
            return resolveString(constantString.stringIndex());
        } else {
            throw new IllegalStateException("TODO");
        }
    }

    public Constant resolve(int index) {
        return constantObjects[index - 1];
    }

    public void setBoostrapMethods(AttributeInfo[] attributeInfos) {
        for (AttributeInfo attributeInfo : attributeInfos) {
            if (attributeInfo instanceof BootstrapMethodsAttributeInfo) {
                BootstrapMethodsAttributeInfo bootstrapMethodsAttributeInfo = (BootstrapMethodsAttributeInfo) attributeInfo;
                this.bootstrapMethodsAttributeInfo = bootstrapMethodsAttributeInfo;
            }
        }
    }

    public BootstrapMethod resolveBoostrapMethod(int index) {
        return this.bootstrapMethodsAttributeInfo.getBoostrapMethod(index);
    }
}
