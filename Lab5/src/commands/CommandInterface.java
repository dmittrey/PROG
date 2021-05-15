package commands;

import java.io.IOException;

/**
 * Interface for commands
 */

public interface CommandInterface {

    String getDescription();

    String execute(String aArg) throws IOException;// для справочных команд
}
