package commands;

import data.StudyGroup;
import utility.CollectionManager;
import utility.ProtectFields;
import utility.TextFormatting;

public class RemoveById extends CommandAbstract{

    private final CollectionManager collectionManager;
    private final ProtectFields protectFields;

    public RemoveById(CollectionManager aCollectionManager,
                      ProtectFields aProtectFields){
        super("remove_by_id", "remove an element from the collection by ID." +
                TextFormatting.getBlueText("You should to enter ID after entering a command"));
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

                return TextFormatting.getGreenText("\n\tSuccessful\n");
            }
        } catch (NullPointerException ignored) { }
        return TextFormatting.getRedText("\tId should be not null positive integer!\n");
    }
}
