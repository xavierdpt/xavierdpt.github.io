package xdtest.java.security;

import org.junit.Test;
import xdtest.SeeAlso;
import xdtest.TestUtils;
import xdtools.java.security.ProviderDumper;


import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@SeeAlso({ProviderDumper.class})
public class ProviderTest {
    @Test
    public void test() throws IOException {
        if (TestUtils.scaffold()) {
            Provider instance = TestUtils.makeInstance(Provider.class);
            String configurationParameter = null;
            Provider provider = instance.configure(configurationParameter);
            String s = instance.toString();
            instance.clear();
            InputStream inputStream = null;
            instance.load(inputStream);
            Map<DummyKey, DummyValue> map = null;
            instance.putAll(map);
            Set<Map.Entry<Object, Object>> entries = instance.entrySet();
            Set<Object> objects = instance.keySet();
            Collection<Object> values = instance.values();
            Object key = null;
            Object value = null;
            Object put = instance.put(key, value);
            Object o = instance.putIfAbsent(key, value);
            Object remove1 = instance.remove(key);
            boolean remove = instance.remove(key, value);
            Object replace = instance.replace(key, value);
            Object oldValue = null;
            Object newValue = null;
            boolean replace1 = instance.replace(key, oldValue, newValue);
            BiFunction<? super Object, ? super Object, ?> replacer = null;
            instance.replaceAll(replacer);
            BiFunction<? super Object, ? super Object, ?> remapper = null;
            Object compute = instance.compute(key, remapper);
            Function<? super Object, ?> mapper = null;
            Object o1 = instance.computeIfAbsent(key, mapper);
            Object o2 = instance.computeIfPresent(key, remapper);
            BiFunction<? super Object, ? super Object, ?> merger = null;
            Object merge = instance.merge(key, value, merger);
            Object o3 = instance.get(key);
            Object defaultValue = null;
            Object orDefault = instance.getOrDefault(key, defaultValue);
            BiConsumer<? super Object, ? super Object> consumer = null;
            instance.forEach(consumer);
            Enumeration<Object> keys = instance.keys();
            Enumeration<Object> elements = instance.elements();
            String propertyName = null;
            instance.getProperty(propertyName);
            String type = null;
            String algorithm = null;
            instance.getService(type, algorithm);
            Set<Provider.Service> services = instance.getServices();
        }

    }

    @Test
    public void servicesTest() throws IOException, NoSuchAlgorithmException {
        if (TestUtils.scaffold()) {
            Provider provider = TestUtils.makeInstance(Provider.class);
            Provider.Service service = provider.getServices().iterator().next();
            String type = null;
            String algorithm = null;
            String className = null;
            List<String> aliases = null;
            Map<String, String> attributes = null;
            Provider.Service x = new Provider.Service(provider, type, algorithm, className, aliases, attributes);
            String type1 = service.getType();
            String algorithm1 = service.getAlgorithm();
            Provider provider1 = service.getProvider();
            String className1 = service.getClassName();
            String attributeName = null;
            String attribute = service.getAttribute(attributeName);
            Object constructorParameter = null;
            Object o = service.newInstance(constructorParameter);
            Object parameter = null;
            boolean b = service.supportsParameter(parameter);
            String s = service.toString();
        }
    }


    public static class DummyKey {
    }

    public static class DummyValue {
    }
}
