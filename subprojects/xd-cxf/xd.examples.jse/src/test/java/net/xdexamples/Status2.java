package net.xdexamples;

import net.xdexamples.jse.index.Index;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Status2 {
    public static void main(String[] args) {
        Set<String> classes = new HashSet<>();
        Set<String> exampleClasses = new HashSet<>();
        int done = 0;
        for (Class<?> indexClass : Index.class.getAnnotation(MasterIndex.class).value()) {
            if (indexClass.isAnnotationPresent(ExampleIndex.class)) {
                for (Class<?> clazz : indexClass.getAnnotation(ExampleIndex.class).value()) {
                    String className = clazz.getName();
                    if (className.endsWith("Exception")) {
                        continue;
                    }
                    if (className.endsWith("Error")) {
                        continue;
                    }
                    if (className.endsWith("Example")) {
                        exampleClasses.add(className);
                        if (clazz.isAnnotationPresent(Done.class)) {
                            ++done;
                        }
                    } else {
                        classes.add(className);
                    }
                }
            }
        }
        System.out.println("Classes: " + classes.size());
        System.out.println("Examples classes: " + exampleClasses.size());
        System.out.println("Done: " + done);

        if (classes.size() > exampleClasses.size()) {
            Predicate<String> predicate = new Predicate<String>() {
                @Override
                public boolean test(String s) {
                    return !exampleClasses.contains("net.xdexamples.jse.examples." + s + "Example");
                }
            };
            if (System.currentTimeMillis() < 0) {
                long count = classes.stream().filter(predicate).sorted().peek(System.out::println).count();
                System.out.println(count);
            }
            {
                Map<String, List<String>> groups = classes.stream()
                        .filter(predicate)
                        .collect(Collectors.groupingBy(s -> s.substring(0, s.lastIndexOf("."))));
                groups
                        .values()
                        .stream()
                        .sorted(Comparator.<List<String>, Integer>comparing(List::size).reversed())
                        .flatMap(Collection::stream)
                        .forEach(System.out::println);
                System.out.println(groups.size());
            }

        }
    }
}
