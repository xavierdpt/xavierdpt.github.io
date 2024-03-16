package com.github.xavierdpt.jvmspect.basex;

import org.basex.BaseXServer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class BaseXSession implements AutoCloseable {
    private final BaseXServer server;
    private final String port;
    private final File tmpDir;

    BaseXSession(BaseXServer server, String port, File tmpDir) {
        this.server = server;
        this.port = port;
        this.tmpDir = tmpDir;
    }

    public BaseXServer server() {
        return server;
    }

    public String port() {
        return port;
    }

    public File tmpDir() {
        return tmpDir;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BaseXSession) obj;
        return Objects.equals(this.server, that.server) &&
                Objects.equals(this.port, that.port) &&
                Objects.equals(this.tmpDir, that.tmpDir);
    }

    @Override
    public void close() throws IOException {
        server.stop();
    }
}
