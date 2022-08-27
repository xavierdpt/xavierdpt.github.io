package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.IOException;
import java.util.List;

public class PowerShellFirewall extends Page {

    public PowerShellFirewall() {
        super("powershell/firewall", "NetFirewallRule", List.of("powershell"));
    }

    @Override
    protected void render(RenderContext renderContext) throws IOException {

        int n = 0;

        section("Create a firewall rule");
        p("Firewall rules have a name and a display name. If the name is not given, as is the case here, it is automatically generated");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule\"""");

        section("Remove a firewall rule by display name");
        p("Note: multiple firewall rules can have the same display name, if you want to remove a specific rule, use the -Name option");
        code("powershell", """
                Remove-NetFirewallRule -DisplayName "Test rule\"""");

        section("Create a disabled firewall rule");
        p("Firewall rule are enabled by default, this option disables it upon creation.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Enabled False""");

        section("Enable a firewall rule");
        p("A firewall rule can be modified in various ways, here this enables all the rules with the given display name.");
        code("powershell", """
                Set-NetFirewallRule -DisplayName "Test rule" -Enabled True""");

        section("Disable new firewall rules by default");
        p("This will se the rules to disabled by default.");
        code("powershell", """
                $PSDefaultParameterValues["New-NetFirewallRule:Enabled"]="False\"""");

        section("Create a firewall rule with a name");
        p("This creates a firewall rule with a specific name");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Name "Test rule\"""");

        section("Create an inbound firewall rule");
        p("Firewall rules are inbound by default, but you can specify it to be more clear, or if the default value may be different.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Direction Inbound""");

        section("Create an outbound firewall rule");
        p("This creates an outbound firewall rule.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Direction Outbound""");

        section("Create a firewall rule that allows traffic");
        p("Firewall allows traffic by default, unless the default value has been changed.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Action Allow""");

        section("Create a firewall rule that blocks traffic");
        p("This creates a firewall that blocks traffic. Nothing is actually blocked because this will be handled by other parameters.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Action Block""");

        section("Create a firewall TCP rule");
        p("This creates a TCP rule, which allows traffic and is enabled by default. But more parameter are required for it to do anything.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP""");

        section("Create a firewall TCP rule");
        p("This creates a TCP rule, which allows traffic and is enabled by default. But more parameter are required for it to do anything.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP""");

        section("Create a TCP firewall rule for remote port 443");
        p("Since by default, it allows traffic, it should not be blocked.");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP -RemotePort 443""");


        section("Example #" + (++n) + ": Block access to all websites");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP -RemotePort 443 -Direction Outbound -Action Block -Enabled True""");

        section("Example #" + (++n) + ": Block all outgoing access for TCP");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP -RemotePort Any -Direction Outbound -Action Block -Enabled True""");

        section("Create a TCP firewall rule for local port 80");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP -LocalPort 80""");

        section("Example #" + (++n) + ": Allow inbound access to TCP 8080");
        code("powershell", """
                New-NetFirewallRule -DisplayName "Test rule" -Protocol TCP -LocalPort 8080 -Direction Inbound -Action Allow -Enabled True""");

        section("TODO");
        code("powershell", """
                New-NetFirewallRule AsJob ...
                New-NetFirewallRule Authentication ...
                New-NetFirewallRule CimSession ...
                New-NetFirewallRule Confirm ...
                New-NetFirewallRule Debug ...
                New-NetFirewallRule Description ...
                New-NetFirewallRule Direction ...
                New-NetFirewallRule DynamicTarget ...
                New-NetFirewallRule EdgeTraversalPolicy ...
                New-NetFirewallRule Encryption ...
                New-NetFirewallRule ErrorAction ...
                New-NetFirewallRule ErrorVariable ...
                New-NetFirewallRule GPOSession ...
                New-NetFirewallRule Group ...
                New-NetFirewallRule IcmpType ...
                New-NetFirewallRule InformationAction ...
                New-NetFirewallRule InformationVariable ...
                New-NetFirewallRule InterfaceAlias ...
                New-NetFirewallRule InterfaceType ...
                New-NetFirewallRule LocalAddress ...
                New-NetFirewallRule LocalOnlyMapping ...
                New-NetFirewallRule LocalPort ...
                New-NetFirewallRule LocalUser ...
                New-NetFirewallRule LooseSourceMapping ...
                New-NetFirewallRule OutBuffer ...
                New-NetFirewallRule OutVariable ...
                New-NetFirewallRule OverrideBlockRules ...
                New-NetFirewallRule Owner ...
                New-NetFirewallRule Package ...
                New-NetFirewallRule PipelineVariable ...
                New-NetFirewallRule Platform ...
                New-NetFirewallRule PolicyStore ...
                New-NetFirewallRule Profile ...
                New-NetFirewallRule Program ...
                New-NetFirewallRule Protocol (other than TCP) ...
                New-NetFirewallRule RemoteAddress ...
                New-NetFirewallRule RemoteDynamicKeywordAddresses ...
                New-NetFirewallRule RemoteMachine ...
                New-NetFirewallRule RemotePort ...
                New-NetFirewallRule RemoteUser ...
                New-NetFirewallRule Service ...
                New-NetFirewallRule ThrottleLimit ...
                New-NetFirewallRule Verbose ...
                New-NetFirewallRule WarningAction ...
                New-NetFirewallRule WarningVariable ...
                New-NetFirewallRule WhatIf ...""");






    }
}
