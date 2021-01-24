package Homework1;

public class EnglishCourse extends Course {
    boolean hasWriting;
    boolean hasReading;
    private String cAttribute;

    public boolean hasWriting() {
        return hasWriting;
    }

    public boolean hasReading() {
        return hasReading;
    }

    public String getAttribute() {
        return cAttribute;
    }

    public EnglishCourse(int crn, String name, String category, String attribute,
                         boolean reading, boolean writing) {
        super(crn, name, category);
        this.cAttribute = attribute;
        this.hasWriting = writing;
        this.hasReading = reading;
    }
}
