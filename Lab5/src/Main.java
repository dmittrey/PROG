import utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        FieldsReceiver fieldsReceiver = new FieldsReceiver(console);
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(fieldsReceiver);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager, fieldsReceiver, studyGroupFactory);
        CommandReader commandReader = new CommandReader(console, invoker);
        FileWorker fileWorker = new FileWorker(collectionManager);
        console.print(fileWorker.getFromXmlFormat());
        commandReader.enable(false);
    }
}
