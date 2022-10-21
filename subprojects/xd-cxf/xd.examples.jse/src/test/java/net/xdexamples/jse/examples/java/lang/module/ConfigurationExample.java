package net.xdexamples.jse.examples.java.lang.module;

import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.jse.examples.java.lang.ModuleLayerExample;
import net.xdexamples.Scaffolded;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ResolvedModule;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@Scaffolded
public class ConfigurationExample extends BaseExample<Configuration> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(Configuration instance) {

        {
            // TODO
            ModuleFinder before = any();
            ModuleFinder after = any();
            Collection<String> roots = any();
            Configuration resolve = instance.resolve(before, after, roots);
        }

        {
            // TODO
            ModuleFinder before = any();
            List<Configuration> parents = any();
            ModuleFinder after = any();
            Collection<String> roots = any();
            Configuration resolve1 = Configuration.resolve(before, parents, after, roots);
        }

        {
            // TODO
            ModuleFinder before = any();
            ModuleFinder after = any();
            Collection<String> roots = any();
            Configuration configuration = instance.resolveAndBind(before, after, roots);
        }

        {
            // TODO
            ModuleFinder before = any();
            List<Configuration> parents = any();
            ModuleFinder after = any();
            Collection<String> roots = any();
            Configuration configuration1 = Configuration.resolveAndBind(before, parents, after, roots);
        }

        {
            Configuration empty = Configuration.empty();
            seeExamples(this::emptyExample);
        }

        {
            List<Configuration> parents1 = instance.parents();
            seeExamples(this::parentsExample);
        }

        {
            Set<ResolvedModule> modules = instance.modules();
            seeExamples(this::modulesExample);
        }

        {
            // TODO
            String name = any();
            Optional<ResolvedModule> module = instance.findModule(name);
        }

        {
            String s = instance.toString();
            seeExamples(this::toStringExample);
        }
    }

    @Test
    public void toStringExample() {
        {
            Set<String> layerString = Arrays.stream(ModuleLayer.boot().toString().split(", ")).collect(Collectors.toSet());
            Set<String> configString = Arrays.stream(ModuleLayer.boot().configuration().toString().split(", ")).collect(Collectors.toSet());
            // same as ModuleLayer::toString
            seeOthers(ModuleLayerExample.class);
        }
        // TODO: is it it possible to have a different set of modules in the layer and in the configuration ?
    }

    @Test
    public void modulesExample() {
        {
            // Same modules in layer and configuration, but different types (Module vs. ResolvedModule)
            ModuleLayer bootLayer = ModuleLayer.boot();
            Configuration configuration = bootLayer.configuration();
            Set<ResolvedModule> modules = configuration.modules();
            Set<String> configModuleNames = modules.stream().map(ResolvedModule::name).collect(Collectors.toSet());
            Set<String> bootLayerModuleNames = bootLayer.modules().stream().map(Module::getName).collect(Collectors.toSet());
            assertEquals(bootLayerModuleNames, configModuleNames);

        }
        seeOthers(ResolvedModuleExample.class);
    }

    @Test
    public void emptyExample() {
        {
            Configuration configuration = Configuration.empty();
            assertTrue(configuration.modules().isEmpty());
            assertEquals("", configuration.toString());
            assertTrue(configuration.parents().isEmpty());
        }
        {
            ModuleLayer emptyLayer = ModuleLayer.empty();
            Configuration emptyConfiguration = Configuration.empty();
            assertSame(emptyConfiguration, emptyLayer.configuration());
        }
    }

    @Test public void parentsExample() {
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        List<Configuration> parents = configuration.parents();
        // The boot layer configuration has a parent
        assertEquals(1, parents.size());
        // That parent is the empty configuration
        Configuration parent = parents.get(0);
        assertSame(Configuration.empty(),parent);
    }

}
