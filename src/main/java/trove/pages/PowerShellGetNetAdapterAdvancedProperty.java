package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellGetNetAdapterAdvancedProperty extends Page {

    public PowerShellGetNetAdapterAdvancedProperty() {
        super("powershell/Get-NetAdapterAdvancedProperty", "Get-NetAdapterAdvancedProperty", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterAdvancedProperty""");
        p("Network adapters can have custom properties defined for them");
        properties();
        summary();
    }


    private void properties() {
        section("Properties");

        p("The `Name` property is the name of the adapter in which the property is defined");
        p("Example value: `Wi-Fi`");
        sep();
        p("The `RegistryKeyword` property has the internal name of the advanced property, prefixed with \"`*`\" when it is a required property.");
        p("Example value: `*DeviceSleepOnDisconnect`");
        sep();
        p("The `InstanceID` property is the GUID of the adapter with the internal name of the advanced property.");
        p("Example value: `{D8332A15-3AB0-46F3-95FA-8EC5422775A7}::*DeviceSleepOnDisconnect`");
        sep();
        p("The `Optional` property tell whether the advanced property is mandatory or not.");
        sep();
        p("The `Description`, `DisplayName` and `ElementName` have the same localized values.");
        p("Example value (in French): `Veille à la déconnexion WoWLAN`");
        sep();
        p("The `InterfaceDescription` is the adapter's interface description.");
        p("Example value: `Hyper-V Virtual Ethernet Adapter`");
        sep();
        p("The `Caption` is the interface description prefixed with the object's class name.");
        p("Example value: `MSFT_NetAdapterAdvancedPropertySettingData 'Hyper-V Virtual Ethernet Adapter'`");
        sep();
        p("The `RegistryDataType` is always `1`.");
        sep();
        p("The `DisplayDataType` is `1`, `5` or `6`. It seems that 1 is for numbers");
        sep();
        p("The `NumericParameterBaseValue` is always 10.");
        p("The `NumericParameterStepValue` is always 1.");
        p("The `NumericParameterMinValue` is 0, 1 or 100.");
        p("The `NumericParameterMaxValue` is 63, 64 or 1500.");
        sep();
        p("The `Source` is always `3`.");
        sep();
        p("The `RegistryValue` and `DefaultRegistryValue` are numbers.");
        p("Example value for `RegistryValue`: {3}");
        p("Example value for `DefaultRegistryValue`: 3");
        sep();
        p("The `DisplayValue` and `DefaultDisplayValue` property can be numbers, text strings or localized text strings.");
        p("Example value for `DisplayValue` and `DefaultDisplayValue` : `8`, `Enabled`, `1. Aucune préférence`, `RTS/CTS activée`");
        sep();
        p("The `ValidRegistryValues` property contains list of numbers, exposed in a string type.");
        p("Example 1: `{0,1,2,3}`");
        p("Example 1: `{1514,4088,9014}`");
        sep();
        p("The `ValidDisplayValues` property contains list texts, exposed in a string type.");
        p("Example 1: `{Disabled, Tx Enabled, Rx Enabled, Rx & Tx Enabled}`");
        p("Example 2: `{Disabled, 4088 Bytes, 9014 Bytes}`");
        sep();
        sep();
        p("The `SystemName` property has the host name as a string.");
        p("The `PSComputerName` property was always blank.");
    }

    private void summary() {
        section("Summary of available properties for some adapters");

        p("This shows the list of all advanced properties available for some network adapters, together with the available display values.");

        pw.println("<ul>");
        pw.println("<li>HyperV</li><ul>");
        {
            pw.println("<li>IPv4 Checksum Offload (" + markdown("`IPChecksumOffloadIPv4`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Tx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx & Tx Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>IPSec Offload (" + markdown("`IPsecOffloadV2`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Auth Header Enabled`") + "</li>");
            pw.println("<li>" + markdown("`ESP Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Auth Header and ESP Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Jumbo Packet (" + markdown("`JumboPacket`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`4088 Bytes`") + "</li>");
            pw.println("<li>" + markdown("`9014 Bytes`") + "</li>");
            pw.println("<li>" + markdown("`Auth Header and ESP Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Large Send Offload Version 2 (IPv4) (" + markdown("`LsoV2IPv4`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Large Send Offload Version 2 (IPv6) (" + markdown("`LsoV2IPv6`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Maximum Number of RSS Processors (" + markdown("`MaxRssProcessors`") + ")<ul>");
            pw.println("<li>1 - 64</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Network Direct (RDMA) (" + markdown("`NetworkDirect`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Maximum Number of RSS Queues (" + markdown("`NumRSSQueues`") + ")<ul>");
            pw.println("<li>1 - 64</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Recv Segment Coalescing (IPv4) (" + markdown("`RscIPv4`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Recv Segment Coalescing (IPv6) (" + markdown("`RscIPv6`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Receive Side Scaling (" + markdown("`RSS`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>RSS Base Processor Number (" + markdown("`RssBaseProcNumber`") + ")<ul>");
            pw.println("<li>0 - 63</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Maximum RSS Processor Number (" + markdown("`RssMaxProcNumber`") + ")<ul>");
            pw.println("<li>0 - 63</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>RSS Profile (" + markdown("`RSSProfile`") + ")<ul>");
            pw.println("<li>" + markdown("`Closest Processor`") + "</li>");
            pw.println("<li>" + markdown("`Closest Processor Static`") + "</li>");
            pw.println("<li>" + markdown("`NUMA Scaling`") + "</li>");
            pw.println("<li>" + markdown("`NUMA Scaling Static`") + "</li>");
            pw.println("<li>" + markdown("`Conservative Scaling`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>TCP Checksum Offload (IPv4) (" + markdown("`TCPChecksumOffloadIPv4`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Tx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx & Tx Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>TCP Checksum Offload (IPv6) (" + markdown("`TCPChecksumOffloadIPv6`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Tx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx & Tx Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>UDP Checksum Offload (IPv4) (" + markdown("`UDPChecksumOffloadIPv4`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Tx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx & Tx Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>UDP Checksum Offload (IPv6) (" + markdown("`UDPChecksumOffloadIPv6`") + ")<ul>");
            pw.println("<li>" + markdown("`Disabled`") + "</li>");
            pw.println("<li>" + markdown("`Tx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx Enabled`") + "</li>");
            pw.println("<li>" + markdown("`Rx & Tx Enabled`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Network Address (" + markdown("`NetworkAddress`") + ")");
            pw.println("</li>");
        }
        pw.println("</ul>");
        pw.println("<li>Wi-Fi<ul>");
        {
            pw.println("<li>Veille à la déconnexion WoWLAN (" + markdown("`DeviceSleepOnDisconnect`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Fusion des paquets (" + markdown("`PacketCoalescing`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Délestage ARP pour WoWLAN (" + markdown("`PMARPOffload`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Délestage NS pour WoWLAN (" + markdown("`PMNSOffload`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Régénération des clés GTK pour WoWLAN (" + markdown("`PMWiFiRekeyOffload`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Wake on Magic Packet (" + markdown("`WakeOnMagicPacket`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Correspondance au modèle WOL (" + markdown("`WakeOnPattern`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Blocage général du scan BG (" + markdown("`BgScanGlobalBlocking`") + ")<ul>");
            pw.println("<li>" + markdown("`Jamais`") + "</li>");
            pw.println("<li>" + markdown("`Lorsque RSSI est bon`") + "</li>");
            pw.println("<li>" + markdown("`Toujours`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Largeur de canal pour 2,4 GHz (" + markdown("`ChannelWidth24`") + ")<ul>");
            pw.println("<li>" + markdown("`20 MHz`") + "</li>");
            pw.println("<li>" + markdown("`Auto`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Largeur de canal pour 5 GHz (" + markdown("`ChannelWidth52`") + ")<ul>");
            pw.println("<li>" + markdown("`20 MHz`") + "</li>");
            pw.println("<li>" + markdown("`Auto`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Protection en mode mixte (" + markdown("`CtsToItself`") + ")<ul>");
            pw.println("<li>" + markdown("`RTS/CTS activée`") + "</li>");
            pw.println("<li>" + markdown("`Auto-CTS activée`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Incompatible avec canaux de 40 MHz (" + markdown("`FatChannelIntolerant`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Puissance de transmission (" + markdown("`IbssTxPower`") + ")<ul>");
            pw.println("<li>" + markdown("`1. Min.`") + "</li>");
            pw.println("<li>" + markdown("`2. Faible`") + "</li>");
            pw.println("<li>" + markdown("`3. Moyenne`") + "</li>");
            pw.println("<li>" + markdown("`4. Élevée`") + "</li>");
            pw.println("<li>" + markdown("`5. Max.`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Mode sans fil?802.11n/ac/ax (" + markdown("`IEEE11nMode`") + ")<ul>");
            pw.println("<li>" + markdown("`1. Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`2. 802.11n`") + "</li>");
            pw.println("<li>" + markdown("`3. 802.11ac`") + "</li>");
            pw.println("<li>" + markdown("`4. 802.11ax`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>MIMO – Mode économie d'énergie (" + markdown("`MIMOPowerSaveMode`") + ")<ul>");
            pw.println("<li>" + markdown("`SMPS auto`") + "</li>");
            pw.println("<li>" + markdown("`SMPS statique`") + "</li>");
            pw.println("<li>" + markdown("`SMPS dynamique`") + "</li>");
            pw.println("<li>" + markdown("`SMPS désactivé`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Agressivité de l'itinérance (" + markdown("`RoamAggressiveness`") + ")<ul>");
            pw.println("<li>" + markdown("`1. Min.`") + "</li>");
            pw.println("<li>" + markdown("`2. Faible`") + "</li>");
            pw.println("<li>" + markdown("`3. Moyenne`") + "</li>");
            pw.println("<li>" + markdown("`4. Élevée`") + "</li>");
            pw.println("<li>" + markdown("`5. Max.`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Bande privilégiée (" + markdown("`RoamingPreferredBandType`") + ")<ul>");
            pw.println("<li>" + markdown("`1. Aucune préférence`") + "</li>");
            pw.println("<li>" + markdown("`2. Préférer bande 2,4 GHz`") + "</li>");
            pw.println("<li>" + markdown("`3. Préférer la bande 5 GHz`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Multiplicateur de débit (" + markdown("`ThroughputBoosterEnabled`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Assistance U-APSD (" + markdown("`uAPSDSupport`") + ")<ul>");
            pw.println("<li>" + markdown("`Désactivé(e)`") + "</li>");
            pw.println("<li>" + markdown("`Activé(e)`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Mode sans fil 802.11a/b/g (" + markdown("`WirelessMode`") + ")<ul>");
            pw.println("<li>" + markdown("`1. 5 GHz 802.11a`") + "</li>");
            pw.println("<li>" + markdown("`2. 2,4 GHz 802.11b`") + "</li>");
            pw.println("<li>" + markdown("`3. 2,4 GHz 802.11g`") + "</li>");
            pw.println("<li>" + markdown("`4. 2,4 GHz 802.11b/g`") + "</li>");
            pw.println("<li>" + markdown("`5. Dual Band 802.11a/g`") + "</li>");
            pw.println("<li>" + markdown("`6. Dual Band 802.11a/b/g`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        pw.println("</ul>");
        pw.println("</li>");
        pw.println("<li>VPN</li><ul>");
        {
            pw.println("<li>Non-Admin Access (" + markdown("`AllowNonAdmin`") + ")<ul>");
            pw.println("<li>" + markdown("`Not Allowed`") + "</li>");
            pw.println("<li>" + markdown("`Allowed`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>Media Status (" + markdown("`MediaStatus`") + ")<ul>");
            pw.println("<li>" + markdown("`Application Controlled`") + "</li>");
            pw.println("<li>" + markdown("`Always Connected`") + "</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>MTU (" + markdown("`MTU`") + ")<ul>");
            pw.println("<li>100 - 1500</li>");
            pw.println("</ul>");
            pw.println("</li>");
        }
        {
            pw.println("<li>MAC Address (" + markdown("`NetworkAddress`") + ")");
            pw.println("</li>");
        }
        pw.println("</ul>");
        pw.println("</ul>");

    }
}
