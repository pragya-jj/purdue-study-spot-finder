
/*
 * Main.java
 * This class runs the Purdue Study Spot Finder program.
 * It reads study spot information from a CSV file
 * and allows users to filter study locations.
 */

// Import classes needed for reading files and storing objects
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Load all study spots from the CSV file
        ArrayList<StudySpot> studySpots = loadStudySpots();

        // Display the program title
        System.out.println("=================================");
        System.out.println("     PURDUE STUDY SPOT FINDER");
        System.out.println("=================================");

        // Display all available study spots
        System.out.println("\nAvailable Study Locations:\n");

        for (int i = 0; i < studySpots.size(); i++) {
            studySpots.get(i).displayInfo();
        }

        // Display a message if no study spots were loaded
        if (studySpots.size() == 0) {
            System.out.println("No study spots were found.");
        }

        // Ask the user to filter locations by noise level
        Scanner input = new Scanner(System.in);

        System.out.println("\nWould you like to filter by noise level? (yes/no)");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            filterByNoiseLevel(studySpots, input);
        }

        input.close();
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

    // Filters study spots based on the user's preferred noise level
    public static void filterByNoiseLevel(ArrayList<StudySpot> studySpots, Scanner input) {

        // Ask the user to select a noise level
        System.out.println("\nChoose a noise level:");
        System.out.println("1. Quiet");
        System.out.println("2. Moderate");
        System.out.println("3. Busy");

        String choice = input.nextLine();
        String selectedNoise = "";

        // Match the user's choice to a noise level
        if (choice.equals("1")) {
            selectedNoise = "Quiet";
        } else if (choice.equals("2")) {
            selectedNoise = "Moderate";
        } else if (choice.equals("3")) {
            selectedNoise = "Busy";
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        // Keep track of whether any matching locations were found
        boolean found = false;

        System.out.println("\nStudy spots with " + selectedNoise + " noise:\n");

        // Check every study spot for a matching noise level
        for (int i = 0; i < studySpots.size(); i++) {

            StudySpot spot = studySpots.get(i);

            if (spot.getNoiseLevel().equalsIgnoreCase(selectedNoise)) {
                spot.displayInfo();
                found = true;
            }
        }

        // Display a message if no locations match
        if (!found) {
            System.out.println("No study spots found for this noise level.");
        }
    }
}

