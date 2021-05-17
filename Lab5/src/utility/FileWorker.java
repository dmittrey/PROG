package utility;

import data.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utility.Interfaces.FileWorkerInterface;

import java.io.*;

import java.util.HashSet;


import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


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

        String filePath = System.getenv("FILE_PATH");

        if (filePath == null) {
            console.print(TextFormatting.getRedText("\tProgram can't find xml file!\n"));

        }

//        try {
//            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            Document document = builder.parse(new File(filePath));
//            Node root = document.getDocumentElement();
//            NodeList studyGroups = root.getChildNodes();
//            clearFields();
//            for (int i = 0; i < studyGroups.getLength(); i++) {
//                boolean checkFields = true;
//                String FieldName;
//                String FieldValue;
//                String ClassName;
//                if (studyGroups.item(i).getNodeType() != Node.TEXT_NODE && studyGroups.item(i).getChildNodes().getLength() > 1) {
//                    String studyGroupInformation = studyGroups.item(i).getNodeName();
//                    NodeList studyGroup = studyGroups.item(i).getChildNodes();
//                    checkHeadSize = false;
//                    checkEyesNumber = false;
//                    for (int j = 0; j < studyGroup.getLength() && checkFields; j++) {
//                        if (studyGroup.item(j).getNodeType() != Node.TEXT_NODE && studyGroup.item(j).getChildNodes().getLength() == 1) {
//                            FieldName = studyGroup.item(j).getNodeName();
//                            FieldValue = studyGroup.item(j).getChildNodes().item(0).getTextContent().replace("\n", "").trim();
//                            checkFields = checkFields(FieldName, FieldValue, "a");
//                        } else if (dragon.item(j).getNodeType() != Node.TEXT_NODE && dragon.item(j).getChildNodes().getLength() > 1) {
//                            NodeList dragon1 = dragon.item(j).getChildNodes();
//                            ClassName = dragon.item(j).getNodeName();
//                            for (int k = 0; k < dragon1.getLength() && checkFields; k++) {
//                                if (dragon1.item(k).getNodeType() != Node.TEXT_NODE && dragon1.item(k).getChildNodes().getLength() == 1) {
//                                    FieldName = dragon1.item(k).getNodeName();
//                                    FieldValue = dragon1.item(k).getChildNodes().item(0).getTextContent().replace("\n", "").trim();
//                                    checkFields = checkFields(ClassName, FieldName, FieldValue);
//                                }
//                            }
//                        }
//                    }
//                }
//                if (dragons.item(i).getNodeType() != Node.TEXT_NODE) {
//                    if (checkFields && elementCreation()) {
//                        System.out.println("Элемент номер " + (i / 2 + 1) + " успешно добавлен в коллекцию");
//                    } else {
//                        System.out.println("Элемент номер " + (i / 2 + 1) + " не может быть добавлен в коллекцию");
//                    }
//                    clearFields();
//                }
//            }
//        } catch (ParserConfigurationException e) {
//            System.out.println("Невозможно считать данные из-за ошибки конфигурации");
//        } catch (IOException ex) {
//            if (!file.exists()) {
//                System.out.println("Файл с таким именем не найден. Создайте файл и запустите программу снова.");
//                System.exit(0);
//
//            } else if (file.exists() && !file.canRead()) {
//                System.out.println("Нет прав для чтения файла. Добавьте необходимые права и запустите программу снова.");
//                System.exit(0);
//            }
//        } catch (SAXException ex) {
//            System.out.println("Невозможно считать данные, так как файл имеет неверную структуру");
//            System.exit(0);
//        }
//        return vector;
//    }
//
//    public void clearFields() {
//        name = null;
//        age = 0;
//        color = null;
//        type = null;
//        character = null;
//        x = null;
//        y = null;
//        call = null;
//        size = null;
//        eyesCount = null;
//        id = null;
//        creationDate = null;
    }


    /**
     * Method print collection in xml file
     *
     * @return status message
     */
    public String getToXmlFormat() {
        String filePath = System.getenv("FILE_PATH");

        if (filePath == null) return TextFormatting.getRedText("\tProgram can't find xml file!\n");

        try {
            File outFile = new File(filePath);
            OutputStream outputStream = new FileOutputStream(outFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            outputStreamWriter.write("<collection>\n");

            for (StudyGroup studyGroup : collectionManager.getCollection()) {
                outputStreamWriter.write("<studyGroup>\n");
                outputStreamWriter.write("<id>" + studyGroup.getId() + "</id>\n");
                outputStreamWriter.write("<name>" + studyGroup.getName() + "</name>\n");
                outputStreamWriter.write("<coordinates>\n");
                outputStreamWriter.write("<coordinateX>" + studyGroup.getCoordinates().getX() + "</coordinateX>\n");
                outputStreamWriter.write("<coordinateY>" + studyGroup.getCoordinates().getY() + "</coordinateY>\n");
                outputStreamWriter.write("</coordinates>\n");
                outputStreamWriter.write("<creationDate>" + studyGroup.getCreationDate() + "</creationDate>\n");
                outputStreamWriter.write("<studentsCount>" + studyGroup.getStudentsCount() + "</studentsCount>\n");
                outputStreamWriter.write("<averageMark>" + studyGroup.getAverageMark() + "</averageMark>\n");
                outputStreamWriter.write("<formOfEducation>" + studyGroup.getFormOfEducation() + "</formOfEducation>\n");
                outputStreamWriter.write("<semesterEnum>" + studyGroup.getSemesterEnum() + "</semesterEnum>\n");
                outputStreamWriter.write("<groupAdmin>\n");
                outputStreamWriter.write("<name>" + studyGroup.getGroupAdmin().getName() + "</name>\n");
                outputStreamWriter.write("<weight>" + studyGroup.getGroupAdmin().getWeight() + "</weight>\n");
                outputStreamWriter.write("<hairColor>" + studyGroup.getGroupAdmin().getHairColor() + "</hairColor>\n");
                outputStreamWriter.write("</groupAdmin>\n");
                outputStreamWriter.write("</studyGroup>\n");
            }
            outputStreamWriter.write("</collection>");
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            return TextFormatting.getRedText("\tChange the file path in the environment variable!\n");
        } catch (IOException e) {
            return TextFormatting.getRedText("\tWe have unexpected problems!\n");
        }
        return TextFormatting.getGreenText("\tCollection recorded successfully!\n");
    }
}
