package xdtest.org.apache.cxf.configuration.security;

import org.apache.cxf.configuration.security.CombinatorType;
import org.apache.cxf.configuration.security.DNConstraintsType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DNConstraintsTypeTest {

    public static final CombinatorType COMBINATOR_OTHER = CombinatorType.ANY;
    public static final String REGULAR_EXPRESSION = "regularExpression";
    public static final CombinatorType COMBINATOR_DEFAULT = CombinatorType.ALL;

    @Test
    public void test() {

        // There is a combinator (ANY or ALL) and regular expressions
        DNConstraintsType instance = new DNConstraintsType();

        // No combinator => ALL
        assertFalse(instance.isSetCombinator());
        assertEquals(COMBINATOR_DEFAULT,instance.getCombinator());

        // Combinator can be set
        instance.setCombinator(COMBINATOR_OTHER);
        assertEquals(instance.getCombinator(), COMBINATOR_OTHER);
        assertTrue(instance.isSetCombinator());

        // Setting to the default value still counts as set
        instance.setCombinator(COMBINATOR_DEFAULT);
        assertEquals(instance.getCombinator(), COMBINATOR_DEFAULT);
        assertTrue(instance.isSetCombinator());

        // And unset
        instance.setCombinator(null);
        assertFalse(instance.isSetCombinator());

        // No regular expressions
        assertFalse(instance.isSetRegularExpression());
        assertTrue(instance.getRegularExpression().isEmpty());

        // The regular expressions can be modified
        instance.getRegularExpression().add(REGULAR_EXPRESSION);
        assertTrue(instance.isSetRegularExpression());
        assertFalse(instance.getRegularExpression().isEmpty());

        // There is a method to reset the regular expressions
        instance.unsetRegularExpression();
        assertFalse(instance.isSetRegularExpression());
        assertTrue(instance.getRegularExpression().isEmpty());

        // But it's almost equivalent to this
        instance.getRegularExpression().clear();


    }
}
