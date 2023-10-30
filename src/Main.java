import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static String userString;
    private static String filePath;
    private static boolean skipWs;
    private static boolean repeatProgram;
    private static File file;
    private static String outputScript = "Stats: lines - %d, words - %d, chars - %d %s%n";
    private static Scanner s = new Scanner(System.in);

    private static final String[][] fileNameAndPath = {
        {"Sisko's Sin", "resources/Sisko's Sin"},
        {"Yar's Farewell", "resources/Yar's Farewell"},
        {"Janeway's Mission", "resources/Janeway's Mission"},
        {"Picard's Resolve", "resources/Picard's Resolve"},
        {"Quark's Bluff", "resources/Quark's Bluff"}
    };

    public static void fileSelection() {
        System.out.println("--Select a passage--");
        for (int i = 0; i < fileNameAndPath.length; i++) {
            System.out.printf("\"%d\": %s%n", i + 1, fileNameAndPath[i][0]);
        }
        filePath = fileNameAndPath[Integer.parseInt(s.nextLine()) - 1][1];
        file = new File(filePath);
    }
    
    public static boolean repeatOption() {
        String input = "";
        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
            System.out.println("Select another text? Y/N");
            input = s.nextLine();
            switch (input.toUpperCase()) {
                case "Y":
                    repeatProgram = true;
                    break;
                case "N":
                    repeatProgram = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        return repeatProgram;
    }

    public static void whiteSpaceSelection() {
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
    }

    public static void launchProgram() {
        fileSelection();
        whiteSpaceSelection();
    }

    public static void main(String[] args) {
        launchProgram();
            try {
                FileStats fs = new FileStats(file, skipWs);
                fs.read(file);
                System.out.printf(outputScript, fs.getNumLines(), fs.getNumWords(), fs.getNumChars(), fs.getFileName());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            if (repeatOption()) {
                launchProgram();
            }
    }
}
