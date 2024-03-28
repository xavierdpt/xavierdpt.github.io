package com.github.xavierdpt.xddbg.discovery2;

import java.lang.reflect.Proxy;

public class VerboseProxy {

    public static <T> T createVerboseProxy(Class<T> clazz, ClassLoader classLoader) {
        return (T) Proxy.newProxyInstance(classLoader, new Class<?>[]{clazz}, (proxy, method, args1) -> {
            System.out.println(method.getName());
            return null;
        });
    }

}
