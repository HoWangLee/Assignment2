import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Course {
    private static List<String> firstRow = new ArrayList<>();
    private static List<String> header = new ArrayList<>();
    private static List<Double> weights = new ArrayList<>();
    private static List<String> overall = new ArrayList<>();
    private static List<String> average = new ArrayList<>();

    public static void setFirstRow(List<String> firstRow) {
        Course.firstRow = firstRow;
    }
    public static void setHeader(List<String> header) {
        Course.header = header;
    }
    public static void setWeights(List<Double> weights) {
        Course.weights = weights;
    }
    public static void setOverall(List<String> overall) {
        Course.overall = overall;
    }
    public static void setAverage(List<String> average) {
        Course.average = average;
    }
    public static List<String> getFirstRow() {
        return firstRow;
    }
    public static List<String> getHeader() {
        return header;
    }
    public static List<Double> getWeights() {
        return weights;
    }
    public static List<String> getOverall() {
        return overall;
    }
    public static List<String> getAverage() {
        return average;
    }

    public static void readFirstRow(File file) throws FileNotFoundException { // Read first row of file
        Scanner topRow = new Scanner(file);
        List<String> firstRow = new ArrayList<>();
        firstRow = Arrays.asList(topRow.nextLine().split(","));
        topRow.close();
        setFirstRow(firstRow);
    }

    public static void createHeader(List<String> firstRow){ // Exclude weights in final header
        List<String> header = new ArrayList<>();
        header.add(0,"ID");
        header.add(1, "Name");
        for(int firstRowCol = 2, headerCol = 2; firstRowCol < firstRow.size(); firstRowCol += 2, headerCol++)
            header.add(headerCol, firstRow.get(firstRowCol));
        header.add("Overall");
        header.add("Rank");
        setHeader(header);
    }

    public static void createWeights(List<String> firstRow) { // Store weights of different tests and assignments
        List<Double> weights = new ArrayList<Double>();
        for(int weightsCol = 0, firstRowCol = 3; firstRowCol < firstRow.size(); weightsCol++, firstRowCol += 2)
            weights.add(weightsCol, Double.parseDouble(firstRow.get(firstRowCol)));
        setWeights(weights);
    }

    public static void calculateOverall(List<Double> weights, List<List<String>> listOfLists) {
        List<String> overall = new ArrayList<String>();
        for (int row = 0; row < listOfLists.size(); row++){
            double total = 0;
            for (int col = 2; col < listOfLists.get(row).size(); col++){
                double weight = weights.get(col-2) / 100;
                double score = Double.parseDouble(listOfLists.get(row).get(col)) * weight;
                total += score;
            }
            String formattedTotal = Display.df.format(total);
            overall.add(formattedTotal);
        }
        setOverall(overall);
    }

    public static void calculateAverage(List<List<String>> listOfLists) {
        List<String> average = new ArrayList<String>();
        average.add("");
        average.add("Average:");
        for (int col = 2; col < listOfLists.get(0).size(); col++){
            double sum = 0, avg = 0, count = 0;
            for (int row = 0; row < Student.getListOfStudentInfo().size(); row++){
                count += 1;
                sum += Double.parseDouble(listOfLists.get(row).get(col));
            }
            avg = sum / count;
            average.add(String.valueOf(Display.df.format(avg)));
        }
        setAverage(average);
    }

    public static void appendOverall(List<List<String>> listOfStudentInfo, List<String> overall){
        List<List<String>> newListOfStudentInfo = listOfStudentInfo;
        for(int row = 0; row < listOfStudentInfo.size(); row++)
            listOfStudentInfo.get(row).add(overall.get(row));
        Student.setListOfStudentInfo(newListOfStudentInfo);
    }

}
