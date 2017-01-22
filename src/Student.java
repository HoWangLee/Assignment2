import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
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
    //private static List<Double> overall = new List<Double>();

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
    }

    public static List<List<String>> getListOfStudentInfo() {
        return listOfStudentInfo;
    }
    List<Double> weights = Course.getWeights();
    static DecimalFormat df = new DecimalFormat("#0.00");
    public static void setListOfStudentInfo(List<Double> weights, List<List<String>> listOfStudentInfo){
        double overall, score, weight;
        for (int row = 0; row < listOfStudentInfo.size(); row++) {
            overall = 0;
            for (int col = 2; col <= listOfStudentInfo.get(row).size(); col++) {
                score = Double.parseDouble(listOfStudentInfo.get(row).get(col));
                weight = weights.get(col-2) / 100;
                overall += score * weight;
            }
            String formattedOverall = df.format(overall);
            listOfStudentInfo.get(row).add(formattedOverall);
        }
    }
    public static void setListOfStudentInfo(){
        listOfStudentInfo.get(listOfStudentInfo.size()).add(1, "");
        listOfStudentInfo.get(listOfStudentInfo.size()).add(1, "Average: ");
        double sum, num, avg;
        for (int col = 2; col < listOfStudentInfo.get(0).size(); col++){
            sum = 0;
            avg = 0;
            for(int row = 0; row < listOfStudentInfo.size()-1; row++){
                num = Double.parseDouble(listOfStudentInfo.get(row).get(col));
                sum += num;
                avg = sum / (listOfStudentInfo.size()-1);
            }String overallFormat = df.format(avg);
            listOfStudentInfo.get(listOfStudentInfo.size()-1).add(overallFormat);
        }
    }
}
