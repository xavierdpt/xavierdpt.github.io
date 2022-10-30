package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.AllMethodsCovered;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@AllMethodsCovered
public class AppendableExample extends BaseExample<Appendable> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(Appendable instance) throws Throwable {

        {
            char ch = 0;
            Appendable same = instance.append(ch);
            seeExamples(this::appendCharExample);
        }

        {
            CharSequence charSequence = any();
            Appendable same = instance.append(charSequence);
            seeExamples(this::appendCharSequenceExample);
        }

        {
            CharSequence charSequence = any();
            int start = 0;
            int end = 0;
            Appendable same = instance.append(charSequence, start, end);
            seeExamples(this::appendCharSequenceStartEndExample);
        }
    }

    @Test
    public void appendCharExample() throws IOException {

        StringWriter stringWriter = new StringWriter();

        Appendable appendable = stringWriter;

        Appendable same = appendable.append('h').append('e').append('l').append('l').append('o');

        assertSame(same, appendable);
        assertEquals("hello", stringWriter.toString());
    }

    @Test
    public void appendCharSequenceExample() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Appendable appendable = stringBuilder;

        CharSequence hello = "hello";
        Appendable same = appendable.append(hello);

        assertSame(same,appendable);
        assertEquals("hello",stringBuilder.toString());
    }

    @Test
    public void appendCharSequenceStartEndExample() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Appendable appendable = stringBuilder;

        CharSequence hello = "hello";
        int start = 1;
        int end = 3;
        Appendable same = appendable.append(hello, start, end);

        assertSame(same,appendable);
        assertEquals("el",stringBuilder.toString());
    }

}
