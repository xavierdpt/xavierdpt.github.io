package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;
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
