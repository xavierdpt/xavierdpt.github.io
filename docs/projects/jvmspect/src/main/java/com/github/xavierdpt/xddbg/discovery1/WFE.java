package com.github.xavierdpt.xddbg.discovery1;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class WFE implements AutoCloseable {
    private final XMLStreamWriter sw;

    public WFE(XMLStreamWriter sw, String name) throws XMLStreamException {
        this.sw = sw;
        sw.writeStartElement(name);
    }

    @Override
    public void close() throws XMLStreamException {
        sw.writeEndElement();
    }
}
