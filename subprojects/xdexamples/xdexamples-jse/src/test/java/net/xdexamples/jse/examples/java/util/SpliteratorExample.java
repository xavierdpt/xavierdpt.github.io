package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpliteratorExample extends BaseExample<Spliterator<Dummy>> {
    @Override
    public void scaffold(Spliterator<Dummy> instance) {


        {
            // TODO
            int characteristics = instance.characteristics();
        }
        {
            // TODO
            long l = instance.estimateSize();
        }
        {
            // TODO
            Consumer<Dummy> consumer = null;
            instance.forEachRemaining(consumer);
        }
        {
            // TODO
            Comparator<? super Dummy> comparator = instance.getComparator();
        }
        {
            // TODO
            long exactSizeIfKnown = instance.getExactSizeIfKnown();
        }
        {
            int characteristics = 0;
            boolean hasCharacteristics = instance.hasCharacteristics(characteristics);
            seeExamples(
                    this::orderedExample,
                    this::distinctExample,
                    this::sortedExample,
                    this::sizedExample,
                    this::immutableExample,
                    this::concurrentExample,
                    this::subsizedExample
            );
            ignore(hasCharacteristics);
        }
        {
            // TODO
            Consumer<Dummy> consumer = null;
            boolean b1 = instance.tryAdvance(consumer);
        }
        {
            // TODO
            Spliterator<Dummy> dummySpliterator = instance.trySplit();
        }

        {
            int ordered = Spliterator.ORDERED;
            seeExamples(this::orderedExample);
            ignore(ordered);
        }
        {
            int distinct = Spliterator.DISTINCT;
            seeExamples(this::distinctExample);
            ignore(distinct);
        }
        {
            int sorted = Spliterator.SORTED;
            seeExamples(this::sortedExample);
            ignore(sorted);
        }
        {
            int sized = Spliterator.SIZED;
            seeExamples(this::sizedExample);
            ignore(sized);
        }
        {
            // TODO: find an example of collection that has this characteristic
            int nonnull = Spliterator.NONNULL;
            ignore(nonnull);
        }
        {
            int immutable = Spliterator.IMMUTABLE;
            seeExamples(this::immutableExample);
            ignore(immutable);
        }
        {
            int concurrent = Spliterator.CONCURRENT;
            seeExamples(this::concurrentExample);
            ignore(concurrent);
        }
        {
            int subsized = Spliterator.SUBSIZED;
            seeExamples(this::subsizedExample);
            ignore(subsized);
        }
    }

    @Test
    public void orderedExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Collection<Dummy> c2 = new HashSet<>();

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = c2.spliterator();

        assertTrue(sp1.hasCharacteristics(Spliterator.ORDERED));
        assertFalse(sp2.hasCharacteristics(Spliterator.ORDERED));
    }

    @Test
    public void distinctExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Collection<Dummy> c2 = new HashSet<>();

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = c2.spliterator();

        assertFalse(sp1.hasCharacteristics(Spliterator.DISTINCT));
        assertTrue(sp2.hasCharacteristics(Spliterator.DISTINCT));
    }

    @Test
    public void sortedExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Collection<Dummy> c2 = new TreeSet<>();

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = c2.spliterator();

        assertFalse(sp1.hasCharacteristics(Spliterator.SORTED));
        assertTrue(sp2.hasCharacteristics(Spliterator.SORTED));
    }

    @Test
    public void sizedExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Stream<Dummy> s1 = Stream.generate(Dummy::new);

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = s1.spliterator();

        assertTrue(sp1.hasCharacteristics(Spliterator.SIZED));
        assertFalse(sp2.hasCharacteristics(Spliterator.SIZED));
    }

    @Test
    public void immutableExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Stream<Dummy> s1 = Stream.generate(Dummy::new);

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = s1.spliterator();

        assertFalse(sp1.hasCharacteristics(Spliterator.IMMUTABLE));
        assertTrue(sp2.hasCharacteristics(Spliterator.IMMUTABLE));
    }

    @Test
    public void concurrentExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Collection<Dummy> c2 = new ConcurrentLinkedQueue<>();

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = c2.spliterator();

        assertFalse(sp1.hasCharacteristics(Spliterator.CONCURRENT));
        assertTrue(sp2.hasCharacteristics(Spliterator.CONCURRENT));
    }

    @Test
    public void subsizedExample() {

        Collection<Dummy> c1 = new ArrayList<>();
        Collection<Dummy> c2 = new HashSet<>();

        Spliterator<Dummy> sp1 = c1.spliterator();
        Spliterator<Dummy> sp2 = c2.spliterator();

        assertTrue(sp1.hasCharacteristics(Spliterator.SUBSIZED));
        assertFalse(sp2.hasCharacteristics(Spliterator.SUBSIZED));
    }

}
