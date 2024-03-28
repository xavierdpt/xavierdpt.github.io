package com.github.xavierdpt.xddbg;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.xavierdpt.jvmspect.utils.FileHelper;
import com.github.xavierdpt.jvmspect.utils.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    public static final File CONFIG_FILE = new File(XDDBGConstants.XDDBG_LOCAL_DIR, "config.json");

    public static JsonNode readConfig(XDDBG.Config config) throws IOException {
        FileHelper.ensureDir(CONFIG_FILE.getParentFile());
        JsonNode json = JSON.readFile(CONFIG_FILE);
        config.setPort(JSON.getString(json, "port", ""));
        config.setClassSearch(JSON.getString(json, "classSearch", ""));
        List<String> classSearchHistoryItems = new ArrayList<>();
        for (JsonNode classSearchHistoryJson : JSON.getArray(json, "classSearchHistory")) {
            if (classSearchHistoryJson.isValueNode()) {
                if (classSearchHistoryJson.isNull()) {
                    continue;
                }
                String value = classSearchHistoryJson.asText();
                if (StringUtils.isEmpty(value)) {
                    continue;
                }
                classSearchHistoryItems.add(value);
            }
        }
        config.setClassSearchHistory(classSearchHistoryItems);
        config.setHideEmptyMethods(JSON.getBoolean(json, "hideEmptyMethods", true));
        return json;
    }

    public static void saveConfig(XDDBG app) throws IOException {
        FileHelper.ensureDir(CONFIG_FILE.getParentFile());
        ObjectNode json = JSON.createObjectNode();
        json.put("port", app.config.getPort());
        json.put("classSearch", app.config.getClassSearch());
        ArrayNode classSearchHistory = JSON.createArrayNode();
        for (String classSearchHistoryItem : app.config.getClassSearchHistory()) {
            classSearchHistory.add(classSearchHistoryItem);
        }
        json.set("classSearchHistory", classSearchHistory);
        json.put("hideEmptyMethods", app.config.hideEmptyMethods());
        JSON.writeFile(CONFIG_FILE, json);
    }
}
