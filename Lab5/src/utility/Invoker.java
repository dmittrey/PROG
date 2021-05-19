package utility;


import commands.*;
import utility.Interfaces.InvokerInterface;

import java.util.*;

public class Invoker implements InvokerInterface {

    private final Console console;
    private final CollectionManager collectionManager;
    private final Map<String, CommandAbstract> commands;
    private final FieldsReceiver fieldsReceiver;
    private final StudyGroupFactory studyGroupFactory;
    private final Queue<String> previousCommands;
    private final Set<String> executedScripts;
    private final FileWorker fileWorker;

    public Invoker(Console aConsole, CollectionManager aCollectionManager, FieldsReceiver aFieldsReceiver,
                   StudyGroupFactory aStudyGroupFactory) {

        fieldsReceiver = aFieldsReceiver;
        console = aConsole;
        collectionManager = aCollectionManager;
        commands = new HashMap<>();
        studyGroupFactory = aStudyGroupFactory;
        previousCommands = new LinkedList<>();
        executedScripts = new HashSet<>();
        fileWorker = new FileWorker(collectionManager);
        initMap();
    }

    private void initMap() {
        commands.put("help", new Help(commands));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add", new Add(studyGroupFactory, collectionManager));
        commands.put("update", new UpdateId(studyGroupFactory, collectionManager, fieldsReceiver));
        commands.put("remove_by_id", new RemoveById(collectionManager, fieldsReceiver));
        commands.put("clear", new Clear(collectionManager));
        commands.put("save", new Save(fileWorker));
        commands.put("execute_script", new ExecuteScript(this));
        commands.put("add_if_max", new AddIfMax(studyGroupFactory, collectionManager));
        commands.put("add_if_min", new AddIfMin(studyGroupFactory, collectionManager));
        commands.put("history", new History(previousCommands));
        commands.put("min_by_students_count", new MinByStudentsCount(collectionManager));
        commands.put("count_less_than_students_count", new CountLessThanStudentsCount(collectionManager, fieldsReceiver));
        commands.put("filter_starts_with_name", new FilterStartsWithName(collectionManager));
    }


    public void execute(String aCommand, String aArg) {

        if (commands.containsKey(aCommand)) {
            if (previousCommands.size() > 13) previousCommands.remove();
            previousCommands.add(aCommand);

            console.print(commands.get(aCommand).execute(aArg));
        } else {
            console.print(TextFormatting.getRedText("\tCommand not found. Please, try again!\n"));
        }
    }

    public boolean addScriptPath(String anArg) {
        return executedScripts.add(anArg);
    }

    public void removeScriptPath(String anArg) {
        executedScripts.remove(anArg);
    }
}
