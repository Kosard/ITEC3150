package Homework5;

import java.io.Serializable;

/**
 * Class: Course
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: January 23, 2021
 * <p>
 * This class describes the common attributes and methods of a Course being added
 * to a list.
 * <p>
 * Purpose: This class is intended to serve as a superclass for the different
 * types of Course.
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -1791967859940442392L;
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
        return "Course Name: " + courseName +
                ", Course Discipline = " + courseDiscipline +
                '}';
    }
}
