package utility.Interfaces;

import data.Color;
import data.FormOfEducation;
import data.Semester;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface FieldsProtectorInterface{

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
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    default boolean getDateCorrectStatus(String line) {

        SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
        try {
            parser.parse(line);
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

    default boolean getAverageMarkCorrectStatus(String line) {
        try {
            return Double.parseDouble(line) > 0;
        } catch (NumberFormatException exception) {
            return true;
        }
    }

    default boolean getFormOfEducationCorrectStatus(String line) {
        try {
            FormOfEducation.valueOf(line);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        } catch (NullPointerException exception) {
            return true;
        }
    }

    default boolean getSemesterEnumCorrectStatus(String line){
        try{
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
        try{
            Color.valueOf(line);
            return true;
        } catch (IllegalArgumentException | NullPointerException exception) {
            return false;
        }
    }
}
