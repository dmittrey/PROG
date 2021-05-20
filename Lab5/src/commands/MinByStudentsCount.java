package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.TextFormatting;

/**
 * Class print object form collection
 */
public class MinByStudentsCount extends CommandAbstract {

    CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public MinByStudentsCount(CollectionManager aCollectionManager) {
        super("min_by_students_count", "print any object from the collection whose " +
                "studentsCount field value is minimal");
        collectionManager = aCollectionManager;
    }

    /**
     * We return execute status
     *
     * (In future we can return min object from collection and print on client)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            try {
                return collectionManager.getMin().toString();
            } catch (NullPointerException e) {
                return TextFormatting.getRedText("\tThere are no study groups in the collection yet!\n");
            }
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly!\n");
        }
    }
}
