package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ByteExample_describeConstable {

    @Test
    @SuppressWarnings({"OptionalGetWithoutIsPresent", "UnnecessaryBoxing"})
    public void example() {
        // TODO: Find more intersting thing to say about this
        Byte value = Byte.valueOf((byte) 0);
        Optional<DynamicConstantDesc<Byte>> result = value.describeConstable();
        assertEquals("DynamicConstantDesc[ConstantBootstraps::explicitCast(0)byte]",
                result.get().toString());
    }
}
