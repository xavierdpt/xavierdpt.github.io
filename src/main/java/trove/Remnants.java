package trove;

import trove.pages.Home;
import trove.pages.PowerShell;
import trove.pages.PowerShellFunctions;

import java.io.File;
import java.io.IOException;

public class Remnants {
    public static void main(String[] args) throws IOException {

        String basePath = "target/output/";

        {
            File file = new File(basePath + "index.html");
            Home home = new Home();
            //home.render(file);
        }

        mkDir("target/output/powershell");

        {
            File file = new File(basePath + "powershell/index.html");
            PowerShell powerShell = new PowerShell();
            //powerShell.render(file);
        }

        {
            File file = new File(basePath + "powershell/functions.html");
            PowerShellFunctions powerShellFunctions = new PowerShellFunctions();
            //powerShellFunctions.render(file);

        }
    }

    private static void mkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
