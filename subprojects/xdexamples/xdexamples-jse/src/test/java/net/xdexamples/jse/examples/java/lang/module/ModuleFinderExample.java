package net.xdexamples.jse.examples.java.lang.module;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Scaffolded
public class ModuleFinderExample extends BaseExample<ModuleFinder> {
    @Override
    public void scaffold(ModuleFinder instance) {
        String name = null;
        Optional<ModuleReference> moduleReference = instance.find(name);

        Set<ModuleReference> all = instance.findAll();

        ModuleFinder moduleFinder = ModuleFinder.ofSystem();

        Path entries = null;
        ModuleFinder of = ModuleFinder.of(entries);

        ModuleFinder[] finders = new ModuleFinder[0];
        ModuleFinder compose = ModuleFinder.compose(finders);

    }
}
