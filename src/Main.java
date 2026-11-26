/*
 * Main.java
 * This class runs the Purdue Study Spot Finder program.
 * It reads study spot information from a CSV file
 * and displays the available study locations.
 */

// Import classes needed for reading files and storing objects
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Load all study spots from the CSV file
        ArrayList<StudySpot> studySpots = loadStudySpots();

        // Display all study spots
        System.out.println("     PURDUE STUDY SPOT FINDER");
        System.out.println("=================================");

        System.out.println("\nAvailable Study Locations:\n");

        // Go through the ArrayList and display each study spot
        for (int i = 0; i < studySpots.size(); i++) {
            studySpots.get(i).displayInfo();
        }

        // Display a message if no study spots were loaded
        if (studySpots.size() == 0) {
            System.out.println("No study spots were found.");
        }
    }

    // Reads the CSV file and creates StudySpot objects
    public static ArrayList<StudySpot> loadStudySpots() {

        // Create an ArrayList to store the study spots
        ArrayList<StudySpot> studySpots = new ArrayList<StudySpot>();

        try {
            // Open the CSV file
            File file = new File("data/study_spots.csv");
            Scanner fileReader = new Scanner(file);

            // Skip the first line because it contains column names
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            // Read each remaining line in the CSV file
            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                // Separate the information using commas
                String[] parts = line.split(",");

                // Make sure the line contains all four pieces of information
                if (parts.length == 4) {

                    // Create a StudySpot object using the CSV information
                    StudySpot spot = new StudySpot(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim()
                    );

                    // Add the new object to the ArrayList
                    studySpots.add(spot);
                }
            }

            // Close the file after reading it
            fileReader.close();

        } catch (FileNotFoundException e) {
            // Display an error if the CSV file cannot be found
            System.out.println("Error: Study spots file could not be found.");
        }

        // Return the list of study spots
        return studySpots;
    }
}
