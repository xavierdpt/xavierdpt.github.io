package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

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
