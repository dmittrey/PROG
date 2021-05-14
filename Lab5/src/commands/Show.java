package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.TextFormatting;

import java.util.HashSet;

public class Show extends CommandAbstract {

    private final HashSet<StudyGroup> studyGroups;

    public Show(CollectionManager aCollectionManager) {
        super("show", "print all elements in string representation to standard output");
        studyGroups = aCollectionManager.getCollection();
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            if (studyGroups.size() == 0) return TextFormatting.getRedText("\tCollection is empty!\n");
            StringBuilder sb = new StringBuilder();
            for (StudyGroup studyGroup: studyGroups) {
                sb.append(studyGroup);
                sb.append("------\n");
            }
            return sb.toString();
        } else {
            return TextFormatting.getRedText("\tArguments entered incorrectly\n");
        }
    }
}
