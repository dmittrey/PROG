package utility;

import utility.Console;
import java.time.ZonedDateTime;
import java.util.HashSet;

public class CollectionManager {

    private final HashSet<data.StudyGroup> studyGroups;

    private boolean exeDone;

    private final ZonedDateTime initTime;

    private final Console console;

    public CollectionManager(Console aConsole) {
        studyGroups = new HashSet<>();
        initTime = ZonedDateTime.now();
        console = aConsole;
    }

    /**
     *
     *
     * Тут будут распологаться команды для взимодействия к коллекцией,
     * но при этом они будут не полностью обрабатывать элементы а просто возвращать требуемое
     *
     */
}
