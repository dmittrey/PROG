package utility;

import data.*;
import utility.Interfaces.StudyGroupFactoryInterface;

import java.util.Date;

public class StudyGroupFactory implements StudyGroupFactoryInterface {

    private int id = 1;
    private final FieldsReceiver fieldsReceiver;
    private final Console console;
    private String creationDate;

    public StudyGroupFactory(FieldsReceiver aFieldsReceiver, Console aConsole) {

        fieldsReceiver = aFieldsReceiver;
        console = aConsole;
    }

    /**
     * Method creates new StudyGroup object
     *
     * @see FieldsReceiver
     */
    public StudyGroup createStudyGroup() {
        int id = getId();
        String name = fieldsReceiver.getName();
        Coordinates coordinates = fieldsReceiver.getCoordinates();
        Date creationDate = new Date();
        Integer studentsCount = fieldsReceiver.getStudentsCount();
        Double averageMark = fieldsReceiver.getAverageMark();
        FormOfEducation formOfEducation = fieldsReceiver.getFormOfEducation();
        Semester semester = fieldsReceiver.getSemester();
        Person groupAdmin = fieldsReceiver.getGroupAdmin();

        return new StudyGroup(id, name, coordinates, creationDate.toString(), studentsCount, averageMark, formOfEducation,
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
