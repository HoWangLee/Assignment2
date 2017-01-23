import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by Howard on 17/1/2017.
 */
public class Driver {
    public static void main(String[] args) throws Exception {
        /* Let user define specific file path of the desired File object to be read.*/
        String filePath = ""; //Store user-defined file path
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Files",
                "txt", "text"); //Create .txt filter

        /* Create GUI file chooser GUI */
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select File");
        chooser.setFileFilter(txtFilter);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            filePath = chooser.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(chooser, "No selection defined.\nProgram will terminate now.");
            System.exit(0);
        }
        System.out.println(filePath);
        File file = new File(filePath); // define File object

        Student.setListOfStudentInfo(file); // read File object into List
        Course.setFirstRowFirstRow(file); // read first row of file object into List
        Course.setHeader(Course.getFirstRow()); // set header
        Display.widthAutomator(Student.getListOfStudentInfo()); // set max width
        Display.printing(Course.getHeader(), Student.getListOfStudentInfo()); // print list


/**
        List<List<String>> listOfStudentInfo = new ArrayList<List<String>>();
        final Scanner infoReader = new Scanner(file);
        infoReader.nextLine();
        String line;
        for (int i = 0; infoReader.hasNextLine(); i++){
            line = infoReader.nextLine();
            listOfStudentInfo.add(Arrays.asList(line.split(",")));
        }
        infoReader.close();
        System.out.println(listOfStudentInfo);
*/

    }
}
