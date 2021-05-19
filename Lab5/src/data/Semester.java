package data;

/**
 * Enum for study group education semester
 */
public enum Semester {
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    SIXTH;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Semester semester: Semester.values()) {
            stringBuilder.append(semester).append("\n");
        }
        return stringBuilder.toString();
    }
}