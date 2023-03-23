import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//edited by Owen van Mantgem, 3/22/2023
public class Main {

    public static void main(String[] args) {
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        boolean skipWs;
        String userFileName;
        File userFile;

        // Write a loop that will ask the user to enter a file path to gather stats on,
        // and continue until "Q" is entered.
        while (true) {
            System.out.println("Please enter a file path");
            userFileName = scanner.nextLine();
            // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File
            Path path = (Path)Paths.get(userFileName);
            userFile = path.toFile();

            // Ask the user if they would like to skip whitespace
            System.out.println("Would you like to skip whitespace (y/n)");
            String skip = scanner.nextLine();

            // Create a variable called skipWs that stores the user's response as a boolean
            if (skip.equals("y")) {skipWs = true;}
            else {skipWs = false;}
            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {
                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args
                FileStats stats = new FileStats(userFile, skipWs);
                // You will need to call the fs.read method, which you need to implement!
                stats.read();
                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */
                System.out.println("stats:");
                System.out.printf("lines - %s", stats.getNumLines());
                System.out.printf(" words - %s", stats.getNumWords());
                System.out.printf(" chars - %s ", stats.getNumChars());
                System.out.print(userFileName);
                System.out.println("");
                System.out.println("");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
