package xd.examples.javax.tools;

import xd.ExampleUtils;

import javax.tools.DiagnosticListener;
import javax.tools.DocumentationTool;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;

public class DocumentationToolExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {

            DocumentationTool instance = ExampleUtils.makeInstance(DocumentationTool.class);

            Writer writer = null;
            JavaFileManager fileManager = null;
            DiagnosticListener<? super JavaFileObject> diagnosticListener = null;
            Class<?> docletClass = null;
            Iterable<String> options = null;
            Iterable<? extends JavaFileObject> compilationUnits = null;
            DocumentationTool.DocumentationTask task = instance.getTask(writer, fileManager, diagnosticListener, docletClass, options, compilationUnits);

            Locale locale = null;
            Charset charset = null;
            StandardJavaFileManager standardFileManager = instance.getStandardFileManager(diagnosticListener, locale, charset);


        }
    }

}
