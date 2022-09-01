package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterRdma extends Page {

    public GetNetAdapterRdma() {
        super("powershell/Get-NetAdapterRdma", "Get-NetAdapterRdma", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterRdma""");
        p("Result type: ` Microsoft.Management.Infrastructure.CimInstance#ROOT/StandardCimv2/MSFT_NetAdapterRdmaSettingData`");
        section("Common properties");
        p("`Name` is the name of the adapter.");
        sep();
        p("`ElementName`, `Description`, `InterfaceDescription`  is the description of the adapter.");
        sep();
        p("`InstanceId` is the GUID of the adapter.");
        sep();
        p("`Caption` is the description of the adapter prefixed with `MSFT_NetAdapterRdmaSettingData`.");
        sep();
        p("`PSComputerName` is blank.");
        sep();
        p("`SystemName` is the hostname.");
        sep();
        p("`Source` is `2`.");

        section("Number and boolean properties");
        p("`Enabled` is a boolean");
        p("The following properties are integers:");
        ul(linesCode("""
                MaxCompletionQueueCount
                MaxInboundReadLimit
                MaxMemoryRegionCount
                MaxMemoryWindowCount
                MaxOutboundReadLimit
                MaxProtectionDomainCount
                MaxQueuePairCount
                MaxSharedReceiveQueueCount"""));

        section("QosConfiguration");
        p("`ETS` and `PFC` are of type `NetAdapterRdma.QosConfiguration`");
        p("Possible values for `Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapterRdma.QosConfiguration`");
        ul(linesCode("""
                False
                NA
                True"""));
        section(markdown("`RdmaMissingCounterInfo`"));
        p("`RdmaMissingCounterInfo` is of type `MSFT_NetAdapter_RdmaMissingCounterInfo`");
        p("This type exposes the following boolean properties:");
        ul(linesCode("""
                AcceptPerformanceCounterMissing
                ActiveConnectionPerformanceCounterMissing
                CompletionQueueErrorPerformanceCounterMissing
                ConnectFailurePerformanceCounterMissing
                ConnectionErrorPerformanceCounterMissing
                ConnectPerformanceCounterMissing
                RDMAInFramesPerformanceCounterMissing
                RDMAInOctetsPerformanceCounterMissing
                RDMAOutFramesPerformanceCounterMissing
                RDMAOutOctetsPerformanceCounterMissing"""));
        section(markdown("`RdmaAdapterInfo`"));
        explore("Get-NetAdapterRdma","RdmaAdapterInfo");
        /*
   TypeName : Microsoft.Management.Infrastructure.CimInstance#ROOT/StandardCimv2/MSFT_NetAdapter_RdmaAdapterInfo

Name                                       MemberType     Definition
----                                       ----------     ----------
DeviceId                                   Property       uint32 DeviceId {get;}
FRMRPageCount                              Property       uint32 FRMRPageCount {get;}
InOrderDMA                                 Property       bool InOrderDMA {get;}
LargeRequestThreshold                      Property       uint32 LargeRequestThreshold {get;}
MajorVersionNumber                         Property       uint16 MajorVersionNumber {get;}
MaxCalleeData                              Property       uint32 MaxCalleeData {get;}
MaxCallerData                              Property       uint32 MaxCallerData {get;}
MaxCompletionQueueDepth                    Property       uint32 MaxCompletionQueueDepth {get;}
MaxInboundReadLimit                        Property       uint32 MaxInboundReadLimit {get;}
MaxInitiatorQueueDepth                     Property       uint32 MaxInitiatorQueueDepth {get;}
MaxInitiatorRequestSge                     Property       uint32 MaxInitiatorRequestSge {get;}
MaxInlineDataSize                          Property       uint32 MaxInlineDataSize {get;}
MaxOutboundReadLimit                       Property       uint32 MaxOutboundReadLimit {get;}
MaxReadRequestSge                          Property       uint32 MaxReadRequestSge {get;}
MaxReceiveQueueDepth                       Property       uint32 MaxReceiveQueueDepth {get;}
MaxReceiveRequestSge                       Property       uint32 MaxReceiveRequestSge {get;}
MaxRegistrationSize                        Property       uint64 MaxRegistrationSize {get;}
MaxSharedReceiveQueueDepth                 Property       uint32 MaxSharedReceiveQueueDepth {get;}
MaxTransferLength                          Property       uint32 MaxTransferLength {get;}
MaxWindowSize                              Property       uint64 MaxWindowSize {get;}
MinorVersionNumber                         Property       uint16 MinorVersionNumber {get;}
PSComputerName                             Property       string PSComputerName {get;}
RdmaReadSinkFlagNotRequired                Property       bool RdmaReadSinkFlagNotRequired {get;}
SupportsCompletionQueueInterruptModeration Property       bool SupportsCompletionQueueInterruptModeration {get;}
SupportsCompletionQueueResize              Property       bool SupportsCompletionQueueResize {get;}
SupportsLoopbackConnections                Property       bool SupportsLoopbackConnections {get;}
SupportsMultiEngine                        Property       bool SupportsMultiEngine {get;}
VendorId                                   Property       uint32 VendorId {get;}
RdmaTechnology                             ScriptProperty System.Object RdmaTechnology {get=[Microsoft.PowerShell.Cmdletization.GeneratedTypes.NetAdapterRdma.Technology]($this.PSBase.CimInstanceProperties['RdmaTechnology'].Value);}
         */
        disclaimer();
    }
}
