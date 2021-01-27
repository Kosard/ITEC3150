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
                         boolean writing, boolean reading) {
        super(crn, name, category);
        this.cAttribute = attribute;
        this.hasWriting = writing;
        this.hasReading = reading;
    }

    @Override
    public String toString() {
        return super.toString() + " EnglishCourse {" +
                "hasWriting=" + hasWriting +
                ", hasReading=" + hasReading +
                ", cAttribute=" + cAttribute +
                '}';
    }
}
