package xd.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.ToBeContinued;

@ToBeContinued
public class ComparableExample extends BaseExample<Comparable<Dummy>> {

    @Override
    protected void scaffold(Comparable<Dummy> instance) throws Throwable {
        Dummy other = any();
        int result = instance.compareTo(other);
        ignore(result);
    }

    @Test
    public void exampleExploded() {
        Integer a = Integer.valueOf(5);
        Integer b =Integer.valueOf(9);

        Comparable<Integer> aComparable = a;
        int abResult = aComparable.compareTo(b);
        Assert.assertTrue(abResult < 0);

        Comparable<Integer> bComparable = b;
        int baResult = bComparable.compareTo(a);
        Assert.assertTrue(baResult > 0);
    }

    @Test
    public void exampleInContext() {
        // TODO
    }


}
