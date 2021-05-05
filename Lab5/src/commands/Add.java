package commands;

import data.StudyGroup;
import utility.CollectionManager;

/** Добавляем учебную группу
 * Читаем объект из консоли и вставляем в коллекцию
 */

public class Add extends CommandAbstract{

    public Add(String name, String aDescription) {
        super(name, aDescription);
    }
}
