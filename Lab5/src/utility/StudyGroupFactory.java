package utility;

import data.*;

import java.util.Date;
import java.util.Scanner;

public class StudyGroupFactory {

    private int id = 1;//Продумать конфликт id объектов из скрипта и объектов из консоли
    private final ProtectFields protectFields;
    private String creationDate;

    public StudyGroupFactory(ProtectFields aProtectFields){
        protectFields = aProtectFields;
    }

    /**
     * Method creates new StudyGroup object
     * @see ProtectFields
     */
    public StudyGroup createStudyGroup() {

        int id = getId();
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

    public StudyGroup createStudyGroupWithId(int anId) {
        StudyGroup newStudyGroup = createStudyGroup();
        newStudyGroup.setId(anId);
        id = anId;
        return newStudyGroup;
    }

    private int getId(){
        return id++;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);
        ProtectFields protectFields = new ProtectFields(console);
        StudyGroupFactory studyGroupFactory = new StudyGroupFactory(protectFields);
        console.print(studyGroupFactory.createStudyGroup());
    }
}
