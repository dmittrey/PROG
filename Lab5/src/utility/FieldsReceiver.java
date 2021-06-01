package utility;

import data.*;
import utility.Interfaces.ConsoleInterface;
import utility.Interfaces.FieldsProtectorInterface;
import utility.Interfaces.FieldsReceiverInterface;

import java.util.Arrays;

/**
 * Class is used to receive fields
 */
public class FieldsReceiver implements FieldsReceiverInterface, FieldsProtectorInterface {

    private final ConsoleInterface console;

    public FieldsReceiver(Console aConsole) {
        console = aConsole;
    }

    @Override
    public String getName() {
        String line;
        if (console.getExeStatus()) {

            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getNameCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstRequest("group name", console);
            while (!getNameCorrectStatus(line)) {
                line = getUniversalRequest("group name", "not null and not empty string", console);
            }
        }
        return line;
    }

    @Override
    public Coordinates getCoordinates() {

        String line;
        int x;
        double y;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getCoordinateXCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
            x = Integer.parseInt(line);

            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getCoordinateYCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            console.print("\n-------------------\n" +
                    "GROUP'S COORDINATES\n" +
                    "-------------------\n\n");

            line = getFirstRequest("group coordinate x", console);

            while (!getCoordinateXCorrectStatus(line)) {
                line = getUniversalRequest("x coordinate", "not null int number", console);
            }
            x = Integer.parseInt(line);

            line = getFirstRequest("group coordinate y", console);

            while (!getCoordinateYCorrectStatus(line)) {
                line = getUniversalRequest("y coordinate", "not null Double number", console);
            }
        }
        y = Double.parseDouble(line);

        return new Coordinates(x, y);
    }

    @Override
    public Integer getStudentsCount() {
        String line;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getStudentsCountCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstRequest("group students count", console);

            while (!getStudentsCountCorrectStatus(line)) {
                line = getUniversalRequest("group student count", "not null positive Integer number",
                        console);
            }
        }
        return Integer.parseInt(line);
    }

    @Override
    public Double getAverageMark() {
        String line;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getAverageMarkCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstRequest("group average mark", console);

            while (!getAverageMarkCorrectStatus(line)) {
                line = getUniversalRequest("group average mark",
                        "positive double or you can skip this field", console);
            }
        }
        if (line == null) return null;
        else return Double.parseDouble(line);
    }

    @Override
    public FormOfEducation getFormOfEducation() {
        String line;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getFormOfEducationCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstEnumRequest("form of education", Arrays.toString(FormOfEducation.values())
                    + TextFormatting.getBlueText("\n-----")
                    + TextFormatting.getBlueText("\n\tYou can write form of education in lower case!")
                    + TextFormatting.getBlueText("\n-----")
                    + TextFormatting.getRedText("\n\n\t(You can skip this field)"), console);

            while (!getFormOfEducationCorrectStatus(line)) {
                line = getUniversalEnumRequest("form of education", console);
            }
        }

        if (line == null) return null;
        else return FormOfEducation.valueOf(line.toUpperCase());
    }

    @Override
    public Semester getSemester() {
        String line;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getSemesterEnumCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstEnumRequest("group semester", Arrays.toString(Semester.values())
                    + TextFormatting.getBlueText("\n-----")
                    + TextFormatting.getBlueText("\n\tYou can write form of education in lower case!")
                    + TextFormatting.getBlueText("\n-----"), console);

            while (!getSemesterEnumCorrectStatus(line)) {
                line = getUniversalEnumRequest("semester", console);
            }
        }
        return Semester.valueOf(line.toUpperCase());
    }

    @Override
    public Person getGroupAdmin() {
        String line;
        String name;
        long weight;
        Color hairColor;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getNameCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            console.print("\n-------------------\n" +
                    TextFormatting.getBlueText("\tGROUP ADMIN\n") +
                    "-------------------\n\n");
            line = getFirstRequest("group admin name", console);

            while (!getNameCorrectStatus(line)) {
                line = getUniversalRequest("group admin name", "not null and empty String", console);
            }
        }
        name = line;

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getGroupAdminWeightCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstRequest("group admin weight", console);

            while (!getGroupAdminWeightCorrectStatus(line)) {
                line = getUniversalRequest("group admin weight", "not null positive long number", console);
            }
        }
        weight = Long.parseLong(line);

        if (console.getExeStatus()) {
            if (!console.hasNextLine()) return null;
            line = console.read();

            while (!getGroupAdminHairColorCorrectStatus(line)) {
                if (!console.hasNextLine()) return null;
                line = console.read();
            }
        } else {
            line = getFirstEnumRequest("group admin hair color", Arrays.toString(Color.values())
                    + TextFormatting.getBlueText("\n-----")
                    + TextFormatting.getBlueText("\n\tYou can write form of education in lower case!")
                    + TextFormatting.getBlueText("\n-----"), console);

            while (!getGroupAdminHairColorCorrectStatus(line)) {
                line = getUniversalEnumRequest("group admin hair color", console);
            }
        }
        hairColor = Color.valueOf(line.toUpperCase());

        return new Person(name, weight, hairColor);
    }
}