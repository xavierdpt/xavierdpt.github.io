package com.github.xavierdpt.jvmspect.input.attributes.code;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstructionDataInput {
    public static List<Instruction> parse(byte[] bytes, int index, int count) throws IOException {
        List<Instruction> result = new ArrayList<>();
        if (count == 0) {
            return result;
        }
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        dis.readNBytes(index);
        boolean wide = false;
        int[] codeIndex = {0};
        while (dis.available() > 0) {
            int opcode = dis.readUnsignedByte();
            ++codeIndex[0];
            OpCode opCode = OpCode.of(opcode);
            switch (opCode) {
                case LOOKUPSWITCH -> {
                    if (wide) {
                        throw cannotBeWide(opCode);
                    }
                    result.add(parseLookupSwitch(dis, codeIndex));
                }
                case TABLESWITCH -> {
                    if (wide) {
                        throw cannotBeWide(opCode);
                    }
                    result.add(parseTableSwitch(dis, codeIndex));
                }
                case WIDE -> {
                    if (wide) {
                        throw cannotBeWide(opCode);
                    }
                    wide = true;
                }
                default -> {
                    int size = getSize(opCode, wide);
                    if (wide) {
                        wide = false;
                    }
                    byte[] opCodeBytes = dis.readNBytes(size);
                    result.add(new SimpleInstruction(opCode, wide, opCodeBytes, codeIndex[0] - 1));
                    codeIndex[0] += size;
                }
            }
            if (result.size() == count) {
                break;
            }
        }
        return result;
    }

    private static int getSize(OpCode opCode, boolean wide) {
        if (wide) {
            return switch (opCode) {
                case ILOAD, FLOAD, ALOAD, LLOAD, DLOAD, ISTORE, FSTORE, ASTORE, LSTORE, DSTORE, RET -> 2;
                case IINC -> 4;
                default -> throw cannotBeWide(opCode);
            };
        } else {
            return opCode.getSize();
        }
    }

    private static IllegalStateException cannotBeWide(OpCode opCode) {
        return new IllegalStateException("This opcode cannot be wide: " + opCode.name());
    }

    private static Instruction parseTableSwitch(DataInputStream dis, int[] codeIndex) throws IOException {

        int paddingBytes = (4 - (codeIndex[0] % 4)) % 4;
        dis.readNBytes(paddingBytes);

        int defaultOffset = dis.readInt();
        int low = dis.readInt();
        int high = dis.readInt();
        int noffsets = high - low + 1;
        int[] offsets = new int[noffsets];
        for (int i = 0; i < noffsets; i++) {
            offsets[i] = dis.readInt();
        }

        int thisCodeIndex = codeIndex[0] - 1;
        codeIndex[0] += paddingBytes + 16 + noffsets * 4;
        return new TableSwitchInstruction(defaultOffset, offsets, thisCodeIndex);
    }

    private static Instruction parseLookupSwitch(DataInputStream dis, int[] codeIndex) throws IOException {

        int paddingBytes = (4 - (codeIndex[0] % 4)) % 4;
        dis.readNBytes(paddingBytes); // paddingBytes

        int defaultOffset = dis.readInt(); // 4
        int npairs = dis.readInt(); // 4

        List<LookupSwitchPair> pairs = new ArrayList<>();
        for (int i = 0; i < npairs; i++) {
            int first = dis.readInt(); // 4
            int second = dis.readInt(); // 4
            pairs.add(new LookupSwitchPair(first, second));
        }

        int thisCodeIndex = codeIndex[0] - 1;
        codeIndex[0] += paddingBytes + 8 + 8 * npairs;

        return new LookupSwitchInstruction(defaultOffset, pairs, thisCodeIndex);
    }
}
