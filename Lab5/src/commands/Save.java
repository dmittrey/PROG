package commands;

import utility.FileWorker;
import utility.Interfaces.FileWorkerInterface;

/**
 * Class to save collection in xml file
 */
public class Save extends CommandAbstract {
    private final FileWorkerInterface fileWorker;

    /**
     * Class constructor
     *
     * @param aFileWorker - Class to work with xml file(read and save)
     */
    public Save(FileWorker aFileWorker) {
        super("save", "save the collection to file");
        fileWorker = aFileWorker;
    }

    /**
     * We return execute status
     * <p>
     * (In future also)
     */
    @Override
    public Object execute(String aArg) {
        return fileWorker.saveToXml();
    }
}
