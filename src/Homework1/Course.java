package Homework1;

public class Course {
    private int courseCrn;
    private String courseName;
    private String courseDiscipline;

    public int getCourseCrn() {
        return courseCrn;
    }

    public String getCourseName() {
        return courseName;
    }

    public Course(int crn, String name, String category) {
        this.courseCrn = crn;
        this.courseName = name;
        this.courseDiscipline = category;
    }

    public String getCourseDiscipline() {
        return courseDiscipline;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CRN=" + courseCrn +
                ", Name=" + courseName +
                ", Discipline=" + courseDiscipline +
                '}';
    }
}
