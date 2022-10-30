package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.IOException;

@Scaffolded
public class ThreadGroupExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            ThreadGroup instance = ExampleUtils.makeInstance(ThreadGroup.class);

            String name = null;
            ThreadGroup parent = null;
            ExampleUtils.ignore(
                    new ThreadGroup(name),
                    new ThreadGroup(parent, name)
            );

            String name1 = instance.getName();
            ThreadGroup parent1 = instance.getParent();
            int maxPriority = instance.getMaxPriority();
            instance.setMaxPriority(maxPriority);
            ThreadGroup other = null;
            boolean b = instance.parentOf(other);
            int i = instance.activeCount();
            Thread[] list = new Thread[0];
            instance.enumerate(list);
            boolean recurse = false;
            instance.enumerate(list, recurse);
            Thread[] groupList = new Thread[0];
            instance.enumerate(groupList);
            instance.enumerate(groupList, recurse);
            int i1 = instance.activeGroupCount();
            instance.interrupt();
            instance.list();
            Thread thread = null;
            Throwable throwable = null;
            instance.uncaughtException(thread, throwable);
            instance.toString();
        }
    }

}
