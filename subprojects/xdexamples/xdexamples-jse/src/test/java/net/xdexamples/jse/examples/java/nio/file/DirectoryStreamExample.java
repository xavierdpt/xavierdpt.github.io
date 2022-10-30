package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;
import xd.helpers.dummies.Dummy;

import java.nio.file.DirectoryStream;
import java.util.Iterator;

@Scaffolded
public class DirectoryStreamExample extends BaseExample<DirectoryStream<Dummy>> {

    @Override
    protected void scaffold(DirectoryStream<Dummy> instance) throws Throwable {
        Iterator<Dummy> iterator = instance.iterator();
    }
}
