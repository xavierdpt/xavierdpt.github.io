package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;

public class CloneableExample {

    @Test
    @SuppressWarnings("Convert2MethodRef")
    public void example() throws CloneNotSupportedException {

        {
            // A overrides clone() but does not implement Cloneable
            A a = new A();

            // Therefore it cannot be cloned
            assertThrows(CloneNotSupportedException.class, () -> {
                a.clone();
            });
        }

        {
            // B overrides clone by simple delegatio to Object::clone and implements Cloneable
            B b = new B("hello", "world");

            // Cloning workds
            Object result = b.clone();

            // The result is not null
            assertNotNull(result);

            // The result is not the original instance (i.e. clone() does not return "this")
            assertNotSame(result, b);

            // The result is of type B (i.e. clone() does not simply return a new Object())
            assertEquals(B.class, result.getClass());

            // The "value" field is set on the result (magic!)
            assertEquals("hello", ((B) result).getValue1());

            // Transient fields are also cloned
            assertEquals("world", ((B) result).getValue2());
        }
    }

    public static class A {
        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B implements Cloneable {
        private final String value1;

        private transient final String value2;

        public B(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public String getValue1() {
            return value1;
        }

        public String getValue2() {
            return value2;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
