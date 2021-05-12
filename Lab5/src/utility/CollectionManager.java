package utility;

import data.StudyGroup;

import java.time.LocalDate;
import java.util.HashSet;

public class CollectionManager implements CollectionManagerInterface {

    private final HashSet<data.StudyGroup> studyGroups;

    private boolean exeDone;

    private final LocalDate initTime;

    public CollectionManager() {
        studyGroups = new HashSet<>();
        initTime = LocalDate.now();
    }

    public String getInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("\t").append("Type of collection:").append("\t\t\t\t\t").append("HashSet").append("\n");
        sb.append("\t").append("Type of collection items:").append("\t\t\t").append("Study groups").append("\n");
        sb.append("\t").append("Priority:").append("\t\t\t\t\t\t\t").append("Average mark").append("\n");
        sb.append("\t").append("Initialization date:").append("\t\t\t\t").append(initTime).append("\n");
        sb.append("\t").append("Number of items in te collection:").append("\t").append(this.getCount()).append("\n");
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

    public void add() {

    }

}
