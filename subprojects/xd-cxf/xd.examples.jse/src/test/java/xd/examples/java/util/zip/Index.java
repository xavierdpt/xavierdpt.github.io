package xd.examples.java.util.zip;

import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.CRC32C;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipError;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    Adler32.class,
                    CheckedInputStream.class,
                    CheckedOutputStream.class,
                    Checksum.class,
                    CRC32.class,
                    CRC32C.class,
                    DataFormatException.class,
                    Deflater.class,
                    DeflaterInputStream.class,
                    DeflaterOutputStream.class,
                    GZIPInputStream.class,
                    GZIPOutputStream.class,
                    Inflater.class,
                    InflaterInputStream.class,
                    InflaterOutputStream.class,
                    ZipEntry.class,
                    ZipError.class,
                    ZipException.class,
                    ZipFile.class,
                    ZipInputStream.class,
                    ZipOutputStream.class
            ));
        }
    }

}
