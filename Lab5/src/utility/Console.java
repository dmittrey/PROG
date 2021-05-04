package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс отвечает за вывод информации в консоль
 * и ввод информации из потока который лежит в scanner
 */

public class Console {

    // объявляем переменную scanner, которая будет отвечать за поток вывода
    private final Scanner scanner;

    /**
     * @param aScanner - поток ввода который указывается в явном параметре конструктора
     */
    public Console(Scanner aScanner){
        scanner = aScanner;
    }

    /**
     * @param aString - строку которую необходимо вывести в консоль
     */
    public void println(String aString){
        System.out.println(aString);
    }

    /**
     * Метод предназначен для построчного ввода из потока ввода который указан
     * в переменной scanner
     *
     * @return - строку или null
     *
     * Проверяет считывающиеся строки на наличие символов и длину:
     * Если длина будет равна нулю или не будет символов,
     * то выведет null, иначе выведет искомую строку
     */
    public String read(){
        String string = null;

        try {
            string = scanner.nextLine();
        } catch (NoSuchElementException exception) {
            //корректный выход тк мы выходим когда кончились строки ввода
            System.exit(0);
        }

        if (string.length() == 0) return null;
        else return string;
    }
}
