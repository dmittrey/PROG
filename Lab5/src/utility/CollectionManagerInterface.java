package utility;

import data.StudyGroup;

import java.util.HashSet;

public interface CollectionManagerInterface {

    /** introduce info about collection */
    String getInfo();

    /** Give collection */
    HashSet<StudyGroup> getCollection();

    /** Add element to te collection */
    void add(StudyGroup studyGroup);
}
