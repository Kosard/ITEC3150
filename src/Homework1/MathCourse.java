package Homework1;

public class MathCourse extends Course {
    private boolean isSTEM;
    private String courseType;

    public boolean isSTEM() {
        return isSTEM;
    }

    public String getCourseType() {
        return courseType;
    }

    public MathCourse(int crn, String name, String category, boolean stem, String type) {
        super(crn, name, category);
        this.isSTEM = stem;
        this.courseType = type;
    }

    @Override
    public String toString() {
        return super.toString() + " MathCourse {" +
                "isSTEM=" + isSTEM +
                ", courseType=" + courseType +
                '}';
    }
}
