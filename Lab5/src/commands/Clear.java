package commands;

import utility.CollectionManager;
import utility.Interfaces.CollectionManagerInterface;
import utility.TextFormatting;

/**
 * Class for remove all elements from collection
 */
public class Clear extends CommandAbstract {

    private final CollectionManagerInterface collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class for work with collection
     */
    public Clear(CollectionManager aCollectionManager) {
        super("clear", "clear the collection");
        collectionManager = aCollectionManager;
    }

    /**
     * We return status of execute and main collection
     * <p>
     * (in future we can return empty collection)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            collectionManager.clear();
            return TextFormatting.getGreenText("\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}
