package com.github.xavierdpt.jvmspect.charts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.basex.BaseXHelper;
import com.github.xavierdpt.jvmspect.utils.FileHelper;
import com.github.xavierdpt.jvmspect.utils.JSON;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChartRenderer {

    public static void generateChart(String port, File tmpDir, ChartInfo chartInfo) throws IOException {
        File queryFile = chartInfo.getQueryFile();
        FileHelper.checkFileExists(queryFile);
        JsonNode[] jsonHolder = new ArrayNode[1];
        BaseXHelper.runQueryFile(port, tmpDir, JVMSpectConstants.JAVAXML, queryFile, fileReader -> {
            try {
                Document document = XML.readDocument(fileReader);
                jsonHolder[0] = chartInfo.convertXmlResultToJson(document);
            } catch (IOException | SAXException e) {
                throw new RuntimeException(e);
            }
        });
        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("JSON", JSON.class);
        context.put("title", chartInfo.getTitle());
        context.put("dataJson", jsonHolder[0]);
        Template template = Velocity.getTemplate(chartInfo.getTemplatePath());
        try (FileWriter fw = new FileWriter(chartInfo.getDestFile())) {
            template.merge(context, fw);
        }
    }

}
