package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.FieldsReceiver;
import utility.TextFormatting;

/**
 * Class that remove object with current id from collection
 */
public class RemoveById extends CommandAbstract {

    private final CollectionManager collectionManager;
    private final FieldsReceiver fieldsReceiver;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aFieldsReceiver    - Class to read fields and create new study groups
     */
    public RemoveById(CollectionManager aCollectionManager,
                      FieldsReceiver aFieldsReceiver) {
        super("remove_by_id", "remove an element from the collection by ID." +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        collectionManager = aCollectionManager;
        fieldsReceiver = aFieldsReceiver;
    }

    /**
     * We return execute status
     *
     * (In future we can return collection without removed object)
     */
    @Override
    public Object execute(String aArg) {
        try {
            if (fieldsReceiver.isPositiveInt(aArg.trim())) {
                StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg.trim()));

                if (studyGroup != null) collectionManager.remove(studyGroup);
                else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

                return TextFormatting.getGreenText("\n\tSuccessful\n\n");
            }
        } catch (NullPointerException ignored) {
        }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}
