import java.io.File;
import java.util.Scanner;

/**
 * This is the main class of the program.
 * It handles:
 * 1. Asking the user for a directory path
 * 2. Validating the directory
 * 3. Calling DirectoryAnalyzer methods to count files
 * 4. Displaying the output
 */
public class Main {

    public static void main(String[] args) {

        // Scanner is used to read input typed by the user
        Scanner scanner = new Scanner(System.in);

        // Create an object of DirectoryAnalyzer to use its methods
        DirectoryAnalyzer analyzer = new DirectoryAnalyzer();

        // Step 1: Prompt user to enter a directory path
        System.out.println("Enter directory path:");

        // Read the path typed by the user as a String
        String path = scanner.nextLine();

        // Convert the path into a File object
        File directory = new File(path);

        // Step 2: Validate the directory
        // Check if the path exists AND it is a folder
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: Invalid directory path.");
            return;  // Stop the program if the path is invalid
        }

        // Step 3: Count the number of .java files
        int javaCount = analyzer.countJavaFiles(directory);

        // Step 4: Count the number of solved issue files
        int issueCount = analyzer.countSolvedIssues(directory);

        // Step 5: Display both results clearly to the user
        System.out.println("Number of Java Files = " + javaCount);
        System.out.println("Number of Issues = " + issueCount);
    }
}
