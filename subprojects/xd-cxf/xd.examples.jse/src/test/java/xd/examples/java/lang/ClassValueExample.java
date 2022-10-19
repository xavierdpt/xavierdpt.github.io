package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.IOException;

@Scaffolded
public class ClassValueExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            ClassValue<Dummy> instance = ExampleUtils.makeInstance(ClassValue.class);
            Class<?> clazz = null;
            Dummy dummy = instance.get(clazz);
            instance.remove(clazz);
        }
    }

    public static class Dummy {
    }
}
