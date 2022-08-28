package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class GetNetAdapterIPsecOffload extends Page {

    public GetNetAdapterIPsecOffload() {
        super("powershell/Get-NetAdapterIPsecOffload", "Get-NetAdapterIPsecOffload",
                List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterIPsecOffload""");
        p("On my system, I had only data for one adapter.");
        sep();
        p("Boolean properties");
        ul(linesCode("""
                AhEnabled
                AhEspCombinedEnabled
                AhEspCombinedSupported
                AhSupported
                Enabled
                EspEnabled
                EspSupported
                IPv4OptionsEnabled
                IPv4OptionsSupported
                IPv6Enabled
                IPv6NonIPsecExtensionHeadersEnabled
                IPv6NonIPsecExtensionHeadersSupported
                IPv6Supported
                LsoEnabled
                LsoSupported
                TransportEnabled
                TransportSupported
                TunnelEnabled
                TunnelSupported"""));
        p("Number properties");
        ul(linesCode("""
                SaOffloadCapacityEnabled
                SaOffloadCapacitySupported
                Source
                UdpEspEnabled
                UdpEspSupported"""));
        section("String properties");
        String powerShellGetNetAdapter = internalLink(renderContext.getPageByClass(PowerShellGetNetAdapter.class), renderContext);
        p("`Name` is the name of the adapter, as it appears in " + powerShellGetNetAdapter);
        sep();
        p("`ElementName`, `Description` and `InterfaceDescription` are the description of the adapter");
        sep();
        p("`Caption` is the description of the adapter, prefixed with `MSFT_NetAdapterIPsecOffloadV2SettingData`");
        sep();
        p("`InstanceID` is the GUID of the interface");
        sep();
        p("`SystemName` is the hostname");
        sep();
        p("`PSComputerName` is empty");
        section("List of strings properties");
        p("`AuthenticationAlgorithmsEnabled` and `AuthenticationAlgorithmsSupported` are list of authentication algorithms");
        p("Example values include:");
        ul(linesCode("""
                MD5
                SHA1
                SHA256
                AESGCM128
                AESGCM192
                AESGCM256"""));
        p("`EncryptionAlgorithmsEnabled` and `EncryptionAlgorithmsSupported` are list of encryption algorithms");
        p("Example values include:");
        ul(linesCode("""
                DESCBC
                DES3CBC
                AESGCM128
                AESGCM192
                AESGCM256
                AESCBC128
                AESCBC192
                AESCBC256"""));
        disclaimer();
    }
}
