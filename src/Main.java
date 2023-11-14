import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        boolean skipWs;

        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        System.out.print("Enter a file path to gather stats on (or 'Q' to quit): ");
        String filePath;
        while (!(filePath = scanner.nextLine()).toUpperCase().equals("Q")) {
            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
            // Ask the user if they would like to skip whitespace
            System.out.print("Do you want to skip whitespace? (true/false): ");
            String response = scanner.nextLine().trim();

            // Create a variable called skipWs that stores the user's response as a boolean
            skipWs = Boolean.parseBoolean(scanner.nextLine());
            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats fileStats = new FileStats(new File(filePath), skipWs);
                // You will need to call the fs.read method, which you need to implement!
                fileStats.read();
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s",
                        fileStats.getNumLines(),
                        fileStats.getNumWords(),
                        fileStats.getNumChars(),
                        fileStats.getFileName()
                );
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Enter a file to gather stats on (Q to quit)");
        }

    }

}
