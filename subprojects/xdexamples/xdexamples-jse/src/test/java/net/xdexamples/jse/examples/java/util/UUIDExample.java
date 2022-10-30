package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.util.UUID;

@Scaffolded
public class UUIDExample extends BaseExample<UUID> {
    @Override
    public void scaffold(UUID instance) {
        long msBits = 0;
        long lsBits = 0;
        ignore(
                new UUID(msBits, lsBits)
        );

        UUID uuid = UUID.randomUUID();

        byte[] bytes = new byte[0];
        UUID uuid1 = UUID.nameUUIDFromBytes(bytes);

        String name = null;
        UUID uuid2 = UUID.fromString(name);

        long leastSignificantBits = instance.getLeastSignificantBits();
        long mostSignificantBits = instance.getMostSignificantBits();
        int version = instance.version();
        int variant = instance.variant();
        long timestamp = instance.timestamp();
        int i = instance.clockSequence();
        long node = instance.node();
        String s = instance.toString();
        int i1 = instance.hashCode();
        UUID other = null;
        boolean equals = instance.equals(other);
        int i2 = instance.compareTo(other);
    }
}
