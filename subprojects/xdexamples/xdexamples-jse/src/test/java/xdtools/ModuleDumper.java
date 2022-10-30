package xdtools;

import java.util.HashSet;
import java.util.Set;

public class ModuleDumper {

    public static void main(String[] args) {
        Set<Module> seen = new HashSet<>();
        dumpModule(Object.class.getModule(), seen);

    }

    private static void dumpModule(Module module, Set<Module> seen) {
        if (!seen.contains(module)) {
            seen.add(module);
            System.out.println(module.getName());
            dumpLayer(module.getLayer(), seen);
        }

    }

    private static void dumpLayer(ModuleLayer layer, Set<Module> seen) {
        if (layer != null) {
            for (Module module : layer.modules()) {
                dumpModule(module, seen);
            }
        }
    }
}
