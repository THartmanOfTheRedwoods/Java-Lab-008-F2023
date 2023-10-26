import java.io.*;

public class FileStats {
    private int numLines;
    private int numWords;
    private int numChars;
    private boolean skipWhiteSpace;
    private File f;
    // The constructor takes a File object and a boolean flag as parameters
    public FileStats(File f, boolean skipWhiteSpace) throws FileNotFoundException {
        // Check if the file exists, otherwise throw an exception
        if (!f.exists()) {
            throw new FileNotFoundException(String.format("File: %s does not exist.", f.getName()));
        }
        // Assign the parameters to the instance variables
        this.f = f;
        this.skipWhiteSpace = skipWhiteSpace;
        // Initialize the counters to zero
        this.numLines = 0;
        this.numWords = 0;
        this.numChars = 0;
    }

    private static String removeSpaces(String line){
        if (line ==null || line.isEmpty()){
            return "";
        }
        return String.join("", line.split("\\s+"));
    }
    // The countChars method takes a line and a boolean flag as parameters
    private static int countChars(String line, boolean skipWhiteSpace) {
        // If skipWhiteSpace is true, remove the spaces from the line
        if (skipWhiteSpace) {
            line = removeSpaces(line);
        }
        // Return the length of the line as the number of characters
        return line.length();
    }
    public void read() throws FileNotFoundException, IOException {
        // Create a BufferedReader object
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Initialize a variable to hold each line
        String line;

        // Read the file line by line
        while ((line = reader.readLine()) != null) {
            // Increment the line count
            numLines++;

            // Count the words in the line and add to the total word count
            numWords += countChars(line, this.skipWhiteSpace );

            // Count the characters in the line and add to the total character count
            numChars += countChars(line, skipWhiteSpace);
        }

        // Close the BufferedReader
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
