package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.DynamicConstantDesc;

@Scaffolded
public class ConstantDescsExample extends BaseExample<ConstantDescs> {
    @Override
    public void scaffold(ConstantDescs instance) {

        ClassDesc owner = null;
        String name = null;
        ClassDesc returnType = null;
        ClassDesc[] paramTypes = new ClassDesc[0];
        DirectMethodHandleDesc directMethodHandleDesc = ConstantDescs.ofCallsiteBootstrap(owner, name, returnType, paramTypes);

        DirectMethodHandleDesc directMethodHandleDesc1 = ConstantDescs.ofConstantBootstrap(owner, name, returnType, paramTypes);

        String defaultName = ConstantDescs.DEFAULT_NAME;
        ClassDesc cd_object = ConstantDescs.CD_Object;
        ClassDesc cd_string = ConstantDescs.CD_String;
        ClassDesc cd_class = ConstantDescs.CD_Class;
        ClassDesc cd_number = ConstantDescs.CD_Number;
        ClassDesc cd_integer = ConstantDescs.CD_Integer;
        ClassDesc cd_long = ConstantDescs.CD_Long;
        ClassDesc cd_float = ConstantDescs.CD_Float;
        ClassDesc cd_double = ConstantDescs.CD_Double;
        ClassDesc cd_short = ConstantDescs.CD_Short;
        ClassDesc cd_byte = ConstantDescs.CD_Byte;
        ClassDesc cd_character = ConstantDescs.CD_Character;
        ClassDesc cd_boolean = ConstantDescs.CD_Boolean;
        ClassDesc cd_void = ConstantDescs.CD_Void;
        ClassDesc cd_throwable = ConstantDescs.CD_Throwable;
        ClassDesc cd_exception = ConstantDescs.CD_Exception;
        ClassDesc cd_enum = ConstantDescs.CD_Enum;
        ClassDesc cd_varHandle = ConstantDescs.CD_VarHandle;
        ClassDesc cd_methodHandles = ConstantDescs.CD_MethodHandles;
        ClassDesc cd_methodHandles_lookup = ConstantDescs.CD_MethodHandles_Lookup;
        ClassDesc cd_methodHandle = ConstantDescs.CD_MethodHandle;
        ClassDesc cd_methodType = ConstantDescs.CD_MethodType;
        ClassDesc cd_callSite = ConstantDescs.CD_CallSite;
        ClassDesc cd_collection = ConstantDescs.CD_Collection;
        ClassDesc cd_list = ConstantDescs.CD_List;
        ClassDesc cd_set = ConstantDescs.CD_Set;
        ClassDesc cd_map = ConstantDescs.CD_Map;
        ClassDesc cd_constantDesc = ConstantDescs.CD_ConstantDesc;
        ClassDesc cd_classDesc = ConstantDescs.CD_ClassDesc;
        ClassDesc cd_enumDesc = ConstantDescs.CD_EnumDesc;
        ClassDesc cd_methodTypeDesc = ConstantDescs.CD_MethodTypeDesc;
        ClassDesc cd_methodHandleDesc = ConstantDescs.CD_MethodHandleDesc;
        ClassDesc cd_directMethodHandleDesc = ConstantDescs.CD_DirectMethodHandleDesc;
        ClassDesc cd_varHandleDesc = ConstantDescs.CD_VarHandleDesc;
        ClassDesc cd_methodHandleDesc_kind = ConstantDescs.CD_MethodHandleDesc_Kind;
        ClassDesc cd_dynamicConstantDesc = ConstantDescs.CD_DynamicConstantDesc;
        ClassDesc cd_dynamicCallSiteDesc = ConstantDescs.CD_DynamicCallSiteDesc;
        ClassDesc cd_constantBootstraps = ConstantDescs.CD_ConstantBootstraps;
        DirectMethodHandleDesc bsmPrimitiveClass = ConstantDescs.BSM_PRIMITIVE_CLASS;
        DirectMethodHandleDesc bsmEnumConstant = ConstantDescs.BSM_ENUM_CONSTANT;
        DirectMethodHandleDesc bsmGetStaticFinal = ConstantDescs.BSM_GET_STATIC_FINAL;
        DirectMethodHandleDesc bsmNullConstant = ConstantDescs.BSM_NULL_CONSTANT;
        DirectMethodHandleDesc bsmVarhandleField = ConstantDescs.BSM_VARHANDLE_FIELD;
        DirectMethodHandleDesc bsmVarhandleStaticField = ConstantDescs.BSM_VARHANDLE_STATIC_FIELD;
        DirectMethodHandleDesc bsmVarhandleArray = ConstantDescs.BSM_VARHANDLE_ARRAY;
        DirectMethodHandleDesc bsmInvoke = ConstantDescs.BSM_INVOKE;
        DirectMethodHandleDesc bsmExplicitCast = ConstantDescs.BSM_EXPLICIT_CAST;
        ClassDesc cd_int = ConstantDescs.CD_int;
        ClassDesc cd_long1 = ConstantDescs.CD_long;
        ClassDesc cd_float1 = ConstantDescs.CD_float;
        ClassDesc cd_double1 = ConstantDescs.CD_double;
        ClassDesc cd_short1 = ConstantDescs.CD_short;
        ClassDesc cd_byte1 = ConstantDescs.CD_byte;
        ClassDesc cd_char = ConstantDescs.CD_char;
        ClassDesc cd_boolean1 = ConstantDescs.CD_boolean;
        ClassDesc cd_void1 = ConstantDescs.CD_void;
        ConstantDesc aNull = ConstantDescs.NULL;
        DynamicConstantDesc<Boolean> aTrue = ConstantDescs.TRUE;
        DynamicConstantDesc<Boolean> aFalse = ConstantDescs.FALSE;

    }
}
