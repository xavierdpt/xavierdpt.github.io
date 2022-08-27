package trove.pages;

import trove.Languages;
import trove.Page;
import trove.RenderContext;
import trove.TableFormat;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import static java.util.function.Function.identity;

public class PowerShellGetNetAdapterBinding extends Page {

    public PowerShellGetNetAdapterBinding() {
        super("powershell/Get-NetAdapterBinding", "Get-NetAdapterBinding", List.of(Languages.PowerShell));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {
        code(Languages.PowerShell, """
                Get-NetAdapterBinding""");

        p("`ComponentClassName` is a string.");
        p("Example values:");
        ul(linesCode("""
                Client
                Filter
                Service
                Transport"""));
        p("`ComponentID` and `ElementName` are strings.");
        p("Example values grouped by `ComponentClassName`:");
        pw.println("<ul>");
        {
            pw.println("<li>" + markdown("Client") + "<ul>");
            pw.println("<li>" + markdown("`ms_msclient`") + "</li>");
            pw.println("</ul></li>");
        }
        {
            pw.println("<li>" + markdown("Filter") + "<ul>");
            pw.println("<li>" + markdown("`INSECURE_NPCAP`") + "</li>");
            pw.println("<li>" + markdown("`ms_pacer`") + "</li>");
            pw.println("<li>" + markdown("`oracle_VBoxNetLwf`") + "</li>");
            pw.println("</ul></li>");
        }
        {
            pw.println("<li>" + markdown("Service") + "<ul>");
            pw.println("<li>" + markdown("`ms_server`") + "</li>");
            pw.println("</ul></li>");
        }
        {
            pw.println("<li>" + markdown("Transport") + "<ul>");
            pw.println("<li>" + markdown("`ms_implat`") + "</li>");
            pw.println("<li>" + markdown("`ms_lldp`") + "</li>");
            pw.println("<li>" + markdown("`ms_lltdio`") + "</li>");
            pw.println("<li>" + markdown("`vms_pp`") + "</li>");
            pw.println("<li>" + markdown("`ms_rspndr`") + "</li>");
            pw.println("<li>" + markdown("`ms_tcpip`") + "</li>");
            pw.println("<li>" + markdown("`ms_tcpip6`") + "</li>");
            pw.println("</ul></li>");
        }
        pw.println("</ul>");
        p("`Name` is the name of the adapter.");
        p("Except particular cases, all components are bound to all interfaces.");
        p("Example value: `VirtualBox Host-Only Network`");
        sep();
        p("`InterfaceDescription` is the description of the adapter.");
        p("Example value: `VirtualBox Host-Only Ethernet Adapter`");
        sep();
        p("`Description` and `DisplayName` are the localized description string of the component.");
        p("Example values (in French) for each component");
        sep();
        Function<String, String> codeFormatter = s -> markdown("`" + s + "`");
        table(new TableFormat(true,
                        List.of(identity(), identity()),
                        List.of(codeFormatter, codeFormatter)),
                List.of(
                        List.of("Component", "Description"),
                        List.of("ms_msclient", "Client pour les réseaux Microsoft"),
                        List.of("INSECURE_NPCAP", "Npcap Packet Driver (NPCAP)"),
                        List.of("ms_pacer", "Planificateur de paquets QoS"),
                        List.of("oracle_VBoxNetLwf", "VirtualBox NDIS6 Bridged Networking Driver"),
                        List.of("ms_server", "Partage de fichiers et imprimantes Réseaux Microsoft"),
                        List.of("ms_implat", "Protocole de multiplexage de carte réseau Microsoft"),
                        List.of("ms_lldp", "Pilote de protocole LLDP Microsoft"),
                        List.of("ms_lltdio", "Pilote E/S de mappage de découverte de topologie de la couche de liaison"),
                        List.of("ms_rspndr", "Répondeur de découverte de la topologie de la couche de liaison"),
                        List.of("ms_tcpip", "Protocole Internet version 4 (TCP/IPv4)"),
                        List.of("ms_tcpip6", "Protocole Internet version 6 (TCP/IPv6)"),
                        List.of("vms_pp", "Commutateur virtuel extensible Hyper-V")
                )
        );
        sep();
        p("`ComponentClassGuid` is the GUID of the component");
        p("Example value: `{4D36E973-E325-11CE-BFC1-08002BE10318}`");
        sep();
        p("`InstanceID` is the component name qualified with the GUID of the adapter.");
        p("Example value: `{545C58EC-A1C2-468B-ADD7-00E3A9604DA2}::ms_tcpip`");
        sep();
        p("`Caption` is the name bniding class followed by the name of the adapter.");
        p("Example value: `MSFT_NetAdapterBindingSettingData 'VirtualBox Host-Only Ethernet Adapter'`");
        sep();
        p("`Source` is always `1`, possibly unless you do funny things.");
        sep();
        p("`Enabled` is always false for `ms_implat` and  `vms_pp`, always true for the others components.");
        sep();
        p("`BindName` does not always have a value. Here are the values for the components that have one.");
        sep();
        table(new TableFormat(true,
                        List.of(identity(), identity()),
                        List.of(codeFormatter, codeFormatter)),
                List.of(
                        List.of("Component", "Bind Name"),
                        List.of("ms_msclient", "LanmanWorkstation"),
                        List.of("ms_server", "LanmanServer"),
                        List.of("ms_implat", "NdisImPlatform"),
                        List.of("ms_lldp", "MsLldp"),
                        List.of("ms_lltdio", "lltdio"),
                        List.of("ms_rspndr", "rspndr"),
                        List.of("ms_tcpip", "Tcpip"),
                        List.of("ms_tcpip6", "Tcpip6"),
                        List.of("vms_pp", "VMSP")
                )
        );
        sep();
        p("`Characteristics` is dependent on the adapter, and the same for all components");
        p("Example values: `1`, `132`, `161`");
        sep();
        p("`SystemName` is the host name");
        sep();
        p("`PSComputerName` is always blank");
        disclaimer();
    }
}
