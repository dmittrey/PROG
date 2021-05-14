package commands;

import utility.CollectionManager;
import utility.StudyGroupFactory;
import utility.TextFormatting;

public class Add extends CommandAbstract {

    private final StudyGroupFactory studyGroupFactory;
    private final CollectionManager collectionManager;

    public Add(StudyGroupFactory aStudyGroupFactory, CollectionManager aCollectionManager) {
        super("add", "add new element to the collection");
        studyGroupFactory = aStudyGroupFactory;
        collectionManager = aCollectionManager;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            collectionManager.add(studyGroupFactory.createStudyGroup());

            return TextFormatting.getGreenText("\n\n\tSuccessful\n\n");
        } else {
            return TextFormatting.getRedText("\tCommand arguments entered incorrectly!\n");
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
 *
 * убрать обновление id
 */
