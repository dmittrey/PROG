package data;

import java.util.Date;

public class StudyGroup implements Comparable<StudyGroup> {
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private String creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private Double averageMark; //Значение поля должно быть больше 0, Поле может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null

    public StudyGroup(int aId, String aName, Coordinates aCoordinates, String aCreationDate, int aStudentsCount,
                      Double aAverageMark, FormOfEducation aFormOfEducation, Semester aSemesterEnum, Person aGroupAdmin) {
        id = aId;//
        name = aName;//
        coordinates = aCoordinates;//
        creationDate = aCreationDate;//
        studentsCount = aStudentsCount;//
        averageMark = aAverageMark;
        formOfEducation = aFormOfEducation;
        semesterEnum = aSemesterEnum;
        groupAdmin = aGroupAdmin;
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
        return "Study Group №" + id
                + "(added " + creationDate + ")"
                + "Name: " + name
                + "Location: " + coordinates
                + "Group size: " + studentsCount
                + "Average mark: " + averageMark
                + "formOfEducation" + formOfEducation
                + "semesterEnum" + semesterEnum
                + "groupAdmin" + groupAdmin;
    }


}
