package utility;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Отвечает за то, чтобы выводить объекты в консоль и считывать их, проверяяих на нулевое значение
 */
public class Console {
    private final Scanner scanner;

    public Console(Scanner aScanner) {
        scanner = aScanner;
    }

    public void print(Object anObj) {
        System.out.print(anObj);
    }

    public void println(Object anObj) {
        System.out.println(anObj);
    }

    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(0);
            line = null;
        }

        if (line.length() == 0) {
            line = null;
        }

        return line;
    }

    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }

    public boolean hasNextDouble(){
        return scanner.hasNextDouble();
    }
}
