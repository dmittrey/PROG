import java.util.Scanner;
//Библиотека для перенаправления потока ввода

/**
 *
 *
 * Прога для сани
 * Второе задание по массивам
 *
 *
 */

public class Main {



    public static void main(String[] args) throws MyException {
        Scanner in = new Scanner(System.in);
        // Делаю объектную переменную и присваиваю ей ссылку на поток ввода

        System.out.println("Введите кол-во строк/столбцов массива:");
        // Вывожу на экран предложение ввести инфу

        int n = in.nextInt();
        // Инициализирую переменную n типа int(целые четырёхбайтные числа)

        if (n < 5) {
            throw new MyException("ffff");
        }


    }

    private static class MyException extends Throwable {
        public MyException(String ffff) {
        }
    }
}
