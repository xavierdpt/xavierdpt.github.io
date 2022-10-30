package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.CacheResponse;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

@ToBeContinued
public class ResponseCacheExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            ResponseCache instance = ExampleUtils.makeInstance(ResponseCache.class);

            URI uri = null;
            URLConnection connection = null;

            ResponseCache responseCache = ResponseCache.getDefault();
            ResponseCache.setDefault(responseCache);
            String requestMethod = null;
            Map<String, List<String>> requestHeaders = null;
            CacheResponse cacheResponse = instance.get(uri, requestMethod, requestHeaders);

            instance.put(uri, connection);
        }
    }

    @Test
    public void example() throws IOException, URISyntaxException {
        // no default
        ResponseCache instance = ResponseCache.getDefault();
        Assert.assertNull(instance);
    }


}
