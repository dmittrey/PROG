package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.FieldsReceiver;
import utility.TextFormatting;

import java.util.HashSet;

/**
 * Class for count elements whose less than specified variable
 */
public class CountLessThanStudentsCount extends CommandAbstract {

    private final CollectionManager collectionManager;
    private final FieldsReceiver fieldsReceiver;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class to work with collection
     * @param aFieldsReceiver    - Class to read fields and check them for correctness
     */
    public CountLessThanStudentsCount(CollectionManager aCollectionManager, FieldsReceiver aFieldsReceiver) {
        super("count_less_than_students_count", "print the number of elements whose "
                + "studentsCount field value is less than the specified one" +
                TextFormatting.getBlueText("\n\tYou should to enter students count after entering a command"));
        collectionManager = aCollectionManager;
        fieldsReceiver = aFieldsReceiver;
    }

    @Override
    public String execute(String aArg) {
        HashSet<StudyGroup> collection = collectionManager.getCollection();

        if (collection.size() == 0) return TextFormatting.getRedText("\tCollection is empty!\n");

        if (fieldsReceiver.isPositiveInt(aArg)) {
            int i = 0;
            for (StudyGroup studyGroup : collection) {
                if (studyGroup.getStudentsCount() < Integer.parseInt(aArg)) i++;
            }
            return TextFormatting.getGreenText("\tAmount of elements: " + i + "\n");
        }

        return TextFormatting.getRedText("\tStudent's count should be not null positive integer number\n");
    }
}
