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
        String name = getName();
        Coordinates coordinates; //Поле не может быть null
        java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        Integer studentsCount;
        Double averageMark; //Значение поля должно быть больше 0, Поле может быть null
        FormOfEducation formOfEducation; //Поле может быть null
        Semester semesterEnum; //Поле не может быть null
        Person groupAdmin; //Поле не может быть null


        Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        //буду заполнять в последнюю очередь тк хэширую поля

        //Засунуть поля в констурктор
        collectionManager.add();

        return "";
    }

    /**
     * Приватные методы для инициализации полей
     */

    /**
     * Метод для вычисения имени объекта
     * <p>
     * Проверяем на нулевую строку или null
     *
     * @return Готовую строку содержащую имя
     * @see Add#execute(String)
     */
    private String getName() {

        console.print("Enter study group's name: ");
        String line = console.read();
        while (line == null || line.trim().equals("")) {
            console.println("The string cannot be empty or null\n");
            console.print("Enter study group's name: ");
            line = console.read();
        }
        return line;
    }

    /**
     * Метод для вычисления координат объекта
     *
     * В процессе вычисления происходит валидация числе на принадлежность к типу и корректность значения
     *
     * @return Объект типа Coordinates с зашитыми координатами
     * @see Add#execute(String)
     */
    public Coordinates getCoordinates() {

        int x;
        double y = 5.0;

        //Неведомая хуйня с переводом каретки, просто перестают выводиться строки(даже хз в чем дело)

        console.print("Enter x coordinate: ");

        boolean nextIntStatus = console.hasNextInt();
        String line = console.read();

        System.out.println(line);//!
        System.out.println(nextIntStatus+"111");//!

        while (!nextIntStatus) {
            console.println("Coordinate x must be integer number\n");

            console.print("Enter x coordinate: ");
            nextIntStatus = console.hasNextInt();
            line = console.read();
            System.out.println(line);//!
            System.out.println(nextIntStatus+"111");//!

        }
        x = Integer.parseInt(line);
        System.out.println(x);









        return new Coordinates(x,y);
    }



    public static void main(String[] args) {
        CollectionManager kek = new CollectionManager();
        Scanner input = new Scanner(System.in);
        Console cons = new Console(input);
        Add kekos = new Add(kek, cons);
        System.out.print(kekos.getCoordinates());
        String line = null;
    }
}

/**
 * Осталось дописать методы для вычисления полей(несложно) и завязать с collection manager
 */

