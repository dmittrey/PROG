package utility;

import utility.Interfaces.FileWorkerInterface;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * FileWorker is used to operate with file
 */
public class FileWorker implements FileWorkerInterface {
    private final CollectionManager collectionManager;
    private final CollectionValidator collectionValidator;
    private final Console console;

    public FileWorker(CollectionManager aCollectionManager, Console aConsole) {
        collectionManager = aCollectionManager;
        collectionValidator = new CollectionValidator(collectionManager);
        console = aConsole;
    }

    /**
     * Read collection from indicated file
     */
    @Override
    public String getFromXmlFormat() {

        String filePath = System.getenv("FILE_PATH");

        if (filePath == null) {
            console.print(TextFormatting.getRedText("\n\tProgram can't find xml file. " +
                    "Change the file path in the environment variable(FILE_PATH)!\n"));
            System.exit(0);
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            /* init jaxb marshaller */
            JAXBContext jaxbContext = JAXBContext.newInstance(CollectionManager.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            /* unmarshalling java objects from xml */
            CollectionManager defaultCollectionManager = (CollectionManager) jaxbUnmarshaller.unmarshal(bufferedReader);

            return collectionValidator.validateCollection(defaultCollectionManager.getCollection());

        } catch (FileNotFoundException e) {
            return TextFormatting.getRedText("\tChange the file path in the environment variable(FILE_PATH)!\n");
        } catch (JAXBException e) {
            return TextFormatting.getRedText("\tFile has been broken!\n");
        }
    }

    /**
     * Method print collection in xml file
     *
     * @return status message
     */
    @Override
    public String saveToXml() {

        String filePath = System.getenv("FILE_PATH");

        if (filePath == null) return TextFormatting.getRedText("\tProgram can't find xml file. " +
                "Change environmental variable!\n\n");

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
     * Не реализована валидация объектов с одинковым id в xml файле(к примеру добавлять после валидации с коллекцией в связке)
     *
     * Неправильная реакция на ошибку(когда файл запривачен+ не выходим почему-то)
     */
}
