import commands.CommandAbstract;
import commands.Help;
import utility.CollectionManager;
import utility.CommandReader;
import utility.Console;
import utility.Invoker;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Console console = new Console(scanner);
//        Invoker invoker = new Invoker();
//        CommandReader commandReader = new CommandReader(console, invoker);
//        commandReader.enable();
//
        HashMap<String, CommandAbstract> commandsInfo = new HashMap<>();
        commandsInfo.put("help", new Help(commandsInfo));

        CommandAbstract help = new Help(commandsInfo);
        help.execute();
    }
}
