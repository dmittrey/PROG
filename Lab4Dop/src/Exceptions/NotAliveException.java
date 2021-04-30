package Exceptions;

public class NotAliveException extends RuntimeException{
    public NotAliveException(){
        super("Person already dead");
    }
}
