package utility;

import data.*;
import utility.Interfaces.StudyGroupFactoryInterface;

import java.util.Date;

/**
 * Class for creating Study groups with autogenerate id and Date
 */
public class StudyGroupFactory implements StudyGroupFactoryInterface {

    private int id = 1;
    private final FieldsReceiver fieldsReceiver;
    private final CollectionManager collectionManager;

    public StudyGroupFactory(FieldsReceiver aFieldsReceiver, CollectionManager aCollectionManager) {

        fieldsReceiver = aFieldsReceiver;
        collectionManager = aCollectionManager;
    }

    /**
     * Method creates new StudyGroup object
     *
     * @see FieldsReceiver
     */
    @Override
    public StudyGroup createStudyGroup() {
        int id = getId();
        while (!collectionManager.getUsedId().add(id)) {
            id = getId();
        }
        String name = fieldsReceiver.getName();
        Coordinates coordinates = fieldsReceiver.getCoordinates();
        Integer studentsCount = fieldsReceiver.getStudentsCount();
        Double averageMark = fieldsReceiver.getAverageMark();
        FormOfEducation formOfEducation = fieldsReceiver.getFormOfEducation();
        Semester semester = fieldsReceiver.getSemester();
        Person groupAdmin = fieldsReceiver.getGroupAdmin();

        return new StudyGroup(id, name, coordinates, new Date(), studentsCount, averageMark, formOfEducation,
                    semester, groupAdmin);
    }

    /**
     * Method to increment id and return previous id
     */
    private int getId() {
        return id++;
    }
}
