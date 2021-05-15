package utility;

import data.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import java.io.*;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/**
 * This class is used to operate with files
 */
public class FileWorker {
    private final CollectionManager collectionManager;
    private final Console console;

    public FileWorker(CollectionManager aCollectionManager, Console aConsole) {
        collectionManager = aCollectionManager;
        console = aConsole;
    }


    /**
     * Read collection from indicated file
     *
     * @return collection from indicated file
     * @throws IllegalArgumentException     if some methods have incorrect argument
     * @throws NullPointerException         if some of the fields is null
     * @throws IOException                  if can't read collection from file
     * @throws SAXException                 if can't match XML format in file
     * @throws ParserConfigurationException if document builder can't be created
     */
    public HashSet<StudyGroup> parse() throws IllegalArgumentException, NullPointerException, IOException, SAXException, ParserConfigurationException {
        HashSet<StudyGroup> collectionFromFile = new HashSet<>();
        Integer id = null;
        String name = null;
        int x = 0;
        Double y = null;
        String creationDate = null;
        Integer studentsCount = null;
        Double averageMark = null;
        FormOfEducation formOfEducation = null;
        Semester semesterEnum = null;
        String adminName = null;
        Long adminWeight = null;
        Color adminHairColor = null;
        try {
            File input = new File("C:\\Users\\zubah\\IdeaProjects\\PROG\\Lab5\\src\\test.xml");
            Scanner scanner = new Scanner(input);
            StringBuilder file = new StringBuilder();
            HashMap<Long, String> incorrectNames = new HashMap<>();
            long studyGroupsNumberForNames = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("<studyGroup>")) {
                    studyGroupsNumberForNames += 1;
                }
                if (line.contains("<name>")) {
                    String helpLine = line;
                    helpLine = helpLine.replace("<name>", "").replace("</name>", "");
                    incorrectNames.put(studyGroupsNumberForNames, helpLine);
                    helpLine = helpLine.replace("<", "");
                    file.append("<name>").append(helpLine).append("</name>");
                } else {
                    file.append(line);
                }
            }
            scanner.close();
            incorrectNames.replaceAll((aStudyGroupsNumberForNames, aHelpLine) -> aHelpLine.replace(" ", ""));
            FileWriter fileWriter = new FileWriter(input);
            fileWriter.write(file.toString());
            fileWriter.close();
            long studyGroupNumber = 1;
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(input);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("studyGroup");

            for (int iter = 0; iter < nList.getLength(); iter++) {
                Node node = nList.item(iter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    try {
                        id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                        if (id <= 0) throw new NumberFormatException();
                    } catch (NumberFormatException exception) {
                        console.print(TextFormatting.getRedText("Wrong id in study group " + studyGroupNumber + "!\n"));
                        id = null;
                    }

                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    if (name == null || name.trim().isEmpty() ) {
                        console.print(TextFormatting.getRedText("Wrong study group name in study group " + studyGroupNumber + "!\n"));
                        name = null;
                    }

                    NodeList tempNodeListCoordinates = element.getElementsByTagName("coordinates");
                    Element elementCoordinates = (Element) tempNodeListCoordinates.item(0);

                    try {
                        x = Integer.parseInt(elementCoordinates.getElementsByTagName("coordinateX").item(0).getTextContent());
                    } catch (NumberFormatException exception) {
                        console.print(TextFormatting.getRedText("Wrong coordinate x in study group " + studyGroupNumber + "!\n"));
                    }

                    try {
                        y = Double.parseDouble(elementCoordinates.getElementsByTagName("coordinateY").item(0).getTextContent());
                    } catch (NumberFormatException exception) {
                        console.print(TextFormatting.getRedText("Wrong coordinate y in study group " + studyGroupNumber + "!\n"));
                    }

                    /**
                     *
                     */

                    creationDate = element.getElementsByTagName("creationDate").item(0).getTextContent();
                    //через регулярку проверить
                    //fixme regex

                    /**
                     *
                     */

                    try {
                        studentsCount = Integer.parseInt(element.getElementsByTagName("studentsCount").item(0).getTextContent());
                        if (studentsCount <= 0) throw new NumberFormatException();

                    } catch (NumberFormatException exception) {
                        console.print(TextFormatting.getRedText("Wrong student's count in study group " + studyGroupNumber + "!\n"));
                    }

                    try {
                        averageMark = Double.parseDouble(element.getElementsByTagName("averageMark").item(0).getTextContent());
                        if (averageMark <= 0) throw new NumberFormatException();

                    } catch (NumberFormatException exception) {
                        console.print(TextFormatting.getRedText("Wrong average mark in study group " + studyGroupNumber + "!\n"));
                    } catch (NullPointerException ignored) { }

                    try {
                        formOfEducation = FormOfEducation.valueOf(element.getElementsByTagName("averageMark").item(0).getTextContent());

                    } catch (IllegalArgumentException exception) {
                        console.print(TextFormatting.getRedText("Wrong form of education in study group " + studyGroupNumber + "!\n"));
                    } catch (NullPointerException ignored) { }

                    try {
                        semesterEnum = Semester.valueOf(element.getElementsByTagName("averageMark").item(0).getTextContent());

                    } catch (IllegalArgumentException | NullPointerException exception) {
                        console.print(TextFormatting.getRedText("Wrong semester in study group " + studyGroupNumber + "!\n"));
                    }

                    NodeList tempNodeListPerson = element.getElementsByTagName("groupAdmin");
                    Element elementPerson = (Element) tempNodeListPerson.item(0);

                    try {
                        adminName = elementPerson.getElementsByTagName("name").item(0).getTextContent();
                        if (adminName.trim().isEmpty()) throw new IllegalArgumentException();
                    } catch (IllegalArgumentException exception) {
                        console.print(TextFormatting.getRedText("Wrong admin name in study group " + studyGroupNumber + "!\n"));
                    }

                    try {
                        adminWeight = Long.parseLong(elementPerson.getElementsByTagName("weight").item(0).getTextContent());
                        if (adminWeight <= 0) {
                            throw new NumberFormatException();
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println("Wrong admin weight in study group " + studyGroupNumber + "!\n");
                        adminWeight = null;
                    }

                    try {
                        adminHairColor = Color.valueOf(elementPerson.getElementsByTagName("weight").item(0).getTextContent());

                    } catch (NullPointerException | IllegalArgumentException e) {
                        System.out.println("Wrong admin hair color in study group " + studyGroupNumber + "!\n");
                    }
                }

                studyGroupNumber += 1;

                if (id == null || name == null || y == null || creationDate == null || studentsCount == null ||
                        semesterEnum == null || adminName == null || adminWeight == null || adminHairColor == null) {
                    console.print(TextFormatting.getRedText("Worker can't be added. Some data is wrong!\n"));
                }
            }
            console.print(TextFormatting.getBlueText("Collection was loaded successfully!\n\n"));
        } catch (FactoryConfigurationError | ParserConfigurationException | IOException | SAXException exception) {
            System.out.println("Something goes wrong. Please correct file and try again. (" + exception.getMessage() + ")");
        }

        return collectionFromFile;
    }

    public void getToXmlFormat() throws IOException {
        File outFile = new File("C:\\Users\\zubah\\IdeaProjects\\PROG\\Lab5\\src\\test.xml");//fixme добавить ссылку на переменную окружения
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
    }

    public static void main(String[] args) {

    }
}
