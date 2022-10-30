package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.AsynchronousByteChannel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

@Scaffolded
public class ChannelsExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Channels instance = ExampleUtils.makeInstance(Channels.class);

            ReadableByteChannel readableByteChannel = null;
            AsynchronousByteChannel asynchronousByteChannel = null;
            InputStream inputStream = Channels.newInputStream(readableByteChannel);
            InputStream inputStream1 = Channels.newInputStream(asynchronousByteChannel);

            WritableByteChannel writableByteChannel = null;
            OutputStream outputStream = Channels.newOutputStream(writableByteChannel);
            OutputStream outputStream1 = Channels.newOutputStream(asynchronousByteChannel);

            ReadableByteChannel readableByteChannel1 = Channels.newChannel(inputStream);
            WritableByteChannel writableByteChannel1 = Channels.newChannel(outputStream);

            String charsetName = null;
            Charset charset = null;
            CharsetDecoder charsetDecoder = null;
            int minBufferCap = 0;
            Reader reader = Channels.newReader(readableByteChannel, charsetDecoder, minBufferCap);
            Reader reader1 = Channels.newReader(readableByteChannel, charset);
            Reader reader2 = Channels.newReader(readableByteChannel, charsetName);

            CharsetEncoder charsetEncoder = null;
            Writer writer = Channels.newWriter(writableByteChannel, charsetEncoder, minBufferCap);
            Writer writer1 = Channels.newWriter(writableByteChannel, charset);
            Writer writer2 = Channels.newWriter(writableByteChannel, charsetName);

        }
    }
}
