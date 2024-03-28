package com.github.xavierdpt.jvmspect.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class JSON {

    private static final ObjectMapper OM = new ObjectMapper();
    private static final ObjectWriter OW = OM.writerWithDefaultPrettyPrinter();

    public static ObjectNode createObjectNode() {
        return OM.createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return OM.createArrayNode();
    }

    public static String toString(Object jsonData) throws JsonProcessingException {
        return OW.writeValueAsString(jsonData);
    }

    public static JsonNode readFile(File file) throws IOException {
        if (file.exists()) {
            if (file.isFile()) {
                return OM.readTree(file);
            } else {
                throw new IOException("Not a file: " + file.getAbsolutePath());
            }
        } else {
            return null;
        }
    }

    public static String getString(JsonNode jsonNode, String name, String defaultText) {
        try {
            return Optional.ofNullable(jsonNode.get(name)).map(JsonNode::textValue).orElse(defaultText);
        } catch (Exception e) {
            return defaultText;
        }

    }

    public static void writeFile(File configFile, ObjectNode json) throws IOException {
        OW.writeValue(configFile, json);
    }

    public static boolean getBoolean(JsonNode json, String name, boolean defaultValue) {
        try {
            return Optional.ofNullable(json.get(name)).map(JsonNode::asBoolean).orElse(defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static ArrayNode getArray(JsonNode json, String name) {
        JsonNode value = json.get(name);
        if (value instanceof ArrayNode jsonArray) {
            return jsonArray;
        }
        return JSON.createArrayNode();
    }
}
