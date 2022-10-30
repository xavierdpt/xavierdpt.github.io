package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.AllMethodsCovered;
import xdtest.SeeAlso;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@AllMethodsCovered
@SeeAlso({CollectionExample.class})
public class SetExample extends BaseExample<Set<Dummy>> {

    @Override
    public void scaffold(Set<Dummy> instancee) {

        {
            Collection<Dummy> collection = null;
            Set<Dummy> dummies = Set.copyOf(collection);
            seeExamples(this::copyOfExample);
            ignore(dummies);
        }

        {
            Dummy value = null;
            Set<Dummy> set = Set.of(value, value, value);
            seeExamples(
                    this::ofExample,
                    this::immutableExample
            );
            ignore(set);
        }
    }

    @Test
    public void ofExample() {
        Set<String> set = Set.of("hello", "world");
        assertEquals(2, set.size());
        assertTrue(set.contains("hello"));
        assertTrue(set.contains("world"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableExample() {
        Set<String> set = Set.of("hello", "world");
        set.add("wonderful");
    }

    @Test
    public void copyOfExample() {
        Collection<String> hashSet = new HashSet<>(Arrays.asList("hello", "world"));
        Set<String> copy = Set.copyOf(hashSet);
        hashSet.add("wonderful");
        assertEquals(3, hashSet.size());
        assertEquals(2, copy.size());
        assertThrows(UnsupportedOperationException.class, () -> copy.add("wonderful"));
    }

}
