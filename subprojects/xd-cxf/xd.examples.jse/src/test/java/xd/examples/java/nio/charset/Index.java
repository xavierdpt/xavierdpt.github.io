package xd.examples.java.nio.charset;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderMalfunctionError;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnmappableCharacterException;
import java.nio.charset.UnsupportedCharsetException;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    CharacterCodingException.class,
                    Charset.class,
                    CharsetDecoder.class,
                    CharsetEncoder.class,
                    CoderMalfunctionError.class,
                    CoderResult.class,
                    CodingErrorAction.class,
                    IllegalCharsetNameException.class,
                    MalformedInputException.class,
                    StandardCharsets.class,
                    UnmappableCharacterException.class,
                    UnsupportedCharsetException.class
            ));
        }
    }


}
