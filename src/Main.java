import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner in = new Scanner(System.in);
        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        public static void filePath(){
            System.out.println("Enter a file path to gather stats on and \"Q\" to quit: ");
            String input = in.nextLine();
            while (!(input.equalsIgnoreCase("Q"))) {
                Path f = Paths.get(input);
                System.out.println("Would you like to skip whitespace? y/n ");
                if (in.nextLine().equals("y")){
                    boolean skipWhiteSpace = true;
                    break;
                }else if (in.nextLine().equals("n")) {
                    boolean skipWhiteSpace = false;
                    break;
                }
            }
        }

            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

            // Ask the user if they would like to skip whitespace

            // Create a variable called skipWs that stores the user's response as a boolean

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats file = new FileStats(f, skipWhiteSpace);


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
