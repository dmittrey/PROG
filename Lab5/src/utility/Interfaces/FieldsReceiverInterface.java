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
        console.print(sb.toString());
        return console.read();
    }

    default String getUniversalRequest(String requestField, String options) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(TextFormatting.getRedText(requestField)).
                append(TextFormatting.getRedText(" should be ")).append(TextFormatting.getRedText(options)).
                append(TextFormatting.getRedText("!\n"));
        sb.append("Enter ").append(requestField).append(" again: ");
        console.print(sb.toString());
        return console.read();
    }

    default String getFirstEnumRequest(String requestField, Enum enumerate) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------------------\n");
        sb.append(requestField.toUpperCase()).append("\n");
        sb.append("-------------------\n\n");

        sb.append("Available forms of education:\n");
        sb.append(TextFormatting.getGreenText(enumerate.toString());


        sb.append("Enter ").append(requestField).append(": ");
        console.print(sb.toString());
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
