package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.DataBinding;
import org.apache.cxf.databinding.DataReader;
import org.apache.cxf.databinding.DataWriter;
import org.apache.cxf.service.Service;

import java.util.Map;

public class DataBindingTest {

    @DataBinding(value = MyDataBinding.class, ref = "hello")
    public static class Dummy {
        private static Class<? extends org.apache.cxf.databinding.DataBinding> foo;
    }

    public static class MyDataBinding implements org.apache.cxf.databinding.DataBinding {

        @Override
        public <T> DataReader<T> createReader(Class<T> cls) {
            return null;
        }

        @Override
        public <T> DataWriter<T> createWriter(Class<T> cls) {
            return null;
        }

        @Override
        public Class<?>[] getSupportedReaderFormats() {
            return new Class[0];
        }

        @Override
        public Class<?>[] getSupportedWriterFormats() {
            return new Class[0];
        }

        @Override
        public void initialize(Service service) {

        }

        @Override
        public Map<String, String> getDeclaredNamespaceMappings() {
            return null;
        }

        @Override
        public void setMtomEnabled(boolean enabled) {

        }

        @Override
        public boolean isMtomEnabled() {
            return false;
        }

        @Override
        public void setMtomThreshold(int threshold) {

        }

        @Override
        public int getMtomThreshold() {
            return 0;
        }
    }
}
