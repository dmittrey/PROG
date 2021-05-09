package utility;

import data.StudyGroup;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;

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

    private int getCount() {
        /**
         * Прочитать про итератор по нормальному
         */

        Iterator<StudyGroup> iterator = studyGroups.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            System.out.println();
            i++;
        }
        return i;
    }



}
