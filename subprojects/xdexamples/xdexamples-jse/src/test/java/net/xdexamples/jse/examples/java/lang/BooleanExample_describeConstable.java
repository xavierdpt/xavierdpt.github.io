package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;
import xdtest.ToBeContinued;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@ToBeContinued
public class BooleanExample_describeConstable {

    @Test
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public void example() {
        // TODO: Understand better this constable thing
        {
            Optional<DynamicConstantDesc<Boolean>> result = Boolean.TRUE.describeConstable();
            assertEquals(
                    "DynamicConstantDesc[ConstantBootstraps::getStaticFinal(TRUE/ClassDesc[Boolean])Boolean]",
                    result.get().toString());
        }
        {
            Optional<DynamicConstantDesc<Boolean>> result = Boolean.FALSE.describeConstable();
            assertEquals("DynamicConstantDesc[ConstantBootstraps::getStaticFinal(FALSE/ClassDesc[Boolean])Boolean]",
                    result.get().toString());
        }
    }

}
