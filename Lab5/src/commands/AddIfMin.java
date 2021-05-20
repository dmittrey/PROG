package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class for add minimal element in collection
 */
public class AddIfMin extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class for read fields from stdin
     * @param aCollectionManager - Class for add new element into collection
     */
    public AddIfMin(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("add_if_min", "add new element to the collection, if it`s value less, than " +
                "smallest element of this collection.");

        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    /**
     * We return status of execute
     *
     * (In future we can return collection with added object or error message)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            StudyGroup inputStudyGroup = studyGroupFactory.createStudyGroup();
            try {
                if (inputStudyGroup.compareTo(collectionManager.getMin()) >= 0) return TextFormatting.getRedText(
                        "\tStudy group isn't worst!\n\n");
            } catch (NullPointerException ignored) {
            }

            collectionManager.add(inputStudyGroup);
            return TextFormatting.getGreenText("\n\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}
