package commands;

import utility.CollectionManager;
import utility.TextFormatting;

/**
 * Class for remove all elements from collection
 */
public class Clear extends CommandAbstract {

    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class for work with collection
     */
    public Clear(CollectionManager aCollectionManager) {
        super("clear", "clear the collection");
        collectionManager = aCollectionManager;
    }

    public String execute(String aArg) {
        if (aArg.equals("")) {
            collectionManager.clear();
            return TextFormatting.getGreenText("\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}
