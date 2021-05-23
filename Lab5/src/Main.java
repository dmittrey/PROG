import utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        FieldsReceiver fieldsReceiver = new FieldsReceiver(console);
        CollectionManager collectionManager = new CollectionManager();
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(fieldsReceiver, collectionManager);
        Invoker invoker = new Invoker(console, collectionManager, fieldsReceiver, studyGroupFactory);
        CommandReader commandReader = new CommandReader(console, invoker);
        FileWorker fileWorker = new FileWorker(collectionManager, console);
        console.print(fileWorker.getFromXmlFormat());
        commandReader.enable(false);
    }
}
