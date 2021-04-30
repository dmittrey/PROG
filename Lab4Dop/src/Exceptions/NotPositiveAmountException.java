package Exceptions;

public class NotPositiveAmountException extends Exception{
    public NotPositiveAmountException(String gripe){
        super(gripe);
    }
}
