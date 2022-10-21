package net.xdexamples.jse.examples.java.util.function;

import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.Dummy1;
import net.xdexamples.Done;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@Done
public class BinaryOperatorExample extends BaseExample<BinaryOperator<Dummy>> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(BinaryOperator<Dummy> instance) throws Throwable {

        {
            Dummy value1 = any();
            Dummy value2 = any();
            Dummy result = instance.apply(value1, value2);
            seeExamples(
                    this::example,
                    this::exampleLambda
            );
        }

        {
            Function<Dummy, Dummy1> other = any();
            BiFunction<Dummy, Dummy, Dummy1> composed = instance.andThen(other);
            seeExamples(this::andThenExample);
        }

        {
            Comparator<Dummy> comparator = any();
            BinaryOperator<Dummy> binop = BinaryOperator.maxBy(comparator);
        }

        {
            Comparator<Dummy> comparator = any();
            BinaryOperator<Dummy> binop = BinaryOperator.minBy(comparator);
        }

    }

    @Test
    @SuppressWarnings({"Convert2Lambda"})
    public void example() {
        BinaryOperator<String> binop = new BinaryOperator<>() {
            @Override
            public String apply(String a, String b) {
                return b.toLowerCase() + a.toUpperCase();
            }
        };
        String result = binop.apply("Hello", "World");
        assertEquals("worldHELLO", result);
    }

    @Test
    public void exampleLambda() {
        BinaryOperator<String> binop = (a, b) -> b.toLowerCase() + a.toUpperCase();
        String result = binop.apply("Hello", "World");
        assertEquals("worldHELLO", result);
    }

    @Test
    public void andThenExample() {
        BinaryOperator<String> binop = (a, b) -> b.toLowerCase() + a.toUpperCase();
        Function<String, Integer> next = String::length;
        BiFunction<String, String, Integer> composed = binop.andThen(next);
        assertEquals(10, composed.apply("Hello", "World").intValue());
    }

    @Test
    public void maxByAndMinByExample() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        BinaryOperator<String> max = BinaryOperator.maxBy(comparator);
        BinaryOperator<String> min = BinaryOperator.minBy(comparator);

        String maxValue = max.apply("hello", "wonderful");
        assertEquals("wonderful", maxValue);

        String minValue = min.apply("hello", "wonderful");
        assertEquals("hello", minValue);
    }
}
