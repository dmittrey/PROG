import java.io.IOException;

public class DieException extends IOException {

    public DieException(){
        super("Маме привет, кчау");
    }

    public DieException(String aString){
        super(aString);
    }

    public static void main(String[] args) {

        System.out.println("Hi");

        Rabbit krosh = new Rabbit();

        try
        {
            krosh.kill();
        }
        catch (DieException exception)
        {
            System.out.println("Пошел ты, козел");
        }

        try
        {
            krosh.setEatingCarrot();
        }
        catch (DieException exception)
        {
            System.out.println("Пошел ты, козел");
        }
    }
}
