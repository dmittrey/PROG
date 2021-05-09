package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandReader {

    private final Console console;
    private final Invoker invoker;
    private Pattern commandName;
    private Pattern argName;

    /**
     * Конструктор предназначен для того, чтобы дать читателю команд поток ввода и инвокер,
     * куда перенаправляются команды из потока ввода.
     * @param aConsole - поток ввода
     *
     * @param aInvoker - Класс, который служит для указания исполняемой команды и ведёт статистику исполняемых команд
     */

    /**
     * Продумать момент как через инвокер отключить CommandReader
     */

    public CommandReader(Console aConsole, Invoker aInvoker) {
        console = aConsole;

        invoker = aInvoker;

        commandName = Pattern.compile("^\\w+\\s+");

        argName = Pattern.compile("^\\w+");
    }

    public void enable() {

        String nextLine;
        String exitSave = "";
        String command;
        String arg;

        while (!exitSave.equals("exit ")) {

            nextLine = console.readln() + " ";
            exitSave = nextLine;

            Matcher matcher = commandName.matcher(nextLine);

            if (matcher.find()) {
                command = matcher.group();
            } else {
                System.out.println("Command is incorrect. Please, try again.");
                continue;
            }

            nextLine = nextLine.substring(command.length());
            matcher = argName.matcher(nextLine);

            if (matcher.find()) {
                arg = matcher.group();
            } else {
                arg = "";
            }

            if (!command.equals("exit ")) invoker.execute(command.trim(), arg);
        }
    }
}