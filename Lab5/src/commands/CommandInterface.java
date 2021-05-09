package commands;

/**
 * Interface for commands
 */


public interface CommandInterface {

    String getDescription();

    String execute(String aArg);// для справочных команд
}
