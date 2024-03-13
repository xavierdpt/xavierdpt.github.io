package xd.jvmspect.bytecode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record SimpleInstruction(OpCode opCode, boolean wide, byte[] opCodeBytes) implements Instruction {

    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element element = document.createElement(opCode.name().toLowerCase());
        if (wide) {
            element.setAttribute("wide", String.valueOf(true));
        }
        fill(document, element, constantResolver);
        return element;
    }

    private void fill(Document document, Element element, ConstantResolver constantResolver) {
        switch (opCode) {
            case AALOAD:
                break;
            case AASTORE:
                break;
            case ACONST_NULL:
                break;
            case ALOAD:
                XML.createChild(document, element, "value", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case ALOAD_0:
                break;
            case ALOAD_1:
                break;
            case ALOAD_2:
                break;
            case ALOAD_3:
                break;
            case ANEWARRAY:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case ARETURN:
                break;
            case ARRAYLENGTH:
                break;
            case ASTORE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case ASTORE_0:
                break;
            case ASTORE_1:
                break;
            case ASTORE_2:
                break;
            case ASTORE_3:
                break;
            case ATHROW:
                break;
            case BALOAD:
                break;
            case BASTORE:
                break;
            case BIPUSH:
                XML.createChild(document, element, "value", String.valueOf(opCodeBytes[0]));
                break;
            case CALOAD:
                break;
            case CASTORE:
                break;
            case CHECKCAST:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case D2F:
                break;
            case D2I:
                break;
            case D2L:
                break;
            case DADD:
                break;
            case DALOAD:
                break;
            case DASTORE:
                break;
            case DCMPG:
                break;
            case DCMPL:
                break;
            case DCONST_0:
                break;
            case DCONST_1:
                break;
            case DDIV:
                break;
            case DLOAD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case DLOAD_0:
                break;
            case DLOAD_1:
                break;
            case DLOAD_2:
                break;
            case DLOAD_3:
                break;
            case DMUL:
                break;
            case DNEG:
                break;
            case DREM:
                break;
            case DRETURN:
                break;
            case DSTORE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case DSTORE_0:
                break;
            case DSTORE_1:
                break;
            case DSTORE_2:
                break;
            case DSTORE_3:
                break;
            case DSUB:
                break;
            case DUP:
                break;
            case DUP2:
                break;
            case DUP2_X1:
                break;
            case DUP2_X2:
                break;
            case DUP_X1:
                break;
            case DUP_X2:
                break;
            case F2D:
                break;
            case F2I:
                break;
            case F2L:
                break;
            case FADD:
                break;
            case FALOAD:
                break;
            case FASTORE:
                break;
            case FCMPG:
                break;
            case FCMPL:
                break;
            case FCONST_0:
                break;
            case FCONST_1:
                break;
            case FCONST_2:
                break;
            case FDIV:
                break;
            case FLOAD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case FLOAD_0:
                break;
            case FLOAD_1:
                break;
            case FLOAD_2:
                break;
            case FLOAD_3:
                break;
            case FMUL:
                break;
            case FNEG:
                break;
            case FREM:
                break;
            case FRETURN:
                break;
            case FSTORE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case FSTORE_0:
                break;
            case FSTORE_1:
                break;
            case FSTORE_2:
                break;
            case FSTORE_3:
                break;
            case FSUB:
                break;
            case GETFIELD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case GETSTATIC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case GOTO:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case GOTO_W:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 4)));
                break;
            case I2B:
                break;
            case I2C:
                break;
            case I2D:
                break;
            case I2F:
                break;
            case I2L:
                break;
            case I2S:
                break;
            case IADD:
                break;
            case IALOAD:
                break;
            case IAND:
                break;
            case IASTORE:
                break;
            case ICONST_0:
                break;
            case ICONST_1:
                break;
            case ICONST_2:
                break;
            case ICONST_3:
                break;
            case ICONST_4:
                break;
            case ICONST_5:
                break;
            case ICONST_M1:
                break;
            case IDIV:
                break;
            case IFEQ:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFGE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFGT:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFLE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFLT:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFNE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFNONNULL:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IFNULL:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ACMPEQ:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ACMPNE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPEQ:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPGE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPGT:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPLE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPLT:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IF_ICMPNE:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IINC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                XML.createChild(document, element, "value", String.valueOf(toInt(opCodeBytes, 1, 1)));
                break;
            case ILOAD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case ILOAD_0:
                break;
            case ILOAD_1:
                break;
            case ILOAD_2:
                break;
            case ILOAD_3:
                break;
            case IMUL:
                break;
            case INEG:
                break;
            case INSTANCEOF:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case INVOKEDYNAMIC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case INVOKEINTERFACE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                XML.createChild(document, element, "count", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case INVOKESPECIAL:
                int index = toInt(opCodeBytes, 0, 2);
                element.appendChild(constantResolver.resolve(index).toXMLForCode(document, constantResolver));
            case INVOKESTATIC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case INVOKEVIRTUAL:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case IOR:
                break;
            case IREM:
                break;
            case IRETURN:
                break;
            case ISHL:
                break;
            case ISHR:
                break;
            case ISTORE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case ISTORE_0:
                break;
            case ISTORE_1:
                break;
            case ISTORE_2:
                break;
            case ISTORE_3:
                break;
            case ISUB:
                break;
            case IUSHR:
                break;
            case IXOR:
                break;
            case JSR:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case JSR_W:
                XML.createChild(document, element, "offset", String.valueOf(toInt(opCodeBytes, 0, 4)));
                break;
            case L2D:
                break;
            case L2F:
                break;
            case L2I:
                break;
            case LADD:
                break;
            case LALOAD:
                break;
            case LAND:
                break;
            case LASTORE:
                break;
            case LCMP:
                break;
            case LCONST_0:
                break;
            case LCONST_1:
                break;
            case LDC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case LDC2_W:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case LDC_W:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case LDIV:
                break;
            case LLOAD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case LLOAD_0:
                break;
            case LLOAD_1:
                break;
            case LLOAD_2:
                break;
            case LLOAD_3:
                break;
            case LMUL:
                break;
            case LNEG:
                break;
            case LOR:
                break;
            case LREM:
                break;
            case LRETURN:
                break;
            case LSHL:
                break;
            case LSHR:
                break;
            case LSTORE:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case LSTORE_0:
                break;
            case LSTORE_1:
                break;
            case LSTORE_2:
                break;
            case LSTORE_3:
                break;
            case LSUB:
                break;
            case LUSHR:
                break;
            case LXOR:
                break;
            case MONITORENTER:
                break;
            case MONITOREXIT:
                break;
            case MULTIANEWARRAY:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                XML.createChild(document, element, "dimensions", String.valueOf(toInt(opCodeBytes, 2, 1)));
                break;
            case NEW:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case NEWARRAY:
                XML.createChild(document, element, "type", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case NOP:
                break;
            case POP:
                break;
            case POP2:
                break;
            case PUTFIELD:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case PUTSTATIC:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case RET:
                XML.createChild(document, element, "index", String.valueOf(toInt(opCodeBytes, 0, 1)));
                break;
            case RETURN:
                break;
            case SALOAD:
                break;
            case SASTORE:
                break;
            case SIPUSH:
                XML.createChild(document, element, "value", String.valueOf(toInt(opCodeBytes, 0, 2)));
                break;
            case SWAP:
                break;
            default:
                throw new IllegalStateException("Unhandled opcode: " + opCode.name());
        }
    }

    private int toInt(byte[] bytes, int offset, int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result <<= 8;
            result |= Byte.toUnsignedInt(bytes[offset + i]);
        }
        return result;
    }
}
