import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a file path or 'Q' to quit: ");
            String filePath = scanner.nextLine().trim();

            if (filePath.equalsIgnoreCase("Q")) {
                break;
            }

            System.out.print("Skip whitespace (true/false): ");
            boolean skipWs = scanner.nextBoolean();
            scanner.nextLine();

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                Path path = Paths.get(filePath);
                File file = path.toFile();


                FileStats fs = new FileStats(file, skipWs);
                fs.read();

                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s%n",
                        fs.getNumLines(), fs.getNumWords(), fs.getNumChars(), fs.getFileName());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
