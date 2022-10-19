package xd.examples.java.util;

import xd.BaseExample;

import java.util.Base64;

public class Base64Example extends BaseExample<Base64> {

    @Override
    public void scaffold(Base64 instance) {

        int lineLength = 0;
        byte[] lineSeparator = new byte[0];

        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        Base64.Encoder mimeEncoder1 = Base64.getMimeEncoder(lineLength, lineSeparator);

        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
    }
}
