package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.StudyGroupFactory;
import utility.TextFormatting;

public class AddIfMin extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final CollectionManager collectionManager;

    public AddIfMin(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("add_if_min", "add new element to the collection, if it`s value less, than " +
                "smallest element of this collection.");

        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {

            StudyGroup inputStudyGroup = studyGroupFactory.createStudyGroup();
            try {

                if (inputStudyGroup.compareTo(collectionManager.getMax()) >= 0) return TextFormatting.getRedText(
                        "\tStudy group isn't worst!\n\n");
            } catch (NullPointerException e) { }

            collectionManager.add(inputStudyGroup);
            return TextFormatting.getGreenText("\tSuccessful!\n\n");

        } else {

            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}
