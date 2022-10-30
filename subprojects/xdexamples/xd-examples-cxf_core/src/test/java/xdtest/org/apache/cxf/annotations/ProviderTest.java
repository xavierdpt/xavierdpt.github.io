package xdtest.org.apache.cxf.annotations;


import org.apache.cxf.annotations.Provider;
import org.junit.Test;

public class ProviderTest {

    @Test
    public void test() {

        Provider annotation = Dummy.class.getAnnotation(Provider.class);

        switch (annotation.scope()) {
            case Server:
                break;
            case Client:
                break;
            case All:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + annotation.scope());
        }

        switch (annotation.value()) {
            case InInterceptor:
                break;
            case OutInterceptor:
                break;
            case InFaultInterceptor:
                break;
            case OutFaultInterceptor:
                break;
            case Feature:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + annotation.value());
        }
    }

    @Provider(value = Provider.Type.Feature, scope = Provider.Scope.Client)
    public static class Dummy {

    }
}
