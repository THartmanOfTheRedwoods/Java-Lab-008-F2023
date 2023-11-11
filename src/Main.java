/**
 *
 * @author Trevor Hartman
 * @author Cameron Meng
 *
 * @since Version 1.0
 *
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner s = new Scanner(System.in);
        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        System.out.print("Enter a file path to gather stats on: ");
        String filePath;
        boolean skipWs;
        while (!(filePath = s.nextLine()).toUpperCase().equals("Q")) {
            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
            File file = new File(filePath);
            // Ask the user if they would like to skip whitespace
            System.out.print("Would like to skip whitespace?: ");
            // Create a variable called skipWs that stores the user's response as a boolean
            skipWs = Boolean.parseBoolean(s.nextLine());
            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats fileStats = new FileStats(file, skipWs);
                // You will need to call the fs.read method, which you need to implement!
                fileStats.read();
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s%n",
                fileStats.getNumLines(),
                fileStats.getNumWords(),
                fileStats.getNumChars(),
                file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
