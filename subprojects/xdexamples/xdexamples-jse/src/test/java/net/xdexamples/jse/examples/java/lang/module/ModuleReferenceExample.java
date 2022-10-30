package net.xdexamples.jse.examples.java.lang.module;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;

import java.io.IOException;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModuleReferenceExample extends BaseExample<ModuleReference> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(ModuleReference instance) throws IOException {
        {
            ModuleDescriptor descriptor = instance.descriptor();
            seeExamples(this::descriptorExample);
        }
        {
            // TODO
            Optional<URI> location = instance.location();
            seeExamples(this::locationExample);
        }
        {
            // TODO
            ModuleReader open = instance.open();
        }
    }

    @Test
    public void descriptorExample() {
        // Find a module reference
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ModuleReference reference = configuration.modules().stream()
                .filter(x -> "java.base".equals(x.name()))
                .findAny().get().reference();

        // Get the descriptor
        ModuleDescriptor descriptor = reference.descriptor();

        // Find the same module directly
        Module module = bootLayer.modules().stream()
                .filter(x -> "java.base".equals(x.getName()))
                .findAny().get();

        // Descriptor are identical
        Assert.assertSame(module.getDescriptor(), descriptor);

        seeOthers(ModuleDescriptorExample.class);
    }

    @Test
    public void locationExample() {
        // Find a module reference
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ModuleReference reference = configuration.modules().stream()
                .filter(x -> "java.base".equals(x.name()))
                .findAny().get().reference();

        // Get the location and check it
        Optional<URI> location = reference.location();
        assertEquals("jrt:/java.base", location.get().toString());
    }

    @Test
    public void openExample() throws IOException {
        // Find a module reference
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ModuleReference reference = configuration.modules().stream()
                .filter(x -> "java.base".equals(x.name()))
                .findAny().get().reference();

        // Open and immeditely closes it
        try (ModuleReader moduleReader = reference.open()) {
            ignore(moduleReader);
        }

        seeOthers(ModuleReaderExample.class);
    }

}
