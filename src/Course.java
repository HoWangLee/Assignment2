import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Course {
    private static List<String> firstRow = new ArrayList<String>();
    private static List<String> header = new ArrayList<String>();
    private static List<Double> weights = new ArrayList<Double>();

    public void readFirstRow(File file, List<String> firstRow) throws FileNotFoundException { // Read first row of file
        Scanner topRow = new Scanner(file);
        firstRow = Arrays.asList(topRow.nextLine().split(","));
        topRow.close();
        this.firstRow = firstRow;
    }

    public void setHeader(List<String> firstRow, List<String> header){ // Exclude weights in final header
        header.add(0,"ID");
        header.add(1, "Name");
        for(int firstRowCol = 2, headerCol = 2; firstRowCol < firstRow.size(); firstRowCol += 2, headerCol++)
            header.add(headerCol, firstRow.get(firstRowCol));
        header.add("Overall");
        this.header = header;
    }

    public void setWeights(List<String> firstRow, List<Double> weights) { // Store weights of different tests and assignments
        for(int weightsCol = 0, firstRowCol = 3; firstRowCol < firstRow.size(); weightsCol++, firstRowCol += 2)
            weights.add(weightsCol, Double.parseDouble(firstRow.get(firstRowCol)));
        this.weights = weights;
    }

    public static List<String> getHeader() {return header;}
    public static List<Double> getWeights() {return weights;}


}
