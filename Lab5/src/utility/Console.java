package utility;

import utility.Interfaces.ConsoleInterface;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Console helps us to read and print information
 */
public class Console implements ConsoleInterface {
    private Scanner scanner;
    private boolean exeStatus;

    public Console(Scanner aScanner, boolean anExeStatus) {

        scanner = aScanner;
        exeStatus = anExeStatus;
    }

    @Override
    public void setScanner(Scanner aScanner){
        scanner = aScanner;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    @Override
    public void enableExeStatus(){
        exeStatus = true;
    }

    @Override
    public void disableExeStatus(){
        exeStatus = false;
    }

    @Override
    public boolean getExeStatus(){
        return exeStatus;
    }

    @Override
    public void print(Object anObj) {

        System.out.print(anObj);
    }

    @Override
    public String read() {
        String line;

        try {
            line = scanner.nextLine();
        } catch (NoSuchElementException e) {
            if (!exeStatus) System.exit(0);
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        return line.trim();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}
