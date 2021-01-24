package Homework1;

public class Course {
    private int courseCrn;
    private String courseName;
    private String courseCategory;

    public int getCourseCrn() {
        return courseCrn;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public Course(int crn, String name, String category) {
        this.courseCrn = crn;
        this.courseName = name;
        this.courseCategory = category;
    }
}
