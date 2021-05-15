package commands;

import utility.FileWorker;
import utility.TextFormatting;

import java.io.IOException;

public class Save extends CommandAbstract {
    private final FileWorker fileWorker;

    public Save(FileWorker aFileWorker){
        super("save", "save the collection to file");
        fileWorker = aFileWorker;
    }

    @Override
    public String execute(String aArg) throws IOException {
        fileWorker.getToXmlFormat();
        return TextFormatting.getGreenText("\tSuccessful\n");
    }
}
