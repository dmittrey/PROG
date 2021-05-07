package utility;


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * Отвечает за то, чтобы выводить объекты в консоль и считывать их, проверяяих на нулевое значение
 */
public class Console {
    private final Scanner scanner;

    public Console(Scanner aScanner){
        scanner = aScanner;
    }

    /**
     * Prints toOut.toString() + \n to Console
     * @param toOut - Object ot print
     */

    public void print(Object toObj){
        System.out.println(toObj);
    }

    public String readln() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.exit(0);
            line = null;
        }

        if (line.length() == 0){
            line = null;
        }

        return line;
    }
}