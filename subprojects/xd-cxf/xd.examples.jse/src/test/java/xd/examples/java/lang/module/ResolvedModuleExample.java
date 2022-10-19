package xd.examples.java.lang.module;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.module.Configuration;
import java.lang.module.ModuleReference;
import java.lang.module.ResolvedModule;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Scaffolded
public class ResolvedModuleExample extends BaseExample<ResolvedModule> {
    @Override
    @SuppressWarnings("unused")
    public void scaffold(ResolvedModule instance) {
        {
            Configuration configuration = instance.configuration();
            seeExamples(this::configurationExample);
        }
        {
            ModuleReference reference = instance.reference();
            seeExamples(this::referenceExample);
        }
        {
            String name = instance.name();
            seeExamples(this::nameExample);
        }
        {
            Set<ResolvedModule> reads = instance.reads();
            seeExamples(this::readsExample);
        }
        {
            // TODO
            int i = instance.hashCode();
        }
        {
            // TODO
            ResolvedModule other = null;
            instance.equals(other);
        }
        {
            String string = instance.toString();
            seeExamples(this::toStringExample);
        }
    }

    @Test
    public void toStringExample() {
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ResolvedModule module = configuration.modules().stream()
                .filter(m -> "java.base".equals(m.name()))
                .findAny().get();
        String expected = System.identityHashCode(configuration) + "/java.base";
        assertEquals(expected, module.toString());
    }

    @Test
    public void nameExample() {
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        assertTrue(configuration.modules().stream()
                .anyMatch(m -> "java.base".equals(m.name())));
    }

    @Test
    public void referenceExample() {
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ResolvedModule module = configuration.modules().stream()
                .filter(m -> "java.base".equals(m.name()))
                .findAny().get();
        ModuleReference reference = module.reference();
        Assert.assertNotNull(reference);
        seeOthers(ModuleReferenceExample.class);
    }

    @Test
    public void configurationExample() {
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration bootLayerConfiguration = bootLayer.configuration();
        ResolvedModule module = bootLayerConfiguration.modules().stream()
                .filter(m -> "java.base".equals(m.name()))
                .findAny().get();
        Configuration configuration = module.configuration();
        Assert.assertSame(bootLayerConfiguration, configuration);
    }

    @Test
    public void readsExample() {
        {
            ModuleLayer bootLayer = ModuleLayer.boot();
            Configuration configuration = bootLayer.configuration();
            Set<ResolvedModule> modules = configuration.modules();
            Map<Boolean, Map<String, ResolvedModule>> partitioned = modules.stream().collect(Collectors.partitioningBy(m -> m.reads().size() > 0, Collectors.toMap(ResolvedModule::name, Function.identity())));

            Map<String, ResolvedModule> withoutReads = partitioned.get(Boolean.FALSE);
            Map<String, ResolvedModule> withReads = partitioned.get(Boolean.TRUE);

            // "java.base" does not read any module
            assertEquals(1, withoutReads.size());
            assertTrue(withoutReads.containsKey("java.base"));

            // all other modules read "java.base"
            assertTrue(withReads.values().stream().allMatch(m -> m.reads().stream().map(ResolvedModule::name).anyMatch("java.base"::equals)));
        }

    }
}
