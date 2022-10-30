package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;

import java.nio.file.FileVisitor;

public class FileVisitorExample extends BaseExample<FileVisitor<Dummy>> {
    @Override
    protected void scaffold(FileVisitor<Dummy> instance) throws Throwable {
/*
postVisitDirectory
preVisitDirectory
visitFile
visitFileFailed
 */
    }
}
