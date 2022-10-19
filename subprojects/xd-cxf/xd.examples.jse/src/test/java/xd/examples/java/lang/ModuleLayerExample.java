package xd.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xd.examples.java.lang.module.ConfigurationExample;
import xdtest.Scaffolded;

import java.lang.module.Configuration;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@Scaffolded
public class ModuleLayerExample extends BaseExample<ModuleLayer> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(ModuleLayer instance) {

        {
            // TODO
            Configuration configuration = any();
            ClassLoader classLoader = any();
            ModuleLayer moduleLayer = instance.defineModulesWithOneLoader(configuration, classLoader);
        }

        {
            // TODO
            Configuration configuration = any();
            ClassLoader classLoader = any();
            ModuleLayer moduleLayer1 = instance.defineModulesWithManyLoaders(configuration, classLoader);
        }

        {
            // TODO
            Configuration configuration = any();
            List<ModuleLayer> moduleLayers = any();
            ClassLoader classLoader = any();
            ModuleLayer.Controller controller = ModuleLayer.defineModulesWithManyLoaders(configuration, moduleLayers, classLoader);
        }

        {
            // TODO
            Configuration configuration = any();
            Function<String, ClassLoader> classLoaderFunction = any();
            ModuleLayer moduleLayer2 = instance.defineModules(configuration, classLoaderFunction);
        }

        {
            // TODO
            Configuration configuration = any();
            List<ModuleLayer> moduleLayers = any();
            Function<String, ClassLoader> classLoaderFunction = any();
            ModuleLayer.Controller controller1 = ModuleLayer.defineModules(configuration, moduleLayers, classLoaderFunction);
        }

        {
            // TODO
            Configuration configuration = any();
            List<ModuleLayer> moduleLayers = any();
            ClassLoader classLoader = any();
            ModuleLayer.Controller controller2 = ModuleLayer.defineModulesWithOneLoader(configuration, moduleLayers, classLoader);
        }

        {
            Configuration configuration1 = instance.configuration();
            seeExamples(this::configurationExample);
        }

        {
            // TODO
            List<ModuleLayer> parents = instance.parents();
        }

        {
            Set<Module> modules = instance.modules();
            seeExamples(this::modulesExample);
        }

        {
            // TODO
            String name = any();
            Optional<Module> module = instance.findModule(name);
        }

        {
            // TODO
            String name = any();
            ClassLoader loader = instance.findLoader(name);
        }

        {
            String string = instance.toString();
            seeExamples(this::toStringExample);
        }

        {
            ModuleLayer empty = ModuleLayer.empty();
            seeExamples(this::emptyExample);
        }

        {
            ModuleLayer boot = ModuleLayer.boot();
            seeExamples(this::bootExample);
        }

    }

    @Test
    public void configurationExample() {
        ModuleLayer layer = Object.class.getModule().getLayer();
        Configuration configuration = layer.configuration();
        assertNotNull(configuration);
        seeOthers(ConfigurationExample.class);
    }

    @Test
    public void toStringExample() {
        ModuleLayer layer = Object.class.getModule().getLayer();
        String string = layer.toString();
        // it's a commas serarated list of modules names
        long commas = string.chars().filter(x -> ',' == x).count();
        assertEquals(commas, layer.modules().size() - 1);
    }

    @Test
    public void emptyExample() {
        ModuleLayer layer = ModuleLayer.empty();
        assertEquals(0, layer.modules().size());
        assertEquals("", layer.toString());
        assertNotNull(layer.configuration());
        // TODO: examine empty layer configuration in ConfigurationExample
    }

    @Test
    public void bootExample() {
        ModuleLayer layer = ModuleLayer.boot();
        Assert.assertSame(Object.class.getModule().getLayer(), layer);
    }

    @Test
    public void modulesExample() {
        ModuleLayer layer = ModuleLayer.boot();
        // Boot layer at least contains the java.base module
        assertTrue(layer.modules().stream().map(Module::getName).anyMatch("java.base"::equals));
    }

    @Test public void parentsExample() {
        {
            // Boot layer
            ModuleLayer layer = ModuleLayer.boot();
            // Parents of boot layer
            List<ModuleLayer> parents = layer.parents();
            // The boot layer has one parent layer
            assertEquals(1, parents.size());
            // That parent is the empty layer
            ModuleLayer parent = parents.get(0);
            assertSame(ModuleLayer.empty(),parent);
        }

        {
            Optional<ModuleLayer> answer = ModuleLayer.boot()
                    .modules()
                    .stream()
                    .map(Module::getLayer)
                    .filter(layer -> layer.parents().size() > 1)
                    .findAny();
            assertTrue(answer.isEmpty());
            // TODO: Find if it is possible to have a layer with more than one parents
        }
    }
}
