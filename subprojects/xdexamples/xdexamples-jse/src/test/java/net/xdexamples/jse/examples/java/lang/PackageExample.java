package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.jse.index.java.lang.ObjectIndex;
import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.pkg.example.DummyForPackageExample;
import xd.pkg.example.DummyPackageAnnotation;
import xdtest.ExternalLinks;
import xdtest.ToBeContinued;

import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@ToBeContinued
@ExternalLinks("https://stackoverflow.com/questions/50119062/difference-between-declaration-annotations-and-type-annotations")
public class PackageExample extends BaseExample<Package> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Package instance) {

        {
            String name = instance.getName();
            seeExamples(this::getNameExample);
        }

        {
            String specificationTitle = instance.getSpecificationTitle();
            seeExamples(this::getSpecificationTitleExample);
        }

        {
            String specificationVersion = instance.getSpecificationVersion();
            seeExamples(this::getSpecificationVersionExample);
        }

        {
            String specificationVendor = instance.getSpecificationVendor();
            seeExamples(this::getSpecificationVendorExample);
        }

        {
            String implementationTitle = instance.getImplementationTitle();
            seeExamples(this::getImplementationTitleExample);
        }

        {
            String implementationVersion = instance.getImplementationVersion();
            seeExamples(this::getImplementationVersionExample);
        }

        {
            String implementationVendor = instance.getImplementationVendor();
            seeExamples(this::getImplementationVendorExample);
        }

        {
            boolean sealed = instance.isSealed();
            seeExamples(this::isSealedExample);
        }

        {
            // TODO isSealed
            URL url = any();
            boolean sealed1 = instance.isSealed(url);
        }

        {
            String someString = any();
            boolean compatibleWith = instance.isCompatibleWith(someString);
            seeExamples(this::isCompatibleWithExample);
        }

        {
            Package[] packages = Package.getPackages();
            seeExamples(this::getPackagesExample);
        }

        {
            int i = instance.hashCode();
            seeOthers(ObjectIndex.class);
        }

        {
            String s = instance.toString();
            seeExamples(this::toStringExample);
        }


        {
            Annotation[] annotations = instance.getAnnotations();
            seeExamples(this::getAnnotationsExample);
        }

        {
            Annotation[] declaredAnnotations = instance.getDeclaredAnnotations();
            seeExamples(this::getAnnotationsExample);
        }

        {
            Class<? extends Annotation> annotationClass = any();
            boolean annotationPresent = instance.isAnnotationPresent(annotationClass);
            seeExamples(this::isAnnotationPresentExample);
        }

        {
            Class<? extends Annotation> annotationClass = any();
            Annotation annotation = instance.getAnnotation(annotationClass);
            seeExamples(this::getAnnotationExample);
        }

        {
            Class<? extends Annotation> annotationClass = any();
            Annotation declaredAnnotation = instance.getDeclaredAnnotation(annotationClass);
            seeExamples(this::getAnnotationExample);
        }

        {
            // TODO getAnnotationsByType
            Class<? extends Annotation> annotationClass = any();
            Annotation[] annotationsByType = instance.getAnnotationsByType(annotationClass);
        }

        {
            // TODO getDeclaredAnnotationsByType
            Class<? extends Annotation> annotationClass = any();
            Annotation[] declaredAnnotationsByType = instance.getDeclaredAnnotationsByType(annotationClass);
        }

    }

    @Test
    public void getNameExample() {
        Package pkg = Object.class.getPackage();
        String name = pkg.getName();
        assertEquals("java.lang", name);
    }

    @Test
    public void getSpecificationTitleExample() {
        {
            Package pkg = Object.class.getPackage();
            String specificationTitle = pkg.getSpecificationTitle();
            assertNull(specificationTitle);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String specificationTitle = pkg.getSpecificationTitle();
            assertEquals("Dummy Specification Title", specificationTitle);
        }
    }

    @Test
    public void getSpecificationVersionExample() {
        {
            Package pkg = Object.class.getPackage();
            String specificationVersion = pkg.getSpecificationVersion();
            assertNull(specificationVersion);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String specificationVersion = pkg.getSpecificationVersion();
            assertEquals("6.7.8", specificationVersion);
        }
    }

    @Test
    public void getSpecificationVendorExample() {
        {
            Package pkg = Object.class.getPackage();
            String specificationVendor = pkg.getSpecificationVendor();
            assertNull(specificationVendor);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String specificationVendor = pkg.getSpecificationVendor();
            assertEquals("Dummy Specification Vendor", specificationVendor);
        }
    }

    @Test
    public void getImplementationTitleExample() {
        {
            Package pkg = Object.class.getPackage();
            String implementationTitle = pkg.getImplementationTitle();
            assertNull(implementationTitle);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String implementationTitle = pkg.getImplementationTitle();
            assertEquals("Dummy Implementation Title", implementationTitle);
        }
    }

    @Test
    public void getImplementationVersionExample() {
        {
            Package pkg = Object.class.getPackage();
            String implementationVersion = pkg.getImplementationVersion();
            assertNull(implementationVersion);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String implementationVersion = pkg.getImplementationVersion();
            assertEquals("3.4.5", implementationVersion);
        }
    }

    @Test
    public void getImplementationVendorExample() {
        {
            Package pkg = Object.class.getPackage();
            String implementationVendor = pkg.getImplementationVendor();
            assertNull(implementationVendor);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String implementationVendor = pkg.getImplementationVendor();
            assertEquals("Dummy Implementation Vendor", implementationVendor);
        }
    }

    @Test
    public void isSealedExample() {
        {
            Package pkg = Object.class.getPackage();
            boolean isSealed = pkg.isSealed();
            assertTrue(isSealed);
        }

        {
            Package pkg = this.getClass().getPackage();
            boolean isSealed = pkg.isSealed();
            assertFalse(isSealed);
        }
    }

    @Test
    public void getPackagesExample() {

        {
            Package[] packages = Package.getPackages();
            Set<String> packageNames = Arrays.stream(packages).map(Package::getName).collect(Collectors.toSet());
            // xd.helpers.dummies does not appear in the output of getPackages()
            Assert.assertFalse(packageNames.contains("xd.helpers.dummies"));
        }

        {
            // load a class from xd.helpers.dummies
            ignore(new Dummy());
            Package[] packages = Package.getPackages();
            Set<String> packageNames = Arrays.stream(packages).map(Package::getName).collect(Collectors.toSet());

            // xd.helpers.dummies appears in the output of getPackages()
            Assert.assertTrue(packageNames.contains("xd.helpers.dummies"));
        }

    }

    @Test
    public void toStringExample() {
        {
            Package pkg = Object.class.getPackage();
            String result = pkg.toString();
            assertEquals("package java.lang", result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            String result = pkg.toString();
            assertEquals("package xd.pkg.example, Dummy Specification Title, version 6.7.8", result);
        }
    }

    @Test
    public void isCompatibleWithExample() {
        {
            Package pkg = Object.class.getPackage();
            assertThrows(NumberFormatException.class, () -> {
                boolean result = pkg.isCompatibleWith("1");
                ignore(result);
            });
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("0.0.0");
            assertTrue(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.0.0");
            assertTrue(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.7.0");
            assertTrue(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.7.8");
            assertTrue(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.7.8.0");
            assertTrue(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.7.8.1");
            assertFalse(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.7.9");
            assertFalse(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("6.8.0");
            assertFalse(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("7.0.0");
            assertFalse(result);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            boolean result = pkg.isCompatibleWith("9.9.9");
            assertFalse(result);
        }
    }

    @Test
    public void getAnnotationsExample() {
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            Annotation[] annotations = pkg.getAnnotations();
            assertEquals(DummyPackageAnnotation.class, annotations[0]);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            Annotation[] declaredAnnotations = pkg.getDeclaredAnnotations();
            assertEquals(1, declaredAnnotations.length);
            assertEquals(DummyPackageAnnotation.class, declaredAnnotations[0]);
        }
        // TODO: Any difference between getAnnotations() and getDeclaredAnnotations() for packages ?
    }

    @Test
    public void isAnnotationPresentExample() {
        Package pkg = DummyForPackageExample.class.getPackage();
        boolean result = pkg.isAnnotationPresent(DummyPackageAnnotation.class);
        assertTrue(result);
    }

    @Test
    public void getAnnotationExample() {
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            DummyPackageAnnotation annotation = pkg.getAnnotation(DummyPackageAnnotation.class);
            assertNotNull(annotation);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            DummyPackageAnnotation annotation = pkg.getDeclaredAnnotation(DummyPackageAnnotation.class);
            assertNotNull(annotation);
        }
        // TODO: @see getAnnotationsExample
    }

    @Test
    public void getAnnotationsByTypeExample() {
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            DummyPackageAnnotation[] annotationsByType = pkg.getAnnotationsByType(DummyPackageAnnotation.class);
            assertEquals(1, annotationsByType.length);
        }
        {
            Package pkg = DummyForPackageExample.class.getPackage();
            DummyPackageAnnotation[] annotationsByType = pkg.getDeclaredAnnotationsByType(DummyPackageAnnotation.class);
            assertEquals(1, annotationsByType.length);
        }
        // TODO: @see getAnnotationsExample
        // TODO: example with multiple annotations of the same type
    }

}
