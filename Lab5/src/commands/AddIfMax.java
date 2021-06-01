package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.Interfaces.CollectionManagerInterface;
import utility.Interfaces.StudyGroupFactoryInterface;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class for add maximum element in collection
 */
public class AddIfMax extends CommandAbstract {

    private final StudyGroupFactoryInterface studyGroupFactory;
    private final CollectionManagerInterface collectionManager;

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

    /**
     * We return status of execute and add maximal element in main collection
     * <p>
     * (In future we can return collection with added object or error message)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            StudyGroup inputStudyGroup = studyGroupFactory.createStudyGroup();

            if (collectionManager.getMax() != null) {
                if (inputStudyGroup.compareTo(collectionManager.getMax()) <= 0)
                    return TextFormatting.getRedText("\tStudy group isn't best!\n\n");
            }

            collectionManager.add(inputStudyGroup);
            return TextFormatting.getGreenText("\n\n\tStudy group has been added!\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
    }
}
