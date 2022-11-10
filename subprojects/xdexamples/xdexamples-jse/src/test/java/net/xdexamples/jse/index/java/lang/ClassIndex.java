package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ClassExample_arrayType;
import net.xdexamples.jse.examples.java.lang.ClassExample_asSubclass;
import net.xdexamples.jse.examples.java.lang.ClassExample_cast;
import net.xdexamples.jse.examples.java.lang.ClassExample_componentType;
import net.xdexamples.jse.examples.java.lang.ClassExample_forName;
import net.xdexamples.jse.examples.java.lang.ClassExample_getAnnotation;
import net.xdexamples.jse.examples.java.lang.ClassExample_getAnnotations;
import net.xdexamples.jse.examples.java.lang.ClassExample_getClasses;
import net.xdexamples.jse.examples.java.lang.ClassExample_getComponentType;
import net.xdexamples.jse.examples.java.lang.ClassExample_getConstructor;
import net.xdexamples.jse.examples.java.lang.ClassExample_getConstructors;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredClasses;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredConstructor;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredConstructors;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredField;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredFields;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredMethod;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaredMethods;
import net.xdexamples.jse.examples.java.lang.ClassExample_getDeclaringClass;
import net.xdexamples.jse.examples.java.lang.ClassExample_getEnclosingClass;
import net.xdexamples.jse.examples.java.lang.ClassExample_getEnclosingConstructor;
import net.xdexamples.jse.examples.java.lang.ClassExample_getEnclosingMethod;
import net.xdexamples.jse.examples.java.lang.ClassExample_getEnumConstants;
import net.xdexamples.jse.examples.java.lang.ClassExample_getField;
import net.xdexamples.jse.examples.java.lang.ClassExample_getFields;
import net.xdexamples.jse.examples.java.lang.ClassExample_getInterfaces;
import net.xdexamples.jse.examples.java.lang.ClassExample_getMethod;
import net.xdexamples.jse.examples.java.lang.ClassExample_getMethods;
import net.xdexamples.jse.examples.java.lang.ClassExample_getModifiers;
import net.xdexamples.jse.examples.java.lang.ClassExample_getModule;
import net.xdexamples.jse.examples.java.lang.ClassExample_getName;
import net.xdexamples.jse.examples.java.lang.ClassExample_getPackage;
import net.xdexamples.jse.examples.java.lang.ClassExample_getPackageName;
import net.xdexamples.jse.examples.java.lang.ClassExample_getPermittedSubclasses;
import net.xdexamples.jse.examples.java.lang.ClassExample_getRecordComponents;
import net.xdexamples.jse.examples.java.lang.ClassExample_getSimpleName;
import net.xdexamples.jse.examples.java.lang.ClassExample_getSuperclass;
import net.xdexamples.jse.examples.java.lang.ClassExample_isAnnotation;
import net.xdexamples.jse.examples.java.lang.ClassExample_isAnnotationPresent;
import net.xdexamples.jse.examples.java.lang.ClassExample_isAnonymousClass;
import net.xdexamples.jse.examples.java.lang.ClassExample_isArray;
import net.xdexamples.jse.examples.java.lang.ClassExample_isAssignableFrom;
import net.xdexamples.jse.examples.java.lang.ClassExample_isEnum;
import net.xdexamples.jse.examples.java.lang.ClassExample_isInstance;
import net.xdexamples.jse.examples.java.lang.ClassExample_isInterface;
import net.xdexamples.jse.examples.java.lang.ClassExample_isLocalClass;
import net.xdexamples.jse.examples.java.lang.ClassExample_isMemberClass;
import net.xdexamples.jse.examples.java.lang.ClassExample_isPrimitive;
import net.xdexamples.jse.examples.java.lang.ClassExample_isRecord;
import net.xdexamples.jse.examples.java.lang.ClassExample_isSealed;
import net.xdexamples.support.internal.AccessLevel;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.Examples;
import org.junit.Test;
import xd.examples.java.lang.ClassExampleDummy;
import xd.helpers.dummies.DummyClass;
import xd.helpers.dummies.DummyClassWithSuperClass;
import xdtest.ToBeContinued;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.constant.ClassDesc;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@ToBeContinued
@Bundle(EBundle.REFLECTION)
@AccessLevel(EAccessLevel.PROTECTED)
@Examples({
        @Example(value = ClassExample_getName.class, illustrated = "getName"),
        @Example(value = ClassExample_getSimpleName.class, illustrated = "getSimpleName"),
        @Example(value = ClassExample_forName.class, illustrated = "forName"),
        @Example(value = ClassExample_isInstance.class, illustrated = "forName"),
        @Example(value = ClassExample_isInterface.class, illustrated = "isInterface"),
        @Example(value = ClassExample_isAssignableFrom.class, illustrated = "isAssignableFrom"),
        @Example(value = ClassExample_isArray.class, illustrated = "isArray"),
        @Example(value = ClassExample_isPrimitive.class, illustrated = "isPrimitive"),
        @Example(value = ClassExample_isAnnotation.class, illustrated = "isAnnotation"),
        @Example(value = ClassExample_getSuperclass.class, illustrated = "getSuperclass"),
        @Example(value = ClassExample_getPackageName.class, illustrated = "getPackageName"),
        @Example(value = ClassExample_getFields.class, illustrated = "getFields"),
        @Example(value = ClassExample_getDeclaredFields.class, illustrated = "getDeclaredFields"),
        @Example(value = ClassExample_getMethods.class, illustrated = "getMethods"),
        @Example(value = ClassExample_getDeclaredMethods.class, illustrated = "getDeclaredMethods"),
        @Example(value = ClassExample_isEnum.class, illustrated = "isEnum"),
        @Example(value = ClassExample_getEnumConstants.class, illustrated = "getEnumConstants"),
        @Example(value = ClassExample_cast.class, illustrated = "cast"),
        @Example(value = ClassExample_getAnnotations.class, illustrated = "getAnnotations"),
        @Example(value = ClassExample_isSealed.class, illustrated = "isSealed"),
        @Example(value = ClassExample_getInterfaces.class, illustrated = "getInterfaces"),
        @Example(value = ClassExample_isAnnotationPresent.class, illustrated = "isAnnotationPresent"),
        @Example(value = ClassExample_getModifiers.class, illustrated = "getModifiers"),
        @Example(value = ClassExample_getComponentType.class, illustrated = "getComponentType"),
        @Example(value = ClassExample_isAnonymousClass.class, illustrated = "isAnonymousClass"),
        @Example(value = ClassExample_isLocalClass.class, illustrated = "isLocalClass"),
        @Example(value = ClassExample_isMemberClass.class, illustrated = "isMemberClass"),
        @Example(value = ClassExample_getMethod.class, illustrated = "getMethod"),
        @Example(value = ClassExample_getEnclosingMethod.class, illustrated = "getEnclosingMethod"),
        @Example(value = ClassExample_getEnclosingConstructor.class, illustrated = "getEnclosingConstructor"),
        @Example(value = ClassExample_getDeclaredConstructors.class, illustrated = "getDeclaredConstructors"),
        @Example(value = ClassExample_getConstructors.class, illustrated = "getConstructors"),
        @Example(value = ClassExample_getEnclosingClass.class, illustrated = "getEnclosingClass"),
        @Example(value = ClassExample_getPermittedSubclasses.class, illustrated = "getPermittedSubclasses"),
        @Example(value = ClassExample_getField.class, illustrated = "getField"),
        @Example(value = ClassExample_getDeclaredField.class, illustrated = "getDeclaredField"),
        @Example(value = ClassExample_getClasses.class, illustrated = "getClasses"),
        @Example(value = ClassExample_getDeclaredClasses.class, illustrated = "getDeclaredClasses"),
        @Example(value = ClassExample_getDeclaredMethod.class, illustrated = "getDeclaredMethod"),
        @Example(value = ClassExample_getDeclaredConstructor.class, illustrated = "getDeclaredConstructor"),
        @Example(value = ClassExample_getConstructor.class, illustrated = "getConstructor"),
        @Example(value = ClassExample_getAnnotation.class, illustrated = "getAnnotation"),
        @Example(value = ClassExample_getDeclaringClass.class, illustrated = "getDeclaringClass"),
        @Example(value = ClassExample_getModule.class, illustrated = "getModule"),
        @Example(value = ClassExample_getPackage.class, illustrated = "getPackage"),
        @Example(value = ClassExample_asSubclass.class, illustrated = "asSubclass"),
        @Example(value = ClassExample_componentType.class, illustrated = "componentType"),
        @Example(value = ClassExample_arrayType.class, illustrated = "arrayType"),
        @Example(value = ClassExample_isRecord.class, illustrated = "isRecord"),
        @Example(value = ClassExample_getRecordComponents.class, illustrated = "getRecordComponents"),
})
public class ClassIndex extends BaseExample<Class<DummyClass>> {

    @Override
    public void scaffold(Class<DummyClass> instance) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        {
            String str = instance.toString();
            ignore(str);
        }
        {
            String str = instance.toGenericString();
            ignore(str);
        }

        {
            ClassLoader classLoader = instance.getClassLoader();
            seeExamples(this::classLoaderExample);
            ignore(classLoader);
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
            Optional<ClassDesc> classDesc = instance.describeConstable();
            ignore(classDesc);
        }


    }


    @Test
    public void isPrimitiveExample() {
        assertTrue(int.class.isPrimitive());
        assertFalse(DummyClass.class.isPrimitive());
    }


    @Test
    public void isAssignableFromWithGenericsExample() {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        // isAssignableFrom ignores generic types parameters
        assertTrue(a.getClass().isAssignableFrom(b.getClass()));
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
    public void getSuperclassExample() {

        assertNull(Object.class.getSuperclass());

        Class<? super DummyClassWithSuperClass> clazz = DummyClassWithSuperClass.class.getSuperclass();
        assertEquals(DummyClass.class, clazz);
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
