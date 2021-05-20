package commands;

import utility.CollectionManager;
import utility.TextFormatting;

/**
 * Class for displaying all information about collection
 */
public class Info extends CommandAbstract {

    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public Info(CollectionManager aCollectionManager) {
        super("info", "Print information about the collection (type, "
                + "initialization date, number of elements, etc.) to standard output");
        collectionManager = aCollectionManager;
    }

    /**
     * We return execute status
     *
     * (In future we can return map of properties and their values)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            return TextFormatting.getBlueText("\nInformation about collection:\n\n") + collectionManager.getInfo();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
