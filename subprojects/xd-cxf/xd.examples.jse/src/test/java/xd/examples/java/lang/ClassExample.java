package xd.examples.java.lang;

import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.DummyBaseClassWithMembers;
import xd.helpers.dummies.DummyClass;
import xd.helpers.dummies.DummyClassImplementingInterface;
import xd.helpers.dummies.DummyWithNestedClasses;
import xd.helpers.dummies.DummyClassWithMembers;
import xd.helpers.dummies.DummyClassWithSuperClass;
import xd.helpers.dummies.DummyEnum;
import xd.helpers.dummies.DummyInterface;
import xd.helpers.dummies.DummyRecord;
import xd.helpers.dummies.DummySealedClass;
import xd.helpers.dummies.DummySealedInterface;
import xdtest.ToBeContinued;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.constant.ClassDesc;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static xdtest.TestUtils.assertContains;
import static xdtest.TestUtils.assertContainsMatch;

@ToBeContinued
public class ClassExample extends BaseExample<Class<DummyClass>> {

    @Override
    public void scaffold(Class<DummyClass> instance) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        {
            String str = instance.toString();
            seeExamples(this::example);
            ignore(str);
        }
        {
            String str = instance.toGenericString();
            seeExamples(this::example);
            ignore(str);
        }
        {
            Class<?> clazz = Class.forName("java.lang.Object");
            seeExamples(this::exampleForNameWithReflection);
            ignore(clazz);
        }
        {
            boolean isInstance = instance.isInstance(new Object());
            seeExamples(this::isInstanceExample);
            ignore(isInstance);
        }
        {
            boolean isAssignableFrom = instance.isAssignableFrom(Object.class);
            seeExamples(
                    this::isAssignableFromExample,
                    this::isAssignableFromWithGenericsExample
            );
            ignore(isAssignableFrom);
        }
        {
            boolean isInterface = instance.isInterface();
            seeExamples(this::isInterfaceExample);
            ignore(isInterface);
        }
        {
            boolean isArray = instance.isArray();
            seeExamples(this::isArrayExample);
            ignore(isArray);
        }
        {
            boolean isPrimitive = instance.isPrimitive();
            seeExamples(this::isPrimitiveExample);
            ignore(isPrimitive);
        }
        {
            boolean isAnnotation = instance.isAnnotation();
            seeExamples(this::isAnnotationExample);
            ignore(isAnnotation);
        }
        {
            String name1 = instance.getName();
            seeExamples(this::example);
            ignore(name1);
        }
        {
            ClassLoader classLoader = instance.getClassLoader();
            seeExamples(this::classLoaderExample);
            ignore(classLoader);
        }
        {
            Class<? super DummyClass> superclass = instance.getSuperclass();
            seeExamples(this::getSuperclassExample);
            ignore(superclass);
        }
        {
            String packageName = instance.getPackageName();
            seeExamples(this::example);
            ignore(packageName);
        }
        {
            String simpleName = instance.getSimpleName();
            seeExamples(this::example);
            ignore(simpleName);
        }
        {
            Field[] fields = instance.getFields();
            seeExamples(this::exampleFields);
            ignore((Object) fields);
        }
        {
            Method[] methods = instance.getMethods();
            seeExamples(this::exampleMethods);
            ignore((Object) methods);
        }
        {
            Constructor<?>[] constructors = instance.getConstructors();
            seeExamples(this::exampleConstructors);
            ignore((Object) constructors);
        }
        {
            Field field = instance.getField("name");
            seeExamples(this::exampleFields);
            ignore(field);
        }
        {
            Method method = instance.getMethod("equals", Object.class);
            seeExamples(
                    this::exampleMethods,
                    this::exampleMethodOverriden
            );
            ignore(method);
        }
        {
            Constructor<DummyClass> constructor = instance.getConstructor(String.class);
            seeExamples(
                    this::exampleConstructors,
                    this::exampleForNameWithReflection
            );
            ignore(constructor);
        }
        {
            Method[] methods = instance.getDeclaredMethods();
            seeExamples(this::exampleMethods);
            ignore((Object) methods);
        }
        {
            Constructor<?>[] constructors = instance.getDeclaredConstructors();
            seeExamples(this::exampleConstructors);
            ignore((Object) constructors);
        }
        {
            Field field = instance.getDeclaredField("name");
            seeExamples(this::exampleFields);
            ignore(field);
        }
        {
            Method declaredMethod = instance.getDeclaredMethod("equals", Object.class);
            seeExamples(this::exampleMethods);
            ignore(declaredMethod);
        }
        {
            Constructor<DummyClass> declaredConstructor = instance.getDeclaredConstructor(String.class);
            seeExamples(this::exampleConstructors);
            ignore(declaredConstructor);
        }
        {
            boolean isEnum = instance.isEnum();
            seeExamples(this::isEnumExample);
            ignore(isEnum);
        }
        {
            boolean isRecord = instance.isRecord();
            seeExamples(this::isRecordExample);
            ignore(isRecord);
        }
        {
            DummyClass[] enumConstants = instance.getEnumConstants();
            seeExamples(this::enumConstantsExample);
            ignore((Object) enumConstants);
        }
        {
            DummyClass cast = instance.cast(new Object());
            seeExamples(this::castExample);
            ignore(cast);
        }
        {
            ToBeContinued annotation = instance.getAnnotation(ToBeContinued.class);
            seeExamples(this::annotationExample);
            ignore(annotation);
        }
        {
            Annotation[] annotations = instance.getAnnotations();
            seeExamples(this::annotationExample);
            ignore((Object) annotations);
        }
        {
            boolean annotationPresent = instance.isAnnotationPresent(ToBeContinued.class);
            seeExamples(this::annotationExample);
            ignore(annotationPresent);
        }
        {
            Class<?>[] permittedSubclasses = instance.getPermittedSubclasses();
            seeExamples(this::sealedExample);
            ignore((Object) permittedSubclasses);
        }
        {
            boolean isSealed = instance.isSealed();
            seeExamples(this::sealedExample);
            ignore(isSealed);
        }
        {
            Class<?>[] interfaces = instance.getInterfaces();
            seeExamples(this::interfacesExample);
            ignore((Object) interfaces);
        }
        {
            Field[] fields = instance.getDeclaredFields();
            seeExamples(this::exampleFields);
            ignore((Object) fields);
        }
        {
            int modifiers = instance.getModifiers();
            seeExamples(this::modifiersExample);
            ignore(modifiers);
        }
        {
            Class<?> componentType = instance.getComponentType();
            seeExamples(this::isArrayExample);
            ignore(componentType);
        }
        {
            boolean anonymousClass = instance.isAnonymousClass();
            seeExamples(this::anonymousAndLocalExample);
            ignore(anonymousClass);
        }
        {
            boolean isLocalClass = instance.isLocalClass();
            seeExamples(this::anonymousAndLocalExample);
            ignore(isLocalClass);
        }
        {
            Method enclosingMethod = instance.getEnclosingMethod();
            seeExamples(this::anonymousAndLocalExample);
            ignore(enclosingMethod);
        }
        {
            Constructor<?> enclosingConstructor = instance.getEnclosingConstructor();
            seeExamples(this::anonymousAndLocalExample);
            ignore(enclosingConstructor);
        }
        {
            Class<?>[] declaredClasses = instance.getDeclaredClasses();
            seeExamples(this::nestedClassesExample);
            ignore((Object) declaredClasses);
        }
        {
            Class<?>[] classes = instance.getClasses();
            seeExamples(this::nestedClassesExample);
            ignore((Object) classes);
        }
        {
            Class<?> declaringClass = instance.getDeclaringClass();
            seeExamples(this::nestedClassesExample);
            ignore(declaringClass);
        }
        {
            Class<?> enclosingClass = instance.getEnclosingClass();
            seeExamples(this::enclosingClassExample);
            ignore(enclosingClass);
        }
        {
            boolean memberClass = instance.isMemberClass();
            seeExamples(this::memberClassExample);
            ignore(memberClass);
        }
        {
            boolean hidden = instance.isHidden();
            seeExamples(this::hiddenClassExample);
            ignore(hidden);
        }

        /*-------------------------------------------------------------------------------*/

        String name = null;
        boolean initialize = false;
        ClassLoader loader = null;
        {
            // TODO
            Class<?> clazz = Class.forName(name, initialize, loader);
            ignore(clazz);
        }
        Module module = null;
        {
            // TODO
            Class<?> clazz = Class.forName(module, name);
            ignore(clazz);
        }
        {
            // TODO
            boolean isSynthetic = instance.isSynthetic();
            ignore(isSynthetic);
        }
        {
            // TODO
            Module module1 = instance.getModule();
            ignore(module1);
        }
        {
            // TODO
            TypeVariable<Class<DummyClass>>[] typeParameters = instance.getTypeParameters();
            ignore((Object) typeParameters);
        }
        {
            // TODO
            Type genericSuperclass = instance.getGenericSuperclass();
            ignore(genericSuperclass);
        }
        {
            // TODO
            Package aPackage = instance.getPackage();
            ignore(aPackage);
        }
        {
            // TODO
            Type[] genericInterfaces = instance.getGenericInterfaces();
            ignore((Object) genericInterfaces);
        }

        {
            // TODO
            Object[] signers = instance.getSigners();
            ignore(signers);
        }
        {
            // TODO
            String typeName = instance.getTypeName();
            ignore(typeName);
        }
        {
            // TODO
            String canonicalName = instance.getCanonicalName();
            ignore(canonicalName);
        }
        {
            // TODO
            RecordComponent[] recordComponents = instance.getRecordComponents();
            ignore((Object) recordComponents);
        }
        {
            // TODO
            InputStream resourceAsStream = instance.getResourceAsStream(name);
            ignore(resourceAsStream);
        }
        {
            // TODO
            URL resource = instance.getResource(name);
            ignore(resource);
        }
        {
            // TODO
            ProtectionDomain protectionDomain = instance.getProtectionDomain();
            ignore(protectionDomain);
        }
        {
            // TODO
            boolean b = instance.desiredAssertionStatus();
            ignore(b);
        }

        Class<?> clazz = null;
        {
            // TODO
            Class<?> aClass3 = instance.asSubclass(clazz);
            ignore(aClass3);
        }
        Class<? extends Annotation> annotationClazz = null;

        {
            // TODO
            Annotation[] annotationsByType = instance.getAnnotationsByType(annotationClazz);
            ignore((Object) annotationsByType);
        }
        {
            // TODO
            Annotation declaredAnnotation = instance.getDeclaredAnnotation(annotationClazz);
            ignore(declaredAnnotation);
        }
        {
            // TODO
            Annotation[] declaredAnnotationsByType = instance.getDeclaredAnnotationsByType(annotationClazz);
            ignore((Object) declaredAnnotationsByType);
        }
        {
            // TODO
            Annotation[] declaredAnnotations = instance.getDeclaredAnnotations();
            ignore((Object) declaredAnnotations);
        }
        {
            // TODO
            AnnotatedType annotatedSuperclass = instance.getAnnotatedSuperclass();
            ignore(annotatedSuperclass);
        }
        {
            // TODO
            AnnotatedType[] annotatedInterfaces = instance.getAnnotatedInterfaces();
            ignore((Object) annotatedInterfaces);
        }
        {
            // TODO
            Class<?> nestHost = instance.getNestHost();
            ignore(nestHost);
        }
        {
            // TODO
            boolean nestmateOf = instance.isNestmateOf(clazz);
            ignore(nestmateOf);
        }
        {
            // TODO
            Class<?>[] nestMembers = instance.getNestMembers();
            ignore((Object) nestMembers);
        }
        {
            // TODO
            String s2 = instance.descriptorString();
            ignore(s2);
        }
        {
            // TODO
            Class<?> aClass4 = instance.componentType();
            ignore(aClass4);
        }
        {
            // TODO
            Class<?> aClass5 = instance.arrayType();
            ignore(aClass5);
        }
        {
            // TODO
            Optional<ClassDesc> classDesc = instance.describeConstable();
            ignore(classDesc);
        }


    }

    @Test
    public void example() {
        Class<DummyClass> clazz = DummyClass.class;

        assertEquals("DummyClass", clazz.getSimpleName());
        assertEquals("xd.helpers.dummies.DummyClass", clazz.getName());
        assertEquals("class xd.helpers.dummies.DummyClass", clazz.toString());
        assertEquals("public class xd.helpers.dummies.DummyClass", clazz.toGenericString());
        assertEquals("xd.helpers.dummies", clazz.getPackageName());
    }

    @Test
    public void isInterfaceExample() {
        assertTrue(DummyInterface.class.isInterface());
        assertFalse(DummyClass.class.isInterface());
    }

    @Test
    public void isPrimitiveExample() {
        assertTrue(int.class.isPrimitive());
        assertFalse(DummyClass.class.isPrimitive());
    }

    @Test
    public void isAnnotationExample() {
        assertTrue(Test.class.isAnnotation());
        assertFalse(DummyClass.class.isAnnotation());
    }

    @Test
    public void exampleForNameWithReflection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("xd.helpers.dummies.DummyClassWithPublicMethod");
        Constructor<?> constructor = clazz.getConstructor();
        Object instance = constructor.newInstance();
        Method method = clazz.getMethod("foo");
        Object result = method.invoke(instance);
        assertEquals(true, result instanceof String);
        String stringResult = (String) result;
        assertEquals("Hello world from foo!", stringResult);
    }

    @Test
    public void isInstanceExample() {
        DummyClass instance1 = new DummyClass();
        DummyClassWithSuperClass instance2 = new DummyClassWithSuperClass();
        DummyClassImplementingInterface instance3 = new DummyClassImplementingInterface();

        Class<DummyClass> clazz1 = DummyClass.class;
        Class<DummyClassWithSuperClass> clazz2 = DummyClassWithSuperClass.class;
        Class<DummyClassImplementingInterface> clazz3 = DummyClassImplementingInterface.class;
        Class<DummyInterface> clazz4 = DummyInterface.class;

        assertTrue(clazz1.isInstance(instance1));
        assertTrue(clazz1.isInstance(instance2));
        assertTrue(clazz2.isInstance(instance2));
        assertTrue(clazz3.isInstance(instance3));
        assertTrue(clazz4.isInstance(instance3));
        // other cases are all false
    }

    @Test
    public void isAssignableFromExample() {
        Class<DummyClass> clazz1 = DummyClass.class;
        Class<DummyClassWithSuperClass> clazz2 = DummyClassWithSuperClass.class;
        Class<DummyClassImplementingInterface> clazz3 = DummyClassImplementingInterface.class;
        Class<DummyInterface> clazz4 = DummyInterface.class;

        // diagonal is always true
        assertTrue(clazz1.isAssignableFrom(clazz2));
        assertTrue(clazz4.isAssignableFrom(clazz3));
        // other cases are always false
    }

    @Test
    public void isAssignableFromWithGenericsExample() {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        // isAssignableFrom ignores generic types parameters
        assertTrue(a.getClass().isAssignableFrom(b.getClass()));
    }

    @Test
    public void isArrayExample() {
        Class<String[]> clazz = String[].class;
        assertTrue(clazz.isArray());
        assertFalse(String.class.isArray());
        assertEquals(String.class, clazz.getComponentType());
    }

    @Test
    public void classLoaderExample() {

        ClassLoader objectClassLoader = Object.class.getClassLoader();
        assertNull(objectClassLoader);

        ClassLoader thisClassLoader = this.getClass().getClassLoader();
        assertEquals("app", thisClassLoader.getName());

        ClassLoader thisParentClassLoader = thisClassLoader.getParent();
        assertEquals("platform", thisParentClassLoader.getName());

        ClassLoader thisParentParent = thisParentClassLoader.getParent();
        assertNull(thisParentParent);
    }

    @Test
    public void isRecordExample() {
        assertTrue(DummyRecord.class.isRecord());
        assertFalse(DummyClass.class.isRecord());
    }

    @Test
    public void isEnumExample() {
        assertTrue(DummyEnum.class.isEnum());
        assertFalse(DummyClass.class.isEnum());
    }

    @Test
    public void enumConstantsExample() {
        DummyEnum[] enumConstants = DummyEnum.class.getEnumConstants();
        assertEquals(2, enumConstants.length);
        assertContains(enumConstants, DummyEnum.DUMMY_VALUE_1);
        assertContains(enumConstants, DummyEnum.DUMMY_VALUE_2);
    }

    @Test
    public void castExample() {
        DummyClassWithSuperClass instance = new DummyClassWithSuperClass();
        DummyClass cast = DummyClass.class.cast(instance);
        assertEquals(DummyClassWithSuperClass.class, cast.getClass());
    }

    @Test
    public void getSuperclassExample() {

        assertNull(Object.class.getSuperclass());

        Class<? super DummyClassWithSuperClass> clazz = DummyClassWithSuperClass.class.getSuperclass();
        assertEquals(DummyClass.class, clazz);
    }

    @Test
    public void exampleConstructors() throws NoSuchMethodException {
        Class<DummyClassWithMembers> clazz = DummyClassWithMembers.class;

        Constructor<?>[] constructors = clazz.getConstructors();
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();

        // public constructor of top class are exposed, public constructor of base class is not exposed
        assertEquals(2, constructors.length);
        assertNotNull(clazz.getConstructor(int.class, int.class, int.class));
        assertNotNull(clazz.getConstructor(boolean.class, boolean.class, boolean.class));

        // all constructors of top class are exposed, constructors of base class are not exposed
        assertEquals(6, declaredConstructors.length);
        assertNotNull(clazz.getDeclaredConstructor(boolean.class, boolean.class, boolean.class));
        assertNotNull(clazz.getDeclaredConstructor(boolean.class, boolean.class));
        assertNotNull(clazz.getDeclaredConstructor(boolean.class));
        assertNotNull(clazz.getDeclaredConstructor(int.class, int.class, int.class));
        assertNotNull(clazz.getDeclaredConstructor(int.class, int.class));
        assertNotNull(clazz.getDeclaredConstructor(int.class));
    }

    @Test
    public void exampleMethods() throws NoSuchMethodException {

        Class<DummyClassWithMembers> clazz = DummyClassWithMembers.class;
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();

        // contains public methods of top class and of base classes
        assertEquals(12, methods.length);
        assertNotNull(clazz.getMethod("publicMethodOverriden"));
        assertNotNull(clazz.getMethod("publicMethodNew"));
        assertNotNull(clazz.getMethod("publicMethod"));
        assertNotNull(clazz.getMethod("wait", long.class, int.class));
        assertNotNull(clazz.getMethod("wait"));
        assertNotNull(clazz.getMethod("wait", long.class));
        assertNotNull(clazz.getMethod("equals", Object.class));
        assertNotNull(clazz.getMethod("toString"));
        assertNotNull(clazz.getMethod("hashCode"));
        assertNotNull(clazz.getMethod("getClass"));
        assertNotNull(clazz.getMethod("notify"));
        assertNotNull(clazz.getMethod("notifyAll"));

        // contains public and non public methods of top class
        assertEquals(6, declaredMethods.length);
        assertNotNull(clazz.getDeclaredMethod("publicMethodOverriden"));
        assertNotNull(clazz.getDeclaredMethod("publicMethodNew"));
        assertNotNull(clazz.getDeclaredMethod("protectedMethodOverriden"));
        assertNotNull(clazz.getDeclaredMethod("privateMethodOverriden"));
        assertNotNull(clazz.getDeclaredMethod("protectedMethodNew"));
        assertNotNull(clazz.getDeclaredMethod("privateMethodNew"));
    }

    @Test
    public void exampleMethodOverriden() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String baseResult = "DummyBaseClassWithMembers publicMethodOverriden";
        String overridenResult = "DummyClassWithMembers publicMethodOverriden";

        DummyBaseClassWithMembers baseInstance = new DummyBaseClassWithMembers();
        DummyClassWithMembers overridenInstance = new DummyClassWithMembers();

        assertEquals(baseResult, baseInstance.publicMethodOverriden());
        assertEquals(overridenResult, overridenInstance.publicMethodOverriden());

        // Even when using reflection, the overriden method is used when overriden
        Method baseMethod = DummyBaseClassWithMembers.class.getMethod("publicMethodOverriden");
        assertEquals(overridenResult, baseMethod.invoke(overridenInstance));

    }

    @Test
    public void exampleFields() throws NoSuchFieldException {
        Class<DummyClassWithMembers> clazz = DummyClassWithMembers.class;

        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();

        // contains all public fields
        assertEquals(4, fields.length);
        assertNotNull(clazz.getField("publicBaseOverridenField"));
        assertNotNull(clazz.getField("publicNewField"));
        assertNotNull(clazz.getField("publicBaseField"));
        assertNotNull(clazz.getField("publicBaseOverridenField"));

        // contains all fields of top class
        assertEquals(6, declaredFields.length);
        assertNotNull(clazz.getDeclaredField("privateBaseOverridenField"));
        assertNotNull(clazz.getDeclaredField("protectedBaseOverridenField"));
        assertNotNull(clazz.getDeclaredField("publicBaseOverridenField"));
        assertNotNull(clazz.getDeclaredField("privateNewField"));
        assertNotNull(clazz.getDeclaredField("protectedNewField"));
        assertNotNull(clazz.getDeclaredField("publicNewField"));
    }

    @Test
    public void annotationExample() {
        Class<ClassExample> clazz = ClassExample.class;

        Annotation[] annotations = clazz.getAnnotations();
        assertEquals(1, annotations.length);

        assertTrue(clazz.isAnnotationPresent(ToBeContinued.class));

        ToBeContinued annotation = clazz.getAnnotation(ToBeContinued.class);
        assertEquals(0, annotation.todos().length);
    }

    @Test
    public void sealedExample() {

        Class<DummySealedInterface> interfaceClass = DummySealedInterface.class;
        Class<DummySealedClass> classClass = DummySealedClass.class;

        assertTrue(interfaceClass.isSealed());
        assertFalse(classClass.isSealed());

        Class<?>[] permittedSubclasses = interfaceClass.getPermittedSubclasses();
        assertEquals(1, permittedSubclasses.length);
        assertEquals(classClass, permittedSubclasses[0]);
    }

    @Test
    public void interfacesExample() {
        Class<?>[] interfaces = DummyClassImplementingInterface.class.getInterfaces();
        assertEquals(1, interfaces.length);
        assertEquals(DummyInterface.class, interfaces[0]);
    }

    @Test
    public void modifiersExample() {
        int modifiers = ClassExample.class.getModifiers();
        assertTrue(Modifier.isPublic(modifiers));
        assertFalse(Modifier.isFinal(modifiers));
        assertFalse(Modifier.isStatic(modifiers));
    }

    @Test
    public void anonymousAndLocalExample() throws NoSuchMethodException {

        // anonymous serializable class instance
        Serializable serializable = new Serializable() {
        };
        assertTrue(serializable.getClass().isAnonymousClass());
        assertFalse(serializable.getClass().isLocalClass());

        // anonymous derived object instance
        Object derivedObject = new Object() {
        };
        assertTrue(derivedObject.getClass().isAnonymousClass());
        assertFalse(derivedObject.getClass().isLocalClass());

        // array to hold the reference to the Inside class
        Class<?>[] classes = new Class<?>[1];

        // named local class
        class DummyLocal {
            public DummyLocal() {
                // named local class within constructor
                class Inside {
                }
                // trick to escape the reference of the class
                classes[0] = Inside.class;
            }
        }
        assertFalse(DummyLocal.class.isAnonymousClass());
        assertTrue(DummyLocal.class.isLocalClass());

        // enclsing method
        Method enclosingMethod = DummyLocal.class.getEnclosingMethod();
        assertEquals(this.getClass().getMethod("anonymousAndLocalExample"), enclosingMethod);

        // create new dummy local to get the reference to the Inside class
        DummyLocal dummyLocal = new DummyLocal();
        assertNotNull(classes[0]);

        // enclosing constructor
        Constructor<?> enclosingConstructor = classes[0].getEnclosingConstructor();
        assertEquals(DummyLocal.class.getConstructors()[0], enclosingConstructor);
    }

    @Test
    public void nestedClassesExample() {

        Class<DummyWithNestedClasses> parent = DummyWithNestedClasses.class;
        Class<DummyWithNestedClasses.Public> innerPublic = DummyWithNestedClasses.Public.class;
        Class<DummyWithNestedClasses.PublicStatic> innerPublicStatic = DummyWithNestedClasses.PublicStatic.class;

        // all public nested classes
        // TODO: what happens with a class that extend a class or interface with nested class
        Class<?>[] classes = parent.getClasses();
        assertEquals(2, classes.length);
        assertContains(classes, innerPublic);
        assertContains(classes, innerPublicStatic);

        assertEquals(parent, innerPublic.getDeclaringClass());

        // all nested classes
        // TODO: what happens with a class that extend a class or interface with nested class
        Class<?>[] declaredClasses = parent.getDeclaredClasses();
        assertEquals(6, declaredClasses.length);
        assertContains(declaredClasses, innerPublic);
        assertContains(declaredClasses, innerPublicStatic);
        assertContainsMatch(declaredClasses, clazz -> "ProtectedStatic".equals(clazz.getSimpleName()));
        assertContainsMatch(declaredClasses, clazz -> "Protected".equals(clazz.getSimpleName()));
        assertContainsMatch(declaredClasses, clazz -> "PrivateStatic".equals(clazz.getSimpleName()));
        assertContainsMatch(declaredClasses, clazz -> "Private".equals(clazz.getSimpleName()));
    }

    @Test
    public void enclosingClassExample() {

        class DummyLocal {
        }

        Serializable serializable = new Serializable() {
        };

        // top class
        assertNull(ClassExample.class.getEnclosingClass());

        // nested class (and inner classes)
        assertEquals(DummyWithNestedClasses.class, DummyWithNestedClasses.Public.class.getEnclosingClass());

        // local class
        assertEquals(ClassExample.class, DummyLocal.class.getEnclosingClass());

        // anonymous class
        assertEquals(ClassExample.class, serializable.getClass().getEnclosingClass());
    }

    @Test
    public void memberClassExample() {

        class DummyLocal {
        }

        Serializable serializable = new Serializable() {
        };

        // top class
        assertFalse(ClassExample.class.isMemberClass());

        // nested class (and inner classes)
        assertTrue(DummyWithNestedClasses.Public.class.isMemberClass());

        // local class
        assertFalse(DummyLocal.class.isMemberClass());

        // anonymous class
        assertFalse(serializable.getClass().isMemberClass());
    }

    @Test
    public void hiddenClassExample() throws IOException, IllegalAccessException {
        // see also https://www.baeldung.com/java-hidden-classes
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<ClassExampleDummy> clazz = ClassExampleDummy.class;
        String className = clazz.getName();
        String classPath = "target/test-classes/" + className.replace('.', '/') + ".class";
        File file = new File(classPath);
        int fileSize = (int) file.length();
        ByteBuffer byteBuffer = ByteBuffer.allocate(fileSize);
        try (FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            channel.read(byteBuffer);
        }
        byte[] bytes = byteBuffer.array();
        Class<?> hiddenClass = lookup.defineHiddenClass(bytes, false).lookupClass();
        assertTrue(hiddenClass.isHidden());
    }

}
