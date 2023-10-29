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


    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter filepath");
    filePath = s.nextLine();                               //user input

        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        while (!filePath.equalsIgnoreCase("Q")) {

            //Copied from Assignment 3
            filePath = "resources/TEST.txt";        //scaffold
            file = new File(filePath);                        //File object created

        break;
    }

    System.out.println("Skip whitespace? Y/N");
    userString = s.nextLine();

    while (Optional.of(skipWs).isEmpty())        {
        if (userString.equalsIgnoreCase("N")) {
            skipWs = false;
        } else if (userString.equalsIgnoreCase("Y")) {
            skipWs = true;
        } else {
            System.out.println("Please enter \"Y\" or \"N\"\n");
        }
    }

            try {
                FileStats fs = new FileStats(file, skipWs);
                fs.read(file);

                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    }
}
