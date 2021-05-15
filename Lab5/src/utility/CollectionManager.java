package utility;

import data.StudyGroup;

import java.util.Date;
import java.util.HashSet;

public class CollectionManager implements CollectionManagerInterface {

    private HashSet<data.StudyGroup> studyGroups;

    private boolean exeDone;

    private final String initTime;

    public CollectionManager() {
        studyGroups = new HashSet<>();
        initTime = new Date().toString();
    }

    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("\t").append("Type of collection").append("\t\t\t\t\t:\t").append("HashSet").append("\n");
        sb.append("\t").append("Type of collection items").append("\t\t\t:\t").append("Study groups").append("\n");
        sb.append("\t").append("Priority").append("\t\t\t\t\t\t\t:\t").append("Student's count").append("\n");
        sb.append("\t").append("Initialization date").append("\t\t\t\t\t:\t").append(initTime).append("\n");
        sb.append("\t").append("Number of items in te collection").append("\t:\t").append(this.getCount()).append("\n\n");
        return sb.toString();
    }

    /**
     * Возвращает кол-во элементов в коллекции
     *
     * @see CollectionManager#getInfo()
     */
    private int getCount() {
        return studyGroups.size();
    }

    /**
     * Возвращает коллекцию
     *
     * @see commands.Show
     */
    public HashSet<StudyGroup> getCollection() {
        return studyGroups;
    }

    public void setCollection(HashSet<StudyGroup> newCollection) {
        studyGroups = newCollection;
    }

    public void add(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
    }

    public void remove(StudyGroup studyGroup) {
        studyGroups.remove(studyGroup);
    }

    public StudyGroup getMin() {

        StudyGroup minGroup = null;

        for (StudyGroup studyGroup : getCollection()) {
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
        return  maxGroup;
    }

    public StudyGroup getId(int key) {
        for (StudyGroup studyGroup: studyGroups) {
            if (studyGroup.getId() == key) return studyGroup;
        }
        return null;
    }

    public void clear(){
        getCollection().clear();
    }

    public String getPath(){
        return System.getenv("FILE_PATH");
    }



}
