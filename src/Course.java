import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Course {
    private static List<String> header = new ArrayList<String>();
    private static List<String> finalHeader = new ArrayList<String>();
    private static List<Double> weights = new ArrayList<Double>();

    public void createHeader(File file) throws FileNotFoundException { // Read first row of file
        Scanner topRow = new Scanner(file);
        header = Arrays.asList(topRow.nextLine().split(","));
        topRow.close();
        this.header = header;
    }
    public void setHeader(List<String> header){this.header = header}
    public List<String> getHeader() {return header;}

    public void setFinalHeader(List<String> getHeader){ // Exclude weights in final header
        finalHeader.add(0,"ID");
        finalHeader.add(1, "Name");
        for(int headerCol = 2, finalHeaderCol = 2; headerCol < header.size(); headerCol += 2, finalHeaderCol++){
            finalHeader.add(finalHeaderCol, header.get(headerCol));
        }
        finalHeader.add("Overall");
        this.finalHeader = finalHeader;
    }
    public List<String> getFinalHeader(){return finalHeader;}

    public void setWeights(List<Double> getHeader) { // Store weights of different tests and assignments
        for(int weightsCol = 0, headerCol = 3; headerCol < header.size(); weightsCol++, headerCol += 2)
            weights.add(weightsCol, Double.parseDouble(header.get(headerCol)));
        this.weights = weights;
    }

    public List<Double> getWeights() {return weights;}



}
