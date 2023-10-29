import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static String userString;
    private static String filePath;
    private static boolean skipWs;
    private static File file;
    private static String outputScript = "Stats: lines - %d, words - %d, chars - %d %s";


    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter filepath");
    filePath = s.nextLine();

        while (!filePath.equalsIgnoreCase("Q")) {
            file = new File(filePath);
            break;
        }

    System.out.println("Skip whitespace? Y/N");
    userString = s.nextLine();

    while (true) {
        if (userString.equalsIgnoreCase("N")) {
            skipWs = false;
            break;
        } else if (userString.equalsIgnoreCase("Y")) {
            skipWs = true;
            break;
        } else {
            System.out.println("Please enter \"Y\" or \"N\"\n");
            userString = s.nextLine();
        }
    }

            try {
                FileStats fs = new FileStats(file, skipWs);
                fs.read(file);
                System.out.printf(outputScript, fs.getNumLines(), fs.getNumWords(), fs.getNumChars(), fs.getFileName());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
}
