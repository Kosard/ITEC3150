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
 * This class describes CourseList used to contain the Course item CourseList. It
 * also contains the main method which starts the program.
 * <p>
 * Purpose: Methods and attributes needed to create a CourseList of Course class
 * items. Print them, read them from a file, search for a specific crn or name,
 * remove and add a new course.
 */
public class CourseList {
    private ArrayList<Course> courseListItems = new ArrayList<>();

    /**
     * Method:main()
     * <p>
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file courses.txt and a menu for allowing user
     * to choose various tasks.
     *
     * @param args
     */
    public static void main(String[] args) {
        // create CourseList by reading in from text file named courses.txt

        CourseList courseList = new CourseList();

        // open text file

        File courseFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");

        // open a scanner to read data from file

        Scanner courseReader = null;
        try {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e) {
            System.out.println("No such file exists or the list is empty");
        }

        // read one course at a time

        while (courseReader != null && courseReader.hasNext()) {
            String discipline = courseReader.nextLine();
            int crn = Integer.parseInt(courseReader.nextLine());
            String courseName = courseReader.nextLine();

            if (discipline.equalsIgnoreCase("English")) {
                String classification = courseReader.nextLine();
                String temp = courseReader.nextLine();
                boolean read = Boolean.parseBoolean(temp);
                temp = courseReader.nextLine();
                boolean writ = Boolean.parseBoolean(temp);
                EnglishCourse engl = new EnglishCourse(crn, courseName, discipline, classification, read, writ);

                courseList.addCourse(engl);
            } else if (discipline.equalsIgnoreCase("Math")) {
                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String type = courseReader.nextLine();
                MathCourse math = new MathCourse(crn, courseName, discipline, stem, type);

                courseList.addCourse(math);
            } else if (discipline.equalsIgnoreCase("History")) {
                String temp = courseReader.nextLine();
                boolean areaE = Boolean.parseBoolean(temp);
                String type = courseReader.nextLine();
                HistoryCourse hist = new HistoryCourse(crn, courseName, discipline, areaE, type);

                courseList.addCourse(hist);
            } else {
                System.out.println("Unknown course discipline " + discipline);
            }
        }

        // open a scanner to read user input to navigate menu

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
                //open a scanner for searching, returns a null course if none found

                Scanner searchScanner = new Scanner(System.in);
                Course course;

                System.out.println("Search by:");
                System.out.println("1) Name?");
                System.out.println("2) CRN?");
                String typeCriteria = searchScanner.nextLine();

                //input validation loop

                while (true) {
                    if (typeCriteria.equalsIgnoreCase("1")) {
                        System.out.println("Enter the name of the course: ");
                        String name = searchScanner.nextLine();
                        course = courseList.searchCourse(name);
                        break;
                    }
                    if (typeCriteria.equalsIgnoreCase("2")) {
                        System.out.println("Enter the CRN of the course: ");
                        int crn = searchScanner.nextInt();
                        course = courseList.searchCourse(crn);
                        break;
                    } else {
                        System.out.println("Not a valid option! Try again:");
                        typeCriteria = searchScanner.nextLine();
                    }
                }

                if (course != null) {
                    System.out.println(course);
                } else {
                    System.out.println("Course was not found");
                }
            } else if (menuNum == 3) {
                // open a scanner for adding a course

                Scanner addScanner = new Scanner(System.in);

                System.out.println("What is the discipline of the course?");
                String discipline = addScanner.nextLine();
                System.out.println("What is the CRN of the course?");
                int crn = Integer.parseInt(addScanner.nextLine());
                System.out.println("What is the name of the course?");
                String courseName = addScanner.nextLine();

                if (discipline.equalsIgnoreCase("English")) {
                    boolean writ = false;
                    boolean read = false;


                    System.out.println("What is the classification level?");
                    String classification = addScanner.nextLine();
                    System.out.println("Is it a reading course?");
                    String userIn1 = addScanner.nextLine();

                    if (userIn1.equalsIgnoreCase("yes")) {
                        read = true;
                    }
                    System.out.println("Is it a writing course?");
                    String userIn2 = addScanner.nextLine();

                    if (userIn2.equalsIgnoreCase("yes")) {
                        writ = true;
                    }
                    EnglishCourse eng = new EnglishCourse(crn, courseName, discipline, classification,
                            read, writ);

                    courseList.addCourse(eng);
                } else if (discipline.equalsIgnoreCase("Math")) {
                    System.out.println("Is it STEM related?");
                    String userIn = addScanner.nextLine();
                    boolean stem = false;

                    if (userIn.equalsIgnoreCase("yes")) {
                        stem = true;
                    }
                    System.out.println("What is the instruction type?");
                    String insType = addScanner.nextLine();
                    MathCourse math = new MathCourse(crn, courseName, discipline, stem, insType);

                    courseList.addCourse(math);
                } else if (discipline.equalsIgnoreCase("History")) {
                    System.out.println("Is it Area E eligible?");
                    String userIn = addScanner.nextLine();
                    boolean areaE = false;

                    if (userIn.equalsIgnoreCase("yes")) {
                        areaE = true;
                    }
                    System.out.println("Is it recorded, online, or in-person?");
                    String insType = addScanner.nextLine();
                    HistoryCourse hist = new HistoryCourse(crn, courseName, discipline, areaE, insType);

                    courseList.addCourse(hist);
                } else {
                    Course course = new Course(crn, courseName, discipline);
                    courseList.addCourse(course);
                }
            } else if (menuNum == 4) {
                // open a scanner for removing a course

                Scanner removeScanner = new Scanner(System.in);

                System.out.println("Remove by:");
                System.out.println("1) Name?");
                System.out.println("2) CRN?");
                String typeCriteria = removeScanner.nextLine();

                //input validation loop

                while (true) {
                    if (typeCriteria.equalsIgnoreCase("1")) {
                        System.out.println("Please enter the name of the course you wish to remove: ");
                        String courseName = removeScanner.nextLine();

                        courseList.removeCourse(courseName);
                        break;
                    }
                    if (typeCriteria.equalsIgnoreCase("2")) {
                        System.out.println("Please enter the CRN of the course you wish to remove:");
                        int crn = removeScanner.nextInt();

                        courseList.removeCourse(crn);
                        break;
                    } else {
                        System.out.println("Not a valid option! Try again:");
                        typeCriteria = removeScanner.nextLine();
                    }
                }
            } else {
                done = true;

                // write out the contents of CourseList back to original file

                PrintWriter output = null;

                // open file for writing

                try {
                    output = new PrintWriter("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\" +
                            "Homework1\\courses.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // write contents of each CourseList item to text file

                for (Course course : courseList.getCourseListItems()) {
                    // write the attributes common to all courses

                    output.println(course.getCourseDiscipline());
                    output.println(course.getCourseCrn());
                    output.println(course.getCourseName());

                    if (course.getCourseDiscipline().equalsIgnoreCase("English")) {
                        // cast to appropriate subclass

                        EnglishCourse engl = (EnglishCourse) course;

                        // write attributes specific to english course

                        output.println(engl.getClassification());
                        output.println(engl.hasWriting());
                        output.println(engl.hasReading());
                    } else if (course.getCourseDiscipline().equalsIgnoreCase("Math")) {
                        // cast to appropriate subclass

                        MathCourse math = (MathCourse) course;

                        // write attributes specific to math course

                        output.println(math.isSTEM());
                        output.println(math.getInstructionType());
                    } else if (course.getCourseDiscipline().equalsIgnoreCase("History")) {
                        // cast to appropriate subclass

                        HistoryCourse hist = (HistoryCourse) course;

                        // write attributes specific to history course

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
        Course currentCourse = searchCourse(name);
        courseListItems.remove(currentCourse);
    }
}
