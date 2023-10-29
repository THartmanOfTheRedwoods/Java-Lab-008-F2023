import java.io.*;

public class FileStats {
    private int numLines;
    private int numWords;
    private int numChars;
    private boolean skipWhiteSpace;
    private File f;

    public FileStats(File f, boolean skipWhiteSpace) throws FileNotFoundException {
        if(!f.exists()) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }

        this.f = f;
        this.skipWhiteSpace = skipWhiteSpace;
        this.numLines = 0;
        this.numWords = 0;
        this.numChars = 0;

        countWords("The quick brown fox jumps over a lazy dog");
    }

    private static int countWords(String line) {
        if (line == null || line.isEmpty()) { return 0; }
        String[] words = line.split("\\s+");
        return words.length;
    }


    /*
        private static String removeSpaces(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        return line.replaceAll("\\s+", "");
    }
    */
    private static String removeSpaces(String line) {
        if (line == null || line.isEmpty()) { return ""; }
        return String.join("", line.split("\\s+"));

    }


    private static int countChars(String line, boolean skipWhiteSpace) {
        // 1. If skipWhiteSpace is true, use the removeSpaces method to remove whitespace from the line.

        // 2. Now write a loop to count the number of characters in the line.
        //    a. HINT: to get the length of a String, use its .length() method!

        // 3. Return the count of characters.
        //    a. HINT: If whitespace isn't being skipped, a newline character (i.e. \n) counts as a character.
        return 0;
    }

    public void read(File f) throws FileNotFoundException, IOException {
        if( !f.exists() ) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        this.f = f;
        this.read();
    }

    public void read() throws FileNotFoundException, IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
            //String line = "";
            while (bufferedReader.readLine() != null)
                //line = bufferedReader.readLine();
                System.out.println(bufferedReader.readLine());
        }



        // 2. Create a loop that uses your BufferedReader object to read the contents of your File object line-by-line
        //    and within the loop count the file's lines, words, and characters. Store them in the FileStats class's
        //    instance variables, so you can retrieve them in your main method.
        //    a. HINT: BufferedReader has a readLine method!!!
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
