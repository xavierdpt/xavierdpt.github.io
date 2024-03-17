package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantFieldRef extends Constant {
    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantFieldRef(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    protected String getTypeName() {
        return "FieldRef";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("classIndex", String.valueOf(classIndex));
        result.setAttribute("nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "class", constantResolver, classIndex);
        XML.constantAttribute(document, result, "nameAndTypeIndex", constantResolver, nameAndTypeIndex);
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        // Same as MethodRef
        Constant classA = constantResolver.resolve(classIndex);
        Constant nameAndTypeA = constantResolver.resolve(nameAndTypeIndex);
        if (classA instanceof ConstantClass classT && nameAndTypeA instanceof ConstantNameAndType nameAndTypeT) {
            Constant classNameA = constantResolver.resolve(classT.getNameIndex());
            int nameIndex = nameAndTypeT.getNameIndex();
            int descriptorIndex = nameAndTypeT.getDescriptorIndex();
            Constant methodNameA = constantResolver.resolve(nameIndex);
            Constant methodDescriptorA = constantResolver.resolve(descriptorIndex);
            if (classNameA instanceof ConstantUtf8 classNameT &&
                methodNameA instanceof ConstantUtf8 methodNameT &&
                methodDescriptorA instanceof ConstantUtf8 methodDescriptorT) {
                return classNameT.getJavaString() + " " + methodNameT.getJavaString() + " " + methodDescriptorT.getJavaString();
            }
        }
        String clazz = classA.toTextDetails(constantResolver);
        String nameAndType = nameAndTypeA.toTextDetails(constantResolver);
        return getTypeName() + "(" + clazz + "," + nameAndType + ")";


    }

}
