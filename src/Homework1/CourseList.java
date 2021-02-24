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
 * Written: February 14, 2021
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

        courseList.readFile();

        Scanner keyboard = new Scanner(System.in);

        boolean done = false;

        do {
            courseList.menu();
            String tp = keyboard.nextLine();
            int menuKey = Integer.parseInt(tp);

            switch (menuKey) {
                case 1:
                    courseList.printCourseListItems();
                    break;
                case 2:
                    System.out.println("Enter Course Name");
                    String courseName = keyboard.nextLine();
                    Course course = courseList.searchCourse(courseName);
                    if (course != null) {
                        System.out.println(course);
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                case 3:
                    System.out.println("What is the discipline of the course?");
                    String category = keyboard.nextLine();
                    System.out.println("What is the CRN of the course?");
                    int crn = Integer.parseInt(keyboard.nextLine());
                    System.out.println("What is the name of the course?");
                    courseName = keyboard.nextLine();

                    if (category.equalsIgnoreCase("English")) {
                        boolean writ = false;
                        boolean read = false;

                        System.out.println("What is the classification level?");
                        String classification = keyboard.nextLine();
                        System.out.println("Is it a reading course?");
                        String userIn1 = keyboard.nextLine();

                        if (userIn1.equalsIgnoreCase("yes")) {
                            read = true;
                        }
                        System.out.println("Is it a writing course?");
                        String userIn2 = keyboard.nextLine();

                        if (userIn2.equalsIgnoreCase("yes")) {
                            writ = true;
                        }
                        EnglishCourse eng = new EnglishCourse(crn, courseName, category, classification,
                                read, writ);

                        courseList.addCourse(eng);
                    } else if (category.equalsIgnoreCase("Math")) {
                        System.out.println("Is it STEM related?");
                        String userIn3 = keyboard.nextLine();
                        boolean stem = false;

                        if (userIn3.equalsIgnoreCase("yes")) {
                            stem = true;
                        }
                        System.out.println("What is the instruction type?");
                        String type = keyboard.nextLine();
                        MathCourse math = new MathCourse(crn, courseName, category, stem, type);

                        courseList.addCourse(math);
                    } else if (category.equalsIgnoreCase("History")) {
                        System.out.println("Is it Area E eligible?");
                        String userIn4 = keyboard.nextLine();
                        boolean areaE = false;

                        if (userIn4.equalsIgnoreCase("yes")) {
                            areaE = true;
                        }
                        System.out.println("What is the instruction type?");
                        String type = keyboard.nextLine();
                        HistoryCourse hist = new HistoryCourse(crn, courseName, category, areaE, type);

                        courseList.addCourse(hist);
                    } else {
                        System.out.println("That discipline is not available to be added at this time");
                    }
                    break;
                case 4:
                    System.out.println("Enter Course Name");
                    String id = keyboard.nextLine();
                    courseList.removeCourse(id);
                    break;
                default:
                    done = true;
                    courseList.writeFile();
            }
        } while (!done);
    }

    //Prof method
    public void readFile() {
        //open text file
        File courseFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
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
            int crn = Integer.parseInt(temp);
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

    //Prof method
    public void writeFile() {
        PrintWriter out = null;

        //open file
        try {
            out = new PrintWriter(new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt"));

            //write contents of each courseList item to file
            for (Course c : getCourseListItems()) {
                //write first attributes common to all
                out.println(c.getCourseDiscipline());
                out.println(c.getCourseCrn());
                out.println(c.getCourseName());

                if (c.getCourseDiscipline().equalsIgnoreCase("History")) {
                    //cast to appropriate subclass
                    HistoryCourse hist = (HistoryCourse) c;
                    //write att specific to Hist
                    out.println(hist.isAreaE_Eligible());
                    out.println(hist.getInstructionType());
                } else if (c.getCourseDiscipline().equalsIgnoreCase("Math")) {
                    //cast to apropos subclass
                    MathCourse math = (MathCourse) c;
                    //write atts specific to Math
                    out.println(math.isSTEM());
                    out.println(math.getInstructionType());
                } else if (c.getCourseDiscipline().equalsIgnoreCase("English")) {
                    EnglishCourse engl = (EnglishCourse) c;
                    out.println(engl.getClassification());
                    out.println(engl.hasReading());
                    out.println(engl.hasWriting());
                } else {
                    System.out.println("Unknown Course type " + c.getCourseDiscipline());
                }
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Prof method
    public void menu() {
        System.out.println("Welcome to your Course List!");
        System.out.println("Would you like to:");
        System.out.println("1) View the current list?");
        System.out.println("2) Search for a course on your list?");
        System.out.println("3) Add a course to your list?");
        System.out.println("4) Remove a course from your list?");
        System.out.println("5) Exit");

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
        if (currentCourse != null) {
            courseListItems.remove(currentCourse);
        }
    }
}
