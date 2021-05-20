package utility;

import data.*;
import utility.Interfaces.StudyGroupFactoryInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for creating Study groups with autogenerate id and Date
 */
public class StudyGroupFactory implements StudyGroupFactoryInterface {

    private int id = 1;
    private final FieldsReceiver fieldsReceiver;

    public StudyGroupFactory(FieldsReceiver aFieldsReceiver) {

        fieldsReceiver = aFieldsReceiver;
    }

    /**
     * Method creates new StudyGroup object
     *
     * @see FieldsReceiver
     */
    @Override
    public StudyGroup createStudyGroup() {
        int id = getId();
        String name = fieldsReceiver.getName();
        Coordinates coordinates = fieldsReceiver.getCoordinates();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationDate = formatter.format(new Date());

        Integer studentsCount = fieldsReceiver.getStudentsCount();
        Double averageMark = fieldsReceiver.getAverageMark();
        FormOfEducation formOfEducation = fieldsReceiver.getFormOfEducation();
        Semester semester = fieldsReceiver.getSemester();
        Person groupAdmin = fieldsReceiver.getGroupAdmin();

        return new StudyGroup(id, name, coordinates, creationDate, studentsCount, averageMark, formOfEducation,
                    semester, groupAdmin);
    }

    /**
     * Method to increment id and return previous id
     */
    private int getId() {
        return id++;
    }
}
