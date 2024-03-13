package xd.jvmspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
}
