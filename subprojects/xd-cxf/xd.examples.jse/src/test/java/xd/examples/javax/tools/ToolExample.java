package xd.examples.javax.tools;

import xd.ExampleUtils;
import xdtest.ToBeContinued;

import javax.lang.model.SourceVersion;
import javax.tools.Tool;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;


@ToBeContinued
public class ToolExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {

            Tool instance = ExampleUtils.makeInstance(Tool.class);

            String name = instance.name();
            InputStream input = null;
            OutputStream output = null;
            OutputStream error = null;
            String arguments = null;
            instance.run(input, output, error, arguments);

            Set<SourceVersion> sourceVersions = instance.getSourceVersions();

        }
    }

}
