package commands;

import data.StudyGroup;
import utility.CollectionManager;

/** Добавляем учебную группу
 * Читаем объект из консоли и вставляем в коллекцию
 */

public class Add extends CommandAbstract{
    private final StudyGroupFactory factory;
    private final CollectionManager collectionManager;

    /** Конструктор
     * @param aFactory - factory for StudyGroup class
     * @param aCollectionManager - collection manager
     */

    public Add(StudyGroupFactory aFactory, CollectionManager aCollectionManager) {
        super("add {element}", "Add new element to the collection");
        factory = aFactory;
        collectionManager = aCollectionManager;
    }

    @Override
    public void execute(String arg){
        try {
            collectionManager.add(factory.getWorkerFromConsole());
        } catch (IncorrectValueException | NullFieldException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
