package xdtest;

import net.xdexamples.AllMethodsCovered;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class IndexTest {
    @Test
    public void test() throws IOException {

        String classPath = System.getProperty("java.class.path", "");
        String[] parts = classPath.split(";", -1);
        String cxfCoreJarPath = Arrays.stream(parts)
                .filter(path -> path.contains("cxf"))
                .filter(path -> path.endsWith(".jar"))
                .filter(path -> path.contains("\\cxf\\cxf-core\\"))
                .findFirst().orElse(null);
        if (cxfCoreJarPath != null) {
            try (JarFile jarFile = new JarFile(cxfCoreJarPath)) {
                class TestClassInfo {

                    private String testClassName;
                    private boolean exists;
                    private boolean done;

                    public TestClassInfo(String testClassName) {
                        this.testClassName = testClassName;
                    }

                    public String getTestClassName() {
                        return testClassName;
                    }

                    public void setExists(boolean exists) {
                        this.exists = exists;
                    }

                    public boolean isExists() {
                        return exists;
                    }

                    public void setDone(boolean done) {
                        this.done = done;
                    }

                    public boolean isDone() {
                        return done;
                    }
                }
                List<TestClassInfo> infos = new ArrayList<>();
                class JarConsumer implements Consumer<JarEntry> {
                    private int count;
                    private int successLoad;
                    private int failLoad;
                    private int successTestClassLoad;
                    private int failTestClassLoad;
                    private int done;

                    @Override
                    public void accept(JarEntry jarEntry) {
                        String path = jarEntry.getName();
                        if (path.endsWith(".class") && !path.contains("$")) {
                            String className = path
                                    .replaceFirst("\\.class$", "")
                                    .replaceAll("/", ".");
                            String testClassName = "xdtest." + className + "Test";
                            try {
                                Class.forName(className);
                                ++successLoad;
                                try {
                                    TestClassInfo testClassInfo = new TestClassInfo(testClassName);
                                    infos.add(testClassInfo);
                                    Class<?> testClass = Class.forName(testClassName);
                                    testClassInfo.setExists(true);
                                    if (testClass.isAnnotationPresent(AllMethodsCovered.class)) {
                                        testClassInfo.setDone(true);
                                        ++done;
                                    }
                                    ++successTestClassLoad;
                                } catch (ClassNotFoundException | NoClassDefFoundError e) {
                                    ++failTestClassLoad;
                                }
                            } catch (ClassNotFoundException | NoClassDefFoundError e) {
                                ++failLoad;
                            }
                            ++count;
                        }
                    }
                }
                JarConsumer consumer = new JarConsumer();
                jarFile.stream().forEach(consumer);
                System.out.println(" - count: " + consumer.count);
                System.out.println(" - successLoad: " + consumer.successLoad);
                System.out.println(" - failLoad: " + consumer.failLoad);
                System.out.println(" - successTestClassLoad: " + consumer.successTestClassLoad);
                System.out.println(" - failTestClassLoad: " + consumer.failTestClassLoad);
                System.out.println(" - done: " + consumer.done);
                Collections.shuffle(infos);
                for (TestClassInfo info : infos) {
                    System.out.println(info.getTestClassName());
                    System.out.println(" exist:"+info.isExists());
                    System.out.println(" done:"+info.isDone());
                }


            }
        }
    }
}
