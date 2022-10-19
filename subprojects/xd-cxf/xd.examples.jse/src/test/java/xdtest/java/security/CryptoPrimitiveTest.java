package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.CryptoPrimitive;

public class CryptoPrimitiveTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            CryptoPrimitive instance = TestUtils.makeInstance(CryptoPrimitive.class);
            switch (instance) {
                case MESSAGE_DIGEST:
                    break;
                case SECURE_RANDOM:
                    break;
                case BLOCK_CIPHER:
                    break;
                case STREAM_CIPHER:
                    break;
                case MAC:
                    break;
                case KEY_WRAP:
                    break;
                case PUBLIC_KEY_ENCRYPTION:
                    break;
                case SIGNATURE:
                    break;
                case KEY_ENCAPSULATION:
                    break;
                case KEY_AGREEMENT:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + instance);
            }
        }
    }
}
