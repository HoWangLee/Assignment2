import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Howard on 20/1/2017.
 */
/* Class Responsibilities:
*  1. Read data from user-defined File object
*  2. Store data from user-defined File object in list of list.
 */
public class Student {
    private static List<List<String>> listOfStudentInfo = new ArrayList<>();

    public static void readStudentInfo(File file) throws FileNotFoundException {
        Scanner infoReader = null;
        infoReader = new Scanner(file);
        infoReader.nextLine();
        for (int i = 0; infoReader.hasNextLine(); i++){
            listOfStudentInfo.add(new ArrayList(Arrays.asList(infoReader.nextLine().split(","))));
        }
        infoReader.close();
    }

    public static void setListOfStudentInfo(List<List<String>> listOfStudentInfo) {
        Student.listOfStudentInfo = listOfStudentInfo;
    }
    public static List<List<String>> getListOfStudentInfo() {
        return listOfStudentInfo;
    }
}
