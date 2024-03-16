package com.github.xavierdpt.jvmspect.workflow;

import com.github.xavierdpt.jvmspect.JVMSpectConstants;
import com.github.xavierdpt.jvmspect.input.clazz.ClassInfo;
import com.github.xavierdpt.jvmspect.input.clazz.ClassInfoDataInput;
import com.github.xavierdpt.jvmspect.utils.FileHelper;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassFileDumper {

    public static void generateXMLFiles(boolean force) throws IOException, TransformerException {
        File extractDir = new File(JVMSpectConstants.LOCAL_DIR, JVMSpectConstants.MODULES_EXTRACTED);
        File xmlDir = new File(JVMSpectConstants.LOCAL_DIR, JVMSpectConstants.JAVAXML);
        FileHelper.ensureDir(xmlDir);
        if (force) {
            FileHelper.cleanDir(xmlDir);
        }
        if (FileHelper.isEmpty(xmlDir)) {
            XMLJavaFileSupplier xmlJavaFileNameSupplier = new XMLJavaFileSupplier(xmlDir);
            goThrough(extractDir, xmlJavaFileNameSupplier);
        }
    }

    private static void goThrough(File file, XMLJavaFileSupplier xmlJavaFileNameSupplier) throws IOException, TransformerException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    goThrough(f, xmlJavaFileNameSupplier);
                }
            }
        } else {
            handleFile(file, xmlJavaFileNameSupplier);
        }
    }

    private static void handleFile(File inputFile, XMLJavaFileSupplier xmlJavaFileSupplier) throws IOException, TransformerException {
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            DataInputStream dis = new DataInputStream(fis);
            if (readMagic(dis)) {
                ClassInfo classInfo = ClassInfoDataInput.read(dis);
                Document xml = classInfo.toXML();
                File outFile = xmlJavaFileSupplier.get();
                try (FileOutputStream fileOutputStream = new FileOutputStream(outFile)) {
                    XML.writeDocument(xml, fileOutputStream);
                }
            }
        }
    }


    private static boolean readMagic(DataInputStream dis) throws IOException {
        int magic = dis.readInt();
        return 0xCAFEBABE == magic;
    }

}
