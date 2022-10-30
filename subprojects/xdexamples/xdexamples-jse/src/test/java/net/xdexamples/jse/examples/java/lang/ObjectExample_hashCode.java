package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class ObjectExample_hashCode {

    @Test
    public void example() {
        Object object1 = new Object();
        Object object2 = new Object();

        int hashCode1 = object1.hashCode();
        int hashCode2 = object2.hashCode();

        // Statistically true
        assertNotEquals(hashCode1, hashCode2);
    }

}
