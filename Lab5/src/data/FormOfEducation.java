package data;

/**
 * Enum for study group form of education
 */
public enum FormOfEducation implements Comparable<FormOfEducation>{
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    int CompareTo(FormOfEducation formOfEducation){
        if (this.equals(FormOfEducation.FULL_TIME_EDUCATION) &&
                (formOfEducation.equals(FormOfEducation.DISTANCE_EDUCATION) ||
                formOfEducation.equals(FormOfEducation.EVENING_CLASSES))) return 1;

        else if (this.equals(FormOfEducation.DISTANCE_EDUCATION) &&
                (formOfEducation.equals(FormOfEducation.EVENING_CLASSES))) return 1;

        else if (this.equals(formOfEducation)) return 0;

        else return -1;
    }
}
