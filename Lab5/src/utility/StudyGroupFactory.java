package utility;

import data.*;
import utility.Interfaces.StudyGroupFactoryInterface;

import java.util.Date;

public class StudyGroupFactory implements StudyGroupFactoryInterface {

    private int id = 1;
    private final ProtectFields protectFields;
    private String creationDate;

    public StudyGroupFactory(ProtectFields aProtectFields) {
        protectFields = aProtectFields;
    }

    /**
     * Method creates new StudyGroup object
     *
     * @see ProtectFields
     */
    public StudyGroup createStudyGroup() {

        int id = getId();
        String name = protectFields.getName();
        Coordinates coordinates = protectFields.getCoordinates();
        Date creationDate = new Date();
        Integer studentsCount = protectFields.getStudentsCount();
        Double averageMark = protectFields.getAverageMark();
        FormOfEducation formOfEducation = protectFields.getFormOfEducation();
        Semester semester = protectFields.getSemester();
        Person groupAdmin = protectFields.getGroupAdmin();

        return new StudyGroup(id, name, coordinates, creationDate, studentsCount, averageMark, formOfEducation,
                semester, groupAdmin);

    }

    public StudyGroup createStudyGroupWithId(int anId) {
        StudyGroup newStudyGroup = createStudyGroup();
        newStudyGroup.setId(anId);
        id = anId;
        return newStudyGroup;
    }

    private int getId() {
        return id++;
    }
}
