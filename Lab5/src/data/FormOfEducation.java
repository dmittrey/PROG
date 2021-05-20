package data;

/**
 * Enum for study group form of education
 */
public enum FormOfEducation implements Comparable<FormOfEducation>{
    DISTANCE_EDUCATION("DISTANCE_EDUCATION"),
    FULL_TIME_EDUCATION("FULL_TIME_EDUCATION"),
    EVENING_CLASSES("EVENING_CLASSES");

    private final String stringRepresentation;

    FormOfEducation(String aStringRepresentation){
        stringRepresentation = aStringRepresentation;
    }

    private String getStringRepresentation(){
        return stringRepresentation;
    }

    public static boolean isIncludeElement(String aFormOfEducation){

        for (FormOfEducation currentFormOfEducation: FormOfEducation.values()){
            if (aFormOfEducation.equals(currentFormOfEducation.getStringRepresentation())) return true;
        }

        return false;
    }
}
