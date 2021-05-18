package utility;

import utility.Interfaces.ConsoleInterface;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Console helps us to read and print information
 */
public class Console implements ConsoleInterface {
    private final Scanner scanner;

    public Console(Scanner aScanner) {
        scanner = aScanner;
    }

    public void print(Object anObj) {
        System.out.print(anObj);
    }

    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            print(TextFormatting.getRedText("\tUnexpected EOF!\n"));
            System.exit(0);
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }
}
