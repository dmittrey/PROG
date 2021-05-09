package commands;

import data.Coordinates;
import data.FormOfEducation;
import data.Person;
import data.Semester;
import utility.CollectionManager;
import utility.Console;

import java.util.Scanner;

public class Add extends CommandAbstract {

    private final Console console;
    private final CollectionManager collectionManager;

    public Add(CollectionManager aCollectionManager, Console aConsole) {
        super("add", "add new element to the collection");
        collectionManager = aCollectionManager;
        console = aConsole;
    }

    @Override
    public String execute(String aArg) {
        String line;
        Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        String name; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates; //Поле не может быть null
        java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        Integer studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
        Double averageMark; //Значение поля должно быть больше 0, Поле может быть null
        FormOfEducation formOfEducation; //Поле может быть null
        Semester semesterEnum; //Поле не может быть null
        Person groupAdmin; //Поле не может быть null

        console.print("Enter Study group's name: ");
        name = (String) console.readArgStr();
        console.print("\n");
        console.print("Enter Study group's id: ");
        id = Integer.valueOf(console.readArgStr());
        return "Объект добавлен в коллекцию";
    }

    public static void main(String[] args) {
        CollectionManager kek = new CollectionManager();
        Scanner input = new Scanner(System.in);
        Console cons = new Console(input);
        Add kekos = new Add(kek, cons);
        System.out.print(kekos.execute("15"));
    }
}

