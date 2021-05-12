package utility;

import data.*;

import java.util.Arrays;

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

    private final Console console;

    public ProtectFields(Console aConsole) {
        console = aConsole;
    }

    /** Method get group's name */
    public String getName() {
        String line;

        console.print("\n-------------------\n" +
                      "GROUP'S NAME\n" +
                      "-------------------\n\n");
        console.print("Enter group name: ");
        line = console.read();
        while (line == null) {
            console.print(TextFormatting.getRedText("\tGroup name should be not null and not empty string!"));
            console.print("\nEnter group name again: ");
            line = console.read();
        }
        return line;
    }

    /** Method get group coordinates */
    public Coordinates getCoordinates() {

        String line;
        int x;
        double y;

        console.print("\n-------------------\n" +
                "GROUP'S COORDINATES\n" +
                "-------------------\n\n");

        console.print("Enter x coordinate: ");
        line = console.read();

        while (line == null || !isInt(line)) {
            console.print(TextFormatting.getRedText("\tCoordinate x should be not null integer number!"));
            console.print("\nEnter x coordinate again: ");
            line = console.read();
        }

        x = Integer.parseInt(line);

        console.print("Enter y coordinate: ");
        line = console.read();

        while (line == null || !isDouble(line)) {
            console.print(TextFormatting.getRedText("\tCoordinate x should be not null double number!"));
            console.print("\nEnter y coordinate again: ");
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

    /** Method get students count in group */
    public Integer getStudentsCount() {
        String line;

        console.print("\n-------------------\n" +
                "GROUP'S STUDENTS COUNT\n" +
                "-------------------\n\n");

        console.print("Enter group's count: ");
        line = console.read();

        while (line == null || !isPositiveInt(line)) {
            console.print(TextFormatting.getRedText("\tGroup count should be positive not null integer!"));
            console.print("\nEnter group count again: ");
            line = console.read();
        }
        return Integer.parseInt(line);
    }

    private boolean isPositiveInt(String aStr) {

        return isInt(aStr) && Integer.parseInt(aStr) > 0;
    }

    /** Method get average mark in group */
    public Double getAverageMark() {
        String line;

        console.print("\n-------------------\n" +
                "GROUP'S AVERAGE MARK\n" +
                "-------------------\n\n");

        console.print("Enter group's average mark: ");
        line = console.read();

        if (line == null) return null;

        while (!isPositiveDouble(line)) {
            console.print(TextFormatting.getRedText("\tGroup count should be positive double or you can skip" +
                    " this field!"));
            console.print("\nEnter group's average mark again: ");
            line = console.read();

            if (line == null) return null;
        }
        return Double.parseDouble(line);
    }

    private boolean isPositiveDouble(String aStr) {

        return isDouble(aStr) && Double.parseDouble(aStr) > 0;
    }

    /** Method get form of group's education */
    public FormOfEducation getFormOfEducation() {
        String line;

        console.print("\n-------------------\n" +
                "GROUP'S FORM OF EDUCATION\n" +
                "-------------------\n\n");

        console.print("Available forms of education:\n" +
                TextFormatting.getGreenText("\tDISTANCE_EDUCATION,\n" +
                "\tFULL_TIME_EDUCATION,\n" +
                "\tEVENING_CLASSES\n"));
        console.print("\nEnter form of education: ");
        line = console.read();

        if (line == null) return null;

        while (!isEducationForm(line)){
            console.print(TextFormatting.getRedText("\tIt's incorrect form of education!"));
            console.print("\nEnter form of education again: ");
            line = console.read();

            if (line == null) return null;
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

    /** Method get group's semester */
    public Semester getSemester(){
        String line;

        console.print("\n-------------------\n" +
                "GROUP'S SEMESTER\n" +
                "-------------------\n\n");

        console.print("Available forms of education:\n" +
                TextFormatting.getGreenText("\tSECOND,\n" +
                "\tTHIRD,\n" +
                "\tFOURTH,\n" +
                "\tFIFTH,\n" +
                "\tSIXTH\n"));
        console.print("\nEnter semester: ");
        line = console.read();

        while (line == null || !isSemester(line)){
            console.print(TextFormatting.getRedText("\tIt's incorrect semester!"));
            console.print("\nEnter semester again: ");
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

    /** Method get group's admin */
    public Person getGroupAdmin(){
        String line;
        String name; //Поле не может быть null, Строка не может быть пустой
        long weight; //Поле не может быть null, Значение поля должно быть больше 0
        Color hairColor; //Поле не может быть null

        console.print("\n-------------------\n" +
                "GROUP'S ADMIN\n" +
                "-------------------\n\n");

        console.print("Enter admin name: ");
        line = console.read();

        while (line == null) {
            console.print(TextFormatting.getRedText("\tAdmin name should be not null string!"));
            console.print("\nEnter admin name: ");
            line = console.read();
        }
        name = line;

        console.print("\nEnter admin weight: ");
        line = console.read();

        while (line == null || !isPositiveLong(line)){
            console.print(TextFormatting.getRedText("\tAdmin weight should be not null positive long number!"));
            console.print("\nEnter admin weight: ");
            line = console.read();
        }
        weight = Long.parseLong(line);

        Color c = Color.BLACK;
        // fixme Color.values().toString()
        console.print("\nAvailable hair color:\n"+
                TextFormatting.getGreenText("\tBLACK,\n" +
                "\tBLUE,\n" +
                "\tYELLOW,\n" +
                "\tWHITE,\n" +
                "\tBROWN\n"));
        console.print("\nEnter hair color: ");
        line = console.read();

        while (line == null || !isHairColor(line)){
            console.print(TextFormatting.getRedText("\tHair color is incorrect!\n"));
            console.print("Enter correct hair color: ");
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
