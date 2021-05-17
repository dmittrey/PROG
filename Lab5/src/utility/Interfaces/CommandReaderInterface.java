package utility.Interfaces;

public interface CommandReaderInterface {

    /**
     * Method to enable line entry
     *
     * @param printPermissionStatus - variable to access print commands after enjoy line.
     *                              <p>
     *                              if command includes letter only we explain invoker and give him command and argument
     */
    void enable(boolean printPermissionStatus);
}
