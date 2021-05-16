import data.*;
import org.xml.sax.SAXException;
import utility.*;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        ProtectFields protectFields = new ProtectFields(console);
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(protectFields);
        CollectionManager collectionManager = new CollectionManager();
        Invoker invoker = new Invoker(console, collectionManager, protectFields, studyGroupFactory);
        CommandReader commandReader = new CommandReader(console, invoker);
        FileWorker fileWorker = new FileWorker(collectionManager, console);
        //collectionManager.setCollection(fileWorker.parse());

        String creationDate = "13.05.21";
        collectionManager.add(new StudyGroup(2323,"dfddwadf", new Coordinates(34,34), creationDate, 23,
                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
        collectionManager.add(new StudyGroup(2324,"dfdf", new Coordinates(34,34), creationDate, 23,
                null, null, Semester.SECOND, new Person("awdawd", 344, Color.BLACK)));
        commandReader.enable(false); // Включаемввод команд и передачу их на исполнение
    }
}
