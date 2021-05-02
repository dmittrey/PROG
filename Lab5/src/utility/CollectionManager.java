package utility;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionManager {

    private final HashSet<data.StudyGroup> studyGroups;

    private File xmlCollection;

    private ZonedDateTime initializationDate;

    private boolean wasStart;

    private HashMap<String, String> commandsInfo;

    {
        wasStart = false;
        studyGroups = new HashSet<>();

        commandsInfo = new HashMap<>();
        commandsInfo.put("help", " - display help for available commands");
        commandsInfo.put("info", " - print information about the collection (type, initialization date, "
                + "number of elements, etc.) to standard output");
        commandsInfo.put("show", " - print all elements in string representation to standard output");
        commandsInfo.put("add {element}", " - add new element to the collection");
        commandsInfo.put("update id {element}", " - update the element`s value, whose ID is equal to the given"
                + " You should to enter ID after entering a command");
        commandsInfo.put("remove_by_id id", " - remove an element from the collection by ID"
                + " You should to enter ID after entering a command");
        commandsInfo.put("clear", " - clear the collection");
        commandsInfo.put("save", " - save the collection to file");
        commandsInfo.put("execute_script file_name", " - read and execute a script from specified file"
                + " You should to enter path to file after entering a command");
        commandsInfo.put("exit", " - end the program (without saving to file)");
        commandsInfo.put("add_if_max {element}", " - add new element to the collection, if it`s value greater, "
                + "than biggest element of this collection. You should to enter characteristics of"
                + " comparing element after entering a command.");
        commandsInfo.put("add_if_min {element}", " - add new element to the collection, if it`s value less, "
                + "than smallest element of this collection. You should to enter characteristics of"
                + " comparing element after entering a command.");
        commandsInfo.put("history", " - print the last 14 commands (without their arguments)");
        commandsInfo.put("min_by_students_count", " - print any object from the collection whose "
                + "studentsCount field value is minimal");
        commandsInfo.put("count_less_than_students_count studentsCount", "print the number of elements whose "
                + "studentsCount field value is less than the specified one");
        commandsInfo.put("filter_starts_with_name name", " - output elements whose name field value starts with"
                + " the specified substring");

    }
}
