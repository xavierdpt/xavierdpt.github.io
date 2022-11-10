package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExample_equals {

    @Test
    @SuppressWarnings({"ConstantConditions", "EqualsWithItself", "SimplifiableAssertion"})
    public void example() {

        Boolean bt = Boolean.TRUE;
        Boolean bf = Boolean.FALSE;

        // TRUE equals TRUE and FALSE equals FALSE
        assertTrue(bt.equals(bt));
        assertTrue(bf.equals(bf));

        // TRUE is not equal to FALSE and FALSE is not equal to TRUE
        assertFalse(bt.equals(bf));
        assertFalse(bf.equals(bt));

    }

}
