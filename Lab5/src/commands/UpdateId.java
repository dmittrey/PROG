package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.ProtectFields;
import utility.StudyGroupFactory;
import utility.TextFormatting;

import java.util.HashSet;

public class UpdateId extends CommandAbstract{

    private final StudyGroupFactory studyGroupFactory;
    private final ProtectFields protectFields;
    private final CollectionManager collectionManager;

    public UpdateId(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager,
                    ProtectFields aProtectFields) {
        super("update", "update the element`s value, whose ID is equal to the given. " +
                TextFormatting.getBlueText("\n\tYou should to enter ID after entering a command"));
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
        protectFields = aProtectFields;
    }

    @Override
    public String execute(String aArg){
        try {
            if (protectFields.isPositiveInt(aArg)) {
                StudyGroup studyGroup = collectionManager.getId(Integer.parseInt(aArg));

                if (studyGroup != null) collectionManager.remove(studyGroup);
                else return TextFormatting.getRedText("\tAn object with this id does not exist!\n");

                collectionManager.add(studyGroupFactory.createStudyGroupWithId(Integer.parseInt(aArg)));

                return TextFormatting.getGreenText("\n\tSuccessful\n\n");
            }
        } catch (NullPointerException ignored) { }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }


}
