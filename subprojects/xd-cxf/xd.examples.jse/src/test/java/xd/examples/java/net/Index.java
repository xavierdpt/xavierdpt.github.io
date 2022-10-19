package xd.examples.java.net;

import java.net.Authenticator;
import java.net.BindException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.ConnectException;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.DatagramSocketImplFactory;
import java.net.FileNameMap;
import java.net.HttpCookie;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.MulticastSocket;
import java.net.NetPermission;
import java.net.NetworkInterface;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.ProtocolFamily;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.SocketOption;
import java.net.SocketOptions;
import java.net.SocketPermission;
import java.net.SocketTimeoutException;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.URLPermission;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.net.UnixDomainSocketAddress;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(

                    Authenticator.class,
                    AuthenticatorExample.class,

                    BindException.class,

                    CacheRequest.class,

                    CacheResponse.class,

                    ConnectException.class,

                    ContentHandler.class,

                    ContentHandlerFactory.class,

                    CookieHandler.class,

                    CookieManager.class,

                    CookiePolicy.class,

                    CookieStore.class,

                    DatagramPacket.class,
                    DatagramPacketExample.class,

                    DatagramSocket.class,
                    DatagramSocketExample.class,

                    DatagramSocketImpl.class,
                    DatagramSocketImplExample.class,

                    DatagramSocketImplFactory.class,
                    DatagramSocketImplFactoryExample.class,

                    FileNameMap.class,
                    FileNameMapExample.class,

                    HttpCookie.class,
                    HttpCookieExample.class,

                    HttpRetryException.class,

                    HttpURLConnection.class,
                    HttpURLConnectionExample.class,

                    IDN.class,
                    IDNExample.class,

                    InetAddress.class,
                    InetAddressExample.class,

                    Inet4Address.class,
                    Inet4AddressExample.class,

                    Inet6Address.class,
                    Inet6AddressExample.class,

                    InetSocketAddress.class,
                    InetSocketAddressExample.class,

                    InterfaceAddress.class,
                    InterfaceAddressExample.class,

                    JarURLConnection.class,
                    JarURLConnectionExample.class,

                    MalformedURLException.class,

                    MulticastSocket.class,
                    MulticastSocketExample.class,

                    NetPermission.class,

                    NetworkInterface.class,
                    NetworkInterfaceExample.class,

                    NoRouteToHostException.class,

                    PasswordAuthentication.class,
                    PasswordAuthenticationExample.class,

                    PortUnreachableException.class,

                    ProtocolException.class,

                    ProtocolFamily.class,
                    ProtocolFamilyExample.class,

                    Proxy.class,
                    ProxyExample.class,

                    ProxySelector.class,
                    ProxySelectorExample.class,

                    ResponseCache.class,
                    ResponseCacheExample.class,

                    SecureCacheResponse.class,
                    SecureCacheResponseExample.class,

                    ServerSocket.class,
                    ServerSocketExample.class,

                    Socket.class,
                    SocketExample.class,


                    SocketAddress.class,
                    SocketAddressExample.class,

                    SocketException.class,

                    SocketImpl.class,
                    SocketImplExample.class,

                    SocketImplFactory.class,
                    SocketImplFactoryExample.class,

                    SocketOption.class,
                    SocketOptionExample.class,

                    SocketOptions.class,
                    SocketOptionsExample.class,

                    SocketPermission.class,

                    SocketTimeoutException.class,

                    StandardProtocolFamily.class,
                    StandardProtocolFamilyExample.class,

                    StandardSocketOptions.class,
                    StandardSocketOptionsExample.class,

                    UnixDomainSocketAddress.class,

                    UnknownHostException.class,

                    UnknownServiceException.class,

                    URI.class,

                    URISyntaxException.class,

                    URL.class,

                    URLClassLoader.class,

                    URLConnection.class,

                    URLDecoder.class,

                    URLEncoder.class,

                    URLPermission.class,

                    URLStreamHandler.class,

                    URLStreamHandlerFactory.class
            ));
        }
    }
}
