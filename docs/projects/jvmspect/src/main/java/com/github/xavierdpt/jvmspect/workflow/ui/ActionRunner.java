package com.github.xavierdpt.jvmspect.workflow.ui;

import com.github.xavierdpt.jvmspect.basex.BaseXSession;
import com.github.xavierdpt.jvmspect.charts.ChartRenderer;
import com.github.xavierdpt.jvmspect.charts.JVMSpectCharts;
import com.github.xavierdpt.jvmspect.workflow.ClassFileDumper;
import com.github.xavierdpt.jvmspect.workflow.ModulesExtractor;
import com.github.xavierdpt.jvmspect.workflow.Step3InitBaseX;
import org.basex.BaseXServer;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class ActionRunner {

    public static void doUnpack(boolean force) throws InterruptedException, IOException {
        ModulesExtractor.extractModules(force);
    }

    public static void doDump(boolean force) throws IOException, TransformerException {
        ClassFileDumper.generateXMLFiles(force);
    }

    public static void doImport(boolean force, BaseXSession session) throws IOException {
        BaseXServer server = session.server();
        String port = session.port();
        File tmpDir = session.tmpDir();
        Step3InitBaseX.doInBaseXSession(server, port, tmpDir, force);
    }

    public static void doGenerateCharts(BaseXSession session) throws IOException {
        String port = session.port();
        File tmpDir = session.tmpDir();
        for (JVMSpectCharts chart : JVMSpectCharts.values()) {
            ChartRenderer.generateChart(port, tmpDir, chart.getChartInfo());
        }


    }

}
