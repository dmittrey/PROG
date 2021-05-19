package data;

/**
 * Enum for study group form of education
 */
public enum FormOfEducation {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (FormOfEducation formOfEducation: FormOfEducation.values()) {
            stringBuilder.append(formOfEducation).append("\n");
        }
        return stringBuilder.toString();
    }
}
