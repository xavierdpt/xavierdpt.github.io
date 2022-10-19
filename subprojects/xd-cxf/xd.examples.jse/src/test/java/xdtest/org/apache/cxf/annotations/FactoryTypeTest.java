package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.FactoryType;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.invoker.Factory;

public class FactoryTypeTest {


    @FactoryType(value = FactoryType.Type.Singleton, args = {"hello", "world"}, factoryClass = FactoryType.DEFAULT.class)
    public static class Dummy1 {

    }

    @FactoryType(value = FactoryType.Type.Session, factoryClass = MyFactory.class)
    public static class Dummy2 {

    }

    @FactoryType(value = FactoryType.Type.Pooled)
    public static class Dummy3 {

    }

    @FactoryType(value = FactoryType.Type.PerRequest)
    public static class Dummy4 {

    }

    public static class MyFactory implements Factory {

        @Override
        public Object create(Exchange e) throws Throwable {
            return null;
        }

        @Override
        public void release(Exchange e, Object o) {

        }
    }
}
