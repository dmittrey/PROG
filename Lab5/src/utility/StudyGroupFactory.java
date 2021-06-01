package utility;

import data.*;
import utility.Interfaces.CollectionManagerInterface;
import utility.Interfaces.FieldsReceiverInterface;
import utility.Interfaces.ObjectValidator;
import utility.Interfaces.StudyGroupFactoryInterface;

import java.util.Date;

/**
 * Class for creating Study groups with autogenerate id and Date
 */
public class StudyGroupFactory implements StudyGroupFactoryInterface, ObjectValidator {

    private int id = 1;
    private final FieldsReceiverInterface fieldsReceiver;
    private final CollectionManagerInterface collectionManager;

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

        if ((name != null) &&
                (coordinates != null) &&
                (studentsCount != null) &&
                (semester != null) &&
                (groupAdmin != null)) {
            return new StudyGroup(id, name, coordinates, new Date(), studentsCount,
                    averageMark, formOfEducation, semester, groupAdmin);
        }
        return null;
    }

    /**
     * Method to increment id and return previous id
     */
    private int getId() {
        return id++;
    }
}
