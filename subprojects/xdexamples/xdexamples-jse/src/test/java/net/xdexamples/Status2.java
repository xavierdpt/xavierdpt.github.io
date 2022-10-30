package net.xdexamples;

import net.xdexamples.jse.index.Index;
import net.xdexamples.support.ExampleIndex;
import net.xdexamples.support.MasterIndex;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
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
                        if (clazz.isAnnotationPresent(AllMethodsCovered.class)) {
                            ++done;
                            foo2(clazz);
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
        if (System.currentTimeMillis() < 0) {
            foo1(classes, exampleClasses);
        }
    }

    private static void foo1(Set<String> classes, Set<String> exampleClasses) {
        // Find unscaffolded classes
        if (!(classes.size() > exampleClasses.size())) {
            return;
        }
        Map<String, List<String>> groups = classes.stream()
                .filter(className -> !exampleClasses.contains("net.xdexamples.jse.examples." + className + "Example"))
                .collect(Collectors.groupingBy(s -> s.substring(0, s.lastIndexOf("."))));
        groups
                .values()
                .stream()
                .sorted(Comparator.<List<String>, Integer>comparing(List::size).reversed())
                .flatMap(Collection::stream)
                .forEach(System.out::println);
        System.out.println(groups.size());
    }

    private static void foo2(Class<?> clazz) {
        Pattern x = Pattern.compile("Example$");
        for (Method method : clazz.getMethods()) {
            String clsname = clazz.getName();
            clsname = clsname.replace("net.xdexamples.jse.examples.", "");
            clsname = x.matcher(clsname).replaceFirst("");
            String packageName = clsname.substring(0, clsname.lastIndexOf("."));
            String className = clsname.substring(packageName.length() + 1);
            if (method.isAnnotationPresent(Test.class)) {
                System.out.println(packageName + " " + className + " " + method.getName());

            }
        }
    }
}
