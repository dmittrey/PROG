package commands;

import utility.FileWorker;
import utility.TextFormatting;

/**
 * Class to save collection in xml file
 */
public class Save extends CommandAbstract {
    private final FileWorker fileWorker;

    /**
     * Class constructor
     *
     * @param aFileWorker - Class to work with xml file(read and save)
     */
    public Save(FileWorker aFileWorker) {
        super("save", "save the collection to file");
        fileWorker = aFileWorker;
    }

    @Override
    public String execute(String aArg) {
        return fileWorker.saveToXml();
    }
}
