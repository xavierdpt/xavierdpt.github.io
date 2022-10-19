package xd.examples.java.lang;

import org.junit.Test;
import xd.BaseExample;
import xd.examples.java.lang.module.ModuleDescriptorExample;
import xdtest.ToBeContinued;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.module.ModuleDescriptor;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@ToBeContinued
public class ModuleExample extends BaseExample<Module> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Module instance) throws Throwable {
        {
            boolean named = instance.isNamed();
            seeExamples(this::isNamedExample);
        }
        {
            String name = instance.getName();
            seeExamples(this::getNameExample);
        }
        {
            // TODO
            ClassLoader classLoader = instance.getClassLoader();
        }
        {
            ModuleDescriptor descriptor = instance.getDescriptor();
            seeExamples(this::getDescriptorExample);
        }
        {
            ModuleLayer layer = instance.getLayer();
            seeExamples(this::getLayerExample);
        }
        {
            // TODO
            Module module = any();
            boolean b = instance.canRead(module);
        }
        {
            // TODO
            Module module = any();
            Module module1 = instance.addReads(module);
        }
        {
            // TODO
            String name = any();
            Module module = any();
            boolean exported = instance.isExported(name, module);
        }
        {
            // TODO
            String name = any();
            Module module = any();
            boolean open = instance.isOpen(name, module);
        }
        {
            // TODO
            String name = any();
            boolean exported1 = instance.isExported(name);
        }
        {
            // TODO
            String name = any();
            boolean open1 = instance.isOpen(name);
        }
        {
            // TODO
            String name = any();
            Module module = any();
            Module module2 = instance.addExports(name, module);
        }
        {
            // TODO
            String name = any();
            Module module = any();
            Module module3 = instance.addOpens(name, module);
        }
        {
            // TODO
            Class<?> clazz = any();
            Module module4 = instance.addUses(clazz);
        }
        {
            // TODO
            Class<?> clazz = any();
            boolean b1 = instance.canUse(clazz);
        }
        {
            // TODO
            Set<String> packages = instance.getPackages();
        }
        {
            // TODO
            Class<Annotation> annotationClazz = any();
            Annotation annotation = instance.getAnnotation(annotationClazz);
        }
        {
            // TODO
            Annotation[] annotations = instance.getAnnotations();
        }
        {
            // TODO
            Annotation[] declaredAnnotations = instance.getDeclaredAnnotations();
        }
        {
            // TODO
            String name = any();
            InputStream resourceAsStream = instance.getResourceAsStream(name);
        }
        {
            String string = instance.toString();
            seeExamples(this::toStringExample);
        }

    }

    @Test
    public void test() {
        Module module = Object.class.getModule();
        assertNotNull(module);
        assertNotNull(module.getDescriptor());
        assertEquals(169, module.getPackages().size());
        assertEquals(0, module.getAnnotations().length);
        assertEquals(0, module.getDeclaredAnnotations().length);

    }

    @Test
    public void isNamedExample() {
        {
            Module module = Object.class.getModule();
            boolean isNamed = module.isNamed();
            assertTrue(isNamed);
        }
        {
            Module module = this.getClass().getModule();
            boolean isNamed = module.isNamed();
            assertFalse(isNamed);
        }
    }

    @Test
    public void getNameExample() {
        {
            Module module = Object.class.getModule();
            String name = module.getName();
            assertEquals("java.base", name);
        }
        {
            Module module = this.getClass().getModule();
            String name = module.getName();
            assertNull(name);
        }
    }

    @Test
    public void toStringExample() {
        {
            Module module = Object.class.getModule();
            String string = module.toString();
            assertEquals("module java.base", string);
            assertEquals("module java.base", string);
        }
        {
            Module module = this.getClass().getModule();
            String string = module.toString();
            String hexId = Integer.toHexString(System.identityHashCode(module));
            assertEquals("unnamed module @" + hexId, string);
        }
    }

    @Test
    public void getLayerExample() {
        {
            Module module = Object.class.getModule();
            ModuleLayer layer = module.getLayer();
            assertNotNull(layer);
        }
        {
            Module module = this.getClass().getModule();
            ModuleLayer layer = module.getLayer();
            assertNull(layer);
        }
        seeOthers(ModuleLayerExample.class);
    }

    @Test
    public void getDescriptorExample() {
        {
            Module module = Object.class.getModule();
            ModuleDescriptor descriptor = module.getDescriptor();
            assertNotNull(descriptor);
        }
        {
            Module module = this.getClass().getModule();
            ModuleDescriptor descriptor = module.getDescriptor();
            assertNull(descriptor);
        }
        seeOthers(ModuleDescriptorExample.class);
    }

}
