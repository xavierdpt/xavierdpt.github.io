package xd.jvmspect.basex;

import org.basex.BaseXServer;

import java.io.File;
import java.io.IOException;

public record BaseXSession(BaseXServer server, String port, File tmpDir) implements AutoCloseable {

    @Override
    public void close() throws IOException {
        server.stop();
    }
}
