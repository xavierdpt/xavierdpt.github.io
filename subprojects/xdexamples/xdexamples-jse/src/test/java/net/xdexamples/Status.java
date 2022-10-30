package net.xdexamples;

import net.xdexamples.support.ExampleIndex;

import java.io.IOException;
import java.lang.module.ModuleReader;
import java.lang.module.ResolvedModule;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Status {
    public static void main(String[] args) {

        Set<String> indexes = new HashSet<>();

        Set<Class<?>> classes = new HashSet<>();
        for (ResolvedModule module : ModuleLayer.boot().configuration().modules()) {
            try {
                try (ModuleReader open = module.reference().open()) {
                    open.list()
                            .filter(s -> s.endsWith(".class"))
                            .filter(s -> !s.contains("$"))
                            .filter(s -> !"module-info.class".equals(s))
                            .map(s -> s.replace(".class", ""))
                            .map(s -> s.replaceAll("/", "."))
                            .forEach(className -> {
                                String packageName = className.substring(0, className.lastIndexOf("."));
                                String indexName = "net.xdexamples.jse.index." + packageName + ".Index";
                                if (!indexes.contains(indexName)) {
                                    indexes.add(indexName);
                                    System.out.println(indexName);
                                    try {
                                        Class<?> indexClass = Class.forName(indexName, false, Status.class.getClassLoader());
                                        // System.out.println("- found");
                                        if(indexClass.isAnnotationPresent(ExampleIndex.class)) {
                                            System.out.println("- ExampleIndex annotation found");
                                            ExampleIndex annotation = indexClass.getAnnotation(ExampleIndex.class);
                                            for (Class<?> clazz : annotation.value()) {
                                                if(clazz.getName().startsWith("net.xdexamples")) {
                                                    System.out.println(clazz.getName());
                                                }
                                            }
                                        } else {
                                            // System.out.println("- ExampleIndex annotation not found");
                                        }
                                    } catch (ClassNotFoundException e) {
                                        // System.out.println("- not found");
                                    }
                                }
                                String exampleClassName = "net.xdexamples.jse.examples." + className + "Example";

                            });
                }
            } catch (IOException e) {
                System.out.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }

        classes.stream().sorted(Comparator.comparing(Class::getName)).forEach(System.out::println);

    }

}
