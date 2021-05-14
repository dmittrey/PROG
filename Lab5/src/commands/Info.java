package commands;

import utility.CollectionManager;
import utility.TextFormatting;

/**
 * @author dmittrey
 * <p>
 * Class for displaying information about collection
 */

public class Info extends CommandAbstract{

    /** The object responsible for operations on the collection */
    private final CollectionManager collectionManager;

    public Info(CollectionManager aCollectionManager){
        super("info", "Print information about the collection (type, "
                        + "initialization date, number of elements, etc.) to standard output");
        collectionManager = aCollectionManager;
    }

    /**
     * Method to print info about collection
     *
     * @param aArg - command arguments
     * @return - 5 lines of information
     * @see CollectionManager#getInfo()
     */
    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {

            return TextFormatting.getBlueText("\nInformation about collection:\n\n") + collectionManager.getInfo();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
