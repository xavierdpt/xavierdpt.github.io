package net.xdexamples.jse.index.java.net;

import net.xdexamples.support.ExampleIndex;
import net.xdexamples.jse.examples.java.net.AuthenticatorExample;
import net.xdexamples.jse.examples.java.net.CacheRequestExample;
import net.xdexamples.jse.examples.java.net.CacheResponseExample;
import net.xdexamples.jse.examples.java.net.ContentHandlerExample;
import net.xdexamples.jse.examples.java.net.ContentHandlerFactoryExample;
import net.xdexamples.jse.examples.java.net.CookieHandlerExample;
import net.xdexamples.jse.examples.java.net.CookieManagerExample;
import net.xdexamples.jse.examples.java.net.CookiePolicyExample;
import net.xdexamples.jse.examples.java.net.CookieStoreExample;
import net.xdexamples.jse.examples.java.net.DatagramPacketExample;
import net.xdexamples.jse.examples.java.net.DatagramSocketExample;
import net.xdexamples.jse.examples.java.net.DatagramSocketImplExample;
import net.xdexamples.jse.examples.java.net.DatagramSocketImplFactoryExample;
import net.xdexamples.jse.examples.java.net.FileNameMapExample;
import net.xdexamples.jse.examples.java.net.HttpCookieExample;
import net.xdexamples.jse.examples.java.net.HttpURLConnectionExample;
import net.xdexamples.jse.examples.java.net.IDNExample;
import net.xdexamples.jse.examples.java.net.Inet4AddressExample;
import net.xdexamples.jse.examples.java.net.Inet6AddressExample;
import net.xdexamples.jse.examples.java.net.InetAddressExample;
import net.xdexamples.jse.examples.java.net.InetSocketAddressExample;
import net.xdexamples.jse.examples.java.net.InterfaceAddressExample;
import net.xdexamples.jse.examples.java.net.JarURLConnectionExample;
import net.xdexamples.jse.examples.java.net.MulticastSocketExample;
import net.xdexamples.jse.examples.java.net.NetPermissionExample;
import net.xdexamples.jse.examples.java.net.NetworkInterfaceExample;
import net.xdexamples.jse.examples.java.net.PasswordAuthenticationExample;
import net.xdexamples.jse.examples.java.net.ProtocolFamilyExample;
import net.xdexamples.jse.examples.java.net.ProxyExample;
import net.xdexamples.jse.examples.java.net.ProxySelectorExample;
import net.xdexamples.jse.examples.java.net.ResponseCacheExample;
import net.xdexamples.jse.examples.java.net.SecureCacheResponseExample;
import net.xdexamples.jse.examples.java.net.ServerSocketExample;
import net.xdexamples.jse.examples.java.net.SocketAddressExample;
import net.xdexamples.jse.examples.java.net.SocketExample;
import net.xdexamples.jse.examples.java.net.SocketImplExample;
import net.xdexamples.jse.examples.java.net.SocketImplFactoryExample;
import net.xdexamples.jse.examples.java.net.SocketOptionExample;
import net.xdexamples.jse.examples.java.net.SocketOptionsExample;
import net.xdexamples.jse.examples.java.net.SocketPermissionExample;
import net.xdexamples.jse.examples.java.net.StandardProtocolFamilyExample;
import net.xdexamples.jse.examples.java.net.StandardSocketOptionsExample;
import net.xdexamples.jse.examples.java.net.URIExample;
import net.xdexamples.jse.examples.java.net.URLClassLoaderExample;
import net.xdexamples.jse.examples.java.net.URLConnectionExample;
import net.xdexamples.jse.examples.java.net.URLDecoderExample;
import net.xdexamples.jse.examples.java.net.URLEncoderExample;
import net.xdexamples.jse.examples.java.net.URLExample;
import net.xdexamples.jse.examples.java.net.URLPermissionExample;
import net.xdexamples.jse.examples.java.net.URLStreamHandlerExample;
import net.xdexamples.jse.examples.java.net.URLStreamHandlerFactoryExample;
import net.xdexamples.jse.examples.java.net.UnixDomainSocketAddressExample;

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

@ExampleIndex({


        Authenticator.class,
        AuthenticatorExample.class,

        BindException.class,

        CacheRequest.class,
        CacheRequestExample.class,

        CacheResponse.class,
        CacheResponseExample.class,

        ConnectException.class,

        ContentHandler.class,
        ContentHandlerExample.class,

        ContentHandlerFactory.class,
        ContentHandlerFactoryExample.class,

        CookieHandler.class,
        CookieHandlerExample.class,

        CookieManager.class,
        CookieManagerExample.class,

        CookiePolicy.class,
        CookiePolicyExample.class,

        CookieStore.class,
        CookieStoreExample.class,

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
        NetPermissionExample.class,

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
        SocketPermissionExample.class,

        SocketTimeoutException.class,

        StandardProtocolFamily.class,
        StandardProtocolFamilyExample.class,

        StandardSocketOptions.class,
        StandardSocketOptionsExample.class,

        UnixDomainSocketAddress.class,
        UnixDomainSocketAddressExample.class,

        UnknownHostException.class,

        UnknownServiceException.class,

        URI.class,
        URIExample.class,

        URISyntaxException.class,

        URL.class,
        URLExample.class,

        URLClassLoader.class,
        URLClassLoaderExample.class,

        URLConnection.class,
        URLConnectionExample.class,

        URLDecoder.class,
        URLDecoderExample.class,

        URLEncoder.class,
        URLEncoderExample.class,

        URLPermission.class,
        URLPermissionExample.class,

        URLStreamHandler.class,
        URLStreamHandlerExample.class,

        URLStreamHandlerFactory.class,
        URLStreamHandlerFactoryExample.class

})
public class Index {

}
