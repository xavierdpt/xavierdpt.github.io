package xdtools.java.security;

import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.RC2ParameterSpec;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AlgorithmParametersExample {

    public static final BigInteger BIG_ONE = BigInteger.ONE;
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                if ("AlgorithmParameters".equals(type)) {
                    String algorithm = service.getAlgorithm();
                    String key = providerName + "/" + algorithm;
                    AlgorithmParameters parameters = AlgorithmParameters.getInstance(algorithm, provider);
                    init(parameters, key);
                }
            }
        }
    }

    private static void init(AlgorithmParameters parameters, String key) throws InvalidParameterSpecException {
        System.out.println(key);
        AlgorithmParameterSpec config;
        switch (key) {
            case "SUN/DSA": {
                BigInteger p = BIG_ONE;
                BigInteger q = BIG_ONE;
                BigInteger g = BIG_ONE;
                config = new DSAParameterSpec(p, q, g);
                break;
            }
            case "SunRsaSign/RSASSA-PSS": {
                config = new PSSParameterSpec(1);
                break;
            }
            case "SunEC/EC": {
                String curveName = findEllipticCurve();
                config = new ECGenParameterSpec(curveName);
                break;
            }
            case "SunJCE/AES": {
                config = new IvParameterSpec(new byte[16]);
                break;
            }
            case "SunJCE/ChaCha20-Poly1305": {
                config = new IvParameterSpec(new byte[12]);
                break;
            }
            case "SunJCE/DESede":
            case "SunJCE/DES":
            case "SunJCE/Blowfish": {
                config = new IvParameterSpec(new byte[8]);
                break;
            }
            case "SunJCE/RC2": {
                config = new RC2ParameterSpec(0);
                break;
            }
            case "SunJCE/PBEWithSHA1AndRC4_128":
            case "SunJCE/PBEWithSHA1AndDESede":
            case "SunJCE/PBEWithSHA1AndRC4_40":
            case "SunJCE/PBEWithSHA1AndRC2_128":
            case "SunJCE/PBEWithMD5AndTripleDES":
            case "SunJCE/PBEWithSHA1AndRC2_40":
            case "SunJCE/PBEWithMD5AndDES":
            case "SunJCE/PBEWithHmacSHA224AndAES_128":
            case "SunJCE/PBES2":
            case "SunJCE/PBEWithHmacSHA224AndAES_256":
            case "SunJCE/PBEWithHmacSHA512AndAES_128":
            case "SunJCE/PBEWithHmacSHA512AndAES_256":
            case "SunJCE/PBEWithHmacSHA256AndAES_128":
            case "SunJCE/PBEWithHmacSHA256AndAES_256":
            case "SunJCE/PBEWithHmacSHA384AndAES_256":
            case "SunJCE/PBEWithHmacSHA384AndAES_128":
            case "SunJCE/PBEWithHmacSHA1AndAES_128":
            case "SunJCE/PBEWithHmacSHA1AndAES_256": {
                config = new PBEParameterSpec(new byte[0], 0);
                break;

            }
            case "SunJCE/OAEP": {
                config = new OAEPParameterSpec("", "MGF1", new MGF1ParameterSpec(""), new PSource.PSpecified(new byte[]{}));
                break;
            }
            case "SunJCE/DiffieHellman": {
                config = new DHParameterSpec(BIG_ONE, BIG_ONE);
                break;
            }
            case "SunJCE/GCM": {
                config = new GCMParameterSpec(0, new byte[0]);
                break;
            }
            default:
                config = new DummyAlgorithmParameterSpec();
        }
        try {
            parameters.init(config);
        } catch (InvalidParameterSpecException e) {
            parameters.init(config);
        }
    }

    public static class DummyAlgorithmParameterSpec implements AlgorithmParameterSpec {
    }

    private static String findEllipticCurve() {

        Set<String> invalid = new HashSet<>(Arrays.asList(""));

        Provider[] providers = Security.getProviders("AlgorithmParameters.EC");
        Provider provider = providers[0];
        Provider.Service service = provider.getService("AlgorithmParameters", "EC");
        String supportedCurves = service.getAttribute("SupportedCurves");
        System.out.println(supportedCurves);
        List<String> names = new ArrayList<>();
        String[] groups = supportedCurves.split("\\|", -1);
        for (String group : groups) {
            String commaList = group.substring(1, group.length() - 1);
            String[] parts = commaList.split(",", -1);
            for (String part : parts) {
                names.add(part);
            }
        }
        String curveName;
        do {
            int idx = random.nextInt(names.size());
            curveName = names.get(idx);
        } while (invalid.contains(curveName));
        return curveName;
    }
}
