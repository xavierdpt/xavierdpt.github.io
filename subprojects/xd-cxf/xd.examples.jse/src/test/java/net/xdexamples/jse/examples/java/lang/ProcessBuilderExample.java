package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.ExampleUtils;
import xdtest.OperatingSystem;
import net.xdexamples.Scaffolded;
import xdtest.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Scaffolded
public class ProcessBuilderExample extends BaseExample<ProcessBuilder> {

    @Override
    public void scaffold(ProcessBuilder instance) throws IOException {

        List<String> commandList = null;
        String command = null;

        {
            ProcessBuilder processBuilder = new ProcessBuilder("ls");
            seeExamples(this::exampleStringCommand);
            ignore(processBuilder);
        }

        {
            ProcessBuilder processBuilder = new ProcessBuilder("ls", ".");
            seeExamples(this::exampleMultipleArguments);
            ExampleUtils.ignore(processBuilder);
        }

        {
            ProcessBuilder processBuilder = new ProcessBuilder(Arrays.asList("ls", "."));
            seeExamples(this::exampleListArguments);
            ExampleUtils.ignore(processBuilder);
        }

        {
            List<String> commandx = instance.command();
            seeExamples(
                    this::exampleStringCommand,
                    this::exampleMultipleArguments,
                    this::exampleListArguments
            );
            ignore(commandx);
        }

        {
            ProcessBuilder command2 = instance.command(command);
            seeExamples(this::exampleCommandStrings);
            ignore(command2);
        }

        {
            ProcessBuilder command3 = instance.command(commandList);
            seeExamples(this::exampleCommandList);
            ignore(command3);
        }

        Map<String, String> environment = instance.environment();

        File directory = instance.directory();
        ProcessBuilder directory1 = instance.directory(directory);

        ProcessBuilder.Redirect redirect = instance.redirectInput();
        File file = null;
        ProcessBuilder processBuilder1 = instance.redirectInput(file);
        ProcessBuilder processBuilder = instance.redirectInput(redirect);

        ProcessBuilder.Redirect redirect1 = instance.redirectOutput();
        ProcessBuilder processBuilder2 = instance.redirectOutput(file);
        ProcessBuilder processBuilder3 = instance.redirectOutput(redirect);

        ProcessBuilder.Redirect redirect2 = instance.redirectError();
        ProcessBuilder processBuilder4 = instance.redirectError(file);
        ProcessBuilder processBuilder5 = instance.redirectError(redirect);

        ProcessBuilder processBuilder6 = instance.inheritIO();

        boolean b = instance.redirectErrorStream();
        ProcessBuilder processBuilder7 = instance.redirectErrorStream(b);

        {
            Process start = instance.start();
            seeExamples(this::exampleStringCommand);
            ignore(start);
        }
        List<ProcessBuilder> builders = null;
        List<Process> processes = ProcessBuilder.startPipeline(builders);

    }

    @Test
    public void exampleStringCommand() throws IOException, InterruptedException {
        if (OperatingSystem.WINDOWS.equals(TestUtils.findOS())) {
            ByteArrayOutputStream error = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            // Runs xcopy with no files, this generates an error message and exits and is available on all Windows versions
            ProcessBuilder builder = new ProcessBuilder("xcopy");

            Assert.assertArrayEquals(new String[]{"xcopy"}, builder.command().toArray());

            Process process = builder.start();
            process.waitFor();
            process.getInputStream().transferTo(output);
            process.getErrorStream().transferTo(error);
            Assert.assertEquals("Invalid number of parameters", error.toString(StandardCharsets.UTF_8).trim());
            Assert.assertEquals("0 File(s) copied", output.toString(StandardCharsets.UTF_8).trim());
            Assert.assertEquals(4, process.exitValue());
        } else {
            Assert.fail("Unsupported operationg system");
        }
    }

    @Test
    public void exampleMultipleArguments() throws IOException, InterruptedException {
        if (OperatingSystem.WINDOWS.equals(TestUtils.findOS())) {
            ByteArrayOutputStream error = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            // Runs xcopy with no files, this generates an error message and exits and is available on all Windows versions
            ProcessBuilder builder = new ProcessBuilder("cmd", "/C", "dir");

            Assert.assertArrayEquals(new String[]{"cmd", "/C", "dir"}, builder.command().toArray());

            Process process = builder.start();
            process.waitFor();
            process.getInputStream().transferTo(output);
            process.getErrorStream().transferTo(error);
            String a = output.toString(StandardCharsets.UTF_8).trim();
            Assert.assertEquals("", error.toString(StandardCharsets.UTF_8).trim());
            Assert.assertTrue(a.contains("Directory of"));
            Assert.assertEquals(0, process.exitValue());
        } else {
            Assert.fail("Unsupported operationg system");
        }
    }

    @Test
    public void exampleListArguments() throws IOException, InterruptedException {
        if (OperatingSystem.WINDOWS.equals(TestUtils.findOS())) {
            ByteArrayOutputStream error = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            // Runs xcopy with no files, this generates an error message and exits and is available on all Windows versions
            List<String> command = Arrays.asList("cmd", "/C", "dir");
            ProcessBuilder builder = new ProcessBuilder(command);

            Assert.assertArrayEquals(new String[]{"cmd", "/C", "dir"}, builder.command().toArray());

            Process process = builder.start();
            process.waitFor();
            process.getInputStream().transferTo(output);
            process.getErrorStream().transferTo(error);
            String a = output.toString(StandardCharsets.UTF_8).trim();
            Assert.assertEquals("", error.toString(StandardCharsets.UTF_8).trim());
            Assert.assertTrue(a.contains("Directory of"));
            Assert.assertEquals(0, process.exitValue());
        } else {
            Assert.fail("Unsupported operationg system");
        }
    }

    @Test
    public void exampleCommandStrings() throws IOException, InterruptedException {
        if (OperatingSystem.WINDOWS.equals(TestUtils.findOS())) {
            ByteArrayOutputStream error = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            // Runs xcopy with no files, this generates an error message and exits and is available on all Windows versions
            ProcessBuilder builder = new ProcessBuilder()
                    .command("cmd", "/C", "dir");

            Process process = builder.start();
            process.waitFor();
            process.getInputStream().transferTo(output);
            process.getErrorStream().transferTo(error);
            String a = output.toString(StandardCharsets.UTF_8).trim();
            Assert.assertEquals("", error.toString(StandardCharsets.UTF_8).trim());
            Assert.assertTrue(a.contains("Directory of"));
            Assert.assertEquals(0, process.exitValue());
        } else {
            Assert.fail("Unsupported operationg system");
        }
    }

    @Test
    public void exampleCommandList() throws IOException, InterruptedException {
        if (OperatingSystem.WINDOWS.equals(TestUtils.findOS())) {
            ByteArrayOutputStream error = new ByteArrayOutputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            // Runs xcopy with no files, this generates an error message and exits and is available on all Windows versions
            List<String> command = Arrays.asList("cmd", "/C", "dir");
            ProcessBuilder builder = new ProcessBuilder()
                    .command(command);

            Process process = builder.start();
            process.waitFor();
            process.getInputStream().transferTo(output);
            process.getErrorStream().transferTo(error);
            String a = output.toString(StandardCharsets.UTF_8).trim();
            Assert.assertEquals("", error.toString(StandardCharsets.UTF_8).trim());
            Assert.assertTrue(a.contains("Directory of"));
            Assert.assertEquals(0, process.exitValue());
        } else {
            Assert.fail("Unsupported operationg system");
        }
    }


}
