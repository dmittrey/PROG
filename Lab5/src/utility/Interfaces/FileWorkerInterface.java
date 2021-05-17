package utility.Interfaces;

import data.StudyGroup;

import java.util.HashSet;

public interface FileWorkerInterface {

    /**
     * Print all objects from collection to xml file(file path should be in environment variable "FILE_PATH")
     *
     * @see commands.Save#execute
     */
    String getToXmlFormat();

    /**
     * Read objects from xml file and add objects to collection(file path should be in environment variable "FILE_PATH")
     */
    HashSet<StudyGroup> getFromXmlFormat();
}
