package net.xdexamples.jse.examples.java.lang.module;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleDescriptor;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

@Scaffolded
public class ModuleDescriptorExample extends BaseExample<ModuleDescriptor> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(ModuleDescriptor instance) throws IOException {

        {
            // TODO
            String name = instance.name();
        }

        {
            // TODO
            Set<ModuleDescriptor.Modifier> modifiers = instance.modifiers();
        }

        {
            // TODO
            boolean open = instance.isOpen();
        }

        {
            // TODO
            boolean automatic = instance.isAutomatic();
        }

        {
            // TODO
            Set<ModuleDescriptor.Requires> requires = instance.requires();
        }

        {
            // TODO
            Set<ModuleDescriptor.Exports> exports = instance.exports();
        }

        {
            // TODO
            Set<ModuleDescriptor.Opens> opens = instance.opens();
        }

        {
            // TODO
            Set<String> uses = instance.uses();
        }

        {
            // TODO
            Set<ModuleDescriptor.Provides> provides = instance.provides();
        }

        {
            // TODO
            Optional<ModuleDescriptor.Version> version = instance.version();
        }

        {
            // TODO
            Optional<String> s = instance.rawVersion();
        }

        {
            // TODO
            String s1 = instance.toNameAndVersion();
        }

        {
            // TODO
            Optional<String> s2 = instance.mainClass();
        }

        {
            // TODO
            Set<String> packages = instance.packages();
        }

        {
            // TODO
            ModuleDescriptor other = any();
            int i = instance.compareTo(other);
        }

        {
            // TODO
            ModuleDescriptor other = any();
            boolean equals = instance.equals(other);
        }

        {
            // TODO
            int i1 = instance.hashCode();
        }

        {
            // TODO
            String s3 = instance.toString();
        }

        {
            // TODO
            String name = any();
            ModuleDescriptor.Builder builder = ModuleDescriptor.newModule(name);
        }

        {
            // TODO
            String name = any();
            Set<ModuleDescriptor.Modifier> modifiers = any();
            ModuleDescriptor.Builder builder1 = ModuleDescriptor.newModule(name, modifiers);
        }

        {
            // TODO
            String name = any();
            ModuleDescriptor.Builder builder2 = ModuleDescriptor.newOpenModule(name);
        }

        {
            // TODO
            String name = any();
            ModuleDescriptor.Builder builder3 = ModuleDescriptor.newAutomaticModule(name);
        }

        {
            // TODO
            InputStream inputStream = any();
            ModuleDescriptor.read(inputStream);
        }

        {
            // TODO
            InputStream inputStream = any();
            Supplier<Set<String>> packageFinder = any();
            ModuleDescriptor.read(inputStream, packageFinder);
        }

        {
            // TODO
            ByteBuffer byteBuffer = any();
            ModuleDescriptor.read(byteBuffer);
        }

        {
            // TODO
            ByteBuffer byteBuffer = any();
            Supplier<Set<String>> packageFinder = any();
            ModuleDescriptor.read(byteBuffer, packageFinder);
        }
    }
}
