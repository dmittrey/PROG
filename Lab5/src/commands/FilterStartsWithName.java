package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.TextFormatting;

import java.util.HashSet;

/**
 * Class for print elements which name field starts with special substring
 */
public class FilterStartsWithName extends CommandAbstract {

    private final HashSet<StudyGroup> collection;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     */
    public FilterStartsWithName(CollectionManager aCollectionManager) {
        super("filter_starts_with_name", "output elements whose name field value starts " +
                "with the specified substring");
        collection = aCollectionManager.getCollection();
    }

    /**
     * We return execute status
     *
     * (In future we can return ArrayList of names or error message)
     */
    public Object execute(String aArg) {
        if (!aArg.equals("")) {
            if (collection.size() == 0) {
                return TextFormatting.getRedText("\tCollection is empty!\n");
            } else {
                StringBuilder sb = new StringBuilder();
                for (StudyGroup studyGroup : collection) {
                    if (studyGroup.getName().contains(aArg)) sb.append(studyGroup).append("------\n");
                }
                if (sb.toString().equals("")) return TextFormatting.getRedText("\tNo objects found!\n");
                else return sb.toString();
            }
        } else {
            return TextFormatting.getRedText("\tSubstring should be not empty!\n");
        }
    }
}
