package utility;


import commands.*;

import java.util.HashMap;
import java.util.Set;

/**
 * В инвокере должны лежать команды, чтобы я мог их вызвать и по сути еще ссылки на сторонние классы
 * чтобы можно было через обратный вызов обращаться из команд к этим классам
 */

public class Invoker {

    private final Console console;
    private final CollectionManager collectionManager;
    private HashMap<String, CommandAbstract> commands;

    public Invoker(Console aConsole, CollectionManager aCollectionManager){

        console = aConsole;
        collectionManager = aCollectionManager;
        commands = new HashMap<>();
        initMap();
    }

    private void initMap(){
        commands.put("help", new Help(commands));
        commands.put("info", new Info(collectionManager));
//        commands.put("show", new Show()); //" - print all elements in string representation to standard output");
//        commands.put("add", new Add()); //" - add new element to the collection");
//        commands.put("update id", new UpdateId()); // " - update the element`s value, whose ID is equal to the given"+ " You should to enter ID after entering a command");
//        commands.put("remove_by_id id", new RemoveById()); //" - remove an element from the collection by ID" + " You should to enter ID after entering a command");
//        commands.put("clear", new Clear()); //" - clear the collection");
//        commands.put("save", new Save()); //" - save the collection to file");
//        commands.put("execute_script", new ExecuteScript()); //" - read and execute a script from specified file" + " You should to enter path to file after entering a command");
//        commands.put("exit", new Exit()); //" - end the program (without saving to file)");
//        commands.put("add_if_max", new AddIfMax()); //" - add new element to the collection, if it`s value greater, "+ "than biggest element of this collection. You should to enter characteristics of"+ " comparing element after entering a command.");
//        commands.put("add_if_min", new AddIfMin()); //" - add new element to the collection, if it`s value less, "+ "than smallest element of this collection. You should to enter characteristics of" + " comparing element after entering a command.");
//        commands.put("history", new History()); //" - print the last 14 commands (without their arguments)");
//        commands.put("min_by_students_count", new MinByStudentsCount()); //" - print any object from the collection whose "+ "studentsCount field value is minimal");
//        commands.put("count_less_than_students_count", new CountLessThanStudentsCount()); //"print the number of elements whose "+ "studentsCount field value is less than the specified one");
//        commands.put("filter_starts_with_name", new FilterStartsWithName()); //" - output elements whose name field value starts with"+ " the specified substring");
    }


    public void execute(String aCommand, String aArg){

        if (commands.containsKey(aCommand)){
            console.print(commands.get(aCommand).execute(aArg));
        } else {
            console.print("Command is incorrect. Please, try again.");
        }
    }


}
