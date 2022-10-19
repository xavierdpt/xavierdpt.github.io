package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

public class WSDLDocumentationCollectionTest {

    @WSDLDocumentationCollection({
            @WSDLDocumentation("hello"),
            @WSDLDocumentation("world")
    })
    public static class Dummy {
        @WSDLDocumentationCollection({
                @WSDLDocumentation("hello-foo"),
                @WSDLDocumentation("world-foo")
        })
        public static void foo() {

        }
    }
}
