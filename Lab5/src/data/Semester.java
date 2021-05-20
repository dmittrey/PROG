package data;

/**
 * Enum for study group education semester
 */
public enum Semester {
    SECOND("SECOND"),
    THIRD("THIRD"),
    FOURTH("FOURTH"),
    FIFTH("FIFTH"),
    SIXTH("SIXTH");

    private final String stringRepresentation;

    Semester(String aStringRepresentation){
        stringRepresentation = aStringRepresentation;
    }

    private String getStringRepresentation(){
        return stringRepresentation;
    }

    public static boolean isIncludeElement(String aSemester){

        for (Semester currentSemester: Semester.values()){
            if (aSemester.equals(currentSemester.getStringRepresentation())) return true;
        }

        return false;
    }
}