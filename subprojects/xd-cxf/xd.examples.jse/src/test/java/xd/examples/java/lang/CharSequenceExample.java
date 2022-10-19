package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.util.stream.IntStream;

@Scaffolded
public class CharSequenceExample {

    public void scaffold() throws Exception {
        if (ExampleUtils.skip()) {
            CharSequence instance = ExampleUtils.makeInstance(CharSequence.class);
            int length = instance.length();
            int index = 0;
            char c = instance.charAt(index);
            boolean empty = instance.isEmpty();
            int start = 0;
            int end = 0;
            CharSequence charSequence = instance.subSequence(start, end);
            String s = instance.toString();
            IntStream chars = instance.chars();
            IntStream intStream = instance.codePoints();
            CharSequence left = null;
            CharSequence right = null;
            int compare = CharSequence.compare(left, right);
        }
    }


}
