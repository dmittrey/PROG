package commands;

import utility.CollectionManager;
import utility.TextFormatting;

public class Clear extends CommandAbstract{

    private final CollectionManager collectionManager;

    public Clear(CollectionManager aCollectionManager){
        super("clear", "clear the collection");
        collectionManager = aCollectionManager;
    }

    public String execute(String aArg){
        if (aArg.equals("")) {
        collectionManager.clear();
        return TextFormatting.getGreenText("\n\tSuccessful!\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}
