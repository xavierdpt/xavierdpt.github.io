package xd.examples.java.nio.file.attribute;

import xd.BaseExample;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class FileTimeExample extends BaseExample<FileTime> {

    @Override
    public void scaffold(FileTime instance) {

        Instant instant = null;
        long value = 0;
        TimeUnit unit = null;
        FileTime from = FileTime.from(instant);
        FileTime from1 = FileTime.from(value, unit);

        FileTime fileTime = FileTime.fromMillis(value);

        long to = instance.to(unit);
        long l = instance.toMillis();
        Instant instant1 = instance.toInstant();

        FileTime other = null;
        instance.equals(other);
        int i = instance.hashCode();
        int i1 = instance.compareTo(other);
        String s = instance.toString();
    }

}
