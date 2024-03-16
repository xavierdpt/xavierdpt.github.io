package com.github.xavierdpt.jvmspect.charts;

import com.fasterxml.jackson.databind.JsonNode;
import org.w3c.dom.Document;

import java.io.File;

public abstract class ChartInfo {
    private final String title;
    private final File queryFile;
    private final String templatePath;
    private final File destFile;

    public ChartInfo(String title, File queryFile, String templatePath, File destFile) {
        this.title = title;
        this.queryFile = queryFile;
        this.templatePath = templatePath;
        this.destFile = destFile;
    }

    public String getTitle() {
        return title;
    }

    public File getQueryFile() {
        return queryFile;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public File getDestFile() {
        return destFile;
    }

    public abstract JsonNode convertXmlResultToJson(Document document);
}
