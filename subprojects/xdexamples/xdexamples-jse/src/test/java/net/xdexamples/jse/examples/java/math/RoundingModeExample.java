package net.xdexamples.jse.examples.java.math;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.math.RoundingMode;

@Scaffolded
public class RoundingModeExample extends BaseExample<RoundingMode> {

    @Override
    protected void scaffold(RoundingMode instance) throws Throwable {
        RoundingMode up = RoundingMode.UP;
        RoundingMode down = RoundingMode.DOWN;
        RoundingMode ceiling = RoundingMode.CEILING;
        RoundingMode floor = RoundingMode.FLOOR;
        RoundingMode halfUp = RoundingMode.HALF_UP;
        RoundingMode halfDown = RoundingMode.HALF_DOWN;
        RoundingMode halfEven = RoundingMode.HALF_EVEN;
        RoundingMode unnecessary = RoundingMode.UNNECESSARY;
    }
}
