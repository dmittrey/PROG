package utility.Interfaces;

import data.Color;
import data.FormOfEducation;
import data.Semester;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface FieldsProtectorInterface {

    default boolean getIdCorrectStatus(String line) {

        try {
            isPositiveInt(line);
            return true;
        } catch (NullPointerException exception) {
            return false;
        }
    }

    default boolean getNameCorrectStatus(String line) {

        return line != null;
    }

    default boolean getCoordinateXCorrectStatus(String line) {

        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    default boolean getCoordinateYCorrectStatus(String line) {

        try {
            Double.parseDouble(line);
            return true;
        } catch (NullPointerException | NumberFormatException exception) {
            return false;
        }
    }

    default boolean getDateCorrectStatus(String line) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            formatter.parse(line);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    default boolean getStudentsCountCorrectStatus(String line) {

        try {
            return Integer.parseInt(line) > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    default boolean isPositiveInt(String line) {
        return getStudentsCountCorrectStatus(line);
    }

    default boolean getAverageMarkCorrectStatus(String line) {

        try {
            if (line.equals("null")) return true;
            return Double.parseDouble(line) > 0;
        } catch (NumberFormatException exception) {
            return false;
        } catch (NullPointerException exception) {
            return true;
        }
    }

    default boolean getFormOfEducationCorrectStatus(String line) {

        try {
            if (line.equals("null")) return true;
            FormOfEducation.valueOf(line);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        } catch (NullPointerException exception) {
            return true;
        }
    }

    default boolean getSemesterEnumCorrectStatus(String line) {

        try {
            Semester.valueOf(line);
            return true;
        } catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }
    }

    default boolean getGroupAdminWeightCorrectStatus(String line) {

        try {
            return Long.parseLong(line) > 0;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    default boolean getGroupAdminHairColorCorrectStatus(String line) {

        try {
            Color.valueOf(line);
            return true;
        } catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }
    }
}
