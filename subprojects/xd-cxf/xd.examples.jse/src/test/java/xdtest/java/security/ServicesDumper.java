package xdtest.java.security;

import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ServicesDumper {
    public static void main(String[] args) {
        Map<String, Set<String>> results = new HashMap<>();
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                String algorithm = service.getAlgorithm();
                results.computeIfAbsent(type, __ -> new TreeSet<>());
                results.get(type).add(algorithm + "[" + providerName + "]");
            }
        }
        results.keySet().stream().sorted().forEach(s -> {
            System.out.println(s);
            results.get(s).stream().sorted().forEach(algorithm -> System.out.println("-- " + algorithm));
        });
    }
}
