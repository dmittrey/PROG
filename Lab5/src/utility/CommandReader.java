package utility;

import javax.xml.ws.spi.Invoker;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Класс нужен для чтения команд из консоли и предоставлять формулировки команд с аргументами в invoker
 */

public class CommandReader {
    private final Scanner scanner;
    private final Invoker invoker;
    private final Pattern commandNamePattern;
    private final Pattern argPattern;

    /**
     * @param scanner - is used to read commands from console
     * @param invoker - invoker which wil execute received commands
     */

    public CommandReader(Scanner aScanner, Invoker aInvoker){
        scanner = aScanner;
        invoker = aInvoker;
        commandNamePattern = Pattern.compile("^\\w+");
        argPattern = Pattern.compile("\\b(.*\\s*)*");

        /**
         * Тут используются регулярки(Надо посмотреть что за класс Pattern и что за статический метод compile)
         * Также надо посмотреть регулярки в java
         */
    }

    /**
     * Начинаем читать команды Loop'ом
     * Loop читает команды и вызывает инвокер для того чтобы выполнить их
     * Loop завершается если на вход подаётся пустая строка или мы вызвали команду exit()
     */

    public void activeMode() {
        String line;
        String command;
        String arg;
        do {

            try {
                line = scanner.nextLine();
            } catch (NoSuchElementException exception) {
                break;
            }

            Matcher matcher = commandNamePattern.matcher(line);

            if (matcher.find()) {
                command =matcher.group();
            } else {
                System.out.println("Input is not a command");
                continue;
            }

            line = line.substring(command.length());
            matcher = argPattern.matcher(line);

            if (matcher.find()) {
                arg = matcher.group();
            } else {
                arg = "";
            }
            invoker.execute(command, arg);
        } while (!invoker.isStopRequesting() && scanner.hasNext());
    }
}
