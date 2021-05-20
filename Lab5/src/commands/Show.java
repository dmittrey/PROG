package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.TextFormatting;

/**
 * Class to print all elements from collection in stdout
 */
public class Show extends CommandAbstract {

    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public Show(CollectionManager aCollectionManager) {
        super("show", "print all elements in string representation to standard output");
        collectionManager = aCollectionManager;
    }

    /**
     * We return execute status
     *
     * (In future we can return collection and print on client)
     */
    @Override
    public Object execute(String aArg) {
        if (aArg.equals("")) {
            if (collectionManager.getCollection().size() == 0)
                return TextFormatting.getRedText("\tCollection is empty!\n");
            StringBuilder sb = new StringBuilder();
            for (StudyGroup studyGroup : collectionManager.getCollection()) {
                sb.append(studyGroup);
                sb.append("------\n");
            }
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
