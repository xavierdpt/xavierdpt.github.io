package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

public class ByteExample_number {

    @Test
    @SuppressWarnings({"UnnecessaryBoxing", "UnnecessaryUnboxing"})
    public void example() {
        // Byte implements the Number interface
        // See examples about Number for more meaningful examples

        Byte b = Byte.valueOf((byte) 0);

        byte byteValue = b.byteValue();
        short shortValue = b.shortValue();
        int intValue = b.intValue();
        long longValue = b.longValue();
        float floatValue = b.floatValue();
        double doubleValue = b.doubleValue();

        Assert.assertEquals((byte) 0, byteValue);
        Assert.assertEquals((short) 0, shortValue);
        Assert.assertEquals(0, intValue);
        Assert.assertEquals(0L, longValue);
        Assert.assertEquals(0F, floatValue, 0F);
        Assert.assertEquals(0D, doubleValue, 0D);

    }
}
