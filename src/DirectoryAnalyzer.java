import java.io.File;

/**
 * This class performs analysis on a directory.
 * It contains methods to count Java files and solved issue files.
 * This supports the assignment requirement of using an OOP structure.
 */
public class DirectoryAnalyzer {

    /**
     * Count the number of .java files inside the selected directory.
     *
     * @param directory The folder selected by the user.
     * @return The total number of Java files.
     */

    public int countJavaFiles(File directory) {

        int count = 0;  // Counter to track how many .java files found

        // Get all files inside the directory
        File[] files = directory.listFiles();

        // If directory is empty OR cannot be read → return 0 to avoid errors
        if (files == null) return 0;

        // Loop through every file in the directory
        for (File file : files) {

            // Check:
            // 1. It must be a file (not a folder)
            // 2. Filename must end with ".java"
            if (file.isFile() && file.getName().toLowerCase().endsWith(".java")) {
                count++; // Increase count when a Java file is found
            }
        }

        return count; // Return total Java files found
    }

    /**
     * Count the number of "solved issue" files.
     * A solved issue file is defined as:
     * - The filename contains BOTH "issue" AND "solved".
     *
     * @param directory The folder selected by the user.
     * @return The total number of solved issue files.
     */
    public int countSolvedIssues(File directory) {

        int count = 0; // Counter for solved issue files

        // Get list of all files in directory
        File[] files = directory.listFiles();

        // If directory cannot be read OR empty → return 0 safely
        if (files == null) return 0;

        // Loop through files
        for (File file : files) {
            String name = file.getName().toLowerCase(); // Convert to lowercase for easy checking

            // Check:
            // 1. It must be a file
            // 2. Name must contain both "issue" and "solved"
            if (file.isFile() && name.contains("issue") && name.contains("solved")) {
                count++; // Found a solved issue file
            }
        }

        return count; // Return total solved issue files found
    }
}
