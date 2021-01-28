package Homework1;

public class EnglishCourse extends Course {
    boolean hasWriting;
    boolean hasReading;
    private String classification;

    public boolean hasWriting() {
        return hasWriting;
    }

    public boolean hasReading() {
        return hasReading;
    }

    public EnglishCourse(int crn, String name, String category, String classification,
                         boolean writing, boolean reading) {
        super(crn, name, category);
        this.classification = classification;
        this.hasWriting = writing;
        this.hasReading = reading;
    }

    public String getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return super.toString() + " EnglishCourse {" +
                "has Writing=" + hasWriting +
                ", has Reading=" + hasReading +
                ", Classification=" + classification +
                '}';
    }
}
