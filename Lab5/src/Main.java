import utility.CommandReader;
import utility.Console;
import utility.Invoker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Указываем стандартный поток ввода
        Console console = new Console(scanner); // Инициализируем обхект для общения с пользователем
        Invoker invoker = new Invoker(console); // Прокси класс
        CommandReader commandReader = new CommandReader(console, invoker); // Делаем класс который передаёт в инвокер
        // вводимые в консоли команды
        commandReader.enable(); // Включаем ввод команд и передачу их на исполнение
    }
}
