package net.xdexamples.jse.examples.javax.tools;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import javax.tools.DocumentationTool;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

@ToBeContinued
public class ToolProviderExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            DocumentationTool systemDocumentationTool = ToolProvider.getSystemDocumentationTool();
        }
    }

}
