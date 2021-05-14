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
    private HashSet<StudyGroup> collection;

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
            if (protectFields.isPositiveInt(aArg)){
                collection = collectionManager.getCollection();
                for (StudyGroup studyGroup: collection) {
                    if (studyGroup.getId() == Integer.parseInt(aArg)) {
                        // fixme страшный момент с ссылкой на объекты(если там лежит Integer, то нам пиздец)
                        collection.remove(studyGroup);
                        collection.add(studyGroupFactory.createStudyGroupWithId(Integer.parseInt(aArg)));
                        return TextFormatting.getGreenText("\n\tSuccessful\n");
                    }
                }
                return TextFormatting.getRedText("\tAn object with this id does not exist!\n");
            }
        } catch (NullPointerException ignored) { }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }


}
