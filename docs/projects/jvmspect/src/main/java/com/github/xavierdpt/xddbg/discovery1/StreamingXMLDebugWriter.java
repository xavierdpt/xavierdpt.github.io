package com.github.xavierdpt.xddbg.discovery1;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.jvmspect.input.attributes.code.InstructionDataInput;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantDataInput;
import com.github.xavierdpt.jvmspect.utils.XML;
import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.IncompatibleThreadStateException;
import com.sun.jdi.InternalException;
import com.sun.jdi.LocalVariable;
import com.sun.jdi.Location;
import com.sun.jdi.Method;
import com.sun.jdi.MonitorInfo;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.StackFrame;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.Value;
import com.sun.jdi.event.LocatableEvent;
import org.w3c.dom.Document;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamingXMLDebugWriter implements AutoCloseable {
    private static XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();

    private final XMLStreamWriter sw;
    private Integer pfc = null;
    private Map<String, ConstantResolver> resolvers = new HashMap<>();

    public StreamingXMLDebugWriter(OutputStream out) throws XMLStreamException {
        sw = xmlOutputFactory.createXMLStreamWriter(out);
        sw.writeStartDocument();
        sw.writeStartElement("root");
    }

    public void writeEvent(LocatableEvent event) throws XMLStreamException, IncompatibleThreadStateException {
        ThreadReference thread = event.thread();
        int frameCount = thread.frameCount();
        if (pfc != null && pfc < frameCount) {
            sw.writeStartElement("frame");
        }
        try (WFE ignored = new WFE(sw, "step")) {
            sw.writeAttribute("frameCount", String.valueOf(frameCount));
            StackFrame currentFrame = thread.frame(0);
            ObjectReference objectReference = currentFrame.thisObject();
            if (objectReference != null) {
                sw.writeAttribute("this", String.valueOf(objectReference.uniqueID()));
            }
            writeLocationInfo(currentFrame.location());
            writeArgumentsInfo(currentFrame);
            writeVisibleVariableInfo(currentFrame);
            writeThreadInfo(thread);
            writeOpCodeInfo(currentFrame.location());
        }
        if (pfc != null && pfc > frameCount) {
            sw.writeEndElement();
        }
        pfc = frameCount;
    }

    private void writeThreadInfo(ThreadReference thread) throws XMLStreamException {
        try (WFE ignored1 = new WFE(sw, "thread")) {
            sw.writeAttribute("thread", thread.name());
            sw.writeAttribute("threadId", String.valueOf(thread.uniqueID()));
            int threadStatus = thread.status();
            String statusText = switch (threadStatus) {
                case ThreadReference.THREAD_STATUS_UNKNOWN -> "unknown";
                case ThreadReference.THREAD_STATUS_ZOMBIE -> "zombie";
                case ThreadReference.THREAD_STATUS_RUNNING -> "running";
                case ThreadReference.THREAD_STATUS_SLEEPING -> "sleeping";
                case ThreadReference.THREAD_STATUS_MONITOR -> "monitor";
                case ThreadReference.THREAD_STATUS_WAIT -> "wait";
                case ThreadReference.THREAD_STATUS_NOT_STARTED -> "started";
                default -> String.valueOf(threadStatus);
            };
            sw.writeAttribute("status", statusText);
            try {
                int entryCount = thread.entryCount();
                sw.writeAttribute("entryCount", String.valueOf(entryCount));
            } catch (IncompatibleThreadStateException ignored) {

            }
            sw.writeAttribute("suspendCount", String.valueOf(thread.suspendCount()));
            sw.writeAttribute("virtual", String.valueOf(thread.isVirtual()));
            try {
                sw.writeAttribute("hasContendedMonitor", String.valueOf(thread.currentContendedMonitor() != null));
            } catch (IncompatibleThreadStateException ignored) {
            }
            try {
                List<MonitorInfo> monitorInfos = thread.ownedMonitorsAndFrames();
                if (!monitorInfos.isEmpty()) {
                    try (WFE ignored = new WFE(sw, "monitors")) {
                        for (MonitorInfo monitorInfo : monitorInfos) {
                            try (WFE ignored2 = new WFE(sw, "monitor")) {
                                sw.writeAttribute("stackDepth", String.valueOf(monitorInfo.stackDepth()));
                            }
                        }
                    }
                }
            } catch (IncompatibleThreadStateException ignored) {
            }
        }
    }

    private void writeLocationInfo(Location location) throws XMLStreamException {
        try (WFE ignored1 = new WFE(sw, "location")) {
            sw.writeAttribute("declaringType", location.declaringType().name());
            Method method = location.method();
            sw.writeAttribute("method", method.name());
            sw.writeAttribute("methodSignature", method.signature());
            sw.writeAttribute("codeIndex", String.valueOf(location.codeIndex()));
            try {
                sw.writeAttribute("sourceName", location.sourceName());
                sw.writeAttribute("sourcePath", location.sourcePath());
                sw.writeAttribute("lineNumber", String.valueOf(location.lineNumber()));
            } catch (AbsentInformationException ignored) {
            }
        }
    }

    private void writeArgumentsInfo(StackFrame frame) throws XMLStreamException {
        try {
            List<Value> argumentValues = frame.getArgumentValues();
            if (!argumentValues.isEmpty()) {
                try (WFE ignored = new WFE(sw, "arguments")) {
                    for (Value argumentValue : argumentValues) {
                        if (argumentValue != null) {
                            try (WFE ignored1 = new WFE(sw, "argument")) {
                                sw.writeAttribute("type", argumentValue.type().name());
                                sw.writeCharacters(argumentValue.toString());
                            }
                        } else {
                            //noinspection EmptyTryBlock
                            try (WFE ignored1 = new WFE(sw, "null")) {
                            }
                        }
                    }
                }

            }
        } catch (InternalException ignored) {
            // Ignore JDWP Error 35
        }

    }

    private void writeVisibleVariableInfo(StackFrame frame) {
        try {
            List<LocalVariable> localVariables = frame.visibleVariables();
            if (!localVariables.isEmpty()) {
                try (WFE ignored = new WFE(sw, "localVariables")) {
                    Map<LocalVariable, Value> values = frame.getValues(localVariables);
                    for (Map.Entry<LocalVariable, Value> entry : values.entrySet()) {
                        LocalVariable key = entry.getKey();
                        Value value = entry.getValue();
                        try (WFE ignored1 = new WFE(sw, "localVariable")) {
                            sw.writeAttribute("name", key.name());
                            sw.writeAttribute("type", key.typeName());
                            if (value != null) {
                                sw.writeCharacters(value.toString());
                            } else {
                                sw.writeAttribute("null", "true");
                            }
                        }
                    }
                }
            }
        } catch (AbsentInformationException | XMLStreamException ignored) {
        }

    }

    private void writeOpCodeInfo(Location location) {
        long codeIndex = location.codeIndex();
        if (codeIndex == -1) {
            return;
        }
        try {
            ConstantResolver constantResolver = getConstantResolver(location);
            byte[] bytecodes = location.method().bytecodes();
            disassemble(bytecodes, codeIndex, constantResolver);
        } catch (IOException ignored) {
            // TODO: Handle this
        }

    }

    private ConstantResolver getConstantResolver(Location location) throws IOException {
        Method method = location.method();
        ReferenceType declaringType = method.declaringType(); // is it always the same as location declaring type ?
        String classLoaderID = Optional.ofNullable(declaringType.classLoader()).map(ObjectReference::uniqueID).map(String::valueOf).orElse("N");
        String declaringTypeName = declaringType.name();
        String key = classLoaderID + "-" + declaringTypeName;
        ConstantResolver constantResolver = resolvers.get(key);
        if (!resolvers.containsKey(key)) {
            byte[] constantPool = declaringType.constantPool();
            int constantPoolCount = declaringType.constantPoolCount();
            Constant[] constants = ConstantDataInput.readAll(constantPool, constantPoolCount);
            constantResolver = new ConstantResolver(constants);
            resolvers.put(key, constantResolver);
        }
        return constantResolver;
    }

    private void disassemble(byte[] bytecodes, long codeIndex, ConstantResolver constantResolver) {
        if (codeIndex > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Code index too large");
        }
        try {
            Document document = XML.createDocument();
            for (Instruction instruction : InstructionDataInput.parse(bytecodes, (int) codeIndex, 1)) {
                instruction.toXML(document, constantResolver);
            }
            // write document to current output stream but strip xml declaration
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws XMLStreamException {
        sw.writeEndElement();
        sw.writeEndDocument();
        sw.close();
    }
}
