package xdtest.javax.xml.namespace;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;

public class QNameTest {

    @Test
    public void testLocalPart() {
        QName qName = new QName("localPart");
        Assert.assertEquals("localPart", qName.getLocalPart());
        Assert.assertEquals("",qName.getNamespaceURI());
        Assert.assertEquals("",qName.getPrefix());
        Assert.assertEquals("localPart",qName.toString());
    }

    @Test
    public void testLocalPartAndNamespace() {
        QName qName = new QName("namespace","localPart");
        Assert.assertEquals("localPart", qName.getLocalPart());
        Assert.assertEquals("namespace",qName.getNamespaceURI());
        Assert.assertEquals("",qName.getPrefix());
        Assert.assertEquals("{namespace}localPart",qName.toString());
    }

    @Test
    public void testLocalPartAndNamespaceAndPrefix() {
        QName qName = new QName("namespace","localPart","prefix");
        Assert.assertEquals("localPart", qName.getLocalPart());
        Assert.assertEquals("namespace",qName.getNamespaceURI());
        Assert.assertEquals("prefix",qName.getPrefix());
        Assert.assertEquals("{namespace}localPart",qName.toString());
    }

    @Test
    public void testStringToLocalPart() {
        QName qName = QName.valueOf("localPart");
        Assert.assertEquals("localPart", qName.getLocalPart());
        Assert.assertEquals("",qName.getNamespaceURI());
        Assert.assertEquals("",qName.getPrefix());
        Assert.assertEquals("localPart",qName.toString());
    }
    @Test
    public void testStringToLocalPartAndPrefix() {
        QName qName = QName.valueOf("{namespace}localPart");
        Assert.assertEquals("localPart", qName.getLocalPart());
        Assert.assertEquals("namespace",qName.getNamespaceURI());
        Assert.assertEquals("",qName.getPrefix());
        Assert.assertEquals("{namespace}localPart",qName.toString());
    }

}
