package utility;

import data.*;

import java.util.Date;

public class StudyGroupFactory {

    private Integer id = 1;
    private ProtectFields protectFields;
    private String creationDate;

    public StudyGroupFactory(ProtectFields aProtectFields){
        protectFields = aProtectFields;
    }

    public StudyGroup createStudyGroup() {

        Integer id = getId();
        String name = protectFields.getName();
        Coordinates coordinates = protectFields.getCoordinates();
        String creationDate = new Date().toString();
        Integer studentsCount = protectFields.getStudentsCount();
        Double averageMark = protectFields.getAverageMark();
        FormOfEducation formOfEducation = protectFields.getFormOfEducation();
        Semester semester = protectFields.getSemester();
        Person groupAdmin = protectFields.getGroupAdmin();

        return new StudyGroup(id, name, coordinates, creationDate, studentsCount, averageMark, formOfEducation,
                semester, groupAdmin);

    }

    private int getId(){
        return id++;
    }
}
