package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.FieldsReceiver;
import utility.Interfaces.CollectionManagerInterface;
import utility.Interfaces.FieldsProtectorInterface;
import utility.Interfaces.StudyGroupFactoryInterface;
import utility.StudyGroupFactory;
import utility.TextFormatting;

/**
 * Class to update study groups in collection by id(set new fields)
 */
public class UpdateId extends CommandAbstract implements FieldsProtectorInterface {

    private final StudyGroupFactoryInterface studyGroupFactory;
    private final CollectionManagerInterface collectionManager;

    /**
     * Class constructor
     *
     * @param aStudyGroupFactory - Class to create new study group
     * @param aCollectionManager - Class to work with collection
     */
    public UpdateId(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("update", "update the element`s value, whose ID is equal to the given. " +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    /**
     * We return execute status
     * <p>
     * (In future we can return updated collection)
     */
    @Override
    public Object execute(String aArg) {
        if (isPositiveInt(aArg)) {
            StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

            if (studyGroup != null) collectionManager.remove(studyGroup);
            else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

            StudyGroup upgradingGroup = studyGroupFactory.createStudyGroup();
            upgradingGroup.setId(Integer.parseInt(aArg));
            collectionManager.add(upgradingGroup);

            return TextFormatting.getGreenText("\n\tObject has been updated!\n\n");
        }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}
