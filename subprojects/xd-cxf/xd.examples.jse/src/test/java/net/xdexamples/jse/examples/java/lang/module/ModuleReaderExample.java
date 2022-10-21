package net.xdexamples.jse.examples.java.lang.module;

import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

@Scaffolded
public class ModuleReaderExample extends BaseExample<ModuleReader> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(ModuleReader instance) throws IOException {

        {
            // TODO
            String name = any();
            Optional<URI> uri = instance.find(name);
        }

        {

            // TODO
            String name = any();
            Optional<InputStream> open = instance.open(name);
        }

        {

            // TODO
            String name = any();
            Optional<ByteBuffer> read = instance.read(name);
        }

        {

            // TODO
            ByteBuffer byteBuffer = any();
            instance.release(byteBuffer);
        }

        {
            // TODO
            Stream<String> list = instance.list();
            seeExamples(this::listExample);
        }

        {

            // TODO
            instance.close();
            seeExamples(this::listExample);
        }
    }

    @Test
    public void listExample() throws IOException {
        // Find a module reference
        ModuleLayer bootLayer = ModuleLayer.boot();
        Configuration configuration = bootLayer.configuration();
        ModuleReference reference = configuration.modules().stream()
                .filter(x -> "java.base".equals(x.name()))
                .findAny().get().reference();

        // Open and list it
        List<String> result;
        try (ModuleReader moduleReader = reference.open()) {
            Stream<String> list = moduleReader.list();
            result = list.sorted().toList();
        }

        // Check that we find what we expect
        assertTrue(result.stream().anyMatch("java/lang/Object.class"::equals));
    }
}
