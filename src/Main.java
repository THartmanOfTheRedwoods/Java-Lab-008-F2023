import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        System.out.print("Enter a file path to analyze: ");
        String filePath;
        Path coolfilePath;
        while (!(filePath = s.nextLine()).toUpperCase().equals("Q")) {

            coolfilePath = Paths.get(filePath);
            File file1 = coolfilePath.toFile();
            System.out.println("Skip white space: [true/false]...");
            boolean skipWs = Boolean.parseBoolean(s.nextLine());




            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

            // Ask the user if they would like to skip whitespace DONE


            // Create a variable called skipWs that stores the user's response as a boolean DONE

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                FileStats statFinder = new FileStats(file1, skipWs);
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args DONE

                // You will need to call the fs.read method, which you need to implement!
                statFinder.read();
                statFinder.getNumLines();
                statFinder.getNumWords();
                statFinder.getNumChars();
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */

                System.out.printf("Stats: lines = %d, words = %d, characters = %d %n",
                        statFinder.getNumLines(),
                        statFinder.getNumWords(),
                        statFinder.getNumChars());

            } catch (IOException e) {
                System.err.println(e.getMessage());

            }System.out.println("Enter a file path to inspect. Enter \"Q\" to quit...");

        }
    }
}
