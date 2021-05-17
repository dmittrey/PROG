package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class for add maximum element in collection
 */
public class AddIfMax extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class for read fields from stdin
     * @param aCollectionManager - Class for add new element into collection
     */
    public AddIfMax(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("add_if_max", "add new element to the collection, if it`s greater, " +
                "than biggest element of this collection.");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            StudyGroup inputStudyGroup = studyGroupFactory.createStudyGroup();
            try {
                if (inputStudyGroup.compareTo(collectionManager.getMax()) <= 0) return TextFormatting.getRedText(
                        "\tStudy group isn't best!\n\n");
            } catch (NullPointerException ignored) {
            }

            collectionManager.add(inputStudyGroup);
            return TextFormatting.getGreenText("\n\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
    }
}
