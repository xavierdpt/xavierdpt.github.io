package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.List;

@Scaffolded
public class ScriptEngineFactoryExample extends BaseExample<ScriptEngineFactory> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(ScriptEngineFactory instance) {
        {
            String engineName = instance.getEngineName();
        }
        {
            String engineVersion = instance.getEngineVersion();
        }
        {
            List<String> extensions = instance.getExtensions();
        }
        {
            String languageName = instance.getLanguageName();
        }
        {
            String languageVersion = instance.getLanguageVersion();
        }
        {
            String object = any();
            String name = any();
            String[] arguments = any();
            String methodCallSyntax = instance.getMethodCallSyntax(object, name, arguments);
        }
        {
            List<String> mimeTypes = instance.getMimeTypes();
        }
        {
            List<String> names = instance.getNames();
        }
        {
            String toDisplay = any();
            String outputStatement = instance.getOutputStatement(toDisplay);
        }
        {
            String key = any();
            Object parameter = instance.getParameter(key);
        }
        {
            String[] statements = any();
            String program = instance.getProgram(statements);
        }
        {
            ScriptEngine scriptEngine = instance.getScriptEngine();
        }

    }
}
