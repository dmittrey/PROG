package utility;

import data.*;
import utility.Interfaces.FieldsProtectorInterface;
import utility.Interfaces.FieldsReceiverInterface;

import java.util.Date;

import java.util.Scanner;

public class FieldsReceiver implements FieldsReceiverInterface, FieldsProtectorInterface {

    private final Console console;

    public FieldsReceiver(Console aConsole) {
        console = aConsole;
    }

    /**
     * Method get group's name
     */
    public String getName() {
        String line = getFirstRequest("group name");
        while (!getNameCorrectStatus(line)) {
            line = getUniversalRequest("Group name", "not null and not empty string");
        }
        return line;
    }

    /**
     * Method get group coordinates
     */
    public Coordinates getCoordinates() {

        String line;
        int x;
        double y;

        console.print("\n-------------------\n" +
                "GROUP'S COORDINATES\n" +
                "-------------------\n\n");

        console.print("Enter x coordinate: ");
        line = console.read();

        while (!getCoordinateXCorrectStatus(line)) {
            line = getUniversalRequest("x coordinate", "not null int number");
        }
        x = Integer.parseInt(line);

        console.print("Enter y coordinate: ");
        line = console.read();

        while (!getCoordinateYCorrectStatus(line)) {
            line = getUniversalRequest("y coordinate", "not null Double number");
        }
        y = Double.parseDouble(line);

        return new Coordinates(x, y);
    }

    /**
     * Method get students count in group
     */
    public Integer getStudentsCount() {
        String line;

        line = getFirstRequest("group students count");

        while (!getStudentsCountCorrectStatus(line)) {
            line = getUniversalRequest("group student count", "not null positive Integer number");
        }
        return Integer.parseInt(line);
    }

    /**
     * Method get average mark in group
     */
    public Double getAverageMark() {
        String line;

        line = getFirstRequest("group average mark");

        while (!getAverageMarkCorrectStatus()) {
            line = getUniversalRequest("group average mark",
                    "positive double or you can skip this field!");
        }
        return Double.parseDouble(line);
    }

    /**
     * Method get form of group's education
     */
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

        while (!isEducationForm(line)) {
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

    /**
     * Method get group's semester
     */
    public Semester getSemester() {
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

        while (line == null || !isSemester(line)) {
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

    /**
     * Method get group's admin
     */
    public Person getGroupAdmin() {
        String line;
        String name;
        long weight;
        Color hairColor;

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

        while (line == null || !isPositiveLong(line)) {
            console.print(TextFormatting.getRedText("\tAdmin weight should be not null positive long number!"));
            console.print("\nEnter admin weight: ");
            line = console.read();
        }
        weight = Long.parseLong(line);

        Color c = Color.BLACK;
        // fixme Color.values().toString()
        console.print("\nAvailable hair color:\n" +
                TextFormatting.getGreenText("\tBLACK,\n" +
                        "\tBLUE,\n" +
                        "\tYELLOW,\n" +
                        "\tWHITE,\n" +
                        "\tBROWN\n"));
        console.print("\nEnter hair color: ");
        line = console.read();

        while (line == null || !isHairColor(line)) {
            console.print(TextFormatting.getRedText("\tHair color is incorrect!\n"));
            console.print("Enter correct hair color: ");
            line = console.read();
        }
        hairColor = Color.valueOf(line);

        return new Person(name, weight, hairColor);

    }

    private boolean isPositiveLong(String aStr) {
        try {
            Long.parseLong(aStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return Long.parseLong(aStr) > 0;
    }

    private boolean isHairColor(String aStr) {
        try {
            Color.valueOf(aStr);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        FieldsReceiver fieldsReceiver = new FieldsReceiver(console);
        //System.out.print(fieldsReceiver.getCoordinates());
        Date date = new Date();
        System.out.print(date.toString());
    }
}
