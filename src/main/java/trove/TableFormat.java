package trove;

import java.util.List;
import java.util.function.Function;

public class TableFormat {
    private final boolean hasHeader;
    private final List<Function<String,String>> headerFormatters;
    private final List<Function<String,String>> formatters;

    public TableFormat(boolean hasHeader, List<Function<String, String>> headerFormatters, List<Function<String, String>> formatters) {
        this.hasHeader = hasHeader;
        this.headerFormatters = headerFormatters;
        this.formatters = formatters;
    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public List<Function<String, String>> getHeaderFormatters() {
        return headerFormatters;
    }

    public List<Function<String, String>> getFormatters() {
        return formatters;
    }
}
