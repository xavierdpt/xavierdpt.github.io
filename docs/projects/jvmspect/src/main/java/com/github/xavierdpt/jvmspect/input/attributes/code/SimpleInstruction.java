package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class SimpleInstruction extends Instruction {

    private final boolean wide;
    private final byte[] opCodeBytes;

    public SimpleInstruction(OpCode opCode, boolean wide, byte[] opCodeBytes, int codeIndex) {
        super(opCode, codeIndex);
        this.wide = wide;
        this.opCodeBytes = opCodeBytes;
    }

    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element element = document.createElement(opCode.name().toLowerCase());
        if (wide) {
            element.setAttribute("wide", String.valueOf(true));
        }
        fill(document, element, constantResolver);
        return element;
    }

    private void fill(Document document, Element result, ConstantResolver constantResolver) {
        switch (opCode) {
            case ILOAD, FLOAD, ALOAD, LLOAD, DLOAD, ISTORE, FSTORE, ASTORE, LSTORE, DSTORE, RET -> {
                int index = switch (opCodeBytes.length) {
                    case 1 -> toUnsignedInt(opCodeBytes, 0, 1);
                    case 2 -> toUnsignedInt(opCodeBytes, 0, 1);
                    default ->
                            throw new IllegalStateException("Unexpected opcode length for " + opCode.name() + ": " + opCodeBytes.length);
                };
                result.setAttribute("index", String.valueOf(index));
            }
            case LDC -> result.setAttribute("index", String.valueOf(toUnsignedInt(opCodeBytes, 0, 1)));
            case ANEWARRAY, CHECKCAST, INSTANCEOF, NEW, GETFIELD, PUTFIELD, GETSTATIC, PUTSTATIC, INVOKEDYNAMIC, INVOKEVIRTUAL, INVOKESPECIAL, INVOKESTATIC, LDC2_W, LDC_W ->
                    result.appendChild(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toXMLRef(document, constantResolver));
            case BIPUSH -> result.setAttribute("value", String.valueOf(toUnsignedInt(opCodeBytes, 0, 1)));
            case IFNULL, IFNONNULL, IFNE, IFLT, IFLE, IFGT, IFGE, IFEQ, IF_ICMPNE, IF_ICMPLT, IF_ICMPLE, IF_ICMPGT, IF_ICMPGE, IF_ICMPEQ, IF_ACMPNE, IF_ACMPEQ, GOTO, JSR ->
                    result.setAttribute("offset", String.valueOf(toSignedInt(opCodeBytes, 0, 2)));
            case GOTO_W, JSR_W -> result.setAttribute("offset", String.valueOf(toSignedInt(opCodeBytes, 0, 4)));
            case IINC -> {
                {
                    int index;
                    int value;
                    switch (opCodeBytes.length) {
                        case 2 -> {
                            index = toUnsignedInt(opCodeBytes, 0, 1);
                            value = toSignedInt(opCodeBytes, 1, 1);
                        }
                        case 4 -> {
                            index = toUnsignedInt(opCodeBytes, 0, 2);
                            value = toSignedInt(opCodeBytes, 2, 2);
                        }
                        default ->
                                throw new IllegalStateException("Unexpected instructin byte length for iinc: " + opCodeBytes.length);
                    }
                    result.setAttribute("index", String.valueOf(index));
                    result.setAttribute("value", String.valueOf(value));
                }
            }
            case INVOKEINTERFACE -> {
                result.setAttribute("count", String.valueOf(toUnsignedInt(opCodeBytes, 2, 1)));
                result.appendChild(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toXMLRef(document, constantResolver));
            }
            case NEWARRAY -> {
                int arrayType = toUnsignedInt(opCodeBytes, 0, 1);
                String value = switch (arrayType) {
                    case 4 -> "boolean";
                    case 5 -> "char";
                    case 6 -> "float";
                    case 7 -> "double";
                    case 8 -> "byte";
                    case 9 -> "short";
                    case 10 -> "int";
                    case 11 -> "long";
                    default -> throw new IllegalStateException("Unexpected array type: " + arrayType);
                };
                result.setAttribute("type", value);
            }
            case MULTIANEWARRAY -> {
                result.appendChild(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toXMLRef(document, constantResolver));
                result.setAttribute("dimensions", String.valueOf(toUnsignedInt(opCodeBytes, 2, 1)));
            }
            case SIPUSH -> result.setAttribute("value", String.valueOf(toSignedInt(opCodeBytes, 0, 2)));
            case LOOKUPSWITCH, TABLESWITCH, WIDE -> {
                throw new IllegalStateException("Unexpected opcode: " + opCode.name());
            }
            default -> {
                if (opCodeBytes.length > 0) {
                    throw new RuntimeException("Unexpected bytes for " + opCode.name());
                }

            }
        }
    }

    @Override
    public String textDetails(ConstantResolver constantResolver) {
        StringBuilder sb = new StringBuilder();
        switch (opCode) {
            case ILOAD, FLOAD, ALOAD, LLOAD, DLOAD, ISTORE, FSTORE, ASTORE, LSTORE, DSTORE, RET -> {
                int index = switch (opCodeBytes.length) {
                    case 1 -> toUnsignedInt(opCodeBytes, 0, 1);
                    case 2 -> toUnsignedInt(opCodeBytes, 0, 1);
                    default ->
                            throw new IllegalStateException("Unexpected opcode length for " + opCode.name() + ": " + opCodeBytes.length);
                };
                sb.append(index);
            }
            case LDC -> sb.append(toUnsignedInt(opCodeBytes, 0, 1));
            case ANEWARRAY, CHECKCAST, INSTANCEOF, NEW, GETFIELD, PUTFIELD, GETSTATIC, PUTSTATIC, INVOKEDYNAMIC, INVOKEVIRTUAL, INVOKESPECIAL, INVOKESTATIC, LDC2_W, LDC_W ->
                    sb.append(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toTextDetails(constantResolver));
            case BIPUSH -> sb.append(toUnsignedInt(opCodeBytes, 0, 1));
            case IFNULL, IFNONNULL, IFNE, IFLT, IFLE, IFGT, IFGE, IFEQ, IF_ICMPNE, IF_ICMPLT, IF_ICMPLE, IF_ICMPGT, IF_ICMPGE, IF_ICMPEQ, IF_ACMPNE, IF_ACMPEQ, GOTO, JSR ->
                    sb.append(codeIndex + toSignedInt(opCodeBytes, 0, 2));
            case GOTO_W, JSR_W -> sb.append(codeIndex + toSignedInt(opCodeBytes, 0, 4));
            case IINC -> {
                {
                    int index;
                    int value;
                    switch (opCodeBytes.length) {
                        case 2 -> {
                            index = toUnsignedInt(opCodeBytes, 0, 1);
                            value = toSignedInt(opCodeBytes, 1, 1);
                        }
                        case 4 -> {
                            index = toUnsignedInt(opCodeBytes, 0, 2);
                            value = toSignedInt(opCodeBytes, 2, 2);
                        }
                        default ->
                                throw new IllegalStateException("Unexpected instructin byte length for iinc: " + opCodeBytes.length);
                    }
                    sb.append(index);
                    sb.append(value);
                }
            }
            case INVOKEINTERFACE -> {
                sb.append(toUnsignedInt(opCodeBytes, 2, 1));
                sb.append(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toTextDetails(constantResolver));
            }
            case NEWARRAY -> {
                int arrayType = toUnsignedInt(opCodeBytes, 0, 1);
                String value = switch (arrayType) {
                    case 4 -> "boolean";
                    case 5 -> "char";
                    case 6 -> "float";
                    case 7 -> "double";
                    case 8 -> "byte";
                    case 9 -> "short";
                    case 10 -> "int";
                    case 11 -> "long";
                    default -> throw new IllegalStateException("Unexpected array type: " + arrayType);
                };
                sb.append(value);
            }
            case MULTIANEWARRAY -> {
                sb.append(constantResolver.resolve(toUnsignedInt(opCodeBytes, 0, 2)).toTextDetails(constantResolver));
                sb.append(toUnsignedInt(opCodeBytes, 2, 1));
            }
            case SIPUSH -> sb.append(toSignedInt(opCodeBytes, 0, 2));
            case LOOKUPSWITCH, TABLESWITCH, WIDE -> {
                throw new IllegalStateException("Unexpected opcode: " + opCode.name());
            }
            default -> {
                if (opCodeBytes.length > 0) {
                    throw new RuntimeException("Unexpected bytes for " + opCode.name());
                }

            }

        }
        return sb.toString();
    }

}
