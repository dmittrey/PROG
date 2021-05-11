package Exceptions;

import java.io.IOException;

public class IncorrectArgumentException extends IOException {

    public IncorrectArgumentException(String typeOfArgument) {
        super(typeOfArgument);
    }
}
