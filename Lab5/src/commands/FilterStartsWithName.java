package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.Console;
import utility.TextFormatting;

import java.util.HashSet;

public class FilterStartsWithName extends CommandAbstract{

    private final CollectionManager collectionManager;
    private final HashSet<StudyGroup> collection;

    public FilterStartsWithName(CollectionManager aCollectionManager){
        super("filter_starts_with_name", "output elements whose name field value starts " +
                "with the specified substring");
        collectionManager = aCollectionManager;
        collection = collectionManager.getCollection();
    }

    public String execute(String aArg){
        if (!aArg.equals("")) {
            if (collection.size() == 0){
                return TextFormatting.getRedText("\tCollection is empty!\n");
            } else {
                StringBuilder sb = new StringBuilder();
                for (StudyGroup studyGroup: collection) {
                    if (studyGroup.getName().contains(aArg)) sb.append(studyGroup).append("\n\t------\n");
                }
                return sb.toString();
            }
        } else {
            return TextFormatting.getRedText("\tSubstring should be not empty!\n");
        }
    }
}
