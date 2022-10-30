package net.xdexamples.jse.examples.java.util.regex;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Scaffolded
public class MatcherExample extends BaseExample<Matcher> {
    @Override
    public void scaffold(Matcher instance) {

        Pattern pattern = instance.pattern();
        MatchResult matchResult = instance.toMatchResult();
        Matcher matcher = instance.usePattern(pattern);
        Matcher reset = instance.reset();
        CharSequence input = null;
        instance.reset(input);

        int group = 0;
        String name = null;
        int start = instance.start();
        int start1 = instance.start(group);
        int start2 = instance.start(name);

        int end = instance.end();
        int end1 = instance.end(group);
        int end2 = instance.end(name);

        String group1 = instance.group();
        String group2 = instance.group(group);
        String group3 = instance.group(name);

        int i = instance.groupCount();

        boolean matches = instance.matches();

        boolean b = instance.find();
        boolean b1 = instance.find(start);

        boolean b2 = instance.lookingAt();

        String str = null;
        String s = Matcher.quoteReplacement(str);

        StringBuffer stringBuffer = null;
        String replacement = null;
        StringBuilder stringBuilder = null;
        Matcher matcher4 = instance.appendReplacement(stringBuffer, replacement);
        Matcher matcher1 = instance.appendReplacement(stringBuilder, replacement);

        StringBuffer stringBuffer1 = instance.appendTail(stringBuffer);
        StringBuilder stringBuilder1 = instance.appendTail(stringBuilder);

        Function<MatchResult, String> replacer = null;
        String s2 = instance.replaceAll(replacement);
        String s1 = instance.replaceAll(replacer);

        Stream<MatchResult> results = instance.results();

        String s3 = instance.replaceFirst(replacement);
        String s4 = instance.replaceFirst(replacer);

        Matcher region = instance.region(start, end);

        int i1 = instance.regionStart();
        int i2 = instance.regionEnd();

        boolean b3 = instance.hasTransparentBounds();
        boolean bound = false;
        Matcher matcher2 = instance.useTransparentBounds(bound);

        boolean b4 = instance.hasAnchoringBounds();
        Matcher matcher3 = instance.useAnchoringBounds(bound);

        String s5 = instance.toString();

        boolean b5 = instance.hitEnd();
        boolean b6 = instance.requireEnd();

    }
}
