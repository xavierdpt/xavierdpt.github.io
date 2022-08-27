package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellGetNetAdapter extends Page {

    public PowerShellGetNetAdapter() {
        super("powershell/Get-NetAdapter", "Get-NetAdapter", List.of("powershell"));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code("powershell", """
                Get-NetAdapter""");

        p("The `Get-NetAdapter` command exposes `MSFT_NetAdapter` instances with 121 properties. Some of them have no values for any adapters, some properties expose the same information as other properties in different ways. This is an attempt to find some rhyme and reason to the available information.");
        sep();
        p("Here's a command that should display most of what you could be looking for, feel free to remove anything you would not be interested in.");
        code("powershell", """
                Get-NetAdapter | Select-Object Name,DriverDescription,DriverProvider,ComponentID,PnPDeviceID,`
                DriverName,InterfaceName,MediaType,DriverDate,DriverVersion,NdisVersion,DeviceID,InterfaceIndex,`
                HigherLayerInterfaceIndices,LowerLayerInterfaceIndices,MacAddress,PermanentAddress,MtuSize,LinkSpeed,`
                AdminStatus,ifOperStatus,MediaConnectionState,Status,SystemName,AdminLocked,Hidden,IMFilter,`
                iSCSIInterface,PromiscuousMode,NotUserRemovable,ConnectorPresent,Virtual,WdmInterface,`
                DeviceWakeUpEnable,OperationalStatusDownDefaultPortNotAuthenticated,`
                OperationalStatusDownInterfacePaused,OperationalStatusDownLowPowerState,`
                OperationalStatusDownMediaDisconnected,EnabledDefault,State,RequestedState,TransitioningToState,`
                PortNumber,EnabledState,NdisMedium,NdisPhysicalMedium,InterfaceAdminStatus,InterfaceType,NetLuid,`
                NetLuidIndex,EndPointInterface,HardwareInterface,FullDuplex,CreationClassName,`
                SystemCreationClassName | Out-GridView""");

        stringInformation();
        datesAndVersions();
        guids();
        indices();
        mac();
        mtu();
        speed();
        updown();
        other();

        section("Properties with no values");
        p("The following properties had no values for any adapters.");
        ul(linesCode("""                                
                AdditionalAvailability
                AutoSense
                Availability
                AvailableRequestedStates
                Caption
                CommunicationStatus
                Description
                DetailedStatus
                ElementName
                ErrorCleared
                ErrorDescription
                HealthState
                IdentifyingDescriptions
                InstallDate
                LastErrorCode
                LinkTechnology
                MaxQuiesceTime
                MaxSpeed
                OperatingStatus
                OperationalStatus
                OtherEnabledState
                OtherIdentifyingInfo
                OtherLinkTechnology
                OtherNetworkPortType
                OtherPortType
                PortType
                PowerManagementCapabilities
                PowerManagementSupported
                PowerOnHours
                PrimaryStatus
                PSComputerName
                RequestedSpeed
                StatusDescriptions
                StatusInfo
                SupportedMaximumTransmissionUnit
                TimeOfLastStateChange
                TotalPowerOnHours
                UsageRestriction
                VlanID"""));

    }

    private void speed() {
        section("Speed");

        p("The `Speed`, `ReceiveLinkSpeed` and `TransmitLinkSpeed` propertiess exposes the interface speed as a 64-bit unsigned integer.");
        p("Example values in increasing order: `0`, `866700000`, `1000000000`, `10000000000`, `100000000000`");
        sep();
        p("The `LinkSpeed` property exposes the interface speed as a formatted string.");
        p("Example values in increasing order: `0 bps`, `866.7 Mbps`, `1 Gbps`, `10 Gbps`, `100 Gbps`");
    }

    private void mac() {
        section("MAC address");

        p("MAC addresses are available in `MacAddress` and `LinkLayerAddress` as strings.");
        p("Example value: `00-B0-D0-63-C2-26`.");
        sep();
        p("The same information is available in the `NetworkAddresses` property as a string too.");
        p("Example value: `{00B0D063C226}`.");
        sep();
        p("The same information is available in the `PermanentAddress` property as a string too, but was different from the MAC address for HyperV.");
        p("Example value: `00B0D063C226`.");

    }

    private void mtu() {
        section("MTU");

        p("The Maximum Transmission Unit can be found in `MtuSize` as an unsigned 32-bit integer" +
                " and in  `ActiveMaximumTransmissionUnit` as an unsigned 64-bit integer");
        p("Example values: `0`, `1500`, `6535`.");
    }

    private void updown() {
        section("Up or down");

        p("A number of properties are related to whether the adapter is up, down, or something in-between.");

        p("The `AdminStatus` property exposes an enum value of type `NET_IF_ADMIN_STATUS`. Most adapters were `Up` according to this property.");
        p("Values in `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapter.NET_IF_ADMIN_STATUS` include:");
        ul(linesCode("""
                Down
                Testing
                Up"""));

        p("The `ifOperStatus` property exposes an enum value of type `IF_OPER_STATUS`. VPN adapters were `Down` according to this property," +
                "other adapters were `Up`, one adapter had `NotPresent`.");
        p("Values in `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapter.IF_OPER_STATUS` include:");
        ul(linesCode("""
                Dormant
                Down
                LowerLayerDown
                NotPresent
                Testing
                Unknown
                Up"""));
        p("The `InterfaceOperationalStatus` property seems to expose `ifOperStatus` as an unsigned 32-bit integer with the corresponding enum's number.");
        sep();
        p("The `MediaConnectionState` property exposes an enum value of type `NET_IF_MEDIA_CONNECT_STATE`. VPNs appeared `Disconnected`, wifi, virtual box and HyperV `Connected`, and another appeared as `Unknown`.");
        p("Values in `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapter.NET_IF_MEDIA_CONNECT_STATE` include:");
        ul(linesCode("""
                Connected
                Disconnected
                Unknown"""));
        p("The `MediaConnectState` property seems to expose `MediaConnectionState` as an unsigned 32-bit integer with the corresponding enum's number.");
        p("The `Status` property seems to expose `MediaConnectionState` as a string, but with different values:");
        ul(linesCode("""
                Up
                Disconnected
                Not Present"""));
    }

    private void other() {
        section("Other properties");
        p("The `SystemName` property is the computer name.");
        sep();
        p("The `AdminLocked` property was always false on my system.");
        sep();
        p("The `Hidden` property was always false on my system.");
        sep();
        p("The `IMFilter` property was always false on my system.");
        sep();
        p("The `iSCSIInterface` property was always false on my system.");
        sep();
        p("The `PromiscuousMode` property was always false on my system.");
        sep();
        p("The `NotUserRemovable` property was true only for HyperV.");
        sep();
        p("The `ConnectorPresent` property was true only for wifi.");
        sep();
        p("The `Virtual` property was false only for wifi.");
        sep();
        p("The `WdmInterface` property was true for some but not others.");
        sep();
        p("The `DeviceWakeUpEnable` property was true only for wifi.");
        sep();
        p("The `OperationalStatusDownDefaultPortNotAuthenticated` property was always false.");
        sep();
        p("The `OperationalStatusDownInterfacePaused` property was always false.");
        sep();
        p("The `OperationalStatusDownLowPowerState` property was always false.");
        sep();
        p("The `OperationalStatusDownMediaDisconnected` property was true for some adapters.");
        sep();
        p("The `EnabledDefault` property was always `2` as an unsigned 16-bit integer.");
        sep();
        p("The `State` property was always `2` as an unsigned 32-bit integer.");
        sep();
        p("The `RequestedState` property was always `12` as an unsigned 16-bit integer.");
        sep();
        p("The `TransitioningToState` property was always `12` as an unsigned 16-bit integer.");
        sep();
        p("The `PortNumber` property was always `0` as an unsigned 16-bit integer.");
        sep();
        p("The `EnabledState` property was always `5` as an unsigned 16-bit integer.");
        sep();
        p("The `NdisMedium` property is a 32-bit unsigned integer, which was mostly `0`, but `16` for on adapter, and `19` for another.");
        p("The `NdisPhysicalMedium` property is a 32-bit unsigned integer, which was mostly `0`, but `9` for on adapter, and `14` for another, " +
                "and not the same adapters as above except wifi which had values for both properties..");
        sep();
        p("The `InterfaceAdminStatus` is exposed as an unsigned 32-bit integer. It was `1` for most adapters, `2` for one adapter.");
        sep();
        p("The `InterfaceType` is exposed as an unsigned 32-bit integer.");
        p("Example values: `6`, `53`, `71`.");
        sep();
        p("The `NetLuid` property is an unsigned 64-bit integer which hold large values.");
        p("Example value: `14918723538255872`");
        sep();
        p("The `NetLuidIndex` property is an unsigned 32-bit integer which hold values typically around 32768.");
        p("Example values: `32768`, `32769`, `32774`, `32777`, `32778`");
        sep();
        p("The `EndpointInterface` property was true only for the VirtualBox adapter.");
        sep();
        p("The `HardwareInterface` property was true only for wifi.");
        sep();
        p("The `FullDuplex` property was true for the VirtualBox and OpenVPN adapters, false for wifi, empty for others .");
        p("The `MediaDuplextState` seems to expose the same information as a 32-bit unsigned integer," +
                " with `0` for nothing, `1` for `False` and `2` for `True` .");
        sep();
        p("The `CreationClassName` property represents the underlying object class presented by the CIM object, " +
                "because `Get-NetAdapter` uses CIM session to retrieve the information. In this case, it is `MSFT_NetAdapter`.");
        sep();
        p("The `SystemCreationClassName` was always `CIM_NetworkPort`.");
    }

    private void indices() {
        section("Interface indices");

        p("The `InterfaceIndex` property exposes a 32-bit unsigned integers.");
        p("The `ifIndex` property contains the same information.");
        sep();
        p("The `HigherLayerInterfaceIndices` and `LowerLayerInterfaceIndices` properties are arrays of 32-bit unsigned integers.");
        p("On my system, `HigherLayerInterfaceIndices` had exactly one value for each adapter.");
        p("On my system, `LowerLayerInterfaceIndices` had one value for HyperV, nothing for the other adapters.");
    }

    private void guids() {
        section("GUIDs");

        p("The `DeviceID` property exposes a GUID as a string with braces.");
        p("The `InterfaceGuid` and `InstanceID` properties exposes the same information.");
        p("Example value: `{545C58EC-A1C2-468B-ADD7-00E3A9604DA2}`");
        sep();
        p("The `DeviceName` property exposes the same GUID prefixed with `\\Device\\`");
        p("Example value: `\\Device\\{545C58EC-A1C2-468B-ADD7-00E3A9604DA2}`");
    }

    private void datesAndVersions() {
        section("Date and version information");

        p("The `DriverInformation` property contains the driver date, version and NDIS in a string.");
        p("Example value: `Driver Date 2022-07-19 Version 6.1.36.2435 NDIS 6.0`");
        sep();
        p("The `DriverDate` property exposes a date as a string");
        p("Example value: `2022-07-19`");
        sep();
        p("The `DriverDateData` property exposes `DriverDate` as a 64-bit unsigned integer.");
        p("Example value: `133026624000000000`");
        sep();
        p("The driver's version is available in `DriverVersion` and `DriverVersionString` as a string.");
        p("Example value: `6.1.36.2435`.");
        sep();
        p("The driver's NDIS version is available in `DriverMajorNdisVersion` and `DriverMinorNdisVersion` as bytes.");
        p("Example values: `6` and `30`.");
        sep();
        p("The full NDIS version is available in `NdisVersion`.");
        p("Example value: `6.30`");
        sep();
        p("The driver's version is available in `MajorDriverVersion` and `MinorDriverVersion` as 16-bit unsigned integers.");
        p("Example values: `9` and `24`.");
    }

    private void stringInformation() {
        section("String information");

        p("The `Name` property contains a string identifier.");
        p("The `InterfaceAlias` and `ifAlias` properties contains the same information.");
        p("Example value: `VirtualBox Host-Only Network`");
        sep();
        p("The `DriverDescription` property contains additional useful information about the driver.");
        p("The `InterfaceDescription` and `ifDesc` properties contains the same information.");
        p("Possible values include:");
        ul(linesCode("""
                Cisco AnyConnect Secure Mobility Client Virtual Miniport Adapter for Windows x64
                Hyper-V Virtual Ethernet Adapter
                Intel(R) Wi-Fi 6 AX200 160MHz
                TAP-Windows Adapter V9
                VirtualBox Host-Only Ethernet Adapter
                Wintun Userspace Tunnel"""));

        p("The `DriverProvider` property contains the company name that developed the driver. Possible values include:");
        ul(linesCode("""
                Cisco Systems
                Intel
                Microsoft
                Oracle Corporation
                TAP-Windows Provider V9
                WireGuard LLC"""));

        p("The Hardware ID, aka PnP component ID, is available in `ComponentID`. Possible values include:");
        ul(linesCode("""
                PCI\\VEN_8086&DEV_2723&SUBSYS_40808086
                root\\tap0901
                sun_vboxnetadp
                vms_mp
                VPNVA
                Wintun"""));

        p("The `PnPDeviceID` holds somewhat similar but different information");
        ul(linesCode("""
                PCI\\VEN_8086&DEV_2723&SUBSYS_40808086&REV_1A\\4&1d510a7f&0&00E0
                ROOT\\NET\\0000
                ROOT\\NET\\0001
                ROOT\\NET\\0002
                ROOT\\NET\\0003
                ROOT\\VMS_MP\\0000"""));

        p("The `DriverFileName` property contains the name of the driver file. Possible values include:");
        ul(linesCode("""
                Netwtw10.sys
                tap0901.sys
                VBoxNetAdp6.sys
                VmsProxyHNic.sys
                vpnva64-6.sys
                wintun.sys"""));

        p("The `DriverName` property contains the path to the driver file.");
        p("Example value: `\\SystemRoot\\system32\\DRIVERS\\VBoxNetAdp6.sys`");
        sep();
        p("The `InterfaceName` property contains a string prefix and a number suffix.");
        p("The `ifName` property contains the same information.");
        p("Example value: ` ethernet_32774`");
        p("Possible prefixes:");
        ul(linesCode("""
                ethernet
                iftype53
                wireless"""));
        p("The `MediaType` property contains a string with the following possible values on my system:");
        ul(linesCode("""
                IP
                Native 802.11
                802.3"""));
        p("The `PhysicalMediaType` property is the same for some adapters, but `Unspecified` for others:");
        ul(linesCode("""
                Unspecified
                Native 802.11
                802.3"""));
    }
}
