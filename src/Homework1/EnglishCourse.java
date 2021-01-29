package Homework1;

/**
 * Class: EnglishCourse
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: January 23, 2021
 * <p>
 * This class describes the subclass of Course called EnglishCourse.
 * <p>
 * Purpose: Contains the attributes specific to a type of Course called EnglishCourse.
 */
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
                " has Writing = " + hasWriting +
                ", has Reading = " + hasReading +
                ", Classification = " + classification +
                '}';
    }
}
