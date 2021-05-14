package commands;

import utility.CollectionManager;
import utility.TextFormatting;

public class MinByStudentsCount extends CommandAbstract {

    CollectionManager collectionManager;
    public MinByStudentsCount(CollectionManager aCollectionManager){
        super("min_by_students_count", "print any object from the collection whose " +
                "studentsCount field value is minimal");
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            try {
                return collectionManager.getMin().toString();
            } catch (NullPointerException e) {
                return TextFormatting.getRedText("There are no study groups in the collection yet");
            }
        } else {
            return TextFormatting.getRedText("Arguments entered incorrectly\n");
        }
    }

}
