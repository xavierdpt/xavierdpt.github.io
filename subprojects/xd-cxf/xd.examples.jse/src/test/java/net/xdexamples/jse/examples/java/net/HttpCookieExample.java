package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

@ToBeContinued
public class HttpCookieExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            HttpCookie instance = ExampleUtils.makeInstance(HttpCookie.class);
            String name = null;
            String value = null;
            HttpCookie httpCookie = new HttpCookie(name, value);

            String header = null;
            List<HttpCookie> parse = HttpCookie.parse(header);
            boolean b = instance.hasExpired();
            String purpose = null;
            instance.setComment(purpose);
            String comment = instance.getComment();
            instance.setCommentURL(purpose);
            String commentURL = instance.getCommentURL();
            boolean discard = false;
            instance.setDiscard(discard);
            boolean discard1 = instance.getDiscard();
            String ports = null;
            instance.setPortlist(ports);
            String portlist = instance.getPortlist();
            String pattern = null;
            instance.setDomain(pattern);
            String domain = instance.getDomain();
            long expiry = 0;
            instance.setMaxAge(expiry);
            long maxAge = instance.getMaxAge();
            String uri = null;
            instance.setPath(uri);
            String path = instance.getPath();
            boolean flag = false;
            instance.setSecure(flag);
            boolean secure = instance.getSecure();
            String name1 = instance.getName();
            String value1 = instance.getValue();
            int version = 0;
            instance.setVersion(version);
            boolean httpOnly = instance.isHttpOnly();
            instance.setHttpOnly(httpOnly);
            String host = null;
            boolean b1 = HttpCookie.domainMatches(".local", "example");
            String s = instance.toString();
            Object clone = instance.clone();
        }
    }




}


