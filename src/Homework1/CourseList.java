package Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: CourseList
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: January 23, 2021
 * <p>
 * This class
 * <p>
 * Purpose:
 */
public class CourseList {
    private ArrayList<Course> courseListItems = new ArrayList<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        CourseList courseList = new CourseList();

        File courseFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
        Scanner courseReader = null;
        try {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            System.out.println("No such file exists or the list is empty");
        }

        while (courseReader != null && courseReader.hasNext()) {
            String disc = courseReader.nextLine();
            int crn = Integer.parseInt(courseReader.nextLine());
            String name = courseReader.nextLine();

            if (disc.equalsIgnoreCase("English")) {
                String classification = courseReader.nextLine();
                String temp = courseReader.nextLine();
                boolean writ = Boolean.parseBoolean(temp);
                temp = courseReader.nextLine();
                boolean read = Boolean.parseBoolean(temp);
                EnglishCourse engl = new EnglishCourse(crn, name, disc, classification, writ, read);
                courseList.addCourse(engl);
            } else if (disc.equalsIgnoreCase("Math")) {
                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String type = courseReader.nextLine();
                MathCourse math = new MathCourse(crn, name, disc, stem, type);
                courseList.addCourse(math);
            } else if (disc.equalsIgnoreCase("History")) {
                String temp = courseReader.nextLine();
                boolean areaE = Boolean.parseBoolean(temp);
                String type = courseReader.nextLine();
                HistoryCourse hist = new HistoryCourse(crn, name, disc, areaE, type);
                courseList.addCourse(hist);
            } else {
                System.out.println("Unknown course discipline " + disc);
            }
        }

        Scanner menuScan = new Scanner(System.in);

        System.out.println("Welcome to your course list!");
        boolean done = false;
        while (!done) {
            System.out.println("Would you like to:");
            System.out.println("1) View the current list?");
            System.out.println("2) Search for a course on your list?");
            System.out.println("3) Add a course to your list?");
            System.out.println("4) Remove a course from your list?");
            System.out.println("5) Exit");
            String menuString = menuScan.nextLine();
            int menuNum = Integer.parseInt(menuString);

            if (menuNum == 1) {
                courseList.printCourseListItems();
            } else if (menuNum == 2) {
                Scanner searchScanner = new Scanner(System.in);
                Course course;
                System.out.println("Search by CRN?");
                if (searchScanner.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println("Enter the CRN of the course: ");
                    int crn = searchScanner.nextInt();
                    course = courseList.searchCourse(crn);
                } else {
                    System.out.println("Enter the name of the course: ");
                    String name = searchScanner.nextLine();
                    course = courseList.searchCourse(name);
                }

                if (course != null) {
                    System.out.println(course);
                } else {
                    System.out.println("Course was not found");
                }
            } else if (menuNum == 3) {
                Scanner addScanner = new Scanner(System.in);
                System.out.println("What is the discipline of the course?");
                String disc = addScanner.nextLine();
                System.out.println("WHat is the CRN of the course?");
                int crn = Integer.parseInt(addScanner.nextLine());
                System.out.println("What is the name of the course?");
                String name = addScanner.nextLine();
                if (disc.equalsIgnoreCase("English")) {
                    System.out.println("What is the classification level?");
                    String classification = addScanner.nextLine();
                    System.out.println("Is it a writing course?");
                    String input1 = addScanner.nextLine();
                    boolean writ = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        writ = true;
                    }
                    System.out.println("Is it a reading course?");
                    String input2 = addScanner.nextLine();
                    boolean read = false;
                    if (input2.equalsIgnoreCase("yes")) {
                        read = true;
                    }
                    EnglishCourse eng = new EnglishCourse(crn, name, disc, classification,
                            read, writ);
                    courseList.addCourse(eng);
                } else if (disc.equalsIgnoreCase("Math")) {
                    System.out.println("Is it STEM related?");
                    String input1 = addScanner.nextLine();
                    boolean stem = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        stem = true;
                    }
                    System.out.println("What is the instruction type?");
                    String type = addScanner.nextLine();
                    MathCourse math = new MathCourse(crn, name, disc, stem, type);
                    courseList.addCourse(math);
                } else {
                    System.out.println("Is it Area E eligible?");
                    String input1 = addScanner.nextLine();
                    boolean areaE = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        areaE = true;
                    }
                    System.out.println("Is it recorded, online, or in-person?");
                    String type = addScanner.nextLine();
                    HistoryCourse hist = new HistoryCourse(crn, name, disc, areaE, type);
                    courseList.addCourse(hist);
                }
            } else if (menuNum == 4) {
                Scanner removeScanner = new Scanner(System.in);
                System.out.println("Remove by:");
                System.out.println("1) Name?");
                System.out.println("2) CRN?");
                int typeCriteria = removeScanner.nextInt();
                if (typeCriteria == 1) {
                    System.out.println("Please enter the name of the course you wish to remove: ");
                    String courseName = removeScanner.nextLine();
                    courseList.removeCourse(courseName);
                } else {
                    System.out.println("Please enter the CRN of the course you wish to remove:");
                    int crn = removeScanner.nextInt();
                    courseList.removeCourse(crn);
                }
            } else {
                done = true;
                PrintWriter output = null;
                try {
                    output = new PrintWriter("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\" +
                            "Homework1\\courses.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                for (Course course : courseList.getCourseListItems()) {
                    output.println(course.getCourseDiscipline());
                    output.println(course.getCourseCrn());
                    output.println(course.getCourseName());

                    if (course.getCourseDiscipline().equalsIgnoreCase("English")) {
                        EnglishCourse engl = (EnglishCourse) course;
                        output.println(engl.getClassification());
                        output.println(engl.hasWriting());
                        output.println(engl.hasReading());
                    } else if (course.getCourseDiscipline().equalsIgnoreCase("Math")) {
                        MathCourse math = (MathCourse) course;
                        output.println(math.isSTEM());
                        output.println(math.getInstructionType());
                    } else if (course.getCourseDiscipline().equalsIgnoreCase("History")) {
                        HistoryCourse hist = (HistoryCourse) course;
                        output.println(hist.isAreaE_Eligible());
                        output.println(hist.getInstructionType());
                    } else {
                        System.out.println("Unknown Course Discipline: " + course.getCourseDiscipline());
                    }
                }
                output.close();
            }
        }
    }

    /**
     * Method: getCourseListItems()
     * This method returns the arraylist attribute of the courseList class
     *
     * @return arraylist attribute
     */
    public ArrayList<Course> getCourseListItems() {
        return courseListItems;
    }

    /**
     * Method: printCourseListItems()
     * This method prints each individual course object to the console
     */
    public void printCourseListItems() {
        for (Course cs : courseListItems) {
            System.out.println(cs);
        }
    }

    /**
     * Method: searchCourse()
     * This method looks through the current list of course objects and returns a
     * specific course object if its crn attribute matches the input parameter crn.
     * It returns null otherwise.
     *
     * @param crn crn of the course to be searched
     * @return the matched course or null if none found
     */
    public Course searchCourse(int crn) {
        Course currentCourse = null;
        for (Course course : courseListItems) {
            if (course.getCourseCrn() == crn) {
                currentCourse = course;
            }
        }
        return currentCourse;
    }

    /**
     * Method: searchCourse()
     * This method looks through the current list of course objects and returns a
     * specific course object if its name attribute matches the input parameter name.
     * It returns null otherwise.
     *
     * @param name name of the course to be searched
     * @return the matched course or null if none found
     */
    public Course searchCourse(String name) {
        Course currentCourse = null;
        for (Course course : courseListItems) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                currentCourse = course;
            }
        }
        return currentCourse;
    }

    /**
     * Method: addCourse()
     * This method calls the arraylist's add() method in order add a course to the arraylist
     *
     * @param course course object that will be added to the arraylist
     */
    public void addCourse(Course course) {
        courseListItems.add(course);
    }

    /**
     * Method: removeCourse()
     * This method removes a course object using the CRN by calling the
     * searchCourse() method and the arraylist's remove() method
     *
     * @param crn crn of the course that is to be removed
     */
    public void removeCourse(int crn) {
        Course currentCourse = searchCourse(crn);
        courseListItems.remove(currentCourse);
    }

    /**
     * Method: removeCourse()
     * This method removes a course object using its name by calling the
     * searchCourse() method and the arraylist's remove() method
     *
     * @param name name of the course that is to be removed
     */
    public void removeCourse(String name) {
//        for (int i = 0; i < courseListItems.size(); i++) {
//            Course currentCourse = courseListItems.get(i);
//            if (currentCourse.getCourseName().equalsIgnoreCase(name)) {
//                courseListItems.remove(currentCourse);
//            }
//        }
        Course currentCourse = searchCourse(name);
        courseListItems.remove(currentCourse);
    }
}
