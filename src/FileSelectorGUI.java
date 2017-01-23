import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by Howard on 23/1/2017.
 */
public class FileSelectorGUI {
    private static String filePath = "";
    private static File file = new File(filePath);

    public static void selectFilePath(){
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
        System.out.println("Directory is set to" + filePath);
        setFilePath(filePath);
    }

    public static void selectFile(String filePath){
        File file = new File(filePath);
        setFile(file);
    }

    public static void setFilePath(String filePath) {
        FileSelectorGUI.filePath = filePath;
    }

    public static void setFile(File file) {
        FileSelectorGUI.file = file;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static File getFile() {
        return file;
    }
}
