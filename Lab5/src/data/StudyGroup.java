package data;

import utility.TextFormatting;

import java.util.Date;

/**
 * Class to study group
 */
public class StudyGroup implements Comparable<StudyGroup> {
    private int id;
    private final String name;
    private final Coordinates coordinates;
    private final Date creationDate;
    private final int studentsCount;
    private final Double averageMark;
    private final FormOfEducation formOfEducation;
    private final Semester semesterEnum;
    private final Person groupAdmin;

    /**
     * Class construct
     *
     * @param aId              - group id
     * @param aName            - group name
     * @param aCoordinates     - group coordinates
     * @param aCreationDate    - group creation date
     * @param aStudentsCount   - group student's count
     * @param aAverageMark     - group average mark
     * @param aFormOfEducation - group form of education
     * @param aSemesterEnum    - group semester of education
     * @param aGroupAdmin      - group admin
     * @see Person
     */
    public StudyGroup(int aId, String aName, Coordinates aCoordinates, Date aCreationDate, int aStudentsCount,
                      Double aAverageMark, FormOfEducation aFormOfEducation, Semester aSemesterEnum, Person aGroupAdmin) {
        id = aId;
        name = aName;
        coordinates = aCoordinates;
        creationDate = aCreationDate;
        studentsCount = aStudentsCount;
        averageMark = aAverageMark;
        formOfEducation = aFormOfEducation;
        semesterEnum = aSemesterEnum;
        groupAdmin = aGroupAdmin;
    }

    public void setId(int anId) {
        id = anId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Double getAverageMark() {
        return averageMark;
    }

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    /**
     * Method to compare two study groups by field(student's count)
     *
     * @param aStudyGroup - study group
     * @return "-1" - if study group in implicit parameter have more students
     *          "0" - if study groups have same students
     *          "1" - if study group in implicit parameter have less students
     */
    @Override
    public int compareTo(StudyGroup aStudyGroup) {

        if (this.getStudentsCount() < aStudyGroup.getStudentsCount()) {
            return 1;
        } else if (this.getStudentsCount() > aStudyGroup.getStudentsCount()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\n" + TextFormatting.getBlueText(name) + ":" + "\n" +
                "Id" + "\t\t\t\t\t:\t" + id + "\n" +
                "Coordinates" + "\t\t\t:\t" + coordinates + "\n" +
                "Creation date" + "\t\t:\t" + creationDate + "\n" +
                "Students count" + "\t\t:\t" + studentsCount + "\n" +
                "Average mark" + "\t\t:\t" + averageMark + "\n" +
                "Form of education" + "\t:\t" + formOfEducation + "\n" +
                "Semester enum" + "\t\t:\t" + semesterEnum + "\n" +
                "Group admin" + "\t\t\t:\t" + groupAdmin + "\n";
    }
}
