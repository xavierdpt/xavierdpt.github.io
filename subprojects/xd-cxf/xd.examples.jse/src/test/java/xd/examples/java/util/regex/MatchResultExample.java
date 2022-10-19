package xd.examples.java.util.regex;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.regex.MatchResult;

@Scaffolded
public class MatchResultExample extends BaseExample<MatchResult> {
    @Override
    public void scaffold(MatchResult instance) throws Throwable {
        int start = instance.start();
        int group = 0;
        int start1 = instance.start(group);
        int end = instance.end();
        int end1 = instance.end(group);
        String group1 = instance.group();
        String group2 = instance.group(group);
        int i = instance.groupCount();

    }
}
