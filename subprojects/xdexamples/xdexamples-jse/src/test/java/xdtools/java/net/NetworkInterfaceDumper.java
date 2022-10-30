package xdtools.java.net;

import net.xdexamples.support.ExampleSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xdtools.XMLHelper;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import static xdtools.XMLHelper.addBooleanElement;
import static xdtools.XMLHelper.addElement;
import static xdtools.XMLHelper.addTextElement;

public class NetworkInterfaceDumper {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {

        boolean upOnly = Arrays.stream(args).anyMatch(x -> "-up".equals(x));

        Document document = XMLHelper.createDocument();
        Element root = XMLHelper.createRootElement(document, "networkInterfaces");
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            if (!upOnly || networkInterface.isUp()) {
                describeNetworkInterface(document, root, networkInterface);
            }
        }
        System.out.println(XMLHelper.documentToString(document));
    }

    private static void describeNetworkInterface(Document document, Element root, NetworkInterface ni) throws IOException {
        Element networkInterfaceXML = addElement(document, root, "networkInterface");
        networkInterfaceXML.setAttribute("name", ni.getName());
        networkInterfaceXML.setAttribute("index", String.valueOf(ni.getIndex()));
        addTextElement(document, networkInterfaceXML, "displayName", ni.getDisplayName());
        addBooleanElement(document, networkInterfaceXML, "up", ni.isUp());
        addBooleanElement(document, networkInterfaceXML, "loopback", ni.isLoopback());
        addBooleanElement(document, networkInterfaceXML, "pointToPoint", ni.isPointToPoint());
        addBooleanElement(document, networkInterfaceXML, "virtual", ni.isVirtual());
        addBooleanElement(document, networkInterfaceXML, "multicastSupported", ni.supportsMulticast());
        int mtu = ni.getMTU();
        if (mtu != -1) {
            addTextElement(document, networkInterfaceXML, "MTU", String.valueOf(mtu));
        }
        byte[] hardwareAddress = ni.getHardwareAddress();
        if (hardwareAddress != null && hardwareAddress.length != 0) {
            addTextElement(document, networkInterfaceXML, "hardwareAddress", ExampleSupport.bytesToHex(hardwareAddress));
        }
        List<InterfaceAddress> interfaceAddresses = ni.getInterfaceAddresses();
        if (interfaceAddresses != null && !interfaceAddresses.isEmpty()) {
            Element interfaceAddressesXML = addElement(document, networkInterfaceXML, "interfaceAddresses");
            for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                describeInterfaceAddress(document, interfaceAddressesXML, interfaceAddress);
            }
        }
        Element subInterfacesXML = null;
        Enumeration<NetworkInterface> subInterfaces = ni.getSubInterfaces();
        while (subInterfaces.hasMoreElements()) {
            if (subInterfacesXML == null) {
                subInterfacesXML = addElement(document, networkInterfaceXML, "subinterfaces");
            }
            describeNetworkInterface(document, subInterfacesXML, subInterfaces.nextElement());
        }
    }


    private static void describeInterfaceAddress(Document document, Element parent, InterfaceAddress ia) throws IOException {
        Element element = addElement(document, parent, "interfaceAddress");
        short networkPrefixLength = ia.getNetworkPrefixLength();
        if (networkPrefixLength != -1) {
            addTextElement(document, element, "networkPrefixLength", String.valueOf(networkPrefixLength));
        }
        describeInetAddress(document, element, "broadcast", ia.getBroadcast());
        describeInetAddress(document, element, "address", ia.getAddress());
    }

    private static void describeInetAddress(Document document, Element parent, String name, InetAddress address) throws IOException {
        if (address != null) {
            Element element = addElement(document, parent, name);
            addTextElement(document, element, "address", ExampleSupport.bytesToHex(address.getAddress()));
            addTextElement(document, element, "hostAddress", address.getHostAddress());
            addBooleanElement(document, element, "multicast", address.isMulticastAddress());
            addBooleanElement(document, element, "anyLocal", address.isAnyLocalAddress());
            addBooleanElement(document, element, "loopback", address.isLoopbackAddress());
            addBooleanElement(document, element, "linkLocal", address.isLinkLocalAddress());
            addBooleanElement(document, element, "siteLocal", address.isSiteLocalAddress());
            addBooleanElement(document, element, "MCGlobal", address.isMCGlobal());
            addBooleanElement(document, element, "MCNodeLocal", address.isMCNodeLocal());
            addBooleanElement(document, element, "MCLinkLocal", address.isMCLinkLocal());
            addBooleanElement(document, element, "MCSiteLocal", address.isMCSiteLocal());
            addBooleanElement(document, element, "MCOrgLocal", address.isMCOrgLocal());
        }
    }


}
