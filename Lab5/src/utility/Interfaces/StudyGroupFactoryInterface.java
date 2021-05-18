package utility.Interfaces;

import data.StudyGroup;

public interface StudyGroupFactoryInterface {

    /**
     * Method creates study group with generate id and date
     */
    StudyGroup createStudyGroup();

    /**
     * Method creates group with generate date
     * @param anId - custom id
     */
    StudyGroup createStudyGroupWithId(int anId);
}
