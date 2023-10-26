import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("Q")) {
            System.out.println("Enter a file path to gather stats on, or 'Q' to quit:");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("Q")) {
                Path path = Paths.get(input);
                File file = path.toFile();

                System.out.println("Would you like to skip whitespace? (yes/no)");
                boolean skipWs = scanner.nextLine().equalsIgnoreCase("yes");

                try {
                    FileStats fs = new FileStats(file, skipWs);
                    fs.read();

                    System.out.printf("Stats: lines - %d, words - %d, chars - %d %s%n",
                            fs.getNumLines(), fs.getNumWords(), fs.getNumChars(), file.getPath());
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
