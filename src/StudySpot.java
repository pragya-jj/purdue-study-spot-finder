// java file

public class StudySpot {
    private String name;
    private String building;
    private String noiseLevel;
    private String studyType;

    public StudySpot(String name, String building, String noiseLevel, String studyType) {
        this.name = name;
        this.building = building;
        this.noiseLevel = noiseLevel;
        this.studyType = studyType;
    }

    public String getName() {
        return name;
    }

    public String getBuilding() {
        return building;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public String getStudyType() {
        return studyType;
    }

    public void displayInfo() {
        System.out.println("Study Spot: " + name);
        System.out.println("Building: " + building);
        System.out.println("Noise Level: " + noiseLevel);
        System.out.println("Study Type: " + studyType);
        System.out.println("-------------------------");
    }
}

