package net.xdexamples.support;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScratchTest {
    // https://stackoverflow.com/questions/7318011/is-it-possible-to-create-an-empty-java-enum-type-with-methods
    @Test
    public void scratch() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Constructor<?> constructor = ScratchEnum.class.getDeclaredConstructors()[0];
        for (Method method : constructor.getClass().getDeclaredMethods()) {
            if ("acquireConstructorAccessor".equals(method.getName())) {
                method.setAccessible(true);
                method.invoke(constructor);
                break;
            }
        }
        Object whut = null;
        for (Field field : constructor.getClass().getDeclaredFields()) {
            if ("constructorAccessor".equals(field.getName())) {
                field.setAccessible(true);
                whut = field.get(constructor);
            }
        }
        Method newInstance = whut.getClass().getMethod("newInstance", new Class[]{Object[].class});
        newInstance.setAccessible(true);
        ScratchEnum magic = (ScratchEnum) newInstance.invoke(whut, new Object[]{new Object[]{"I don't exist", Integer.MAX_VALUE}});
        System.out.println(magic.name());
    }
}
