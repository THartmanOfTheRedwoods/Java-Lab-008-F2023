import java.io.*;

public class FileStats {
    private int numLines;
    private int numWords;
    private int numChars;
    private boolean skipWhiteSpace;
    private File f;

    public FileStats(File f, boolean skipWhiteSpace) throws FileNotFoundException {
        if (!f.exists()) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        this.f = f;
        this.skipWhiteSpace = skipWhiteSpace;
    }

    private static int countWords(String line) {
        if (line == null || line.isEmpty()) {
            return 0;
        }
        String[] words = line.split("\\s+");
        return words.length;
    }

    private static String removeSpaces(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        return String.join("", line.split("\\s+"));
    }

    private static int countChars(String line, boolean skipWhiteSpace) {
        if (skipWhiteSpace) {
            line = removeSpaces(line);
        }
        return line.length();
    }

    public void read(File f) throws FileNotFoundException, IOException {
        if (!f.exists()) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        this.f = f;
        this.read();
    }

    public void read() throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numLines++;
                numWords += countWords(line);
                numChars += countChars(line, skipWhiteSpace);
            }
        }
    }

    public int getNumLines() {
        return numLines;
    }

    public int getNumWords() {
        return numWords;
    }

    public int getNumChars() {
        return numChars;
    }

    public String getFileName() {
        return this.f.getAbsolutePath();
    }
}
