package com.github.xavierdpt.jvmspect.input.attributes.smt;

public enum SimpleVariableInfoType {

    TOP(0),
    INTEGER(1),
    FLOAT(2),
    DOUBLE(3),
    LONG(4),
    NULL(5),
    UNINITIALIZED_THIS(6);

    private final int tag;

    SimpleVariableInfoType(int tag) {
        this.tag = tag;
    }

    public static SimpleVariableInfoType ofTag(int tag) {
        for (SimpleVariableInfoType value : values()) {
            if (tag == value.tag) {
                return value;
            }
        }
        return null;
    }

}
