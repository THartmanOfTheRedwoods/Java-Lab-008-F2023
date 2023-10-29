import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static String userString;
    private static String filePath;
    private static boolean skipWs;

    public static void main(String[] args) {

    // Create a scanner object
    Scanner s = new Scanner(System.in);
        filePath = "resources/TEST.txt";

        System.out.println("");

        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        while (!filePath.equalsIgnoreCase("Q")) {

            //Copied from Assignment 3
            filePath = s.nextLine();                               //user input
            File file = new File(filePath);                        //File object created

        break;
    }


    // Ask the user if they would like to skip whitespace
    // Create a variable called skipWs that stores the user's response as a boolean
    System.out.println("Skip whitespace? Y/N");
    userString = s.nextLine();

    while (userString == null) {
        if (userString.equalsIgnoreCase("N")) {
            skipWs = false;
        } else if (userString.equalsIgnoreCase("Y")) {
            skipWs = true;
        } else {
            System.out.println("Please enter \"Y\" or \"N\"\n");
        }
    }
        Path.of(filePath);
        File file = new File(filePath);



        /*
         * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
         * write code to get the line, word, and character count of the File object created above!
         */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats fileStats = new FileStats(file, skipWs);

                // You will need to call the fs.read method, which you need to implement!

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
