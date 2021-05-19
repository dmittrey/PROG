package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.FieldsReceiver;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class to update study groups in collection by id(set new fields)
 */
public class UpdateId extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final FieldsReceiver fieldsReceiver;
    private final CollectionManager collectionManager;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class to create new study group
     * @param aCollectionManager - Class to work with collection
     * @param aFieldsReceiver     - Class to read fields and create new study groups
     */
    public UpdateId(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager,
                    FieldsReceiver aFieldsReceiver) {
        super("update", "update the element`s value, whose ID is equal to the given. " +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
        fieldsReceiver = aFieldsReceiver;
    }

    @Override
    public String execute(String aArg) {
        if (fieldsReceiver.isPositiveInt(aArg)) {
            StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

            if (studyGroup != null) collectionManager.remove(studyGroup);
            else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

            collectionManager.add(studyGroupFactory.createStudyGroupWithId(Integer.parseInt(aArg)));

            return TextFormatting.getGreenText("\n\tSuccessful\n\n");
        }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}
