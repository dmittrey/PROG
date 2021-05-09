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

    public String readArgStr() {
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
        //Нужно осуществить нормальную валидацию потому что есть риск что я ничего не введу или введу несколько аргументов
    }

    public String readArgInt() {
        String line = readArgStr() + "";
        intName = Pattern.compile("")
        if дш
    }

    public String read() {
        String line;

        try {
            line = scanner.next();
        } catch (NoSuchElementException e) {
            System.exit(0);
            line = null;
        }

        if (line.length() == 0) {
            line = null;
        }

        return line;
    }
}
