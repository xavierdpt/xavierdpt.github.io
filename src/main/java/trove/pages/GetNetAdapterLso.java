package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterLso extends Page {

    public GetNetAdapterLso() {
        super("powershell/Get-NetAdapterLso", "Get-NetAdapterLso", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterLso""");
        section("Properties common to other commands");
        p("`Name` is the name of the adapter.");
        sep();
        p("`ElementName`, `Description`, `InterfaceDescription` is the description of the adapter.");
        sep();
        p("`Caption` is the description of the adapter prefixed with `MSFT_NetAdapterLsoSettingData`.");
        sep();
        p("`InstanceID` is the GUID of the adapter.");
        sep();
        p("`SystemName` is the hostname.");
        sep();
        p("`PSComputerName` is blank.");
        sep();
        p("`Source` is `2`.");
        section("Boolean and number properties");
        p("There are three boolean properties in this command:");
        ul(linesCode("""
                IPv4Enabled
                IPv6Enabled
                V1IPv4Enabled"""));
        p("`MaximumLsoVersionSupported` is the only number property.");
        section(markdown("`LargeSendOffloadV1HardwareCapabilities`"));
        code(Languages.PowerShell, """
                $v1 = (Get-NetAdapterLso).LargeSendOffloadV1HardwareCapabilities""");
        p("Two boolean properties");
        ul(linesCode("""
                IPv4IpOptionsSupported
                IPv4TcpOptionsSupported
                """));
        p("Two number properties");
        ul(linesCode("""
                IPv4IpOptionsSupported
                IPv4TcpOptionsSupported
                """));
        p("`PSComputerName` is blank");
        section(markdown("`LargeSendOffloadV1HardwareCapabilities.IPv4Encapsulation`"));
        code(Languages.PowerShell, """
                $v1Encapsulation = ($v1).IPv4Encapsulation""");
        p("Boolean properties:");
        ul(linesCode("""
                NdisEncapsulationIeee802_3
                NdisEncapsulationIeee802_3pAndq
                NdisEncapsulationIeee802_3PAndQInOob
                NdisEncapsulationIeeLlcSnapRouted
                NdisEncapsulationNotNull
                NdisEncapsulationNotSupported
                """));
        p("`PSComputerName` is blank");
        section(markdown("`LargeSendOffloadV2HardwareCapabilities`"));
        code(Languages.PowerShell, """
                $v2 = (Get-NetAdapterLso).LargeSendOffloadV2HardwareCapabilities""");
        p("Two boolean properties");
        ul(linesCode("""
                IPv6IpExtensionHeadersSupported
                IPv6TcpOptionsSupported
                """));
        p("Four number properties");
        ul(linesCode("""
                IPv4MaxOffloadSizeSupported
                IPv4MinSegmentCountSupported
                IPv6MaxOffLoadSizeSupported
                IPv6MinSegmentCountSupported
                """));
        p("`PSComputerName` is blank");
        section(markdown("`LargeSendOffloadV2HardwareCapabilities.IPv4Encapsulation`"));
        code(Languages.PowerShell, """
                $v2_Ipv4Encapsulation = ($v2).IPv4Encapsulation""");
        p("It's probably the same thing as for V1");
        section(markdown("`LargeSendOffloadV2HardwareCapabilities.IPv6Encapsulation`"));
        code(Languages.PowerShell, """
                $v2_Ipv6Encapsulation = ($v2).IPv6Encapsulation""");
        p("Boolean properties:");
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
