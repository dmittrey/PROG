package data;

import utility.TextFormatting;

public class StudyGroup implements Comparable<StudyGroup> {
    private int id;
    private final String name;
    private final Coordinates coordinates;
    private final String creationDate;
    private final int studentsCount;
    private final Double averageMark;
    private final FormOfEducation formOfEducation;
    private final Semester semesterEnum;
    private final Person groupAdmin;

    public StudyGroup(int aId, String aName, Coordinates aCoordinates, String aCreationDate, int aStudentsCount,
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

    public void setId(int anId){
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

    public String getCreationDate() {
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

    @Override
    public int compareTo(StudyGroup aStudyGroup) {

        if (this.getStudentsCount() < aStudyGroup.getStudentsCount()) {
            return 1;
        }
        else if (this.getStudentsCount() > aStudyGroup.getStudentsCount()) {
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
