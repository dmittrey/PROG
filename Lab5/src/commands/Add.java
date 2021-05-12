package commands;

import data.Coordinates;
import data.FormOfEducation;
import data.Person;
import data.Semester;
import utility.CollectionManager;
import utility.Console;
import utility.StudyGroupFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Add extends CommandAbstract {

    private final Console console;
    private final CollectionManager collectionManager;
    private final StudyGroupFactory studyGroupFactory;

    public Add(CollectionManager aCollectionManager, Console aConsole, StudyGroupFactory aStudyGroupFactory) {
        super("add", "add new element to the collection");
        collectionManager = aCollectionManager;
        console = aConsole;
        studyGroupFactory = aStudyGroupFactory;
    }

    @Override
    public String execute(String aArg) {
        if (aArg.equals("")) {
            studyGroupFactory.createStudyGroup();
            return "Successful";
        } else {
            return "Arguments entered incorrectly";
        }
    }
}
