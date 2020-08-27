import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] Args) throws Exception {

//        SortCSVLabels.sort();

        //Hier den Pfad der Daten angeben + in der Methode "unzipFile" den Pfad zum Entpacken ändern
        File zipFilePath = new File("SET\\TO\\YOUR\\PATH\\" +  "CreditCardFraud.zip");
        System.out.println(SortCSVLabels.unzipFile(zipFilePath));
    }
}