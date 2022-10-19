package xd.examples.java.util;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;
import xdtest.ToBeContinued;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.RandomAccess;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@ToBeContinued
public class RandomAccessExample extends BaseExample<RandomAccess> {

    @Override
    public void scaffold(RandomAccess instance) throws Throwable {
        // nothing
    }

    @Test
    public void example() {
        Collection<Dummy> collection1 = new ArrayList<>();
        Collection<Dummy> collection2 = new HashSet<>();

        assertTrue(collection1 instanceof RandomAccess);
        assertFalse(collection2 instanceof RandomAccess);
    }
}
