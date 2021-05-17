package utility.Interfaces;

public interface InvokerInterface {

    /**
     * Method to execute command
     */
    void execute(String aCommand, String anArg);

    /**
     * Method to add script path in executed scripts to catch recursion
     */
    boolean addScriptPath(String anArg);

    /**
     * Method to remove script path from executed scripts
     */
    void removeScriptPath(String anArg);
}
