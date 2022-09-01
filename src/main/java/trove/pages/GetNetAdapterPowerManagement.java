package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterPowerManagement extends Page {
    public GetNetAdapterPowerManagement() {
        super("powershell/Get-NetAdapterPowerManagement", "Get-NetAdapterPowerManagement", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterPowerManagement""");
        section("Common properties");
        p("`Name` is the name of the adapter");
        sep();
        p("`ElementName`, `Description` and `InterfaceDescription` are the description of the adapter");
        sep();
        p("`Caption` is the interface description prefixed with `MSFT_NetAdapterPowerManagementSettingData`");
        sep();
        p("`InstanceID` is the GUID of the adapter");
        sep();
        p("`Source` is `2` or `3`");
        sep();
        p("`SystemName` is the hostname");
        sep();
        p("`PSComputerName` is blank");
        section(markdown("`OffloadParameters`"));
        code(Languages.PowerShell, """
                $offloadParameters = (Get-NetAdapterPowerManagement).OffloadParameters""");
        p("This contains an an array of objects of diverse types.");
        section(markdown("`OffloadParameters` : `MSFT_NetAdapterPowerManagement_Offload_NS`"));
        p("`FriendlyName` is `ND Offload`");
        sep();
        p("`ID` is an integer");
        sep();
        p("`MacAddress` is a string");
        p("Example value: `D4-BE-D9-8D-46-9A`");
        sep();
        p("`OffloadType` is an integer");
        sep();
        p("`Priority` is a large integer");
        sep();
        p("`PSComputerName` is blank");
        sep();
        p("`RemoteIPv6Address` is string");
        p("Example value: `::`");
        sep();
        p("`SolicitedNodeIPv6Address` is string representing an IPv6 address");
        p("Example value: `2001:db8::1234:5678`");
        sep();
        p("`TargetIPv6Addresses` is a list of strings representing IPv6 addresses.");
        p("Example value: `{2001:db8::1234:5678, ::}`");

        section(markdown("`OffloadParameters` : `MSFT_NetAdapterPowerManagement_Offload_Arp`"));
        p("`FriendlyName` is `ARP Offload`");
        sep();
        p("`HostIPv4Address` is a string representing an IPv4 address");
        p("Example value: `192.168.0.1`");
        sep();
        p("`ID` is an integer");
        sep();
        p("`MACAddress` is a string representing a MAC address");
        p("Example value: `D4-BE-D9-8D-46-9A`");
        sep();
        p("`OffloadType` is an integer");
        sep();
        p("`Priority` is a large integer");
        sep();
        p("`PSComputerName` is blank");
        sep();
        p("`RemoteIPv4Address` is a string representing an IPv4 address");
        p("Example value: `0.0.0.0`");

        section(markdown("`WakePatterns`"));
        code(Languages.PowerShell, """
                $wakePatterns = (Get-NetAdapterPowerManagement).WakePatterns""");
        p("This contains an an array of objects of diverse types.");

        section(markdown("`WakePatterns` : `MSFT_NetAdapterPowerManagement_WakePattern_MagicPacket`"));
        p("`FriendlyName` is a string, typically `Magic Packet`");
        sep();
        p("`ID` is an integer");
        sep();
        p("`Priority` is an integer");
        sep();
        p("`PSComputerName` is blank");
        sep();
        p("`WakePacketType` is an integer");

        section(markdown("`WakePatterns` : `MSFT_NetAdapterPowerManagement_WakePattern_TcpSyn`"));
        p("`FriendlyName` is a string, usually blank");
        sep();
        p("`ID` is an integer");
        sep();
        p("`Priority` is an integer");
        sep();
        p("`PSComputerName` is blank");
        sep();
        p("`WakePacketType` is an integer");
        sep();
        p("`DestinationAddress` is an string that can represent an IPv4 or an IPv6 address.");
        p("Example values: `::`, `0.0.0.0`");
        sep();
        p("`DestinationPort` is an integer that can be 0");
        sep();
        p("`SourceAddress` is an string that can represent an IPv4 or an IPv6 address.");
        p("Example values: `::`, `0.0.0.0`");
        sep();
        p("`SourcePort` is an integer that can be 0");

        section(markdown("`WakePatterns` : `MSFT_NetAdapterPowerManagement_WakePattern_Bitmap`"));
        p("`FriendlyName` is a string");
        p("Example values:");
        ul(linesCode("""
                TCP PortCoalescedPattern
                UDP PortCoalescedPattern
                TCP V4 Packet
                TCP V6 Packet
                NCB:Inbox Client - WNS/EAS
                """));
        sep();
        p("`ID` is an integer");
        sep();
        p("`Priority` is a possibly very large integer");
        sep();
        p("`PSComputerName` is blank");
        sep();
        p("`WakePacketType` is an integer, usually `1`");
        sep();
        p("`Mask and Pattern are arrays of bytes`");
        section("Settings");
        p("The following properties are of type `NetAdapterPowerManagement.Setting`:");
        ul(linesCode("""
                AllowComputerToTurnOffDevice
                ArpOffload
                D0PacketCoalescing
                DeviceSleepOnDisconnect
                NSOffload
                RsnRekeyOffload
                SelectiveSuspend
                WakeOnMagicPacket
                WakeOnPattern"""));
        p("Possible values for `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapterPowerManagement.Setting`:");
        ul(linesCode("""
                Disabled
                Enabled
                Inactive
                Unsupported"""));
        disclaimer();
    }
}

