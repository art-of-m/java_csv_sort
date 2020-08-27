import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.nd4j.util.ArchiveUtils;

public class SortCSVLabels {

    /**
     * Unzip file .zip to a designated location
     * @param zipFilePath zip file name
     * @return file path
     */
    public static File unzipFile(File zipFilePath) throws Exception
    {
        //Den gewuenschten Pfad zum Entpacken angeben
        File rootDir = new File(System.getProperty("user.home")+ "/DL4JDataDir");

        File dataDir = new File(rootDir, "/CreditCardFraudData");

        if(!dataDir.exists())
        {
            System.out.println("Unzipping data file...");

            if(!rootDir.exists()) rootDir.mkdir();

            dataDir.mkdir();

            ArchiveUtils.unzipFileTo(zipFilePath.getAbsolutePath(), dataDir.getAbsolutePath());
        }
        else
        {
            System.out.println("Data already exist. Proceed");
        }

        return dataDir.getAbsoluteFile();
    }


    //Der Rest wird nicht gebraucht. Sortiert die Fraud-Labels und packt die in eine neue Directory (newDirectory)
    static String labelDir = "C:\\Users\\rempe\\Documents\\AIProject\\relevant_reps\\fraud_detection\\test_dir\\test_label\\";
    static String oldDirectory = "C:\\Users\\rempe\\Documents\\AIProject\\relevant_reps\\fraud_detection\\test_dir\\test_label\\";
    static String newDirectory = "C:\\Users\\rempe\\Documents\\AIProject\\relevant_reps\\fraud_detection\\test_dir\\test_fraud\\";

    public static void sort() throws IOException {
        File baseDir = new File(labelDir);
        String[] contents;
        contents = baseDir.list();

        String oldDir = oldDirectory;
        String newDir = newDirectory;

        for (String content : contents) {
            BufferedReader csvReader = new BufferedReader(new FileReader(baseDir + "\\" + content));
            if (csvReader.readLine().equals("1")){
                Path oldPath = Paths.get(oldDir + content);
                Path newPath = Paths.get(newDir + content);
                csvReader.close();
                Files.move(newPath, oldPath);
            }
        }
    }
}
