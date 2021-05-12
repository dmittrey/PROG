package utility;

import data.*;


//надо потом будет потыкать валидацию еще раз и еще нужно нормально пояснять какая ошибка во вводе, просто if else
// в блоке while

/**
 * потыкать валидацию каждого паблик и сравнить с областью определения
 * сделать норм оформление и перейти к команде add(там 5 строчек максимум поменять)
 *
 * потом докрутить все команды(в совновном работа связки collection manager + команда)
 *
 * затем поработать со скриптом и всё
 *
 * мб к вечеру успею
 */

public class ProtectFields {

    private Console console;

    public ProtectFields(Console aConsole) {
        console = aConsole;
    }

    /**
     * Метод вычисляет имя группы
     */
    public String getName() {
        String line;
        console.print("Enter group name: ");
        line = console.read();
        while (line == null) {
            console.print("\t\tGroup name should be not null string!\n\nEnter group name again: ");
            line = console.read();
        }
        return line;
    }

    /**
     * Метод вычисляет координаты объекта
     */
    public Coordinates getCoordinates() {

        String line;
        Integer x;
        Double y;

        console.print("Enter x coordinate: ");
        line = console.read();
        while (line == null || !isInt(line)) {
            console.print("\t\tCoordinate x should be not null integer number!\n\nEnter x coordinate again: ");
            //надо уточнить момент, может ли быть null
            line = console.read();
        }
        x = Integer.parseInt(line);

        console.print("Enter y coordinate: ");
        line = console.read();
        while (line == null || !isDouble(line)) {
            console.print("\t\tCoordinate x should be not null integer number!\n\nEnter y coordinate again: ");
            line = console.read();
        }
        y = Double.parseDouble(line);

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

    private boolean isDouble(String aStr) {
        try {
            Double.parseDouble(aStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Метод вычисляет кол-во человек в группе
     */
    public Integer getStudentsCount() {
        String line;

        console.print("Enter group's count: ");
        line = console.read();

        while (line == null || !isPositiveInt(line)) {
            console.print("\t\tGroup count should be positive not null integer!\n\nEnter group count again: ");
            line = console.read();
        }
        return Integer.parseInt(line);
    }

    private boolean isPositiveInt(String aStr) {
        try {
            Integer.parseInt(aStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return Integer.parseInt(aStr) > 0;
    }

    /**
     * Метод вычисляет значение среднего балла в группе
     */
    public Double getAverageMark() {
        String line;

        console.print("Enter group's average mark: ");
        line = console.read();

        if (line == null) return null;

        while (!isPositiveDouble(line)) {
            console.print("\t\tGroup count should be positive not null double!\n\nEnter group's average mark again: ");
            line = console.read();
        }
        return Double.parseDouble(line);
    }

    private boolean isPositiveDouble(String aStr) {
        try {
            Double.parseDouble(aStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return Double.parseDouble(aStr) > 0;
    }

    /**
     * Метод вычисляет форму обучения
     */
    public FormOfEducation getFormOfEducation() {
        String line;

        console.print("Available forms of education:\n" +
                "\tDISTANCE_EDUCATION,\n" +
                "\tFULL_TIME_EDUCATION,\n" +
                "\tEVENING_CLASSES\n");
        console.print("Enter form of education: ");
        line = console.read();

        if (line == null) return null;

        while (!isEducationForm(line)){
            console.print("\t\tIt's incorrect form of education\n\nEnter form of education again: ");
            line = console.read();
        }
        return FormOfEducation.valueOf(line);
    }

    private boolean isEducationForm(String aStr) {
        try {
            FormOfEducation.valueOf(aStr);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public Semester getSemester(){
        String line;

        console.print("Available forms of education:\n" +
                "\tSECOND,\n" +
                "\tTHIRD,\n" +
                "\tFOURTH,\n" +
                "\tFIFTH,\n" +
                "\tSIXTH\n");
        console.print("Enter semester: ");
        line = console.read();

        if (line == null) return null;

        while (!isSemester(line)){
            console.print("\t\tIt's incorrect semester\n\nEnter semester again: ");
            line = console.read();
        }
        return Semester.valueOf(line);
    }

    private boolean isSemester(String aStr) {
        try {
            Semester.valueOf(aStr);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public Person getGroupAdmin(){
        String line;
        String name; //Поле не может быть null, Строка не может быть пустой
        Long weight; //Поле не может быть null, Значение поля должно быть больше 0
        Color hairColor; //Поле не может быть null

        console.print("-------------------\n" +
                "GROUP'S ADMIN\n" +
                "-------------------\n\n");

        console.print("\tEnter admin name: ");
        line = console.read();

        while (line == null) {
            console.print("Admin name should be not null string.\n\nEnter admin name: ");
            line = console.read();
        }
        name = line;

        console.print("\tEnter admin weight: ");
        line = console.read();

        while (line == null || !isPositiveLong(line)){
            console.print("Admin weight should be not null long number.\n\nEnter admin weight: ");
            line = console.read();
        }
        weight = Long.parseLong(line);

        console.print("Available hair color:"+
                "\tBLACK,\n" +
                "\tBLUE,\n" +
                "\tYELLOW,\n" +
                "\tWHITE,\n" +
                "\tBROWN\n");
        console.print("\tEnter hair color: ");
        line = console.read();

        while (line == null || !isHairColor(line)){
            console.print("\tEnter correct hair color: ");
            line = console.read();
        }
        hairColor = Color.valueOf(line);

        return new Person(name, weight, hairColor);

    }

    private boolean isPositiveLong(String aStr){
        try {
            Long.parseLong(aStr);
        } catch (NumberFormatException e){
            return false;
        }

        return Long.parseLong(aStr) > 0;
    }

    private boolean isHairColor(String aStr){
        try {
            Color.valueOf(aStr);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
