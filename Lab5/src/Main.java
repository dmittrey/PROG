import utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        FieldsReceiver fieldsReceiver = new FieldsReceiver(console);
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(fieldsReceiver, console);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager, fieldsReceiver, studyGroupFactory);
        CommandReader commandReader = new CommandReader(console, invoker);
        FileWorker fileWorker = new FileWorker(collectionManager);
        console.print(fileWorker.getFromXmlFormat());


//        Date creationDate = new Date();
//        collectionManager.add(new StudyGroup(2323,"dfddwadf", new Coordinates(34,34), creationDate.toString(), 23,
//                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
//        collectionManager.add(new StudyGroup(2324,"dfdf", new Coordinates(34,34), creationDate.toString(), 236,
//                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
        commandReader.enable(false); // Включаемввод команд и передачу их на исполнение
    }
}

/**
 * Осталось доебашить пару команд просто на парсер и скомпилить на хелиос
 *
 * потыкать на хелиос
 *
 * пофиксить табулацию
 *
 * указать где можно null
 *
 * Добавить на хелиос xml
 */
