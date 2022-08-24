package trove.pages;

import trove.Page;
import trove.RenderContext;

import java.io.FileNotFoundException;
import java.util.List;

public class PowerShellFunctions extends Page {
    public PowerShellFunctions() {
        super("powershell/functions", "PowerShell Functions", List.of("powershell"));
    }

    @Override
    public void render(RenderContext renderContext) throws FileNotFoundException {

        section("An empty function");
        code("powershell", """
                function foo {}
                foo""");

        section("A function that returns a constant");
        code("powershell", """
                function foo { 5 }
                foo""");

        section("A function that returns its argument");
        code("powershell", """
                function foo {
                    param($x)
                    $x
                }
                foo 5""");

        section("A function that returns its argument and it's an integer");
        code("powershell", """
                function foo {
                    param([int]$x)
                    $x
                }
                foo 5""");

        section("A function that returns its argument plus one");
        code("powershell", """
                function foo {
                    param([int]$x)
                    $x + 1
                }
                foo 5""");

        section("A function that takes it's argument from the pipeline");
        code("powershell", """
                function foo {
                    param(
                        [Parameter(ValueFromPipeline)]
                        [int]$x
                    )
                    $x + 1
                }
                3 | foo""");

        section("A function that can accept multiple values from the pipeline");
        code("powershell", """
                function foo {
                    param(
                        [Parameter(ValueFromPipeline)]
                        [int]$x
                    )
                    process { $x + 1 }
                }
                1,2,3 | foo""");

        section("A function that does something only once at the beginning of the pipeline and at the end of the pipeline");
        code("powershell", """
                function foo {
                    param(
                        [Parameter(ValueFromPipeline)]
                        [int]$x
                    )
                    begin { "Let's do this!" }
                    process { $x + 1 }
                    end { "That was a piece of cake!" }
                }
                1,2,3 | foo""");

        section("A function with a mandatory argument");
        code("powershell", """
                function foo {
                    param(
                        [Parameter(Mandatory)]
                        [int]$x
                    )
                    $x + 1
                }
                foo # PowerShell will ask for the value of x""");


    }
}
