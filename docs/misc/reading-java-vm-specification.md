# 1. Introduction

## 2.3. Primitive Types and Values

- numeric types
  - integral types
    - byte
    - short
    - int
    - long
    - char
  - floating-point types  
    - float
    - double
- boolean type
  - for regular use, treated as an int
  - for arrays, newarray support the creation of boolean arrays, and baload and bastore can be used for access and assignment
  - also they are typically stored as bits in an array of bytes
- returnAddress type
  - for jsr, ret, and jsr_w
- reference types
  - class types
  - array types
  - interface types
-  null reference

## 2.5. Run-Time Data Areas


Run-Time Data Areas
- pc Register
  - one per thread
  - contains address of the JVM instruction when executing a non-native method
  - undefined when executing a native method
  - wide enough to contain a returnAddress or a native pointer
- stacks
  - one per thread
  - contain frames
  - frames can also be allocated on the heap
  - initial size, minimum and maximum sizes can be specified
  - stacks can grow as needed
- heap
  - can be expanded or contracted as needed
- method area
  - run-time constant pool
    - per-class and per-interface
  - field and method data
  - code for methods, constructors, interface initialization and instance initialization methods
- native method stacks

## 2.6. Frames

frame
- array of local variables
  - long and double must be stored as a pair of local variables
  - long and double need not be 64-bit aligned
  - local variable 0 is a reference to `this`
- operand stack
  - maximum depth is known at compile time
  - dup and swap operators on data areas as raw-values, but cannot be used to modify or break individual values
    - this is enforced through class file verification
- reference to the run-time constant pool of the class of the current method
  - this allows dynamic linking of the method code
  - dynamic linking translates symbolic method references into concrete method references
- implementation-specific information
  - debugging information


## 2.9. Special Methods

### 2.9.1. Instance Initialization Methods

Instance initialization methods are named `<init>`  with a return type of `void`, and are only allowed in classes.
- on the declaration, the method's `access_flags` item and code array are constrained
- they can only be invoked used `invokespecial` on an uninitialized class

### 2.9.2. Class Initialization Methods

At most one class or interface initialization method, named `<clinit>`, returns `void`.
- version >= 51.0 => `ACC_STATIC` flag set (Java SE 7), and no arguments (Java SE 9).
- version < 50.0 => these constraints are not enforced

### 2.9.3. Signature Polymorphic Methods

A method is signature polymorphic if all of the following are true:
- It is declared in the `java.lang.invoke.MethodHandle` class or the `java.lang.invoke.VarHandle` class.
- It has a single formal parameter of type `Object[]`.
- It has the `ACC_VARARGS` and `ACC_NATIVE` flags set.

special treatment when invoked using `invokevirtual`

## 2.11. Instruction Set Summary

lookupswitch and tableswitch are padded to force internal alignment of some of their operands on 4-byte boundaries.

### 2.11.10. Synchronization

monitor

method_info structure:
- `ACC_SYNCHRONIZED` flag


- `monitorenter`
- `monitorexit` 



# 3. Compiling for the Java Virtual Machine

## 3.1. Format of Examples
## 3.2. Use of Constants, Local Variables, and Control Constructs
## 3.3. Arithmetic
## 3.4. Accessing the Run-Time Constant Pool
## 3.5. More Control Examples
## 3.6. Receiving Arguments
## 3.7. Invoking Methods
## 3.8. Working with Class Instances
## 3.9. Arrays
## 3.10. Compiling Switches
## 3.11. Operations on the Operand Stack
## 3.12. Throwing and Handling Exceptions
## 3.13. Compiling finally
## 3.14. Synchronization
## 3.15. Annotations
## 3.16. Modules

# 4. The class File Format

## 4.1. The ClassFile Structure
## 4.2. Names

### 4.2.1. Binary Class and Interface Names
### 4.2.2. Unqualified Names
### 4.2.3. Module and Package Names

## 4.3. Descriptors

## 4.3.1. Grammar Notation
## 4.3.2. Field Descriptors
## 4.3.3. Method Descriptors

## 4.4. The Constant Pool

### 4.4.1. The CONSTANT_Class_info Structure
### 4.4.2. The CONSTANT_Fieldref_info, CONSTANT_Methodref_info, and CONSTANT_InterfaceMethodref_info Structures
### 4.4.3. The CONSTANT_String_info Structure
### 4.4.4. The CONSTANT_Integer_info and CONSTANT_Float_info Structures
### 4.4.5. The CONSTANT_Long_info and CONSTANT_Double_info Structures
### 4.4.6. The CONSTANT_NameAndType_info Structure
### 4.4.7. The CONSTANT_Utf8_info Structure
### 4.4.8. The CONSTANT_MethodHandle_info Structure
### 4.4.9. The CONSTANT_MethodType_info Structure
### 4.4.10. The CONSTANT_Dynamic_info and CONSTANT_InvokeDynamic_info Structures
### 4.4.11. The CONSTANT_Module_info Structure
### 4.4.12. The CONSTANT_Package_info Structure

## 4.5. Fields
## 4.6. Methods
## 4.7. Attributes

### 4.7.1. Defining and Naming New Attributes
### 4.7.2. The ConstantValue Attribute
### 4.7.3. The Code Attribute
### 4.7.4. The StackMapTable Attribute
### 4.7.5. The Exceptions Attribute
### 4.7.6. The InnerClasses Attribute
### 4.7.7. The EnclosingMethod Attribute
### 4.7.8. The Synthetic Attribute
### 4.7.9. The Signature Attribute

            4.7.9.1. Signatures

### 4.7.10. The SourceFile Attribute
### 4.7.11. The SourceDebugExtension Attribute
### 4.7.12. The LineNumberTable Attribute
### 4.7.13. The LocalVariableTable Attribute
### 4.7.14. The LocalVariableTypeTable Attribute
### 4.7.15. The Deprecated Attribute
### 4.7.16. The RuntimeVisibleAnnotations Attribute

            4.7.16.1. The element_value structure

### 4.7.17. The RuntimeInvisibleAnnotations Attribute
### 4.7.18. The RuntimeVisibleParameterAnnotations Attribute
### 4.7.19. The RuntimeInvisibleParameterAnnotations Attribute
### 4.7.20. The RuntimeVisibleTypeAnnotations Attribute

            4.7.20.1. The target_info union
            4.7.20.2. The type_path structure

### 4.7.21. The RuntimeInvisibleTypeAnnotations Attribute
### 4.7.22. The AnnotationDefault Attribute
### 4.7.23. The BootstrapMethods Attribute
### 4.7.24. The MethodParameters Attribute
### 4.7.25. The Module Attribute
### 4.7.26. The ModulePackages Attribute
### 4.7.27. The ModuleMainClass Attribute
### 4.7.28. The NestHost Attribute
### 4.7.29. The NestMembers Attribute
### 4.7.30. The Record Attribute
### 4.7.31. The PermittedSubclasses Attribute

## 4.8. Format Checking
## 4.9. Constraints on Java Virtual Machine Code

### 4.9.1. Static Constraints
### 4.9.2. Structural Constraints

## 4.10. Verification of class Files

### 4.10.1. Verification by Type Checking

#### 4.10.1.1. Accessors for Java Virtual Machine Artifacts
#### 4.10.1.2. Verification Type System
#### 4.10.1.3. Instruction Representation
#### 4.10.1.4. Stack Map Frames and Type Transitions
#### 4.10.1.5. Type Checking Abstract and Native Methods
#### 4.10.1.6. Type Checking Methods with Code
#### 4.10.1.7. Type Checking Load and Store Instructions
#### 4.10.1.8. Type Checking for protected Members
#### 4.10.1.9. Type Checking Instructions

- aaload
- aastore
- aconst_null
- aload, aload_<n>
- anewarray
- areturn
- arraylength
- astore, astore_<n>
- athrow
- baload
- bastore
- bipush
- caload
- castore
- checkcast
- d2f, d2i, d2l
- dadd
- daload
- dastore
- dcmp<op>
- dconst_<d>
- ddiv
- dload, dload_<n>
- dmul
- dneg
- drem
- dreturn
- dstore, dstore_<n>
- dsub
- dup
- dup_x1
- dup_x2
- dup2
- dup2_x1
- dup2_x2
- f2d, f2i, f2l
- fadd
- faload
- fastore
- fcmp<op>
- fconst_<f>
- fdiv
- fload, fload_<n>
- fmul
- fneg
- frem
- freturn
- fstore, fstore_<n>
- fsub
- getfield
- getstatic
- goto, goto_w
- i2b, i2c, i2d, i2f, i2l, i2s
- iadd
- iaload
- iand
- iastore
- iconst_<i>
- idiv
- if_acmp<cond>
- if_icmp<cond>
- if<cond>
- ifnonnull, ifnull
- iinc
- iload, iload_<n>
- imul
- ineg
- instanceof
- invokedynamic
- invokeinterface
- invokespecial
- invokestatic
- invokevirtual
- ior, irem
- ireturn
- ishl, ishr, iushr
- istore, istore_<n>
- isub, ixor
- l2d, l2f, l2i
- ladd
- laload
- land
- lastore
- lcmp
- lconst_<l>
- ldc, ldc_w, ldc2_w
- ldiv
- lload, lload_<n>
- lmul
- lneg
- lookupswitch
- lor, lrem
- lreturn
- lshl, lshr, lushr
- lstore, lstore_<n>
- lsub, lxor
- monitorenter, monitorexit
- multianewarray
- new
- newarray
- nop
- pop, pop2
- putfield
- putstatic
- return
- saload
- sastore
- sipush
- swap
- tableswitch
- wide

### 4.10.2. Verification by Type Inference

#### 4.10.2.1. The Process of Verification by Type Inference
#### 4.10.2.2. The Bytecode Verifier
#### 4.10.2.3. Values of Types long and double
#### 4.10.2.4. Instance Initialization Methods and Newly Created Objects
#### 4.10.2.5. Exceptions and finally

## 4.11. Limitations of the Java Virtual Machine

#  5. Loading, Linking, and Initializing

## 5.1. The Run-Time Constant Pool
## 5.2. Java Virtual Machine Startup
## 5.3. Creation and Loading

### 5.3.1. Loading Using the Bootstrap Class Loader
### 5.3.2. Loading Using a User-defined Class Loader
### 5.3.3. Creating Array Classes
### 5.3.4. Loading Constraints
### 5.3.5. Deriving a Class from a class File Representation
### 5.3.6. Modules and Layers

## 5.4. Linking

### 5.4.1. Verification
### 5.4.2. Preparation
### 5.4.3. Resolution

#### 5.4.3.1. Class and Interface Resolution
#### 5.4.3.2. Field Resolution
#### 5.4.3.3. Method Resolution
#### 5.4.3.4. Interface Method Resolution
#### 5.4.3.5. Method Type and Method Handle Resolution
#### 5.4.3.6. Dynamically-Computed Constant and Call Site Resolution

### 5.4.4. Access Control
### 5.4.5. Method Overriding
### 5.4.6. Method Selection

## 5.5. Initialization
## 5.6. Binding Native Method Implementations
## 5.7. Java Virtual Machine Termination

# 6. The Java Virtual Machine Instruction Set

## 6.1. Assumptions: The Meaning of "Must"
## 6.2. Reserved Opcodes
## 6.3. Virtual Machine Errors
## 6.4. Format of Instruction Descriptions

- mnemonic

## 6.5. Instructions

        aaload

        aastore

        aconst_null

        aload

        aload_<n>

        anewarray

        areturn

        arraylength

        astore

        astore_<n>

        athrow

        baload

        bastore

        bipush

        caload

        castore

        checkcast

        d2f

        d2i

        d2l

        dadd

        daload

        dastore

        dcmp<op>

        dconst_<d>

        ddiv

        dload

        dload_<n>

        dmul

        dneg

        drem

        dreturn

        dstore

        dstore_<n>

        dsub

        dup

        dup_x1

        dup_x2

        dup2

        dup2_x1

        dup2_x2

        f2d

        f2i

        f2l

        fadd

        faload

        fastore

        fcmp<op>

        fconst_<f>

        fdiv

        fload

        fload_<n>

        fmul

        fneg

        frem

        freturn

        fstore

        fstore_<n>

        fsub

        getfield

        getstatic

        goto

        goto_w

        i2b

        i2c

        i2d

        i2f

        i2l

        i2s

        iadd

        iaload

        iand

        iastore

        iconst_<i>

        idiv

        if_acmp<cond>

        if_icmp<cond>

        if<cond>

        ifnonnull

        ifnull

        iinc

        iload

        iload_<n>

        imul

        ineg

        instanceof

        invokedynamic

        invokeinterface

        invokespecial

        invokestatic

        invokevirtual

        ior

        irem

        ireturn

        ishl

        ishr

        istore

        istore_<n>

        isub

        iushr

        ixor

        jsr

        jsr_w

        l2d

        l2f

        l2i

        ladd

        laload

        land

        lastore

        lcmp

        lconst_<l>

        ldc

        ldc_w

        ldc2_w

        ldiv

        lload

        lload_<n>

        lmul

        lneg

        lookupswitch

        lor

        lrem

        lreturn

        lshl

        lshr

        lstore

        lstore_<n>

        lsub

        lushr

        lxor

        monitorenter

        monitorexit

        multianewarray

        new

        newarray

        nop

        pop

        pop2

        putfield

        putstatic

        ret

        return

        saload

        sastore

        sipush

        swap

        tableswitch

        wide

# 7. Opcode Mnemonics by Opcode