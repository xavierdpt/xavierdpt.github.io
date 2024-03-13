package xd.jvmspect;

import xd.jvmspect.constants.ConstantObject;
import xd.jvmspect.constants.ConstantString;
import xd.jvmspect.constants.ConstantUtf8;

public class ConstantResolver {
    private final ConstantObject[] constantObjects;

    public ConstantResolver(ConstantObject[] constantObjects) {

        this.constantObjects = constantObjects;
    }

    public String resolveString(int index) {
        ConstantObject constantObject = constantObjects[index - 1];
        if (constantObject instanceof ConstantUtf8 constantUtf8) {
            return constantUtf8.getUTF8String();
        } else if (constantObject instanceof ConstantString constantString) {
            return resolveString(constantString.stringIndex());
        } else {
            throw new IllegalStateException("TODO");
        }
    }

    public ConstantObject resolve(int index) {
        if (index==0) {
            System.out.println("Whut?");
        }
        return constantObjects[index - 1];
    }
}
