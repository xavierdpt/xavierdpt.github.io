package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.junit.Test;

public class WSDLDocumentationTest {
    @Test
    public void test() {
        WSDLDocumentation annotation = Dummy.class.getAnnotation(WSDLDocumentation.class);
        switch (annotation.placement()) {
            case DEFAULT:
                break;
            case TOP:
                break;
            case INPUT_MESSAGE:
                break;
            case OUTPUT_MESSAGE:
                break;
            case FAULT_MESSAGE:
                break;
            case PORT_TYPE:
                break;
            case PORT_TYPE_OPERATION:
                break;
            case PORT_TYPE_OPERATION_INPUT:
                break;
            case PORT_TYPE_OPERATION_OUTPUT:
                break;
            case PORT_TYPE_OPERATION_FAULT:
                break;
            case BINDING:
                break;
            case BINDING_OPERATION:
                break;
            case BINDING_OPERATION_INPUT:
                break;
            case BINDING_OPERATION_OUTPUT:
                break;
            case BINDING_OPERATION_FAULT:
                break;
            case SERVICE:
                break;
            case SERVICE_PORT:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + annotation.placement());
        }
    }

    @WSDLDocumentation(
            value = "hello",
            placement = WSDLDocumentation.Placement.DEFAULT,
            faultClass = WSDLDocumentation.DEFAULT.class
    )
    public static class Dummy {
        @WSDLDocumentation(value = "world", faultClass = MyFault.class)
        public static void foo() {

        }
    }

    public static class MyFault {
    }
}
