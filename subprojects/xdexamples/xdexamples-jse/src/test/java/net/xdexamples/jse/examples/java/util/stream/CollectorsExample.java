package net.xdexamples.jse.examples.java.util.stream;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.Dummy1;
import xd.helpers.dummies.Dummy2;
import xd.helpers.dummies.Dummy3;
import xd.helpers.dummies.Dummy4;
import xd.helpers.dummies.Dummy5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CollectorsExample extends BaseExample<Collectors> {

    @Override
    public void scaffold(Collectors instance) throws Throwable {

        CharSequence delimiter = null;
        CharSequence prefix = null;
        CharSequence suffix = null;

        Dummy1 identity = null;
        Comparator<Dummy> comparator = null;

        Function<Dummy1, Dummy2> keyMapperOrClassifier = null;
        Function<Dummy1, Dummy3> valueMapper__ = null;
        Function<Dummy2, Dummy1> reducingMapper = null;
        Function<Dummy3, Dummy4> d3To4 = null;

        Function<Dummy1, Stream<Dummy2>> flatMapper = null;

        BiFunction<Dummy3, Dummy5, ?> biFunction = null;

        BinaryOperator<Dummy1> reducingOperation = null;
        BinaryOperator<Dummy3> mergeFunction__ = null;

        Predicate<Dummy1> predicate = null;

        ToDoubleFunction<Dummy> toDouble = null;
        ToIntFunction<Dummy> toInt = null;
        ToLongFunction<Dummy> toLong = null;

        Supplier<Collection<Dummy>> collectionFactory = null;
        Supplier<Map<Dummy2, Dummy3>> mapFactory = null;
        Supplier<Map<Dummy2, Dummy4>> mapSupplier = null;
        Supplier<ConcurrentMap<Dummy2, Dummy4>> concurrentMapFactory24 = null;
        Supplier<ConcurrentMap<Dummy2, Dummy3>> concurrentMapFactory23 = null;

        Collector<Dummy1, Dummy3, Dummy4> downstream134 = null;
        Collector<Dummy2, Dummy3, Dummy4> downstream234 = null;
        Collector<Dummy1, Dummy2, Dummy3> downstream123 = null;
        Collector<Dummy1, Dummy4, Dummy5> downstream145 = null;

        {
            Collector<Dummy, ?, Long> collector = Collectors.counting();
            seeExamples(this::countingExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, List<Dummy>> collector = Collectors.toList();
            seeExamples(
                    this::toListExample,
                    this::mappingExample
            );
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Set<Dummy>> toSet = Collectors.toSet();
            seeExamples(
                    this::toSetExample,
                    this::groupingByWithDownstreamExample,
                    this::groupingByWithDownstreamAndMapFactoryExample
            );
            ignore(toSet);
        }

        {
            Collector<Object, ?, List<Object>> collector = Collectors.toUnmodifiableList();
            seeExamples(this::toUnmodifiableListExample);
            ignore(collector);
        }

        {
            Collector<Object, ?, Set<Object>> collector = Collectors.toUnmodifiableSet();
            seeExamples(this::toUnmodifiableSetExample);
            ignore(collector);
        }

        {
            Function<Dummy1, Dummy2> keyMapper = null;
            Function<Dummy1, Dummy3> valueMapper_ = null;
            Collector<Dummy1, ?, Map<Dummy2, Dummy3>> collector = Collectors.toMap(keyMapper, valueMapper_);
            seeExamples(
                    this::toMapExample,
                    this::toMapDuplicate
            );
            ignore(collector);
        }

        {
            Function<Dummy1, Dummy2> keyMapper = null;
            Function<Dummy1, Dummy3> valueMapper_ = null;
            BinaryOperator<Dummy3> mergeFunction_ = null;
            Collector<Dummy1, ?, Map<Dummy2, Dummy3>> collector = Collectors.toMap(keyMapper, valueMapper_, mergeFunction_);
            seeExamples(this::toMapWithMergeExample);
            ignore(collector);
        }

        {
            Function<Dummy1, Dummy2> keyMapper = keyMapperOrClassifier;
            Function<Dummy1, Dummy3> valueMapper_ = valueMapper__;
            BinaryOperator<Dummy3> mergeFunction_ = mergeFunction__;
            Supplier<Map<Dummy2, Dummy3>> mapFactory_ = mapFactory;
            Collector<Dummy1, ?, Map<Dummy2, Dummy3>> toMap2 = Collectors.toMap(keyMapper, valueMapper_, mergeFunction_, mapFactory_);
            seeExamples(this::toMapWithMergeAndConstructorExample);
            ignore(toMap2);
        }

        {
            Function<Dummy1, Dummy2> keyMapper = null;
            Function<Dummy1, Dummy3> valueMapper = null;
            Collector<Dummy1, ?, Map<Dummy2, Dummy3>> collector = Collectors.toUnmodifiableMap(keyMapper, valueMapper);
            seeExamples(this::toUnmodifiableMapExample);
            ignore(collector);
        }

        {
            Function<Dummy1, Dummy2> keyMapper = null;
            Function<Dummy1, Dummy3> valueMapper = null;
            BinaryOperator<Dummy3> mergeFunction = null;
            Collector<Dummy1, ?, Map<Dummy2, Dummy3>> collector = Collectors.toUnmodifiableMap(keyMapper, valueMapper, mergeFunction);
            seeExamples(this::toUnmodifiableMapWithMergeExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, Dummy3>> collector = Collectors.toConcurrentMap(keyMapperOrClassifier, valueMapper__);
            seeExamples(this::toConcurrentMapExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, Dummy3>> collector = Collectors.toConcurrentMap(keyMapperOrClassifier, valueMapper__, mergeFunction__);
            seeExamples(this::toConcurrentMapWithMergeExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, Dummy3>> collector = Collectors.toConcurrentMap(keyMapperOrClassifier, valueMapper__, mergeFunction__, concurrentMapFactory23);
            seeExamples(this::toConcurrentMapWithMergeAndConstructorExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, DoubleSummaryStatistics> collector = Collectors.summarizingDouble(toDouble);
            seeExamples(this::summarizingDoubleExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(toInt);
            seeExamples(this::summarizingIntExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, LongSummaryStatistics> collector = Collectors.summarizingLong(toLong);
            seeExamples(this::summarizingLongExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Double> collector = Collectors.summingDouble(toDouble);
            seeExamples(this::summarizingDoubleExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Integer> collector = Collectors.summingInt(toInt);
            seeExamples(this::summingDoubleExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Long> collector = Collectors.summingLong(toLong);
            seeExamples(this::summingLongExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Double> averagingDouble = Collectors.averagingDouble(toDouble);
            seeExamples(this::averagingDoubleExample);
            ignore(averagingDouble);
        }

        {
            Collector<Dummy, ?, Double> averagingInt = Collectors.averagingInt(toInt);
            seeExamples(this::averagingIntExample);
            ignore(averagingInt);
        }

        {
            Collector<Dummy, ?, Double> averagingLong = Collectors.averagingLong(toLong);
            seeExamples(this::averagingLongExample);
            ignore(averagingLong);
        }

        {
            Collector<Dummy, ?, Optional<Dummy>> collector = Collectors.maxBy(comparator);
            seeExamples(this::maxByExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Optional<Dummy>> collector = Collectors.minBy(comparator);
            seeExamples(this::minByExample);
            ignore(collector);
        }

        {
            Collector<CharSequence, ?, String> collector = Collectors.joining();
            seeExamples(this::joiningExample);
            ignore(collector);
        }

        {
            Collector<CharSequence, ?, String> collector = Collectors.joining(delimiter);
            seeExamples(this::joining1Example);
            ignore(collector);
        }

        {
            Collector<CharSequence, ?, String> collector = Collectors.joining(delimiter, prefix, suffix);
            seeExamples(this::joining2Example);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Optional<Dummy1>> collector = Collectors.reducing(reducingOperation);
            seeExamples(this::reducingExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Dummy1> collector = Collectors.reducing(identity, reducingOperation);
            seeExamples(this::reducingWithIdentityExample);
            ignore(collector);
        }

        {
            Collector<Dummy2, ?, Dummy1> collector = Collectors.reducing(identity, reducingMapper, reducingOperation);
            seeExamples(this::reducingWithMapperExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Dummy4> collector = Collectors.mapping(keyMapperOrClassifier, downstream234);
            seeExamples(this::mappingExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Dummy3> collector = Collectors.filtering(predicate, downstream123);
            seeExamples(this::filteringExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Map<Dummy2, List<Dummy1>>> collector = Collectors.groupingBy(keyMapperOrClassifier);
            seeExamples(this::groupingByExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Map<Dummy2, Dummy4>> collector = Collectors.groupingBy(keyMapperOrClassifier, downstream134);
            seeExamples(this::groupingByWithDownstreamExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Map<Dummy2, Dummy4>> collector = Collectors.groupingBy(keyMapperOrClassifier, mapSupplier, downstream134);
            seeExamples(this::groupingByWithDownstreamAndMapFactoryExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, List<Dummy1>>> collector = Collectors.groupingByConcurrent(keyMapperOrClassifier);
            seeExamples(this::groupingByConcurrentExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, Dummy4>> collector = Collectors.groupingByConcurrent(keyMapperOrClassifier, downstream134);
            seeExamples(this::groupingByConcurrentWithDownstreamExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ConcurrentMap<Dummy2, Dummy4>> collector = Collectors.groupingByConcurrent(keyMapperOrClassifier, concurrentMapFactory24, downstream134);
            seeExamples(this::groupingByConcurrentWithDownstreamAndMapFactoryExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Map<Boolean, List<Dummy1>>> collector = Collectors.partitioningBy(predicate);
            seeExamples(this::partitionByExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Map<Boolean, Dummy3>> collector = Collectors.partitioningBy(predicate, downstream123);
            seeExamples(this::partitionByWithDownstreamExample);
            ignore(collector);
        }

        {
            Collector<Dummy, ?, Collection<Dummy>> collector = Collectors.toCollection(collectionFactory);
            seeExamples(this::toCollectionExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, Dummy2, Dummy4> collector = Collectors.collectingAndThen(downstream123, d3To4);
            seeExamples(this::andThenExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, ?> collector = Collectors.teeing(downstream123, downstream145, biFunction);
            seeExamples(this::teeingExample);
            ignore(collector);
        }

        {
            Collector<Dummy1, ?, Dummy4> collector = Collectors.flatMapping(flatMapper, downstream234);
            seeExamples(this::flatMappingExample);
            ignore(collector);
        }
    }

    @Test
    public void countingExample() {
        Collector<Integer, ?, Long> collector = Collectors.counting();
        Long result = Stream.of(1, 2, 3).collect(collector);
        assertEquals(3L, result.longValue());
    }

    @Test
    public void toListExample() {
        Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
        List<Integer> result = Stream.of(1, 2, 3).collect(collector);
        assertArrayEquals(new Integer[]{1, 2, 3}, result.toArray());
        assertTrue(result instanceof ArrayList);
    }

    @Test
    public void toSetExample() {
        Collector<Integer, ?, Set<Integer>> collector = Collectors.toSet();
        Set<Integer> result = Stream.of(1, 2, 3).collect(collector);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result instanceof HashSet);
    }

    @Test
    public void toUnmodifiableListExample() {
        Collector<Integer, ?, List<Integer>> collector = Collectors.toUnmodifiableList();
        List<Integer> result = Stream.of(1, 2, 3).collect(collector);
        assertArrayEquals(new Integer[]{1, 2, 3}, result.toArray());
        assertThrows(UnsupportedOperationException.class, () -> result.add(4));
    }

    @Test
    public void toUnmodifiableSetExample() {
        Collector<Integer, ?, Set<Integer>> collector = Collectors.toUnmodifiableSet();
        Set<Integer> result = Stream.of(1, 2, 3).collect(collector);
        assertEquals(3, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertThrows(UnsupportedOperationException.class, () -> result.add(4));
    }

    @Test
    public void toMapExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, String> valueMapper = y -> "Value" + y;
        Collector<Integer, ?, Map<String, String>> collector = Collectors.toMap(keyMapper, valueMapper);
        Map<String, String> result = Stream.of(1, 2, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals("Value1", result.get("Key1"));
        assertEquals("Value2", result.get("Key2"));
        assertEquals("Value3", result.get("Key3"));
        assertTrue(result instanceof HashMap);
    }

    @Test(expected = IllegalStateException.class)
    public void toMapDuplicate() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, String> valueMapper = y -> "Value" + y;
        Collector<Integer, ?, Map<String, String>> collector = Collectors.toMap(keyMapper, valueMapper);
        Map<String, String> result = Stream.of(1, 2, 3, 3).collect(collector);
    }

    @Test
    public void toMapWithMergeExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, Integer> valueMapper = y -> 1;
        BinaryOperator<Integer> mergeFunction = Integer::sum;
        Collector<Integer, ?, Map<String, Integer>> collector = Collectors.toMap(keyMapper, valueMapper, mergeFunction);
        Map<String, Integer> result = Stream.of(1, 2, 3, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals(1, result.get("Key1").intValue());
        assertEquals(1, result.get("Key2").intValue());
        assertEquals(2, result.get("Key3").intValue());
        assertTrue(result instanceof HashMap);
    }

    @Test
    public void toMapWithMergeAndConstructorExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, Integer> valueMapper = y -> 1;
        BinaryOperator<Integer> mergeFunction = Integer::sum;
        Supplier<Map<String, Integer>> mapFactory = TreeMap::new;
        Collector<Integer, ?, Map<String, Integer>> collector = Collectors.toMap(keyMapper, valueMapper, mergeFunction, mapFactory);
        Map<String, Integer> result = Stream.of(1, 2, 3, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals(1, result.get("Key1").intValue());
        assertEquals(1, result.get("Key2").intValue());
        assertEquals(2, result.get("Key3").intValue());
        assertTrue(result instanceof TreeMap);
    }

    @Test
    public void toUnmodifiableMapExample() {
        Function<Integer, String> keyMapper = String::valueOf;
        Function<Integer, String> valueMapper = String::valueOf;
        Collector<Integer, ?, Map<String, String>> collector = Collectors.toUnmodifiableMap(keyMapper, valueMapper);
        Map<String, String> result = Stream.of(1, 2, 3).collect(collector);
        assertThrows(UnsupportedOperationException.class,
                () -> result.put("KeyX", "ValueX"));
    }

    @Test
    public void toUnmodifiableMapWithMergeExample() {
        Function<Integer, String> keyMapper = String::valueOf;
        Function<Integer, Integer> valueMapper = y -> 1;
        BinaryOperator<Integer> mergeFunction = Integer::sum;
        Collector<Integer, ?, Map<String, Integer>> collector = Collectors.toUnmodifiableMap(keyMapper, valueMapper, mergeFunction);
        Map<String, Integer> result = Stream.of(1, 2, 3, 3).collect(collector);
        assertThrows(UnsupportedOperationException.class,
                () -> result.put("KeyX", 1));
    }

    @Test
    public void toConcurrentMapExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, String> valueMapper = y -> "Value" + y;
        Collector<Integer, ?, ConcurrentMap<String, String>> collector = Collectors.toConcurrentMap(keyMapper, valueMapper);
        ConcurrentMap<String, String> result = Stream.of(1, 2, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals("Value1", result.get("Key1"));
        assertEquals("Value2", result.get("Key2"));
        assertEquals("Value3", result.get("Key3"));
        assertTrue(result instanceof ConcurrentHashMap);
    }

    @Test
    public void toConcurrentMapWithMergeExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, Integer> valueMapper = y -> 1;
        BinaryOperator<Integer> mergeFunction = Integer::sum;
        Collector<Integer, ?, ConcurrentMap<String, Integer>> collector = Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction);
        ConcurrentMap<String, Integer> result = Stream.of(1, 2, 3, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals(1, result.get("Key1").intValue());
        assertEquals(1, result.get("Key2").intValue());
        assertEquals(2, result.get("Key3").intValue());
        assertTrue(result instanceof ConcurrentHashMap);
    }

    @Test
    public void toConcurrentMapWithMergeAndConstructorExample() {
        Function<Integer, String> keyMapper = x -> "Key" + x;
        Function<Integer, Integer> valueMapper = y -> 1;
        BinaryOperator<Integer> mergeFunction = Integer::sum;
        Supplier<ConcurrentMap<String, Integer>> mapFactory = ConcurrentSkipListMap::new;
        Collector<Integer, ?, ConcurrentMap<String, Integer>> collector = Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction, mapFactory);
        ConcurrentMap<String, Integer> result = Stream.of(1, 2, 3, 3).collect(collector);
        assertEquals(3, result.size());
        assertEquals(1, result.get("Key1").intValue());
        assertEquals(1, result.get("Key2").intValue());
        assertEquals(2, result.get("Key3").intValue());
        assertTrue(result instanceof ConcurrentSkipListMap);
    }

    @Test
    public void summarizingIntExample() {
        ToIntFunction<String> mapper = String::length;
        Collector<String, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(mapper);
        IntSummaryStatistics result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19, result.getSum());
    }

    @Test
    public void summarizingLongExample() {
        ToLongFunction<String> mapper = String::length;
        Collector<String, ?, LongSummaryStatistics> collector = Collectors.summarizingLong(mapper);
        LongSummaryStatistics result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19L, result.getSum());
    }

    @Test
    public void summarizingDoubleExample() {
        ToDoubleFunction<String> mapper = String::length;
        Collector<String, ?, DoubleSummaryStatistics> collector = Collectors.summarizingDouble(mapper);
        DoubleSummaryStatistics result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19D, result.getSum(), 0D);
    }

    @Test
    public void summingIntExample() {
        ToIntFunction<String> mapper = String::length;
        Collector<String, ?, Integer> collector = Collectors.summingInt(mapper);
        Integer result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19, result.intValue());
    }

    @Test
    public void summingLongExample() {
        ToLongFunction<String> mapper = String::length;
        Collector<String, ?, Long> collector = Collectors.summingLong(mapper);
        Long result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19L, result.longValue());
    }

    @Test
    public void summingDoubleExample() {
        ToDoubleFunction<String> mapper = String::length;
        Collector<String, ?, Double> collector = Collectors.summingDouble(mapper);
        Double result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19D, result, 0D);
    }

    @Test
    public void averagingIntExample() {
        ToIntFunction<String> mapper = String::length;
        Collector<String, ?, Double> collector = Collectors.averagingInt(mapper);
        Double result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(6.33D, result, 0.01D);
    }

    @Test
    public void averagingLongExample() {
        ToLongFunction<String> mapper = String::length;
        Collector<String, ?, Double> collector = Collectors.averagingLong(mapper);
        Double result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(6.33D, result, 0.01D);
    }

    @Test
    public void averagingDoubleExample() {
        ToDoubleFunction<String> mapper = String::length;
        Collector<String, ?, Double> collector = Collectors.averagingDouble(mapper);
        Double result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(6.33D, result, 0.01D);
    }

    @Test
    public void maxByExample() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Collector<String, ?, Optional<String>> collector = Collectors.maxBy(comparator);
        Optional<String> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("wonderful", result.get());
    }

    @Test
    public void minByExample() {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        Collector<String, ?, Optional<String>> collector = Collectors.minBy(comparator);
        Optional<String> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("hello", result.get());
    }

    @Test
    public void joiningExample() {
        Collector<CharSequence, ?, String> collector = Collectors.joining();
        String result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("hellowonderfulworld", result);
    }

    @Test
    public void joining1Example() {
        Collector<CharSequence, ?, String> collector = Collectors.joining(",");
        String result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("hello,wonderful,world", result);
    }

    @Test
    public void joining2Example() {
        Collector<CharSequence, ?, String> collector = Collectors.joining(",", "[", "]");
        String result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("[hello,wonderful,world]", result);
    }

    @Test
    public void reducingExample() {
        BinaryOperator<String> op = (x, y) -> x + y;
        Collector<String, ?, Optional<String>> collector = Collectors.reducing(op);
        Optional<String> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("hellowonderfulworld", result.get());
    }

    @Test
    public void reducingEmptyExample() {
        BinaryOperator<String> op = (x, y) -> x + y;
        Collector<String, ?, Optional<String>> collector = Collectors.reducing(op);
        Optional<String> result = Stream.<String>of().collect(collector);
        assertTrue(result.isEmpty());
    }

    @Test
    public void reducingWithIdentityExample() {
        String identity = "";
        BinaryOperator<String> op = (x, y) -> x + y;
        Collector<String, ?, String> collector = Collectors.reducing(identity, op);
        String result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals("hellowonderfulworld", result);
    }

    @Test
    public void reducingWithIdentityEmptyExample() {
        String identity = "";
        BinaryOperator<String> op = (x, y) -> x + y;
        Collector<String, ?, String> collector = Collectors.reducing(identity, op);
        String result = Stream.<String>of().collect(collector);
        assertEquals("", result);
    }

    @Test
    public void reducingWithMapperExample() {
        Integer identity = 0;
        Function<String, Integer> mapper = String::length;
        BinaryOperator<Integer> op = Integer::sum;
        Collector<String, ?, Integer> collector = Collectors.reducing(identity, mapper, op);
        Integer result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(19, result.intValue());
    }

    @Test
    public void mappingExample() {
        Function<String, Integer> mapper = String::length;
        Collector<Integer, ?, List<Integer>> downstream = Collectors.toList();
        Collector<String, ?, List<Integer>> collector = Collectors.mapping(mapper, downstream);
        List<Integer> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertArrayEquals(new Integer[]{5, 9, 5}, result.toArray());
    }

    @Test
    public void filteringExample() {
        Predicate<String> predicate = x -> x.length() == 5;
        Collector<String, ?, List<String>> downstream = Collectors.toList();
        Collector<String, ?, List<String>> collector = Collectors.filtering(predicate, downstream);
        List<String> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertArrayEquals(new String[]{"hello", "world"}, result.toArray());
    }

    @Test
    public void groupingByExample() {
        Function<String, Integer> classifier = String::length;
        Collector<String, ?, Map<Integer, List<String>>> collector = Collectors.groupingBy(classifier);
        Map<Integer, List<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertArrayEquals(new String[]{"hello", "world"}, result.get(5).toArray());
        assertArrayEquals(new String[]{"wonderful"}, result.get(9).toArray());
        assertTrue(result instanceof HashMap);
    }

    @Test
    public void groupingByWithDownstreamExample() {
        Function<String, Integer> classifier = String::length;
        Collector<String, ?, Set<String>> downstream = Collectors.toSet();
        Collector<String, ?, Map<Integer, Set<String>>> collector = Collectors.groupingBy(classifier, downstream);
        Map<Integer, Set<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertEquals(2, result.get(5).size());
        assertEquals(1, result.get(9).size());
        assertTrue(result.get(5).contains("hello"));
        assertTrue(result.get(5).contains("world"));
        assertTrue(result.get(9).contains("wonderful"));
    }

    @Test
    public void groupingByWithDownstreamAndMapFactoryExample() {
        Function<String, Integer> classifier = String::length;
        Supplier<TreeMap<Integer, Set<String>>> mapFactory = TreeMap::new;
        Collector<String, ?, Set<String>> downstream = Collectors.toSet();
        Collector<String, ?, TreeMap<Integer, Set<String>>> collector = Collectors.groupingBy(classifier, mapFactory, downstream);
        TreeMap<Integer, Set<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertEquals(2, result.get(5).size());
        assertEquals(1, result.get(9).size());
        assertTrue(result.get(5).contains("hello"));
        assertTrue(result.get(5).contains("world"));
        assertTrue(result.get(9).contains("wonderful"));
    }

    @Test
    public void groupingByConcurrentExample() {
        Function<String, Integer> classifier = String::length;
        Collector<String, ?, ConcurrentMap<Integer, List<String>>> collector = Collectors.groupingByConcurrent(classifier);
        ConcurrentMap<Integer, List<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertArrayEquals(new String[]{"hello", "world"}, result.get(5).toArray());
        assertArrayEquals(new String[]{"wonderful"}, result.get(9).toArray());
        assertTrue(result instanceof ConcurrentHashMap);
    }

    @Test
    public void groupingByConcurrentWithDownstreamExample() {
        Function<String, Integer> classifier = String::length;
        Collector<String, ?, Set<String>> downstream = Collectors.toSet();
        Collector<String, ?, ConcurrentMap<Integer, Set<String>>> collector = Collectors.groupingByConcurrent(classifier, downstream);
        ConcurrentMap<Integer, Set<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertEquals(2, result.get(5).size());
        assertEquals(1, result.get(9).size());
        assertTrue(result.get(5).contains("hello"));
        assertTrue(result.get(5).contains("world"));
        assertTrue(result.get(9).contains("wonderful"));
    }

    @Test
    public void groupingByConcurrentWithDownstreamAndMapFactoryExample() {
        Function<String, Integer> classifier = String::length;
        Supplier<ConcurrentMap<Integer, Set<String>>> mapFactory = ConcurrentSkipListMap::new;
        Collector<String, ?, Set<String>> downstream = Collectors.toSet();
        Collector<String, ?, ConcurrentMap<Integer, Set<String>>> collector = Collectors.groupingByConcurrent(classifier, mapFactory, downstream);
        ConcurrentMap<Integer, Set<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.size());
        assertEquals(2, result.get(5).size());
        assertEquals(1, result.get(9).size());
        assertTrue(result.get(5).contains("hello"));
        assertTrue(result.get(5).contains("world"));
        assertTrue(result.get(9).contains("wonderful"));
        assertTrue(result instanceof ConcurrentSkipListMap);
    }

    @Test
    public void partitionByExample() {
        Predicate<String> predicate = x -> x.length() == 5;
        Collector<String, ?, Map<Boolean, List<String>>> collector = Collectors.partitioningBy(predicate);
        Map<Boolean, List<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertArrayEquals(new String[]{"hello", "world"}, result.get(true).toArray());
        assertArrayEquals(new String[]{"wonderful"}, result.get(false).toArray());
    }

    @Test
    public void partitionByWithDownstreamExample() {
        Predicate<String> predicate = x -> x.length() == 5;
        Collector<String, ?, Set<String>> downstream = Collectors.toSet();
        Collector<String, ?, Map<Boolean, Set<String>>> collector = Collectors.partitioningBy(predicate, downstream);
        Map<Boolean, Set<String>> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(2, result.get(true).size());
        assertTrue(result.get(true).contains("hello"));
        assertTrue(result.get(true).contains("world"));
        assertTrue(result.get(false).contains("wonderful"));
    }

    @Test
    public void toCollectionExample() {
        Supplier<Collection<String>> collectionFactory = PriorityQueue::new;
        Collector<String, ?, Collection<String>> collector = Collectors.toCollection(collectionFactory);
        Collection<String> result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertTrue(result instanceof PriorityQueue);
    }

    @Test
    public void andThenExample() {
        Function<List<String>, Integer> finisher = List::size;
        Collector<String, ?, List<String>> downstream = Collectors.toList();
        Collector<String, ?, Integer> collector = Collectors.collectingAndThen(downstream, finisher);
        Integer result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(3, result.intValue());
    }

    @Test
    public void teeingExample() {
        Collector<String, ?, List<String>> downstream1 = Collectors.toList();
        Collector<String, ?, Set<String>> downstream2 = Collectors.toSet();
        BiFunction<List<String>, Set<String>, Integer> merger = (x, y) -> x.size() + y.size();
        Collector<String, ?, Integer> collector = Collectors.teeing(downstream1, downstream2, merger);
        Integer result = Stream.of("hello", "wonderful", "world").collect(collector);
        assertEquals(6, result.intValue());
    }

    @Test
    public void flatMappingExample() {
        Function<String, Stream<? extends String>> mapper = x -> Arrays.stream(x.split(""));
        Collector<String, ?, List<String>> downstream = Collectors.toList();
        Collector<String, ?, List<String>> collector = Collectors.flatMapping(mapper, downstream);
        List<String> result = Stream.of("hello", "world").collect(collector);
        assertArrayEquals(new String[]{"h", "e", "l", "l", "o", "w", "o", "r", "l", "d"}, result.toArray());
    }

}
