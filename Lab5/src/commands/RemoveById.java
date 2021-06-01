package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.Interfaces.CollectionManagerInterface;
import utility.Interfaces.FieldsProtectorInterface;
import utility.TextFormatting;

/**
 * Class that remove object with current id from collection
 */
public class RemoveById extends CommandAbstract implements FieldsProtectorInterface {

    private final CollectionManagerInterface collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public RemoveById(CollectionManager aCollectionManager) {
        super("remove_by_id", "remove an element from the collection by ID." +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        collectionManager = aCollectionManager;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return collection without removed object)
     */
    @Override
    public Object execute(String aArg) {
        if (isPositiveInt(aArg)) {

            StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

            if (studyGroup != null) collectionManager.remove(studyGroup);
            else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

            return TextFormatting.getGreenText("\n\tObject has been removed!\n\n");
        }

        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}
