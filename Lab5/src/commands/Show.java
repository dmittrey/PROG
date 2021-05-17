package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.TextFormatting;

import java.util.HashSet;

/**
 * Class to print all elements from collection in stdout
 */
public class Show extends CommandAbstract {

    private final CollectionManager collectionManager;

    private final HashSet<StudyGroup> studyGroupsCopy;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public Show(CollectionManager aCollectionManager) {
        super("show", "print all elements in string representation to standard output");
        collectionManager = aCollectionManager;
        studyGroupsCopy = (HashSet<StudyGroup>) collectionManager.getCollection().clone();
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            if (collectionManager.getCollection().size() == 0)
                return TextFormatting.getRedText("\tCollection is empty!\n");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < collectionManager.getCollection().size(); i++) {
                sb.append(collectionManager.getMax());
                collectionManager.remove(collectionManager.getMax());
                sb.append("------\n");
            }
            collectionManager.setCollection(studyGroupsCopy);
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
