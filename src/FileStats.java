import javax.tools.FileObject;
import java.io.*;

public class FileStats {
    public int numLines;
    public int numWords;
    public int numChars;
    public boolean skipWhiteSpace;
    public File f;
    private FileReader reader;

    // **You will need to complete the FileStats class's constructor, so you can create FileStats objects**
    public FileStats(File f, boolean skipWhiteSpace) throws FileNotFoundException {
        if (!(f.exists())){
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        /*
         * Use the File objects exists method to determine if the File passed in actually exists.
         * If it does not exist, throw the FileNotFoundException as shown below:
         *
         * throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
         */
        // Initialize FileStats' instance variables.
        numLines = 0;
        numChars = 0;
        numWords = 0;
        this.skipWhiteSpace = skipWhiteSpace;
        this.f = f;
        reader = new FileReader(f);

    }

    // **You will need to call this method!!!**
    // This method takes a line and counts the number of words in that line.
    private static int countWords(String line) {
        // If the line variable is null or an empty string, return 0 for the word count.
        if (line == null || line.isEmpty()) { return 0; }
        // Otherwise, use the split method to break the String apart into words
        // i.e. separate the words by whitespace (\\s+ == RegEx for whitespace)
        String[] words = line.split("\\s+");
        // Words is now an Array of Strings (i.e. the words)
        // Thus, the number of elements in the array is the word count, so just return it.
        return words.length;
    }

    // **You will likely want to call this method!!!**
    private static String removeSpaces(String line) {
        if (line == null || line.isEmpty()) { return ""; }
        return String.join("", line.split("\\s+"));
        // How does this method remove whitespace?
        // line.split("\\s+") breaks the line apart into a word Array (kinda like a list of Strings)
        // String.join("", ...) Joins the word Array back together separated by ""

        // In other words, if the line value was "a b c", **split** on whitespace turns this into an array
        // ["a", "b", "c"] eliminating the spaces, and **join** puts the string back together separated by
        // an empty string (i.e. ""). Thus the string becomes "abc" with no more whitespace.
    }

    // **You will need to implement this method.**
    // This method should take a line and count the number of characters in that line.
    private static int countChars(String line, boolean skipWhiteSpace) {
        // 1. If skipWhiteSpace is true, use the removeSpaces method to remove whitespace from the line.
        int stats = 0;
        while (skipWhiteSpace == true){
            stats = Integer.parseInt(removeSpaces(line));
            return stats;

        }for (int j = 0; j < stats; j++){
            return j;
        }
        while (skipWhiteSpace == false){
            break;
        }
        // 2. Now write a loop to count the number of characters in the line.
        //    a. HINT: to get the length of a String, use its .length() method!
        int charCount = 0;
        for (int i = 0; i < line.length(); i++){
            charCount++;
        }return charCount;

        // 3. Return the count of characters.
        //    a. HINT: If whitespace isn't being skipped, a newline character (i.e. \n) counts as a character.


    }

    // An overloaded method for the read method you will be writing!
    public void read(File f) throws FileNotFoundException, IOException {
        if( !f.exists() ) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        this.f = f;
        this.read();
    }

    // **You will need to implement this method.**
    // This method should use the java.io.BufferedReader class to efficiently read the File object line-by-line
    public void read() throws FileNotFoundException, IOException {
        // 1. Create a BufferedReader object: BufferedReader is a Java class that is very efficient at reading input due
        //    to its buffering mechanisms.
        BufferedReader bufRead = new BufferedReader(reader);

        //    a. HINT: BufferReader's Constructor takes another Reader as an argument. Consider FileReader
        //    b. REF: https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/
        String line;
        while((line = bufRead.readLine()) != null) {
        numChars += countChars(line, skipWhiteSpace);
        numWords += countWords(line);
        numLines += bufRead.read();
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
