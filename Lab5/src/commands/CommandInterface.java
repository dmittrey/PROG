package commands;

/**
 * Interface for commands
 */


public interface CommandInterface {

    String getDescription();

    void execute(String argument);
}
