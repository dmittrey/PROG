package commands;

import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupFactory;
import utility.TextFormatting;

public class Add extends CommandAbstract {

    private final Console console;
    private final CollectionManager collectionManager;
    private final StudyGroupFactory studyGroupFactory;

    public Add(CollectionManager aCollectionManager, Console aConsole, StudyGroupFactory aStudyGroupFactory) {
        super("add", "add new element to the collection");
        collectionManager = aCollectionManager;
        console = aConsole;
        studyGroupFactory = aStudyGroupFactory;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            studyGroupFactory.createStudyGroup();
            return TextFormatting.getGreenText("\tSuccessful\n\n");
        } else {
            return TextFormatting.getRedText("Command arguments entered incorrectly!\n");
        }
    }
}

/**
 * Yаписать документацию к команде, поработать с другими кмандами(кроме скрипта), там будет связка
 *
 * CollectionManager + команда
 *
 * Затем перейти к работе со скриптом и закончить переменной окружения(мб закончу к утру, надо понять, имеет ли
 * смысл не спать и идти или нужно постараться чтобы он дал код ревью и я могу бы сдать выполнение(чтобы он потыкал
 * прогу лишний раз))
 */
