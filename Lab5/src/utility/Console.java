package utility;

import utility.Interfaces.ConsoleInterface;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Console helps us to read and print information
 */
public class Console implements ConsoleInterface {
    private Scanner scanner;
    private boolean printPermission;

    public Console(Scanner aScanner) {

        scanner = aScanner;
        printPermission = true;
    }

    public void disablePrintPermissionStatus(){

        printPermission = false;
    }

    public void enablePrintPermission(){

        printPermission = true;
    }

    public void setScanner(Scanner aScanner){
        scanner = aScanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void closeScanner(){
        scanner.close();
    }

    @Override
    public void print(Object anObj) {

        if (printPermission) System.out.print(anObj);
    }

    @Override
    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.print("GG");
            System.exit(0);
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
