package net.xdexamples.jse.examples.javax.tools;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;

@ToBeContinued
public class JavaCompilerExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            JavaCompiler instance = ExampleUtils.makeInstance(JavaCompiler.class);

            Writer writer = null;
            JavaFileManager javaFileManager = null;
            DiagnosticListener<? super JavaFileObject> diagnosticListener = null;
            Iterable<String> options = null;
            Iterable<String> classes = null;
            Iterable<? extends JavaFileObject> compilationUnits = null;
            Locale locale = null;
            Charset charset = null;

            JavaCompiler.CompilationTask task = instance.getTask(writer, javaFileManager, diagnosticListener, options, classes, compilationUnits);
            StandardJavaFileManager standardFileManager = instance.getStandardFileManager(diagnosticListener, locale, charset);
        }
    }
}
