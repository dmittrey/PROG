package commands;

import data.Coordinates;
import data.FormOfEducation;
import data.Person;
import data.Semester;
import utility.CollectionManager;
import utility.Console;

import java.io.IOException;
import java.util.Date;
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
        Coordinates coordinates;
        java.util.Date creationDate = getCreationDate();
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
            console.println("The string cannot be empty or null\nEnter study group's name: ");
            line = console.read();
        }
        return line;
    }

    /**
     * Метод для вычисления координат объекта
     * <p>
     * В процессе вычисления происходит валидация числе на принадлежность к типу и корректность значения
     *
     * @return Объект типа Coordinates с зашитыми координатами
     * @see Add#execute(String)
     */
    public Coordinates getCoordinates() {

        int x;
        double y;

        // надо потом будет оптимизировать так, чтобы код не повторялся два раза для разных осей
        console.print("Enter x coordinate: ");
        String line = console.read();

        while (line == null || line.trim().equals("") || !isInt(line)){
            console.print("\n\t\tCoordinate x must be integer number.\n\n Enter x coordinate again: ");
            line = console.read();
        }

        x = Integer.parseInt(line);

        console.print("Enter y coordinate:");
        line = console.read();

        while (line == null || line.trim().equals("") || !isDouble(line)){
            console.print("\n\t\tCoordinate y must be integer number.\n\n Enter x coordinate again: ");
            line = console.read();
        }

        y = Double.parseDouble(line);

        // Продумать момент где должна распологаться валидация(ProtectField)

        //Сделать класс фабрику для таких групп

        // Продумать как не повторять код(приватный метод в ProtectField)
        return new Coordinates(x, y);
    }

    private boolean isInt(String aStr) {
        try {
            Integer.parseInt(aStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isDouble(String aStr){
        try {
            Double.parseDouble(aStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    /**
     * Метод для вычисления даты создания объекта коллекции
     *
     * @return Дата создания объекта
     * @see Add#execute(String)
     */
    private java.util.Date getCreationDate() {
        Date creationDate = new Date();
        creationDate.getTime();
        return creationDate;
    }

    /**
     * Метод для вычисления кол-ва человек в группе
     *
     * @return Кол-во человек в группе
     * @see Add#execute(String)
     */
    private Integer getStudentsCount() {


        return 55;
    }


    public static void main(String[] args) throws IOException {
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

