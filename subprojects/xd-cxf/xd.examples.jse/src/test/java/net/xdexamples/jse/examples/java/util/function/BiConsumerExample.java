package net.xdexamples.jse.examples.java.util.function;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy1;
import xd.helpers.dummies.Dummy2;
import xdtest.ToBeContinued;

import java.io.StringWriter;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

@ToBeContinued
public class BiConsumerExample extends BaseExample<BiConsumer<Dummy1, Dummy2>> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(BiConsumer<Dummy1, Dummy2> instance) throws Throwable {
        {
            Dummy1 value1 = any();
            Dummy2 value2 = any();
            instance.accept(value1, value2);
            seeExamples(
                    this::example,
                    this::exampleLambda
            );
        }
        {
            BiConsumer<Dummy1, Dummy2> other = any();
            BiConsumer<Dummy1, Dummy2> result = instance.andThen(other);
            seeExamples(
                    this::andThenExample,
                    this::andThenWithReduceExample
            );
        }
    }


    @Test
    @SuppressWarnings("Convert2Lambda")
    public void example() {
        StringWriter sw = new StringWriter();
        BiConsumer<String, Integer> biConsumer = new BiConsumer<>() {
            @Override
            public void accept(String value1, Integer value2) {
                sw.append(value1);
                sw.append(String.valueOf(value2));
            }
        };
        biConsumer.accept("hello", 5);
        Assert.assertEquals("hello5", sw.toString());
    }

    @Test
    public void exampleLambda() {
        StringWriter sw = new StringWriter();
        BiConsumer<String, Integer> biConsumer = (value1, value2) -> {
            sw.append(value1);
            sw.append(String.valueOf(value2));
        };
        biConsumer.accept("hello", 5);
        Assert.assertEquals("hello5", sw.toString());
    }

    @Test
    public void andThenExample() {
        StringWriter sw = new StringWriter();
        BiConsumer<String, Integer> biConsumer1 = (value12, value22) -> {
            sw.append(value12);
            sw.append(String.valueOf(value22));
        };
        BiConsumer<String, Integer> biConsumer2 = (value1, value2) -> {
            sw.append(".");
        };
        BiConsumer<String, Integer> biConsumer3 = (value11, value21) -> {
            sw.append(String.valueOf(value21));
            sw.append(value11);
        };
        biConsumer1.andThen(biConsumer2).andThen(biConsumer3).accept("hello", 5);
        Assert.assertEquals("hello5.5hello", sw.toString());
    }

    @Test
    public void andThenWithReduceExample() {
        StringWriter sw = new StringWriter();
        BiConsumer<String, Integer> biConsumer = Stream.<BiConsumer<String, Integer>>of(
                (a, b) -> {
                    sw.append(a);
                    sw.append(String.valueOf(b));
                },
                (a1, b1) -> {
                    sw.append(".");
                },
                (a2, b2) -> {
                    sw.append(String.valueOf(b2));
                    sw.append(a2);
                }
        ).reduce(BiConsumer::andThen).get();
        biConsumer.accept("hello", 5);
        Assert.assertEquals("hello5.5hello", sw.toString());
    }
}
