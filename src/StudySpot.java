
/*
 * StudySpot.java
 * This class represents a study location on Purdue's campus.
 */

public class StudySpot {

    // Information stored for each study spot
    private String name;
    private String building;
    private String noiseLevel;
    private String studyType;

    // Constructor used to create a new study spot
    public StudySpot(String name, String building, String noiseLevel, String studyType) {
        this.name = name;
        this.building = building;
        this.noiseLevel = noiseLevel;
        this.studyType = studyType;
    }

    // Returns the name of the study spot
    public String getName() {
        return name;
    }

    // Returns the building where the study spot is located
    public String getBuilding() {
        return building;
    }

    // Returns the noise level of the study spot
    public String getNoiseLevel() {
        return noiseLevel;
    }

    // Returns the type of studying the location supports
    public String getStudyType() {
        return studyType;
    }

    // Prints all information about the study spot
    public void displayInfo() {
        System.out.println("Study Spot: " + name);
        System.out.println("Building: " + building);
        System.out.println("Noise Level: " + noiseLevel);
        System.out.println("Study Type: " + studyType);
        System.out.println("-------------------------");
    }
}

