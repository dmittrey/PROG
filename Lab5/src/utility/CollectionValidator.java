package utility;

import data.StudyGroup;
import utility.Interfaces.FieldsProtectorInterface;

import java.util.HashSet;

/**
 * Class to validate objects from xml file and add correct study groups in collection
 */
public class CollectionValidator implements FieldsProtectorInterface {

    CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aCollectionManager - Class for add new element into collection
     */
    public CollectionValidator(CollectionManager aCollectionManager) {
        collectionManager = aCollectionManager;
    }

    public String validateCollection(HashSet<StudyGroup> inputCollection) {

        for (StudyGroup studyGroup : inputCollection) {

            if (getIdCorrectStatus(String.valueOf(studyGroup.getId())) &&
                    getNameCorrectStatus(String.valueOf(studyGroup.getName())) &&
                    getCoordinateXCorrectStatus(String.valueOf(studyGroup.getCoordinates().getX())) &&
                    getCoordinateYCorrectStatus(String.valueOf(studyGroup.getCoordinates().getY())) &&
                    getDateCorrectStatus(studyGroup.getCreationDate()) &&
                    getStudentsCountCorrectStatus(String.valueOf(studyGroup.getStudentsCount())) &&
                    getAverageMarkCorrectStatus(String.valueOf(studyGroup.getAverageMark())) &&
                    getFormOfEducationCorrectStatus(String.valueOf(studyGroup.getFormOfEducation())) &&
                    getSemesterEnumCorrectStatus(String.valueOf(studyGroup.getSemesterEnum())) &&
                    getNameCorrectStatus(String.valueOf(studyGroup.getGroupAdmin().getName())) &&
                    getGroupAdminWeightCorrectStatus(String.valueOf(studyGroup.getGroupAdmin().getWeight())) &&
                    getGroupAdminHairColorCorrectStatus(String.valueOf(studyGroup.getGroupAdmin().getHairColor()))) {
                collectionManager.add(studyGroup);
            } else return TextFormatting.getGreenText("\n\tXml file has been broken!(not all objects was loaded)\n\n");
        }
        return TextFormatting.getGreenText("\n\tCollection was loaded!\n\n");
    }
}
