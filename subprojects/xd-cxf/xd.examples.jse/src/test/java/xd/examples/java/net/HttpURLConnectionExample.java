package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.TestUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.security.Permission;

@ToBeContinued
public class HttpURLConnectionExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {

            int httpOk = HttpURLConnection.HTTP_OK;
            int httpCreated = HttpURLConnection.HTTP_CREATED;
            int httpAccepted = HttpURLConnection.HTTP_ACCEPTED;
            int httpNotAuthoritative = HttpURLConnection.HTTP_NOT_AUTHORITATIVE;
            int httpNoContent = HttpURLConnection.HTTP_NO_CONTENT;
            int httpReset = HttpURLConnection.HTTP_RESET;
            int httpPartial = HttpURLConnection.HTTP_PARTIAL;
            int httpMultChoice = HttpURLConnection.HTTP_MULT_CHOICE;
            int httpMovedPerm = HttpURLConnection.HTTP_MOVED_PERM;
            int httpMovedTemp = HttpURLConnection.HTTP_MOVED_TEMP;
            int httpSeeOther = HttpURLConnection.HTTP_SEE_OTHER;
            int httpNotModified = HttpURLConnection.HTTP_NOT_MODIFIED;
            int httpUseProxy = HttpURLConnection.HTTP_USE_PROXY;
            int httpBadRequest = HttpURLConnection.HTTP_BAD_REQUEST;
            int httpUnauthorized = HttpURLConnection.HTTP_UNAUTHORIZED;
            int httpPaymentRequired = HttpURLConnection.HTTP_PAYMENT_REQUIRED;
            int httpForbidden = HttpURLConnection.HTTP_FORBIDDEN;
            int httpNotFound = HttpURLConnection.HTTP_NOT_FOUND;
            int httpBadMethod = HttpURLConnection.HTTP_BAD_METHOD;
            int httpNotAcceptable = HttpURLConnection.HTTP_NOT_ACCEPTABLE;
            int httpProxyAuth = HttpURLConnection.HTTP_PROXY_AUTH;
            int httpClientTimeout = HttpURLConnection.HTTP_CLIENT_TIMEOUT;
            int httpConflict = HttpURLConnection.HTTP_CONFLICT;
            int httpGone = HttpURLConnection.HTTP_GONE;
            int httpLengthRequired = HttpURLConnection.HTTP_LENGTH_REQUIRED;
            int httpPreconFailed = HttpURLConnection.HTTP_PRECON_FAILED;
            int httpEntityTooLarge = HttpURLConnection.HTTP_ENTITY_TOO_LARGE;
            int httpReqTooLong = HttpURLConnection.HTTP_REQ_TOO_LONG;
            int httpUnsupportedType = HttpURLConnection.HTTP_UNSUPPORTED_TYPE;
            int httpInternalError = HttpURLConnection.HTTP_INTERNAL_ERROR;
            int httpNotImplemented = HttpURLConnection.HTTP_NOT_IMPLEMENTED;
            int httpBadGateway = HttpURLConnection.HTTP_BAD_GATEWAY;
            int httpUnavailable = HttpURLConnection.HTTP_UNAVAILABLE;
            int httpGatewayTimeout = HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
            int httpVersion = HttpURLConnection.HTTP_VERSION;

            HttpURLConnection instance = TestUtils.makeInstance(HttpURLConnection.class);

            Authenticator authenticator = null;
            instance.setAuthenticator(authenticator);
            int num = 0;
            String headerFieldKey = instance.getHeaderFieldKey(num);
            int anInt = 0;
            instance.setFixedLengthStreamingMode(anInt);
            long aLong = 0;
            instance.setFixedLengthStreamingMode(aLong);
            int chunklen = 0;
            instance.setChunkedStreamingMode(chunklen);
            String headerField = instance.getHeaderField(num);
            boolean followRedirects = false;
            HttpURLConnection.setFollowRedirects(followRedirects);
            boolean followRedirects1 = HttpURLConnection.getFollowRedirects();
            instance.setInstanceFollowRedirects(followRedirects);
            boolean instanceFollowRedirects = instance.getInstanceFollowRedirects();
            String method = null;
            instance.setRequestMethod(method);
            String requestMethod = instance.getRequestMethod();
            int responseCode = instance.getResponseCode();
            String responseMessage = instance.getResponseMessage();
            String name = null;
            long def = 0;
            long headerFieldDate = instance.getHeaderFieldDate(name, def);
            instance.disconnect();
            boolean b = instance.usingProxy();
            Permission permission = instance.getPermission();
            InputStream errorStream = instance.getErrorStream();
        }
    }
}
