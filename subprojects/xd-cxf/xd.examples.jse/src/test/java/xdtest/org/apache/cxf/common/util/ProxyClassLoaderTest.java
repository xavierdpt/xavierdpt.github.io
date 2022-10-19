package xdtest.org.apache.cxf.common.util;

import org.apache.cxf.common.util.ProxyClassLoader;
import org.junit.Test;
import xdtest.Done;
import xdtest.TestUtils;

@Done
public class ProxyClassLoaderTest {

    public static final ClassLoader PARENT_LOADER = ProxyClassLoaderTest.class.getClassLoader();
    public static final ClassLoader LOADER = ProxyClassLoaderTest.class.getClassLoader();
    public static final Class<?>[] CLASSES = new Class[0];

    @Test
    public void test() throws ClassNotFoundException {
        if (TestUtils.principle()) {
            {
                // Construct with a loader and some classes
                ProxyClassLoader instance = new ProxyClassLoader(PARENT_LOADER, CLASSES);

                // Can add multiple loaders
                instance.addLoader(LOADER);

                // enables the system loader
                instance.addLoader(null);

                // First look in the supplied classes
                // Then use each loader in turn
                // If still not found and checkSystem is true, use the System class loaader
                instance.findClass("Dummy.class");

                // Use each loader to find the resource
                instance.findResource("dummy.txt");
            }
            {
                // No preloaded classes, exclusively rely on the loaders
                ProxyClassLoader instance = new ProxyClassLoader(PARENT_LOADER);
                TestUtils.ignore(instance);
            }
            {
                // The parent class is only used for inheritance
                // This is valid because a null parent class loader is allowed
                ProxyClassLoader instance = new ProxyClassLoader(null);
                // But this won't cause the parent loader to be used to look up class
                instance = new ProxyClassLoader(PARENT_LOADER);
                // loaders must be added with addLoader to be considered
                instance.addLoader(LOADER);
                // this enables the system loader at the end but does not add a null loader
                instance.addLoader(null);
                TestUtils.ignore(instance);
            }
        }
    }
}
