package utility.Interfaces;

import commands.ExecuteScript;
import utility.FieldsReceiver;

import java.util.Scanner;

public interface ConsoleInterface {

    /**
     * Set new scanner in console
     *
     * @see ExecuteScript#execute
     */
    void setScanner(Scanner aScanner);

    /**
     * Returns scanner from console to save
     *
     * @see ExecuteScript#execute
     */
    Scanner getScanner();

    /**
     * Enable script execution status in console to read fields using another way
     *
     * @see FieldsReceiver
     */
    void enableExeStatus();

    /**
     * Disable script execution status in console to work in interactive
     *
     * @see FieldsReceiver
     */
    void disableExeStatus();

    /**
     * Return script execution status to understand how we should receive fields
     *
     * @see FieldsReceiver
     */
    boolean getExeStatus();

    /**
     * Print object in stdout
     *
     * @param anObject - Object, that we should print(usually String)
     */
    void print(Object anObject);

    /**
     * Read String from stdin
     *
     * @return null or not empty String
     */
    String read();

    /**
     * Check next line to find any symbol to avoid NullPointerException
     */
    boolean hasNextLine();
}
