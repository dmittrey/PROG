package commands;

import utility.CollectionManager;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class for read study group from console and add this in collection
 */
public class Add extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class for read fields from stdin
     * @param aCollectionManager - Class for add new element into collection
     */
    public Add(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("add", "add new element to the collection");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    /**
     * We returning status of execute
     *
     * (In future we can return collection with added object)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            collectionManager.add(studyGroupFactory.createStudyGroup());

            return TextFormatting.getGreenText("\n\n\tSuccessful\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
    }
}
