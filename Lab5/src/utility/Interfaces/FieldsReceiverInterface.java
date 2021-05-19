package utility.Interfaces;

import data.Coordinates;
import data.FormOfEducation;
import data.Person;
import data.Semester;
import utility.Console;
import utility.TextFormatting;

import java.util.Scanner;

public interface FieldsReceiverInterface {

    Scanner scanner = new Scanner(System.in);
    Console console = new Console(scanner);

    default String getFirstRequest(String requestField){
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------\n");
        sb.append(requestField.toUpperCase()).append("\n");
        sb.append("-------------------\n\n");
        sb.append("Enter ").append(requestField).append(": ");
        console.print(sb);
        return console.read();
    }

    default String getUniversalRequest(String requestField, String options) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(TextFormatting.getRedText(TextFormatting.capitalize(requestField))).
                append(TextFormatting.getRedText(" should be ")).append(TextFormatting.getRedText(options)).
                append(TextFormatting.getRedText("!\n"));
        sb.append("Enter ").append(requestField).append(" again: ");
        console.print(sb);
        return console.read();
    }

    default String getFirstEnumRequest(String requestField, String enumerateList) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------\n");
        sb.append(requestField.toUpperCase()).append("\n");
        sb.append("-------------------\n\n");
        sb.append("Available ").append(requestField).append(":\n");
        sb.append("\t").append(TextFormatting.getGreenText(enumerateList));
        sb.append("\n\nEnter ").append(requestField).append(": ");
        console.print(sb);
        return console.read();
    }

    default String getUniversalEnumRequest(String requestField) {
        StringBuilder sb = new StringBuilder();
        sb.append(TextFormatting.getRedText("\tIt's incorrect ")).
                append(TextFormatting.getRedText(requestField)).append(TextFormatting.getRedText("!"));
        sb.append("\nEnter ").append(requestField).append(" again: ");
        console.print(sb);
        return console.read();
    }

    /**
     * Method get group's name
     */
    String getName();

    /**
     * Method get group coordinates
     */
    Coordinates getCoordinates();

    /**
     * Method get students count in group
     */
    Integer getStudentsCount();

    /**
     * Method get average mark in group
     */
    Double getAverageMark();

    /**
     * Method get form of group's education
     */
    FormOfEducation getFormOfEducation();

    /**
     * Method get group's semester
     */
    Semester getSemester();

    /**
     * Method get group admin
     */
    Person getGroupAdmin();
}
