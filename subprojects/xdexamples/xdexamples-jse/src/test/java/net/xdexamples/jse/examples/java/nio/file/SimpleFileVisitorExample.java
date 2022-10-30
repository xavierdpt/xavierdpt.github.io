package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;

import java.nio.file.SimpleFileVisitor;

public class SimpleFileVisitorExample extends BaseExample<SimpleFileVisitor<Dummy>> {
    @Override
    protected void scaffold(SimpleFileVisitor<Dummy> instance) throws Throwable {
/*
postVisitDirectory
preVisitDirectory
visitFile
visitFileFailed
 */
    }
}
