package xdtest.org.apache.cxf.binding;

import org.apache.cxf.binding.BindingConfiguration;
import org.junit.Test;

public class BindingConfigurationTest {
    @Test
    public void test() {
        BindingConfiguration instance = new Dummy();
        String bindingId = instance.getBindingId();
    }

    public static class Dummy extends BindingConfiguration {
        @Override
        public String getBindingId() {
            return null;
        }
    }
}
