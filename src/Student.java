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
    private static List<List<String>> listOfStudentInfo = new ArrayList<List<String>>();

    public static void setListOfStudentInfo(File file){
        Scanner infoReader = null;
        try {
            infoReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        infoReader.nextLine();
        for (int i = 0; infoReader.hasNextLine(); i++){
            listOfStudentInfo.add(Arrays.asList(infoReader.nextLine().split(",")));
        }
        infoReader.close();
        Student.listOfStudentInfo = listOfStudentInfo;
    }

    public static List<List<String>> getListOfStudentInfo() {
        return listOfStudentInfo;
    }



}
