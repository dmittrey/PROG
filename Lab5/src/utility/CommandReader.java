package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс нужен для того, чтобы считать строку из консоли и распарсить строку так, чтобы передать
 * готовую строку и аргументы в Invoker
 * (Напишу этот класс и надо прочитать хорстмана про обобщенное программирование + логика утверждений)
 */
public class CommandReader {

    private final Console console;
    private final Invoker invoker;
    private Pattern commandName;
    private Pattern argName;

    /**
     * Конструктор предназначен для того, чтобы дать читателю команд поток ввода и инвокер,
     * куда перенаправляются команды из потока ввода.
     * @param aConsole - поток ввода
     *                 (тут очень щепетильный момент, можно либо делегировать считывание строк до конца CommandReader
     *                 либо считывать их по одной в main и передавать в CommandReader
     *
     *                 Скорее всего второй вариант выигрышнее потому, что при парсинге файла в FileManager мы будем
     *                 передавать уже готовые строки и получается просто два раза одно и то же пишем
     *
     *                 Скорее всего лучше сделать парсинг в Main и FileManager, а в CommandReader просто оставить
     *                 регулярки для перенаправления команд в Invoker)
     *
     *                 (Ещё один щепетильный момент, следует ли указать console или достаточно указать scanner?
     *
     *                 Скорее всего укажу консоль, тк при вводе некорректных команд буду туда посылать сообщения с ошибкой
     *                 а иначе буду считывать оттуда команды и не надо будет по новой проверять на наличие строки)
     *
     * @param aInvoker - Класс, который служит для указания исполняемой команды и ведёт статистику исполняемых команд
     */
    public CommandReader(Console aConsole, Invoker aInvoker) {
        console = aConsole;
        invoker = aInvoker;
        commandName = Pattern.compile("^\\w+\\s+");
        // Заматчим с строкой
        // Обрежем заматченную строку
        argName = Pattern.compile("^\\w+");
        // Заматчим с оставшейся строкой
    }

    /**
     * Команда для включения CommandReader
     *
     * Будем считывать loop'ом просто до того как строки закончаться, а потом по сути вернется код окончания программы
     *
     * В методе осущетсвляется считывание строки из консоли (априори мы считаем её ненулевой)
     * остается распарсить просто в формат (имя команды, аргументы)
     *
     * Стоит почитать про обобщенное программирование(Там где String ...)
     *
     * !!
     * !!
     * !! пробую считывать на пофиг и потом просто выходить с кодом ноль из прогм!!
     * !!
     * !!
     */

    public void enable(){

        String nextLine = console.readln() + " ";
        String command;
        String arg;

        while (!nextLine.equals("exit ")) {

            nextLine = console.readln() + " ";

            Matcher matcher = commandName.matcher(nextLine);

            if (matcher.find()) {
                command = matcher.group();
                console.print(nextLine);
                console.print(command);

                /**
                 * продумать как вводить аргументы пока не закончаться в строке
                 *
                 * продумать как взять в строку нли аргументы и убрать команду
                 */

                nextLine = nextLine.substring(matcher.end(), (nextLine.length() - matcher.end() + 1));
                console.print(nextLine);

                if (nextLine.length() != 0) {
                    matcher = argName.matcher(nextLine);
                    arg = matcher.group();
                    console.print(matcher);
                } else {
                    console.print("Ввели команду без аргумента");
                }
            } else {
                console.print("Команда введена некорректно, попробуйте ввести еще раз или введите exit для выхода");
            }
        }


    }
}