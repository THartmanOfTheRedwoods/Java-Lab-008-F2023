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
    }

    private static int countWords(String line) {
        if (line == null || line.isEmpty()) { return 0; }
        String[] words = line.split("\\s+");
        return words.length;
    }


    private static String removeSpaces(String line) {
        if (line == null || line.isEmpty()) { return ""; }
        return String.join("", line.split("\\s+"));

    }


    private static int countChars(String line, boolean skipWhiteSpace) {
        int numChars = 0;

        if (skipWhiteSpace) {
            line = removeSpaces(line);
        }

        // 2. Now write a loop to count the number of characters in the line.
        //    a. HINT: to get the length of a String, use its .length() method!
        numChars = line.length();

        // 3. Return the count of characters.
        //    a. HINT: If whitespace isn't being skipped, a newline character (i.e. \n) counts as a character.
        if (!skipWhiteSpace) {

        }

        return line.length();
    }

    public void read(File f) throws FileNotFoundException, IOException {
        if( !f.exists() ) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        this.f = f;
        this.read();
    }

    public void read() throws FileNotFoundException, IOException {
        System.out.println(skipWhiteSpace);     //scaffold

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                numWords += countWords(line);
                System.out.println(numWords);       //scaffold
                numLines++;
                line = removeSpaces(line);
                }

            /*if (skipWhiteSpace) {
             */
                System.out.println(line);             //scaffold
                line = bufferedReader.readLine();     //scaffold
            }
        }



        // 2. Create a loop that uses your BufferedReader object to read the contents of your File object line-by-line
        //    and within the loop count the file's lines, words, and characters. Store them in the FileStats class's
        //    instance variables, so you can retrieve them in your main method.
        //    a. HINT: BufferedReader has a readLine method!!!


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
