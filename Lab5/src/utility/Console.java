package utility;


import java.io.EOFException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
//            System.exit(0);
            // fixme Throw normal exception
            throw new RuntimeException("Unexpected EOF");
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Console pekus = new Console(sc);
        System.out.println(pekus.read());
    }
}
