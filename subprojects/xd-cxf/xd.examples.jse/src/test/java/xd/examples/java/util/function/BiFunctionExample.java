package xd.examples.java.util.function;

import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.Dummy1;
import xd.helpers.dummies.Dummy2;
import xd.helpers.dummies.Dummy3;
import xd.helpers.dummies.Dummy4;
import xdtest.Done;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@Done
public class BiFunctionExample extends BaseExample<BiFunction<Dummy1, Dummy2, Dummy3>> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(BiFunction<Dummy1, Dummy2, Dummy3> instance) throws Throwable {
        {
            Dummy1 a = any();
            Dummy2 b = any();
            Dummy3 result = instance.apply(a, b);
            seeExamples(
                    this::example,
                    this::exampleLambda,
                    this::exampleMethodReference
            );
        }
        {
            Function<Dummy3, Dummy4> other = any();
            BiFunction<Dummy1, Dummy2, Dummy4> function = instance.andThen(other);
            seeExamples(this::andThenExample);
        }
    }


    @Test
    @SuppressWarnings({"Convert2Lambda", "Anonymous2MethodRef"})
    public void example() {
        BiFunction<String, Integer, Map.Entry<String, Integer>> biFunction = new BiFunction<>() {
            @Override
            public Map.Entry<String, Integer> apply(String a, Integer b) {
                return Map.entry(a, b);
            }
        };
        Map.Entry<String, Integer> result = biFunction.apply("hello", 5);
        assertEquals("hello", result.getKey());
        assertEquals(5, result.getValue().intValue());
    }

    @Test
    @SuppressWarnings("Convert2MethodRef")
    public void exampleLambda() {
        BiFunction<String, Integer, Map.Entry<String, Integer>> biFunction = (a, b) -> Map.entry(a, b);
        Map.Entry<String, Integer> result = biFunction.apply("hello", 5);
        assertEquals("hello", result.getKey());
        assertEquals(5, result.getValue().intValue());
    }

    @Test
    public void exampleMethodReference() {
        BiFunction<String, Integer, Map.Entry<String, Integer>> biFunction = Map::entry;
        Map.Entry<String, Integer> result = biFunction.apply("hello", 5);
        assertEquals("hello", result.getKey());
        assertEquals(5, result.getValue().intValue());
    }

    @Test
    public void andThenExample() {
        BiFunction<String, Integer, Map.Entry<String, Integer>> biFunction = Map::entry;
        Function<Map.Entry<String, Integer>, Map.Entry<Integer, String>> exchange = k -> Map.entry(k.getValue(), k.getKey());
        BiFunction<String, Integer, Map.Entry<Integer, String>> composed = biFunction.andThen(exchange);
        Map.Entry<Integer, String> result = composed.apply("hello", 5);
        assertEquals("hello", result.getValue());
        assertEquals(5, result.getKey().intValue());
    }
}
