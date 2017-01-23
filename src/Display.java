import java.text.DecimalFormat;
import java.util.List;
/**
 * Created by Howard on 23/1/2017.
 */
public class Display {
    private static int maxLength = 8;
    /**public static void trim(List<List<String>> listOfLists){
        for (int row = 0; row < listOfLists.size(); row++)
            for (int col = 0; col < listOfLists.get(row).size(); col++) {
                listOfLists.get(row).get(col) = listOfLists.get(row).get(col).trim(); // trim excess space of character
            }
    }*/
    public static void widthAutomator(List<List<String>> listOfLists){
        for (int row = 0; row < listOfLists.size(); row++)
            for (int col = 0; col < listOfLists.get(row).size(); col++)
                if (listOfLists.get(row).get(col).length() > maxLength) maxLength = listOfLists.get(row).get(col).length();
    }

    public static void printing(List<String> header, List<List<String>> listOfLists, List<String> average) {
        String format = "%-" + (maxLength + 2) + "s";
        for (int col = 0; col < header.size(); col++) { // print header
            header.set(col, header.get(col).trim());
            System.out.printf(format, header.get(col));
        }
        System.out.printf("\n");
        for (int row = 0; row < listOfLists.size(); row++) { // print student info and scores
            for (int col = 0; col < listOfLists.get(row).size(); col++) {
                listOfLists.get(row).set(col, listOfLists.get(row).get(col).trim());
                System.out.printf(format, listOfLists.get(row).get(col));
            }
            System.out.printf("\n");
        }
        for (int col = 0; col < average.size(); col++){ // print average
            average.set(col, average.get(col).trim());
            System.out.printf(format, average.get(col));
        }
    }
    public static DecimalFormat df = new DecimalFormat("#0.00");

}
