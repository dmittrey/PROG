package utility.Interfaces;

public interface ConsoleInterface {

    /**
     * Print object in stdout
     *
     * @param anObject - Object, that we should print(usually String)
     */
    void print(Object anObject);

    /**
     * Read String from stdin
     *
     * @return null or not empty String
     */
    String read();
}
