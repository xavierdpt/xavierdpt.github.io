package pm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public class Commands {

    private static ObjectMapper om = new ObjectMapper();

    static {
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    private static ObjectWriter ow = om.writerWithDefaultPrettyPrinter();

    public static void openBook(Book book) throws IOException {
        Desktop.getDesktop().browse(URI.create(book.getPath()));
    }

    public static void dumpState(Object state) throws JsonProcessingException {
        System.out.println(ow.writeValueAsString(state));
    }
}
