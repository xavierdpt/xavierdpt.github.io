package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.util.TimerTask;

@Scaffolded
public class TimerTaskExample extends BaseExample<TimerTask> {
    @Override
    public void scaffold(TimerTask instance) {
        instance.run();
        boolean cancel = instance.cancel();
        long l = instance.scheduledExecutionTime();
    }
}
