package com.github.xavierdpt.jvmspect.charts.library;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.charts.ChartInfo;
import com.github.xavierdpt.jvmspect.utils.JSON;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Map;

import static com.github.xavierdpt.jvmspect.utils.ResourceUtils.resourcePath;

public class NativeChartInfo extends ChartInfo {

    public NativeChartInfo() {
        super(
                "Native methods OpenJDK 21",
                new File(resourcePath("charts/native/native.xquery")),
                resourcePath("charts/native/native.vm"),
                new File(JVMSpectConstants.PUBLISHED_DIR, "nativeChart.html")
        );
    }

    @Override
    public JsonNode convertXmlResultToJson(Document document) {

        NodeList classes = document.getDocumentElement().getChildNodes();

        StringTree stringTree = new StringTree();
        for (int classIdx = 0; classIdx < classes.getLength(); classIdx++) {
            Node clazz = classes.item(classIdx);
            String className = clazz.getAttributes().getNamedItem("name").getNodeValue();
            String[] parts = className.split("/");
            NodeList methods = clazz.getChildNodes();
            for (int methodIdx = 0; methodIdx < methods.getLength(); methodIdx++) {
                String methodName = methods.item(methodIdx).getAttributes().getNamedItem("name").getNodeValue();
                addToStringTree(stringTree, methodName, parts, 0);

            }
        }

        return generateJsonData(stringTree);
    }

    private void addToStringTree(StringTree stringTree, String methodName, String[] parts, int partIdx) {
        String name;
        boolean isLeaf = partIdx >= parts.length;
        if (isLeaf) {
            name = methodName;
        } else {
            name = parts[partIdx];
        }
        StringTree subTree = stringTree.get(name);
        if (!isLeaf) {
            addToStringTree(subTree, methodName, parts, ++partIdx);
        }
    }

    private ArrayNode generateJsonData(StringTree tree) {
        ArrayNode jsonData = JSON.createArrayNode();
        for (Map.Entry<String, StringTree> entry : tree.children.entrySet()) {
            String key = entry.getKey();
            StringTree subTree = entry.getValue();
            ObjectNode jsonDatum = JSON.createObjectNode();
            jsonDatum.put("name", key);
            if (subTree.isLeaf()) {
                jsonDatum.put("value", 1);
            } else {
                jsonDatum.set("children", generateJsonData(subTree));

            }
            jsonData.add(jsonDatum);
        }
        return jsonData;
    }

}
