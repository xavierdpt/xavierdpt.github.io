package com.github.xavierdpt.jvmspect.input.attributes.module;

import com.github.xavierdpt.jvmspect.input.clazz.AccessFlagsDataInput;
import com.github.xavierdpt.jvmspect.input.flags.ExportsFlags;
import com.github.xavierdpt.jvmspect.input.flags.ModuleFlags;
import com.github.xavierdpt.jvmspect.input.flags.OpensFlags;
import com.github.xavierdpt.jvmspect.input.flags.RequiresFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class ModuleDataInput {
    public static ModuleAttributeInfo readModule(DataInputStream dis) throws IOException {

        int moduleNameIndex = dis.readUnsignedShort();
        ModuleFlags moduleFlags = AccessFlagsDataInput.readModuleFlags(dis);
        int moduleVersionIndex = dis.readUnsignedShort();

        int requiresCount = dis.readUnsignedShort();
        Requires[] requires = new Requires[requiresCount];
        for (int i = 0; i < requiresCount; i++) {
            requires[i] = readRequires(dis);
        }

        int exportsCount = dis.readUnsignedShort();
        Exports[] exports = new Exports[exportsCount];
        for (int i = 0; i < exportsCount; i++) {
            exports[i] = readExports(dis);
        }

        int opensCount = dis.readUnsignedShort();
        Opens[] opens = new Opens[opensCount];
        for (int i = 0; i < opensCount; i++) {
            opens[i] = readOpens(dis);
        }

        int usesCount = dis.readUnsignedShort();
        int[] usesIndexes = new int[usesCount];
        for (int i = 0; i < usesCount; i++) {
            int usesIndex = dis.readUnsignedShort();
            usesIndexes[i] = usesIndex;
        }

        int providesCount = dis.readUnsignedShort();
        Provides[] provides = new Provides[providesCount];
        for (int i = 0; i < providesCount; i++) {
            provides[i] = readProvides(dis);
        }

        return new ModuleAttributeInfo(moduleNameIndex, moduleFlags, moduleVersionIndex, requires, exports, opens, usesIndexes, provides);
    }

    public static Requires readRequires(DataInputStream dis) throws IOException {
        int requiresIndex = dis.readUnsignedShort();
        RequiresFlags requiresFlags1 = AccessFlagsDataInput.readRequiresFlags(dis);
        RequiresFlags requiresFlags = requiresFlags1;
        int requiresVersionIndex = dis.readUnsignedShort();
        return new Requires(requiresIndex, requiresFlags, requiresVersionIndex);
    }

    public static Exports readExports(DataInputStream dis) throws IOException {
        int exportsIndex = dis.readUnsignedShort();
        ExportsFlags exportsFlags = AccessFlagsDataInput.readExportsFlags(dis);
        int exportsToCount = dis.readUnsignedShort();
        int[] exportsToIndexes = new int[exportsToCount];
        for (int i = 0; i < exportsToCount; i++) {
            int exportsToIndex = dis.readUnsignedShort();
            exportsToIndexes[i] = exportsToIndex;
        }
        return new Exports(exportsIndex, exportsFlags, exportsToIndexes);
    }

    public static Opens readOpens(DataInputStream dis) throws IOException {
        int opensIndex = dis.readUnsignedShort();
        OpensFlags opensFlags = AccessFlagsDataInput.readOpensFlags(dis);
        int opensToCount = dis.readUnsignedShort();
        int[] opensToIndexes = new int[opensToCount];
        for (int i = 0; i < opensToCount; i++) {
            int opensToIndex = dis.readUnsignedShort();
            opensToIndexes[i] = opensToIndex;
        }
        return new Opens(opensIndex, opensFlags, opensToIndexes);
    }

    public static Provides readProvides(DataInputStream dis) throws IOException {
        int providesIndex = dis.readUnsignedShort();
        int providesWithCount = dis.readUnsignedShort();
        int[] providesWithIndexes = new int[providesWithCount];
        for (int i = 0; i < providesWithCount; i++) {
            int providesWithIndex = dis.readUnsignedShort();
            providesWithIndexes[i] = providesWithIndex;
        }
        return new Provides(providesIndex, providesWithIndexes);
    }
}
