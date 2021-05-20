package data;

import utility.TextFormatting;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class to study group
 */
@XmlType(propOrder = {"id", "name", "coordinates", "creationDate", "studentsCount", "averageMark", "formOfEducation",
        "semesterEnum", "groupAdmin"})
public class StudyGroup implements Comparable<StudyGroup> {

    private int id;
    private String name;
    private Coordinates coordinates;
    private String creationDate;
    private int studentsCount;
    private Double averageMark;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;

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
    public StudyGroup(int aId, String aName, Coordinates aCoordinates, String aCreationDate, int aStudentsCount,
                      Double aAverageMark, FormOfEducation aFormOfEducation, Semester aSemesterEnum,
                      Person aGroupAdmin) {
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

    /**
     * Class constructor for Xml parser
     */
    public StudyGroup() {
    }

    @XmlAttribute
    public void setId(int anId) {
        id = anId;
    }

    @XmlElement
    public void setName(String aName) {
        name = aName;
    }

    @XmlElement
    public void setCoordinates(Coordinates aCoordinates) {
        coordinates = aCoordinates;
    }

    @XmlElement
    public void setCreationDate(String aCreationDate) {
        creationDate = aCreationDate;
    }

    @XmlElement
    public void setStudentsCount(int aStudentsCount) {
        studentsCount = aStudentsCount;
    }

    @XmlElement
    public void setAverageMark(Double anAverageMark) {
        averageMark = anAverageMark;
    }

    @XmlElement
    public void setFormOfEducation(FormOfEducation aFormOfEducation) {
        formOfEducation = aFormOfEducation;
    }

    @XmlElement
    public void setSemesterEnum(Semester aSemesterEnum) {
        semesterEnum = aSemesterEnum;
    }

    @XmlElement
    public void setGroupAdmin(Person aGroupAdmin) {
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

    /**
     * Method to compare two study groups by field(student's count)
     *
     * @param aStudyGroup - study group
     * @return "-1" - if study group in implicit parameter have more students
     * "0" - if study groups have same students
     * "1" - if study group in implicit parameter have less students
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
                "Id" + "\t\t\t:\t" + id + "\n" +
                "Coordinates" + "\t\t:\t" + coordinates + "\n" +
                "Creation date" + "\t\t:\t" + creationDate + "\n" +
                "Students count" + "\t\t:\t" + studentsCount + "\n" +
                "Average mark" + "\t\t:\t" + averageMark + "\n" +
                "Form of education" + "\t:\t" + formOfEducation + "\n" +
                "Semester enum" + "\t\t:\t" + semesterEnum + "\n" +
                "Group admin" + "\t\t:\t" + groupAdmin + "\n";
    }
}
