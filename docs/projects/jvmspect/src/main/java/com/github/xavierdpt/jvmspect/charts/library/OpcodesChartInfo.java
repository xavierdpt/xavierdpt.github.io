package com.github.xavierdpt.jvmspect.charts.library;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.charts.ChartInfo;
import com.github.xavierdpt.jvmspect.utils.JSON;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

import static com.github.xavierdpt.jvmspect.utils.ResourceUtils.resourcePath;

public class OpcodesChartInfo extends ChartInfo {

    public OpcodesChartInfo() {
        super(
                "JVM opcode counts in OpenJDK 21",
                new File(resourcePath("charts/opcodes/opcodes.xquery")),
                resourcePath("charts/opcodes/opcodes.vm"),
                new File(JVMSpectConstants.PUBLISHED_DIR, "opcodeStats.html")
        );
    }

    @Override
    public JsonNode convertXmlResultToJson(Document document) {
        NodeList childNodes = document.getDocumentElement().getChildNodes();
        ArrayNode jsonData = JSON.createArrayNode();
        for (int idx = 0; idx < childNodes.getLength(); idx++) {
            Element item = (Element) childNodes.item(idx);
            String name = item.getAttribute("name");
            long count = Long.parseLong(item.getAttribute("count"));
            ObjectNode jsonDatum = JSON.createObjectNode();
            jsonDatum.put("name", name);
            jsonDatum.put("value", count);
            jsonData.add(jsonDatum);
        }
        return jsonData;
    }
}
