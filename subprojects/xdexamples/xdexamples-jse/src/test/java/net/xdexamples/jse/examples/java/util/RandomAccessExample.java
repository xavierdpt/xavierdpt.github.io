package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.ToBeContinued;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.RandomAccess;

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
