package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyClass;
import net.xdexamples.Scaffolded;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Scaffolded
public class OptionalExample extends BaseExample<Optional<Dummy>> {

    @Override
    public void scaffold(Optional<Dummy> instance) throws Throwable {

        Optional<Dummy> empty = Optional.empty();

        Optional<Dummy> other = null;
        boolean equals = instance.equals(other);

        Predicate<Dummy> predicate = null;
        Optional<Dummy> dummy = instance.filter(predicate);

        Function<Dummy, Optional<DummyClass>> function = null;
        Optional<DummyClass> dummyClass = instance.flatMap(function);

        Dummy dummy1 = instance.get();

        int i = instance.hashCode();

        Consumer<Dummy> action = null;
        instance.ifPresent(action);

        Runnable emptyAction = null;
        instance.ifPresentOrElse(action, emptyAction);

        boolean empty1 = instance.isEmpty();

        boolean present = instance.isPresent();

        Function<Dummy, DummyClass> mfunction = null;
        Optional<DummyClass> dummyClass1 = instance.map(mfunction);

        Dummy dummyValue = null;
        Optional<Dummy> dummyValue1 = Optional.of(dummyValue);

        Optional<Dummy> dummyValue2 = Optional.ofNullable(dummyValue);

        Supplier<Optional<Dummy>> supplier = null;
        Optional<Dummy> or = instance.or(supplier);

        Dummy dummy2 = instance.orElse(dummyValue);

        Supplier<Dummy> supplierr = null;
        Dummy dummy3 = instance.orElseGet(supplierr);

        Dummy dummy4 = instance.orElseThrow();

        Supplier<Throwable> exsupplier = null;
        Dummy dummy5 = instance.orElseThrow(exsupplier);

        Stream<Dummy> stream = instance.stream();

        String s = instance.toString();
    }
}
