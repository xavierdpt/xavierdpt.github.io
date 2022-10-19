package xd.examples.java.math;

import xd.ExampleUtils;
import xdtest.Enum;
import xdtest.Scaffolded;

import java.math.RoundingMode;

@Scaffolded
@Enum
public class RoundingModeExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
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
}
