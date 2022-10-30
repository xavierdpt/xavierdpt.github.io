package net.xdexamples.jse.examples.java.util.stream;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.ExampleUtils;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyClass;
import xd.helpers.dummies.DummyInterface;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@Scaffolded
public class StreamExample extends BaseExample<Stream<Dummy>> {
    @Override
    public void scaffold(Stream<Dummy> instance) {


        Predicate<Dummy> predicate__ = null;
        Collector<Dummy, DummyClass, DummyInterface> collector = null;
        Supplier<Dummy> supplier = null;
        BiConsumer<Dummy, Dummy> accumulator = null;
        BiConsumer<Dummy, Dummy> combiner = null;
        Stream<Dummy> stream1__ = null;
        Stream<Dummy> stream2__ = null;
        Function<Dummy, Stream<DummyClass>> mapper = null;
        Function<Dummy, DoubleStream> mapperd = null;
        Function<Dummy, IntStream> mapperi = null;
        Function<Dummy, LongStream> mapperl = null;
        Consumer<Dummy> consumer__ = null;
        Dummy seed = null;
        UnaryOperator<Dummy> function = null;
        long maxSize = 0;
        Function<Dummy, DummyClass> mapperr = null;
        BiConsumer<Dummy, Consumer<DummyClass>> biconsumer = null;
        BiConsumer<Dummy, DoubleConsumer> aaa = null;
        BiConsumer<Dummy, IntConsumer> bbb = null;
        BiConsumer<Dummy, LongConsumer> ccc = null;
        ToDoubleFunction<Dummy> ddd = null;
        ToIntFunction<Dummy> eee = null;
        ToLongFunction<? super Dummy> fff = null;
        Comparator<Dummy> comparator__ = null;
        Dummy value_ = null;
        Dummy ggg = null;
        BinaryOperator<Dummy> hhh = null;
        Dummy iii = null;
        BiFunction<Dummy, Dummy, Dummy> jjj = null;
        BinaryOperator<Dummy> kkk = null;
        long n = 0;

        {
            Predicate<Dummy> predicate = null;
            boolean result = instance.allMatch(predicate);
            seeExamples(this::allMatchExample);
            ignore(result);
        }

        {
            Predicate<Dummy> predicate = null;
            boolean result = instance.anyMatch(predicate);
            seeExamples(this::anyMatchExample);
            ignore(result);
        }

        Stream.Builder<Dummy> builder = Stream.builder();
        DummyInterface collect = instance.collect(collector);
        Dummy collect1 = instance.collect(supplier, accumulator, combiner);
        {
            Stream<Dummy> stream1 = null;
            Stream<Dummy> stream2 = null;
            Stream<Dummy> concat = Stream.concat(stream1, stream2);
            seeExamples(this::concatExample);
            ignore(concat);
        }
        long count = instance.count();
        Stream<Dummy> distinct = instance.distinct();
        Stream<Dummy> dummyStream = instance.dropWhile(predicate__);
        {
            Stream<Dummy> stream = Stream.empty();
            seeExamples(this::emptyExample);
            ignore(stream);
        }
        {
            Predicate<Dummy> predicate = null;
            Stream<Dummy> stream = instance.filter(predicate);
            seeExamples(this::filterExample);
            ignore(stream);
        }
        {
            Optional<Dummy> result = instance.findAny();
            seeExamples(
                    this::findAnyPrincipleExample,
                    this::findAnyNondeterministicExample
            );
            ignore(result);
        }
        {
            Optional<Dummy> result = instance.findFirst();
            seeExamples(
                    this::findFirstPrincipleExample,
                    this::findFirstNondeterministicExample
            );
            ignore(result);
        }
        {
            Stream<DummyClass> stream = instance.flatMap(mapper);
            seeExamples(this::flatMapExample);
            ignore(stream);
        }
        {
            DoubleStream doubleStream = instance.flatMapToDouble(mapperd);
        }
        {
            IntStream intStream = instance.flatMapToInt(mapperi);
        }
        {
            LongStream longStream = instance.flatMapToLong(mapperl);
        }
        {
            Consumer<Dummy> consumer = null;
            instance.forEach(consumer);
            seeExamples(this::forEachExample);
        }
        {
            Consumer<Dummy> consumer = null;
            instance.forEachOrdered(consumer);
            seeExamples(this::forEachOrderedExample);

        }
        {
            Stream<Dummy> generate = Stream.generate(supplier);
        }
        Stream<Dummy> iterate = Stream.iterate(seed, function);
        Stream<Dummy> iterate1 = Stream.iterate(seed, predicate__, function);
        {
            Stream<Dummy> limit = instance.limit(maxSize);
        }
        Stream<DummyClass> dummyClassStream1 = instance.map(mapperr);
        Stream<DummyClass> dummyClassStream2 = instance.mapMulti(biconsumer);
        instance.mapMultiToDouble(aaa);
        IntStream intStream1 = instance.mapMultiToInt(bbb);
        LongStream longStream1 = instance.mapMultiToLong(ccc);
        DoubleStream doubleStream1 = instance.mapToDouble(ddd);
        IntStream intStream2 = instance.mapToInt(eee);
        LongStream longStream2 = instance.mapToLong(fff);

        {
            Comparator<Dummy> comparator = null;
            Optional<Dummy> max = instance.max(comparator);
            seeExamples(this::maxExample);
            ignore(max);
        }

        {
            Comparator<Dummy> comparator = comparator__;
            Optional<Dummy> min = instance.min(comparator);
            seeExamples(this::minExample);
            ignore(min);
        }

        {
            Predicate<Dummy> predicate = null;
            boolean result = instance.noneMatch(predicate);
            seeExamples(this::noneMatchExample);
            ignore(result);
        }

        {
            Dummy value = null;
            Stream<Dummy> stream = Stream.of(value, value, value);
            seeExamples(
                    this::maxExample,
                    this::minExample,
                    this::noneMatchExample
            );
            ignore(stream);
        }

        {
            Dummy value = null;
            Stream<Dummy> stream = Stream.ofNullable(value);
            seeExamples(this::ofNullableExample);
            ignore(stream);
        }

        Stream<Dummy> peek = instance.peek(consumer__);
        Dummy reduce = instance.reduce(ggg, hhh);
        Optional<Dummy> reduce1 = instance.reduce(hhh);
        Dummy reduce2 = instance.reduce(iii, jjj, kkk);
        Stream<Dummy> skip = instance.skip(n);
        Stream<Dummy> sorted = instance.sorted();
        Stream<Dummy> sorted1 = instance.sorted(comparator__);
        Stream<Dummy> dummyStream2 = instance.takeWhile(predicate__);

        {
            Object[] array = instance.toArray();
            seeExamples(this::toArrayExample);
            ignore(array);
        }

        {
            Dummy[] array = instance.toArray(Dummy[]::new);
            seeExamples(this::toArrayWithGeneratorExample);
            ignore(array);

        }

        {
            List<Dummy> list = instance.toList();
            seeExamples(this::toListExample);
            ignore(list);
        }

    }

    @Test
    public void maxExample() {
        Optional<Integer> max = Stream.of(1, 2, 3).max(Integer::compare);
        assertEquals(3, (int) max.get());

    }

    @Test
    public void minExample() {
        Optional<Integer> max = Stream.of(1, 2, 3).min(Integer::compare);
        assertEquals(1, (int) max.get());
    }

    @Test
    public void noneMatchExample() {
        assertTrue(Stream.of(1, 2, 3).noneMatch(x -> x == 0));
        assertFalse(Stream.of(1, 2, 3).noneMatch(x -> x == 1));
    }

    @Test
    public void ofNullableExample() {

        Stream<String> ofNonNull = Stream.ofNullable("a");
        assertArrayEquals(new String[]{"a"}, ofNonNull.toArray());

        Stream<String> ofNull = Stream.ofNullable(null);
        assertArrayEquals(new String[0], ofNull.toArray());

    }

    @Test
    public void toArrayExample() {
        Stream<String> stream = Stream.of("hello", "world");
        Object[] result = stream.toArray();
        assertArrayEquals(new String[]{"hello", "world"}, result);
    }

    @Test
    public void toArrayWithGeneratorExample() {
        Stream<String> stream = Stream.of("hello", "world");
        String[] result = stream.toArray(String[]::new);
        assertArrayEquals(new String[]{"hello", "world"}, result);
    }

    @Test
    public void toListExample() {
        Stream<String> stream = Stream.of("hello", "world");
        List<String> result = stream.toList();
        assertArrayEquals(new String[]{"hello", "world"}, result.toArray());
        Assert.assertThrows(UnsupportedOperationException.class,
                () -> result.add("!"));
    }

    @Test
    public void allMatchExample() {

        Stream<String> stream1 = Stream.of("hello", "wonderful", "world");
        assertFalse(stream1.allMatch(x -> x.length() == 5));

        Stream<String> stream2 = Stream.of("hello", "wonderful", "world");
        assertTrue(stream2.allMatch(x -> x.length() > 0));

        Stream<String> stream3 = Stream.of();
        assertTrue(stream3.allMatch(x -> false));

    }

    @Test
    public void anyMatchExample() {

        Stream<String> stream1 = Stream.of("hello", "wonderful", "world");
        assertTrue(stream1.anyMatch(x -> x.length() == 5));

        Stream<String> stream2 = Stream.of("hello", "wonderful", "world");
        assertFalse(stream2.anyMatch(x -> x.length() == 0));

        Random random = new Random(System.currentTimeMillis());
        Stream<String> stream3 = Stream.of();
        assertFalse(stream3.anyMatch(x -> random.nextBoolean()));

    }

    @Test
    public void concatExample() {
        String[] array = new String[]{"hello", "wonderful", "world"};
        Stream<String> stream1 = Stream.of(array);
        Stream<String> stream2 = Stream.of(array).map(String::length).map(Object::toString);
        Stream<String> stream = Stream.concat(stream1, stream2);
        String[] result = stream.toArray(String[]::new);
        assertArrayEquals(new String[]{"hello", "wonderful", "world", "5", "9", "5"}, result);
    }

    @Test
    public void emptyExample() {
        Stream<String> empty = Stream.empty();
        assertArrayEquals(new String[]{}, empty.toArray());
    }

    @Test
    public void filterExample() {
        Stream<String> stream = Stream.of("hello", "wonderful", "world")
                .filter(x -> x.length() == 5);
        assertArrayEquals(new String[]{"hello", "world"}, stream.toArray());
    }

    @Test
    public void findAnyPrincipleExample() {
        Stream<String> stream = Stream.of("hello", "wonderful", "world");
        Optional<String> result = stream.findAny();
        assertTrue(result.isPresent());
    }

    @Test
    public void findAnyNondeterministicExample() {
        // TODO: find an example where the same call can generate different results
        fail("TODO");
    }

    @Test
    public void findFirstPrincipleExample() {
        Stream<String> stream = Stream.of("hello", "wonderful", "world");
        Optional<String> result = stream.findFirst();
        assertEquals("hello", result.get());
    }

    @Test
    public void findFirstNondeterministicExample() {
        // TODO: same as indAnyNondeterministicExample, should return the first element
        fail("TODO");
    }

    @Test
    public void flatMapExample() {
        Function<String, Stream<String>> flatMapper = s -> Arrays.stream(s.split(""));
        Stream<String> stream = Stream.of("hello", "world").flatMap(flatMapper);
        assertArrayEquals(new String[]{"h", "e", "l", "l", "o", "w", "o", "r", "l", "d"}, stream.toArray());
    }

    @Test
    public void forEachExample() {
        Stream.of("hello", "world").forEach(Assert::assertNotNull);
    }

    @Test
    public void forEachOrderedExample() {
        // TODO: find an example where order matters *and* forEach would actually execute in an unpredictable order
        Stream.of("hello", "world").forEachOrdered(Assert::assertNotNull);
    }

    @Test
    public void generateSkipAndLimitExample() {
        Supplier<Integer> supplier = new Supplier<>() {
            private int i;

            @Override
            public Integer get() {
                return ++i;
            }
        };
        Stream<Integer> stream = Stream.generate(supplier).skip(5).limit(5);
        assertArrayEquals(new Integer[]{6, 7, 8, 9, 10}, stream.toArray());
    }

    @Test
    public void collatzTakeWhileExample() {
        Supplier<Long> collatz = new Collatz(3L);
        Stream<Long> stream = Stream.generate(collatz).takeWhile(x -> x != 1L);
        assertArrayEquals(new Long[]{3L, 10L, 5L, 16L, 8L, 4L, 2L}, stream.toArray());
    }

    @Test
    public void collatzFindAnyExample() {
        Random random = new Random(System.currentTimeMillis());
        Supplier<Long> collatz = new Collatz(random.nextInt(1, Integer.MAX_VALUE) + 1); // [2 ; Integer.MAX_VALUE]
        assertTrue(Stream.generate(collatz).anyMatch(x -> x == 1L));
    }

    @Test
    public void collatzAllIntegers() {
        if (ExampleUtils.skip()) {
            // very long, uncomment to run
            // TODO: optimized version with LongStream and LongSupplier
            long longest = 0L;
            for (int start = 2; start < Integer.MAX_VALUE; start++) {
                Supplier<Long> collatz = new Collatz(start);
                long count = Stream.generate(collatz).takeWhile(x -> x != 1L).count();
                if (count > longest) {
                    longest = count;
                    System.out.println("Start: " + start + "; length: " + longest);
                }
            }
        }
    }

    private class Collatz implements Supplier<Long> {

        private long value;

        public Collatz(long start) {
            this.value = start;
        }

        @Override
        public Long get() {
            long previous = value;
            if (value % 2 == 0) {
                value /= 2;
            } else {
                value = Math.multiplyExact(value, 3L);
                value = Math.addExact(value, 1L);
            }
            return previous;
        }
    }

}
