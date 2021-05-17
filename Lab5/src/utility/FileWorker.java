package utility;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import data.*;

import utility.Interfaces.FileWorkerInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.*;

import java.util.HashSet;

/**
 * <code>FileWorker</code> is used to operate with file
 */
public class FileWorker implements FileWorkerInterface {
    private final CollectionManager collectionManager;
    private final Console console;

    public FileWorker(CollectionManager aCollectionManager, Console aConsole) {
        collectionManager = aCollectionManager;
        console = aConsole;
    }


    /**
     * Read collection from indicated file
     * Поехали писать парсер
     */
    public HashSet<StudyGroup> getFromXmlFormat() {


        return new HashSet<>();
    }

    /**
     * Method print collection in xml file
     *
     * @return status message
     */
    public String saveToXml() {
        String filePath = System.getenv("FILE_PATH");
        HashSet<StudyGroup> studyGroups  = collectionManager.getCollection();

        if (filePath == null) return TextFormatting.getRedText("\tProgram can't find xml file!\n");

        try {
            File outFile = new File(filePath);
            OutputStream outputStream = new FileOutputStream(outFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            /* init jaxb marshaller */
            CollectionToPrint collection = new CollectionToPrint(collectionManager.getCollection());
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionToPrint.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( collection, outputStreamWriter );

            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            return TextFormatting.getRedText("\tChange the file path in the environment variable!\n");
        } catch (IOException e) {
            return TextFormatting.getRedText("\tWe have unexpected problems!\n");
        } catch (JAXBException e) {
            TextFormatting.getRedText("\tFile has been broken!\n");
        }
        return TextFormatting.getGreenText("\tCollection recorded successfully!\n");
    }
}

//    File outFile = new File(filePath);
//    OutputStream outputStream = new FileOutputStream(outFile);
//    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//            outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
//                    outputStreamWriter.write("<collection>\n");
//
//                    for (StudyGroup studyGroup : collectionManager.getCollection()) {
//                    outputStreamWriter.write("<studyGroup>\n");
//                    outputStreamWriter.write("<id>" + studyGroup.getId() + "</id>\n");
//                    outputStreamWriter.write("<name>" + studyGroup.getName() + "</name>\n");
//                    outputStreamWriter.write("<coordinates>\n");
//                    outputStreamWriter.write("<coordinateX>" + studyGroup.getCoordinates().getX() + "</coordinateX>\n");
//                    outputStreamWriter.write("<coordinateY>" + studyGroup.getCoordinates().getY() + "</coordinateY>\n");
//                    outputStreamWriter.write("</coordinates>\n");
//                    outputStreamWriter.write("<creationDate>" + studyGroup.getCreationDate() + "</creationDate>\n");
//                    outputStreamWriter.write("<studentsCount>" + studyGroup.getStudentsCount() + "</studentsCount>\n");
//                    outputStreamWriter.write("<averageMark>" + studyGroup.getAverageMark() + "</averageMark>\n");
//                    outputStreamWriter.write("<formOfEducation>" + studyGroup.getFormOfEducation() + "</formOfEducation>\n");
//                    outputStreamWriter.write("<semesterEnum>" + studyGroup.getSemesterEnum() + "</semesterEnum>\n");
//                    outputStreamWriter.write("<groupAdmin>\n");
//                    outputStreamWriter.write("<name>" + studyGroup.getGroupAdmin().getName() + "</name>\n");
//                    outputStreamWriter.write("<weight>" + studyGroup.getGroupAdmin().getWeight() + "</weight>\n");
//                    outputStreamWriter.write("<hairColor>" + studyGroup.getGroupAdmin().getHairColor() + "</hairColor>\n");
//                    outputStreamWriter.write("</groupAdmin>\n");
//                    outputStreamWriter.write("</studyGroup>\n");
//                    }
//                    outputStreamWriter.write("</collection>");
//                    outputStreamWriter.close();
//                    } catch (FileNotFoundException e) {
//                    return TextFormatting.getRedText("\tChange the file path in the environment variable!\n");
//                    } catch (IOException e) {
//                    return TextFormatting.getRedText("\tWe have unexpected problems!\n");
//                    }