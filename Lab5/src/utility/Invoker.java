package utility;

import commands.CommandInterface;
import commands.*;

import java.util.HashMap;

public class Invoker {
    private HashMap<String, CommandInterface> commands;
    private CollectionManager collectionManager;
    //Пропишем список команд которые можно применять и затем пропишем очередь чтобы можно было зранить
    // хранить там элементы и доставать их оттуда командой

    public Invoker() {

    }

    public void setCommands(String aName, CommandInterface aCommandInterface) {
        commands.put("help", new Help(commands);
        commands.put("info", new Info(CollectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("add {element}", new Add());
        commands.put("update id {element}", new UpdateId());
        commands.put("remove_by_id id", new RemoveById()));
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script file_name", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("add_if_max {element}", new AddIfMax());
        commands.put("add_if_min {element}", new AddIfMin());
        commands.put("history", new History());
        commands.put("min_by_students_count", new MinByStudentsCount());
        commands.put("count_less_than_students_count studentsCount", new CountLessThanStudentsCount());
        commands.put("filter_starts_with_name name", new FilterStartsWithName());
    }
}
