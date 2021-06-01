package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.Interfaces.CollectionManagerInterface;
import utility.Interfaces.StudyGroupFactoryInterface;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class for read study group from console and add this in collection
 */
public class Add extends CommandAbstract {

    private final StudyGroupFactoryInterface studyGroupFactory;
    private final CollectionManagerInterface collectionManager;

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

            StudyGroup studyGroup = studyGroupFactory.createStudyGroup();

            if (studyGroup != null) collectionManager.add(studyGroup);

            return TextFormatting.getGreenText("\n\tObject has been added!\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
        }
    }
}
