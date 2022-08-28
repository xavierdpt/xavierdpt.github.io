package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterChecksumOffload extends Page {

    public GetNetAdapterChecksumOffload() {
        super("powershell/Get-NetAdapterChecksumOffload", "Get-NetAdapterChecksumOffload", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterChecksumOffload""");
        String href = internalLink(renderContext.getPageByClass(PowerShellGetNetAdapterAdvancedProperty.class), renderContext);
        p("This function gets some of the advanced properties available in " + href + ".");
        section("Main object");
        p("`Name` is the name of the adapter");
        p("Example value: `vEthernet (Default Switch)`");
        sep();
        p("`Description`, `ElementName` and `InterfaceDescription` are the description of the adapter");
        p("Example value: `Hyper-V Virtual Ethernet Adapter`");
        sep();
        p("`Caption` is the description of the adapter prefixed with the class name.");
        p("Example value: `MSFT_NetAdapterChecksumOffloadSettingData 'Hyper-V Virtual Ethernet Adapter'`");
        sep();
        p("`InstanceID` is the GUID of the adapter.");
        p("Example value: `{DABC4D36-0A7F-4009-8CD9-D0A9337960B6}`");
        sep();
        p("`Source` is `2`.");
        sep();
        p("`SystemName` is the host name.");
        sep();
        p("`PSComputerName` is blank.");
        sep();
        p("`ChecksumOffloadHardwareCapabilities` is a CIM object.");
        p("Example value when rendered as a string: `MSFT_NetAdapterChecksumOffloadCapabilities`");
        sep();
        p("`IpIPv4Enabled`, `TcpIPv4Enabled`, `TcpIPv6Enabled`, `UdpIPv4Enabled`, `UdpIPv6Enabled` are enum values of type `NetAdapterChecksumOffload.Direction`.");
        p("They have all this value: `RxTxEnabled`");
        section(markdown("`NetAdapterChecksumOffload.Direction`"));
        p("Possible values for `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapterChecksumOffload.Direction`:");
        ul(linesCode("""
                Disabled
                RxEnabled
                RxTxEnabled
                TxEnabled"""));
        section(markdown("`ChecksumOffloadHardwareCapabilities`"));
        code(Languages.PowerShell, """
                $cap=(Get-NetAdapterChecksumOffload).ChecksumOffloadHardwareCapabilities""");
        p("The following booleans were all true (there's only data for the HyperV adapter)");
        ul(linesCode("""
                IPv4ReceiveIpChecksumSupported
                IPv4ReceiveIpOptionsSupported
                IPv4ReceiveTcpChecksumSupported
                IPv4ReceiveTcpOptionsSupported
                IPv4ReceiveUdpChecksumSupported
                IPv4TransmitIpChecksumSupported
                IPv4TransmitIpOptionsSupported
                IPv4TransmitTcpChecksumSupported
                IPv4TransmitTcpOptionsSupported
                IPv4TransmitUdpChecksumSupported
                IPv6ReceiveIpExtensionHeadersSupported
                IPv6ReceiveTcpChecksumSupported
                IPv6ReceiveTcpOptionsSupported
                IPv6ReceiveUdpChecksumSupported
                IPv6TransmitIpExtensionHeadersSupported
                IPv6TransmitTcpChecksumSupported
                IPv6TransmitTcpOptionsSupported
                IPv6TransmitUdpChecksumSupported
                """));
        p("`PSComputerName` is blank");
        section("Encapsulation");
        p("The following objects have the same properties with the same values:");
        ul(linesCode("""
                IPv4ReceiveEncapsulation
                IPv4TransmitEncapsulation
                IPv6ReceiveEncapsulation
                IPv6TransmitEncapsulation
                """));
        code(Languages.PowerShell, """
                $IPv4Receive = ($cap).IPv4ReceiveEncapsulation""");
        p("They have more boolean properties, among with only `NdisEncapsulationIeee802_3` is true, the others are false.");
        ul(linesCode("""
                NdisEncapsulationIeee802_3
                NdisEncapsulationIeee802_3pAndq
                NdisEncapsulationIeee802_3PAndQInOob
                NdisEncapsulationIeeLlcSnapRouted
                NdisEncapsulationNotNull
                NdisEncapsulationNotSupported
                """));
        p("`PSComputerName` is blank");
        disclaimer();

    }
}
