package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashSet;

/** Class for print collection in xml format */
@XmlRootElement(name = "studyGroups")
public class CollectionToPrint {

    HashSet<StudyGroup> studyGroups;

    public CollectionToPrint(){
        studyGroups = new HashSet<>();
    };

    public CollectionToPrint(HashSet<StudyGroup> aStudyGroups){
        studyGroups = aStudyGroups;
    }

    @XmlElement (name = "studyGroup")
    public void setStudyGroups(HashSet<StudyGroup> aStudyGroups){
        studyGroups = aStudyGroups;
    }

    public HashSet<StudyGroup> getStudyGroups(){
        return studyGroups;
    }
}
