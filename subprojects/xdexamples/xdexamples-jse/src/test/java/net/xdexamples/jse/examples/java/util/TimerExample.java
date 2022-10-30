package net.xdexamples.jse.examples.java.util;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Scaffolded
public class TimerExample extends BaseExample<Timer> {
    @Override
    public void scaffold(Timer instance) {
        boolean isDaemon = false;
        String name = null;
        ignore(
                new Timer(),
                new Timer(isDaemon),
                new Timer(name),
                new Timer(name, isDaemon)
        );
        TimerTask timerTask = null;
        long delay = 0;
        Date time = null;
        long period = 0;
        Date firstTime = null;
        instance.schedule(timerTask, delay);
        instance.schedule(timerTask, time);
        instance.schedule(timerTask, delay, period);
        instance.schedule(timerTask, firstTime, period);

        instance.scheduleAtFixedRate(timerTask, delay, period);
        instance.scheduleAtFixedRate(timerTask, firstTime, period);

        instance.cancel();

        int purge = instance.purge();
    }
}
