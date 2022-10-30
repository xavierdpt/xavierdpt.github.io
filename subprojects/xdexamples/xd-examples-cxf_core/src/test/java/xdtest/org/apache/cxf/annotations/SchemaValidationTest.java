package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.SchemaValidation;

public class SchemaValidationTest {
    public static void main(String[] args) {
        SchemaValidation annotation = Dummy.class.getAnnotation(SchemaValidation.class);
        switch (annotation.type()) {
            case IN:
                break;
            case REQUEST:
                break;
            case OUT:
                break;
            case RESPONSE:
                break;
            case BOTH:
                break;
            case NONE:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + annotation.type());
        }

    }

    @SchemaValidation(type = SchemaValidation.SchemaValidationType.BOTH, schemas = {"hello", "world"})
    public static class Dummy {
        @SchemaValidation()
        public static void foo() {

        }
    }
}
