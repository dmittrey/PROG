package utility;

import data.StudyGroup;
import utility.Interfaces.CollectionManagerInterface;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Class to work with collection
 */
@XmlRootElement(name = "studyGroups")
public class CollectionManager implements CollectionManagerInterface {

    private HashSet<data.StudyGroup> studyGroups;

    private final String initTime;

    public CollectionManager() {
        studyGroups = new HashSet<>();
        initTime = new Date().toString();
    }

    public String getInfo() {

        return "Type of collection" + "  \t\t\t:\t" + "HashSet" + "\n" +
                "Type of collection items" + "\t\t:\t" + "Study groups" + "\n" +
                "Priority" + "\t\t\t\t:\t" + "Student's count" + "\n" +
                "Initialization date" + "\t\t\t:\t" + initTime + "\n" +
                "Number of items in te collection" + "\t:\t" + studyGroups.size() + "\n\n";
    }

    public HashSet<StudyGroup> getCollection() {
        return studyGroups;
    }

    @XmlElement(name = "studyGroup")
    public void setCollection(HashSet<StudyGroup> aStudyGroups) {
        studyGroups = aStudyGroups;
    }

    public void add(StudyGroup studyGroup) {

        for (StudyGroup currentStudyGroup : studyGroups) {
            if (currentStudyGroup.getId() == studyGroup.getId()) remove(currentStudyGroup);
        }
        studyGroups.add(studyGroup);
    }

    public void remove(StudyGroup studyGroup) {
        studyGroups.remove(studyGroup);
    }

    public StudyGroup getMin() {

        StudyGroup minGroup = null;

        for (StudyGroup studyGroup : studyGroups) {
            if (minGroup == null) {
                minGroup = studyGroup;
            } else {
                if (minGroup.compareTo(studyGroup) < 0) minGroup = studyGroup;
            }
        }

        return minGroup;
    }

    public StudyGroup getMax() {

        StudyGroup maxGroup = null;

        for (StudyGroup studyGroup : studyGroups) {
            if (maxGroup == null) {
                maxGroup = studyGroup;
            } else {
                if (maxGroup.compareTo(studyGroup) > 0) maxGroup = studyGroup;
            }
        }
        return maxGroup;
    }

    public StudyGroup getId(int key) {
        for (StudyGroup studyGroup : studyGroups) {
            if (studyGroup.getId() == key) return studyGroup;
        }
        return null;
    }

    public void clear() {
        studyGroups.clear();
    }
}
