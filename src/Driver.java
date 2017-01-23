import java.io.File;

/**
 * Created by Howard on 17/1/2017.
 */
public class Driver {
    public static void main(String[] args) throws Exception {
        FileSelectorGUI.selectFilePath(); // user defines targeted file location
        FileSelectorGUI.selectFile(FileSelectorGUI.getFilePath()); // define file object

        File file = FileSelectorGUI.getFile();
        Student.readStudentInfo(file); // read File object into List
        Course.readFirstRow(file); // read first row of file object into List
        Course.createHeader(Course.getFirstRow()); // set header
        Course.createWeights(Course.getFirstRow()); // set weights
        Course.calculateOverall(Course.getWeights(),Student.getListOfStudentInfo()); // calculate overall scores
        Course.appendOverall(Student.getListOfStudentInfo(),Course.getOverall());
        Course.calculateAverage(Student.getListOfStudentInfo());

        Display.widthAutomator(Student.getListOfStudentInfo()); // set max width
        Display.printing(Course.getHeader(), Student.getListOfStudentInfo(), Course.getAverage()); // print list




    }
}
