package xd.examples.java.io;

import xd.examples.java.rmi.NamingExample;
import xdtest.ExampleIndex;

import javax.imageio.IIOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.CharConversionException;
import java.io.Closeable;
import java.io.Console;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.Externalizable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.FilterReader;
import java.io.FilterWriter;
import java.io.Flushable;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.LineNumberReader;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamConstants;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.io.Serial;
import java.io.Serializable;
import java.io.SerializablePermission;
import java.io.StreamCorruptedException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UncheckedIOException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.io.Writer;

@ExampleIndex({

        BufferedInputStream.class,
        BufferedInputStreamExample.class,

        BufferedOutputStream.class,
        BufferedOutputStreamExample.class,

        BufferedReader.class,
        BufferedReaderExample.class,

        BufferedWriter.class,
        BufferedWriterExample.class,

        ByteArrayInputStream.class,
        ByteArrayInputStreamExample.class,

        ByteArrayOutputStream.class,
        ByteArrayOutputStreamExample.class,

        CharArrayReader.class,
        CharArrayReaderExample.class,

        CharArrayWriter.class,
        CharArrayWriterExample.class,

        CharConversionException.class,

        Closeable.class,
        CloseableExample.class,

        Console.class,
        ConsoleExample.class,

        DataInput.class,
        DataInputExample.class,

        DataInputStream.class,
        DataInputStreamExample.class,

        DataOutput.class,
        DataOutputExample.class,

        DataOutputStream.class,
        DataOutputStreamExample.class,

        EOFException.class,

        Externalizable.class,
        ExternalizableExample.class,

        File.class,
        FileExample.class,

        FileDescriptor.class,
        FileDescriptorExample.class,

        FileFilter.class,
        FileFilterExample.class,

        FileInputStream.class,
        FileInputStreamExample.class,

        FilenameFilter.class,
        FilenameFilterExample.class,

        FileNotFoundException.class,

        FileOutputStream.class,
        FileOutputStreamExample.class,

        FilePermission.class,
        FilePermissionExample.class,

        FileReader.class,
        FileReaderExample.class,

        FilterInputStream.class,
        FilterInputStreamExample.class,

        FilterOutputStream.class,
        FilterOutputStreamExample.class,

        FilterReader.class,
        FilterReaderExample.class,

        FilterWriter.class,
        FilterWriterExample.class,

        Flushable.class,
        FlushableExample.class,

        InputStream.class,
        InputStreamExample.class,

        InputStreamReader.class,
        InputStreamReaderExample.class,

        InterruptedIOException.class,

        InvalidClassException.class,

        InvalidObjectException.class,

        IOError.class,

        IOException.class,

        LineNumberReader.class,
        LineNumberReaderExample.class,

        NotActiveException.class,

        NotSerializableException.class,

        ObjectInput.class,
        ObjectInputExample.class,

        ObjectInputFilter.class,
        ObjectInputFilterExample.class,

        ObjectInputStream.class,
        ObjectInputStreamExample.class,

        ObjectInputValidation.class,
        ObjectInputValidationExample.class,

        ObjectOutput.class,
        ObjectOutputExample.class,

        ObjectOutputStream.class,
        ObjectOutputStreamExample.class,

        ObjectStreamClass.class,
        ObjectStreamClassExample.class,

        ObjectStreamConstants.class,
        ObjectStreamConstantsExample.class,

        ObjectStreamException.class,

        ObjectStreamField.class,
        ObjectStreamFieldExample.class,

        OutputStream.class,
        OutputStreamExample.class,

        OutputStreamWriter.class,
        OutputStreamWriterExample.class,

        PipedInputStream.class,
        PipedInputStreamExample.class,

        PipedOutputStream.class,
        PipedOutputStreamExample.class,

        PipedReader.class,
        PipedReaderExample.class,

        PipedWriter.class,
        PipedWriterExample.class,

        PrintStream.class,
        PrintStreamExample.class,

        PrintWriter.class,
        PrintWriterExample.class,

        PushbackInputStream.class,
        PushbackInputStreamExample.class,

        PushbackReader.class,
        PushbackReaderExample.class,

        RandomAccessFile.class,
        RandomAccessFileExample.class,

        Reader.class,
        ReaderExample.class,

        SequenceInputStream.class,
        SequenceInputStreamExample.class,

        Serial.class,
        SerialExample.class,

        Serializable.class,
        SerializableExample.class,

        SerializablePermission.class,
        SerializablePermissionExample.class,

        StreamCorruptedException.class,

        StreamTokenizer.class,
        StreamTokenizerExample.class,

        StringReader.class,
        StringReaderExample.class,

        StringWriter.class,
        StringWriterExample.class,

        SyncFailedException.class,

        UncheckedIOException.class,

        UnsupportedEncodingException.class,

        UTFDataFormatException.class,

        WriteAbortedException.class,

        Writer.class,
        WriterExample.class,
})
public class Index {
}
