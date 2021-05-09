package commands;

import data.StudyGroup;
import utility.CollectionManager;

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
            StringBuilder sb = new StringBuilder();
            for (StudyGroup studyGroup: studyGroups) {
                sb.append(getObjectInfo(studyGroup));
                sb.append("\n------\n");
            }
            return sb.toString();
        } else {
            return "Arguments entered incorrectly";
        }
    }


    private StringBuilder getObjectInfo(StudyGroup aStudyGroup) {
        StringBuilder sb = new StringBuilder();
        sb.append(aStudyGroup.getName()).append(":").append("\n");
        sb.append("Id").append("\t\t:\t\t").append(aStudyGroup.getId()).append("\n");
        sb.append("Coordinates").append("\t\t:\t\t").append(aStudyGroup.getCoordinates()).append("\n");
        sb.append("Creation date").append("\t\t:\t\t").append(aStudyGroup.getCreationDate());
        sb.append("Students count").append("\t\t:\t\t").append(aStudyGroup.getStudentsCount());
        sb.append("Average mark").append("\t\t:\t\t").append(aStudyGroup.getAverageMark());
        sb.append("Form of education").append("\t\t:\t\t").append(aStudyGroup.getFormOfEducation());
        sb.append("Semester enum").append("\t\t:\t\t").append(aStudyGroup.getSemesterEnum());
        sb.append("Group admin").append("\t\t:\t\t").append(aStudyGroup.getGroupAdmin());
        return sb;
    }
}
