package net.xdexamples.jse.index.javax.tools;


import net.xdexamples.ExampleIndex;
import net.xdexamples.jse.examples.javax.tools.DocumentationToolExample;
import net.xdexamples.jse.examples.javax.tools.JavaCompilerExample;
import net.xdexamples.jse.examples.javax.tools.ToolExample;
import net.xdexamples.jse.examples.javax.tools.ToolProviderExample;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.DiagnosticListener;
import javax.tools.DocumentationTool;
import javax.tools.FileObject;
import javax.tools.ForwardingFileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.ForwardingJavaFileObject;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.OptionChecker;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.Tool;
import javax.tools.ToolProvider;

@ExampleIndex({
        Diagnostic.class,
        DiagnosticCollector.class,
        DiagnosticListener.class,

        DocumentationTool.class,
        DocumentationToolExample.class,

        FileObject.class,
        ForwardingFileObject.class,
        ForwardingJavaFileManager.class,
        ForwardingJavaFileObject.class,

        JavaCompiler.class,
        JavaCompilerExample.class,

        JavaFileManager.class,
        JavaFileObject.class,
        OptionChecker.class,
        SimpleJavaFileObject.class,
        StandardJavaFileManager.class,
        StandardLocation.class,

        Tool.class,
        ToolExample.class,

        ToolProvider.class,
        ToolProviderExample.class,
})
public class Index {
}
