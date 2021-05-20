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

    @Override
    public String getInfo() {

        return "Type of collection" + "  \t\t\t:\t" + "HashSet" + "\n" +
                "Type of collection items" + "\t\t:\t" + "Study groups" + "\n" +
                "Priority" + "\t\t\t\t:\t" + "Student's count" + "\n" +
                "Initialization date" + "\t\t\t:\t" + initTime + "\n" +
                "Number of items in te collection" + "\t:\t" + studyGroups.size() + "\n\n";
    }

    @Override
    public HashSet<StudyGroup> getCollection() {
        return studyGroups;
    }

    @Override
    @XmlElement(name = "studyGroup")
    public void setCollection(HashSet<StudyGroup> aStudyGroups) {
        studyGroups = aStudyGroups;
    }

    @Override
    public void add(StudyGroup studyGroup) {

        for (StudyGroup currentStudyGroup : studyGroups) {
            if (currentStudyGroup.getId() == studyGroup.getId()) remove(currentStudyGroup);
        }
        studyGroups.add(studyGroup);
        //тут надо добавить на проверку исключительности id и если такой элемент уже есть то старый элемент удалять
        //но тут такой момент что не надо трогать id которые добавлены из xml файла(привязать к генерации значит)
    }

    @Override
    public void remove(StudyGroup studyGroup) {
        studyGroups.remove(studyGroup);
    }

    @Override
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

    @Override
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

    @Override
    public StudyGroup getId(int key) {
        for (StudyGroup studyGroup : studyGroups) {
            if (studyGroup.getId() == key) return studyGroup;
        }
        return null;
    }

    @Override
    public void clear() {
        studyGroups.clear();
    }
}
