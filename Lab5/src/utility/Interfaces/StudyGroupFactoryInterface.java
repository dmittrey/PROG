package utility.Interfaces;

import data.StudyGroup;

public interface StudyGroupFactoryInterface {

    StudyGroup createStudyGroup();

    StudyGroup createStudyGroupWithId(int anId);
}
