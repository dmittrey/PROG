package utility;


import commands.*;

import java.util.*;

/**
 * В инвокере должны лежать команды, чтобы я мог их вызвать и по сути еще ссылки на сторонние классы
 * чтобы можно было через обратный вызов обращаться из команд к этим классам
 */

public class Invoker {

    private final Console console;
    private final CollectionManager collectionManager;
    private final HashMap<String, CommandAbstract> commands;
    private final ProtectFields protectFields;
    private final StudyGroupFactory studyGroupFactory;
    private final Queue previousCommands;

    public Invoker(Console aConsole, CollectionManager aCollectionManager, ProtectFields aProtectFields,
                   StudyGroupFactory aStudyGroupFactory) {

        protectFields = aProtectFields;
        console = aConsole;
        collectionManager = aCollectionManager;
        commands = new HashMap<>();
        studyGroupFactory = aStudyGroupFactory;
        previousCommands = new LinkedList<String>();
        initMap();
    }

    private void initMap(){
        commands.put("help", new Help(commands));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add", new Add(studyGroupFactory, collectionManager));
        commands.put("update", new UpdateId(studyGroupFactory, collectionManager, protectFields));
//         вот тут можно просто пройтись по всем объектам коллекции и найти тот у которого id совпадет, а потом просто наебнуть
        // пройтись по коллекции до конца попутно удаляя старый файл с id, ищя файл со старым id и ожидая конца коллекции

//        commands.put("remove_by_id id", new RemoveById()); //" - remove an element from the collection by ID" + " You should to enter ID after entering a command");

        //это тоже самое что выше
        commands.put("clear", new Clear(collectionManager)); //" - clear the collection");
//        commands.put("save", new Save()); //" - save the collection to file");
//        commands.put("execute_script", new ExecuteScript()); //" - read and execute a script from specified file" + " You should to enter path to file after entering a command");
        commands.put("add_if_max", new AddIfMax(studyGroupFactory, collectionManager));
        commands.put("add_if_min", new AddIfMin(studyGroupFactory, collectionManager));
        commands.put("history", new History(previousCommands, console)); //" - print the last 14 commands (without their arguments)");
        commands.put("min_by_students_count", new MinByStudentsCount(collectionManager)); //" - print any object from the collection whose "+ "studentsCount field value is minimal");
//        commands.put("count_less_than_students_count", new CountLessThanStudentsCount()); //"print the number of elements whose "+ "studentsCount field value is less than the specified one");
//        commands.put("filter_starts_with_name", new FilterStartsWithName()); //" - output elements whose name field value starts with"+ " the specified substring");
    }


    public void execute(String aCommand, String aArg){

        if (commands.containsKey(aCommand)){
            if (previousCommands.size() > 13) previousCommands.remove();
            previousCommands.add(aCommand);

            console.print(commands.get(aCommand).execute(aArg));
        } else {
            console.print(TextFormatting.getRedText("Command not found. Please, try again!\n"));
        }
    }


}
