package utility;

import data.*;

import utility.Interfaces.FileWorkerInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

import java.util.HashSet;

/**
 * <code>FileWorker</code> is used to operate with file
 */
public class FileWorker implements FileWorkerInterface {
    private final CollectionManager collectionManager;

    public FileWorker(CollectionManager aCollectionManager) {
        collectionManager = aCollectionManager;
    }

    /**
     * Read collection from indicated file
     */
    public String getFromXmlFormat() {
        String filePath = "C:\\Users\\zubah\\IdeaProjects\\PROG\\Lab5\\src\\test.xml";
        //String filePath = System.getenv("FILE_PATH");

        try {
            File inputFile = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            /* init jaxb marshaller */
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            /* unmarshalling java objects from xml */
            CollectionManager defaultCollectionManager = (CollectionManager) jaxbUnmarshaller.unmarshal(bufferedReader);
            collectionManager.setCollection(defaultCollectionManager.getCollection());

        } catch (FileNotFoundException e) {
            return TextFormatting.getRedText("\tChange the file path in the environment variable!\n");
        } catch (JAXBException e) {
            TextFormatting.getRedText("\tFile has been broken!\n");
        }
        return TextFormatting.getGreenText("\n\tCollection was loaded!\n\n");
    }

    /**
     * Method print collection in xml file
     *
     * @return status message
     */
    public String saveToXml() {
        String filePath = "C:\\Users\\zubah\\IdeaProjects\\PROG\\Lab5\\src\\test.xml";
        //String filePath = System.getenv("FILE_PATH");
        HashSet<StudyGroup> studyGroups = collectionManager.getCollection();

        try {
            File outFile = new File(filePath);
            OutputStream outputStream = new FileOutputStream(outFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

            /* init jaxb marshaller */
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml */
            jaxbMarshaller.marshal(collectionManager, outputStreamWriter);

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
/**
 * Сделать парсинг с кири
 *
 * сделать protectfields
 *
 * сделать метод
 */
}
