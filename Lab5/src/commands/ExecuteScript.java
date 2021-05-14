package commands;

import utility.CommandReader;
import utility.Console;
import utility.Invoker;
import utility.TextFormatting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScript extends CommandAbstract{

    private final Invoker invoker;

    public ExecuteScript(Invoker aInvoker){
        super("execute_script", "Read and execute script from entered file");
        invoker = aInvoker;
    }

    @Override
    public String execute(String aArg){
        System.out.println(aArg);
        if (aArg.equals("")) return TextFormatting.getRedText("\tYou should write script path!\n");
        else if (!(invoker.addScriptPath(aArg))) return TextFormatting.getRedText("\tRecursion has been found. " +
                "Please correct your script!\n");
        else {
            invoker.addScriptPath(aArg);
            try {
                Scanner scriptScanner = new Scanner(new File(aArg));
                Console console = new Console(scriptScanner);
                CommandReader commandReader = new CommandReader(console, invoker);
                while (scriptScanner.hasNextLine()) {
                    commandReader.enable(true);
                }
            } catch (FileNotFoundException exception) {
                return TextFormatting.getRedText("\tFile not found!\n");
            }
            invoker.removeScriptPath(aArg);
            return TextFormatting.getGreenText("\n\n\tSuccessful!\n\n");
        }
    }
}
