package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterHardwareInfo extends Page {

    public GetNetAdapterHardwareInfo() {
        super("powershell/Get-NetAdapterHardwareInfo", "Get-NetAdapterHardwareInfo",
                List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterHardwareInfo""");
        p("On my system, I had only data for one adapter.");
        sep();
        p("The following are boolean properties:");
        ul(linesCode("""
                Dma64BitSupported
                LineBasedInterrupts
                LineBasedInterruptSupported
                MsiEnabled
                MsiInterruptSupported
                MsiSupported
                MsiXEnabled
                MsiXInterruptSupported
                MsiXSupported
                NoInterrupt
                S0WakeupSupported
                """));
        p("The following are number properties, many of which are related to PCI hardware configuration:");
        ul(linesCode("""
                NumaNode
                BusNumber
                DeviceNumber
                FunctionNumber
                MaxInterruptMessages
                NumMsiMessages
                NumMsixTableEntries
                PciCurrentSpeedAndMode
                PciDeviceLabelID
                PciDeviceType
                PciExpressCurrentLinkSpeedEncoded
                PciExpressCurrentLinkWidth
                PciExpressCurrentPayloadSize
                PciExpressMaxLinkSpeedEncoded
                PciExpressMaxLinkWidth
                PciExpressMaxPayloadSize
                PciExpressMaxReadRequestSize
                PciExpressVersion
                PciXCurrentSpeedAndMode
                SegmentNumber
                SlotNumber
                Source
                """));
        p("The following properties can receive values among a fixed set of possibilities.");
        sep();
        p("`CurrentSpeedAndMode`");
        ul(linesCode("""
                Conventional PCI 33MHz
                Conventional PCI 66MHz
                PCI-X Mode conventional PCI
                PCI-X Mode1 66MHz
                PCI-X Mode1 100MHz
                PCI-X Mode1 133MHz
                PCI-X Mode1 ECC 66MHz
                PCI-X Mode1 ECC 100MHz
                PCI-X Mode1 ECC 133MHz
                PCI-X Mode2 266 66MHz
                PCI-X Mode2 266 100MHz
                PCI-X Mode2 266 133MHz
                PCI-X Mode2 533 66MHz
                PCI-X Mode2 533 100MHz
                PCI-X Mode2 533 133MHz
                Unknown
                NA"""));
        p("`DeviceType`");
        ul(linesCode("""
                Conventional PCI
                PCI-X
                PCI Express endpoint
                PCI Express legacy endpoint
                PCI Express Root Complex integrated endpoint
                PCI Express treated as PCI
                Unknown"""));
        p("`PcieLinkSpeed` and `PcieMaxLinkSpeed`");
        ul(linesCode("""
                2.5 GT/s
                5.0 GT/s
                8.0 GT/s
                Unknown"""));
        p("`SriovSupport`");
        ul(linesCode("""
                1.0
                1.1"""));

        p("`LocationInformationString` is the location of the device on the PCI bus");
        sep();
        p("`InstanceID` is the GUID of the adapter");
        sep();
        p("`Name` is the name of the adapter");
        sep();
        p("`Description`, `ElementName`, `InterfaceDescription` is the description of the adapter");
        sep();
        p("`Caption` is the description of the adapter prefixed with `MSFT_NetAdapterHardwareInfoSettingData`");
        sep();
        p("`Version` is a string that looks like `x.y`");
        sep();
        p("`PciDeviceLabelString` is  blank");
        sep();
        p("`SystemName` is the host name, as usual");
        sep();
        p("`PSComputerName` is blank, as usual");
        sep();
        p("`MsixMessageAffinityArray` is a list CIM objects with two integer properties: `ProcessorGroup` and `ProcessorAffinityMask`");
        disclaimer();
    }
}
