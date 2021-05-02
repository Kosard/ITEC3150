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
 * This is a driver class, which means it contains the main method that will be used to run the program. In addition to
 * the main method, it also contains methods that read a specified file while also calling a method that adds each Course
 * object to the custom HashMap.
 * <p>
 * Purpose: To integrate various Java competencies that we have learned over the whole semester.
 */
public class Driver {
    //Instance Variable
    private CourseHashMap<Integer, Course> theMap = new CourseHashMap<>();

    public static void main(String[] args) {
        //create driver object to use methods and refer to HashMap
        Driver d = new Driver();

        //call to method that reads text file
        d.readFile();

        //call to method that prints HashMap
        d.printHashMap();
    }

    /**
     * This method temporarily creates a Set from the HashMap, which allows to be iterated and thus be printed to the
     * console.
     */
    public void printHashMap(){
        //create Set from keyset method
        Set<Integer> keyset = theMap.keySet();

        //iterate through the Set
        for (Integer key : keyset){
            Course value= theMap.get(key);
            System.out.println(key + ": " + value);
        }
    }

    /**
     * This method reads the specified text file containing raw Course object text that will be converted to an actual
     * Course object. After making each Course object, it will then be added to the custom HashMap.
     */
    public void readFile() {
        //open text file
        File courseFile = new File("C:\\Users\\kevin\\IdeaProjects\\ITEC3150\\src\\Homework5\\courses");
        //open a Scanner
        Scanner courseReader = null;

        //try to read file
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

            //if category is English, create EnglishCourse object
            if (category.equalsIgnoreCase("English")) {
                String level = courseReader.nextLine();
                temp = courseReader.nextLine();
                boolean read = Boolean.parseBoolean(temp);
                temp = courseReader.nextLine();
                boolean writ = Boolean.parseBoolean(temp);

                EnglishCourse engl = new EnglishCourse(crn, name, category, level, read, writ);

                addCourse(engl);
            }

            //if category is Math, create MathCourse object
            else if (category.equalsIgnoreCase("Math")) {
                temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                MathCourse math = new MathCourse(crn, name, category, stem, format);

                addCourse(math);
            }

            //if category is History, create HistoryCourse object
            else if (category.equalsIgnoreCase("History")) {
                temp = courseReader.nextLine();
                boolean areaE = Boolean.parseBoolean(temp);
                String format = courseReader.nextLine();

                HistoryCourse hist = new HistoryCourse(crn, name, category, areaE, format);

                addCourse(hist);
            }

            //Unknown category
            else {
                System.out.println("Unknown Course type " + category);
            }
        }
    }

    /**
     * This method adds the Course object to the HashMap
     * @param course Course to be added to the HashMap
     */
    private void addCourse(Course course) {
        theMap.put(course.getCourseCrn(), course);
    }
}
