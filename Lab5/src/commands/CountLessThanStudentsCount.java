package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.ProtectFields;
import utility.TextFormatting;

import java.util.HashSet;

public class CountLessThanStudentsCount extends CommandAbstract{

    private final CollectionManager collectionManager;
    private final ProtectFields protectFields;
    private HashSet<StudyGroup> collection;

    public CountLessThanStudentsCount(CollectionManager aCollectionManager, ProtectFields aProtectFields){
        super("count_less_than_students_count", "print the number of elements whose "
                + "studentsCount field value is less than the specified one.");
        collectionManager = aCollectionManager;
        protectFields = aProtectFields;
    }

    public String execute(String aArg){
        collection = collectionManager.getCollection();

        if (collection.size() == 0) return TextFormatting.getRedText("\tCollection is empty!\n");

        if (protectFields.isPositiveInt(aArg)) {
            int i = 0;
            for (StudyGroup studyGroup: collection) {if (studyGroup.getStudentsCount() < Integer.parseInt(aArg)) i++;}
            return TextFormatting.getGreenText("\tAmount of elements: " + i + "\n");
        }

        return TextFormatting.getRedText("\tStudent's count should be not null positive integer number\n");
    }
}
