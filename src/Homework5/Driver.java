package Homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

/**
 * Class: Driver
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/21/2021
 * <p>
 * This class:
 * <p>
 * Purpose:
 */
public class Driver {
    private CourseHashMap<Integer, Course> theMap = new CourseHashMap<>();

    public static void main(String[] args) {
        Driver d = new Driver();
        d.readFile();

        Set<Integer> keyset = d.theMap.keySet();
        for (Integer key : keyset){
            Course value= d.theMap.get(key);
            System.out.println(key + ": " + value);
        }
    }

    public void readFile() {
        //open text file
        File courseFile = new File("C:\\Users\\kevin\\IdeaProjects\\ITEC3150\\src\\Homework5\\courses");
        //open a Scanner
        Scanner courseReader = null;

        try {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            System.out.println("No courseList Course found or courseList is empty");
        }

        //read one course at a time
        while (courseReader != null && courseReader.hasNext()) {
            String category = courseReader.nextLine();
            String temp = courseReader.nextLine();
            int crn = java.lang.Integer.parseInt(temp);
            String name = courseReader.nextLine();

            if (category.equalsIgnoreCase("English")) {
                String level = courseReader.nextLine();
                temp = courseReader.nextLine();
                boolean read = Boolean.parseBoolean(temp);
                temp = courseReader.nextLine();
                boolean writ = Boolean.parseBoolean(temp);

                EnglishCourse engl = new EnglishCourse(crn, name, category, level, read, writ);

                addCourse(engl);
            } else if (category.equalsIgnoreCase("Math")) {
                temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                MathCourse math = new MathCourse(crn, name, category, stem, format);

                addCourse(math);
            } else if (category.equalsIgnoreCase("History")) {
                temp = courseReader.nextLine();
                boolean areaE = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                HistoryCourse hist = new HistoryCourse(crn, name, category, areaE, format);

                addCourse(hist);
            } else {
                System.out.println("Unknown Course type " + category);
            }
        }
    }

    private void addCourse(Course course) {
        theMap.put(course.getCourseCrn(), course);
    }
}
