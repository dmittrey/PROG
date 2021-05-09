package commands;

import utility.CollectionManager;

public class Info extends CommandAbstract{

    private CollectionManager collectionManager;

    public Info(CollectionManager aCollectionManager){
        super("info", "print information about the collection (type, "
                        + "initialization date, number of elements, etc.) to standard output");
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String aArg) {
        return collectionManager.getInfo();
    }
}
