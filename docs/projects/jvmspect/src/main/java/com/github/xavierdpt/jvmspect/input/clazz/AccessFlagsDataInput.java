package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.flags.ClassAccessFlags;
import com.github.xavierdpt.jvmspect.input.flags.ExportsFlags;
import com.github.xavierdpt.jvmspect.input.flags.FieldAccessFlags;
import com.github.xavierdpt.jvmspect.input.flags.InnerClassAccessFlags;
import com.github.xavierdpt.jvmspect.input.flags.MethodAccessFlags;
import com.github.xavierdpt.jvmspect.input.flags.MethodParameterAccessFlags;
import com.github.xavierdpt.jvmspect.input.flags.ModuleFlags;
import com.github.xavierdpt.jvmspect.input.flags.OpensFlags;
import com.github.xavierdpt.jvmspect.input.flags.RequiresFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class AccessFlagsDataInput {

    public static ClassAccessFlags readClassFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new ClassAccessFlags(accessFlags);
    }

    public static FieldAccessFlags readFieldFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new FieldAccessFlags(accessFlags);
    }

    public static MethodAccessFlags readMethodFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new MethodAccessFlags(accessFlags);
    }

    public static InnerClassAccessFlags readInnerClassFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new InnerClassAccessFlags(accessFlags);
    }

    public static MethodParameterAccessFlags readMethodParameterFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new MethodParameterAccessFlags(accessFlags);
    }

    public static ModuleFlags readModuleFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new ModuleFlags(accessFlags);
    }

    public static RequiresFlags readRequiresFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new RequiresFlags(accessFlags);
    }

    public static ExportsFlags readExportsFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new ExportsFlags(accessFlags);
    }

    public static OpensFlags readOpensFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new OpensFlags(accessFlags);
    }
}
