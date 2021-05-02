package utility;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashSet;

public class CollectionManager {

    private final HashSet<data.StudyGroup> studyGroups;

    private File xmlCollection;

    private ZonedDateTime initializationDate;

    private boolean wasStart;
}
