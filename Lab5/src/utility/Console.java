package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <code>Console</code> helps us to read and print information
 */
public class Console {
    private final Scanner scanner;

    public Console(Scanner aScanner) {
        scanner = aScanner;
    }

    /**
     * Method print information in stdout
     * @param anObj - information
     */
    public void print(Object anObj) {
        System.out.print(anObj);
    }

    /**
     * Method read information from stdin
     * @return null or not empty string
     */
    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            print(TextFormatting.getRedText("\tUnexpected EOF!\n"));
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }
}
