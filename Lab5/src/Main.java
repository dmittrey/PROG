import data.*;
import utility.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Указываем стандартный поток ввода
        Console console = new Console(scanner); // Инициализируем объект для общения с пользователем
        ProtectFields protectFields = new ProtectFields(console);
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(protectFields);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager, studyGroupFactory); // Прокси класс
        CommandReader commandReader = new CommandReader(console, invoker); // Делаем класс который передаёт в инвокер
        // вводимые в консоли команды
        String creationDate = "13.05.21";
        collectionManager.add(new StudyGroup(2323,"dfdf", new Coordinates(34,34), creationDate, 23,
                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
        collectionManager.add(new StudyGroup(2324,"dfdf", new Coordinates(34,34), creationDate, 23,
                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
        commandReader.enable(); // Включаем ввод команд и передачу их на исполнение
    }
}
