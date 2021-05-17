package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.ProtectFields;
import utility.TextFormatting;

/**
 * Class that remove object with current id from collection
 */
public class RemoveById extends CommandAbstract {

    private final CollectionManager collectionManager;
    private final ProtectFields protectFields;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aProtectFields     - Class to read fields and create new study groups
     */
    public RemoveById(CollectionManager aCollectionManager,
                      ProtectFields aProtectFields) {
        super("remove_by_id", "remove an element from the collection by ID." +
                TextFormatting.getBlueText("You should to enter ID after entering a command"));
        collectionManager = aCollectionManager;
        protectFields = aProtectFields;
    }

    @Override
    public String execute(String aArg) {
        try {
            if (protectFields.isPositiveInt(aArg.trim())) {
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
