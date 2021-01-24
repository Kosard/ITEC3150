package Homework1;

public class MathCourse extends Course {
    private boolean isSTEM;
    private String courseType;

    public MathCourse(int crn, String name, String category, boolean stem, String type) {
        super(crn, name, category);
        this.isSTEM = stem;
        this.courseType = type;
    }
}
