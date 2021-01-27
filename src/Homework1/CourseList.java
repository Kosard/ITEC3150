package Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseList {
    private ArrayList<Course> courseListItems = new ArrayList<>();

    public static void main(String[] args) {
        CourseList courseList = new CourseList();

        File courseFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses");
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
                String attribute = courseReader.nextLine();
                String temp = courseReader.nextLine();
                boolean writ = Boolean.parseBoolean(temp);
                temp = courseReader.nextLine();
                boolean read = Boolean.parseBoolean(temp);
                EnglishCourse engl = new EnglishCourse(crn, name, disc, attribute, writ, read);
                courseList.addCourse(engl);
            } else if (disc.equalsIgnoreCase("Math")) {
                System.out.println("Is it STEM related?");
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
                Scanner courseScan = new Scanner(System.in);
                Course course;
                System.out.println("Search by CRN?");
                if (courseScan.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println("Enter the CRN of the course: ");
                    int crn = courseScan.nextInt();
                    course = courseList.searchCourse(crn);
                } else {
                    System.out.println("Enter the name of the course: ");
                    String name = courseScan.nextLine();
                    course = courseList.searchCourse(name);
                }

                if (course != null) {
                    System.out.println(course);
                } else {
                    System.out.println("Course was not found");
                }
            } else if (menuNum == 3) {
                Scanner userIn = new Scanner(System.in);
                Course course = null;
                System.out.println("What is the discipline of the course?");
                String disc = userIn.nextLine();
                System.out.println("WHat is the CRN of the course?");
                int crn = Integer.parseInt(userIn.nextLine());
                System.out.println("What is the name of the course?");
                String name = userIn.nextLine();
                if (disc.equalsIgnoreCase("English")) {
                    System.out.println("What is the attribute level?");
                    String attribute = userIn.nextLine();
                    System.out.println("Is it a writing course?");
                    String input1 = userIn.nextLine();
                    boolean writ = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        writ = true;
                    }
                    System.out.println("Is it a reading course?");
                    String input2 = userIn.nextLine();
                    boolean read = false;
                    if (input2.equalsIgnoreCase("yes")) {
                        read = true;
                    }
                    EnglishCourse eng = new EnglishCourse(crn, name, disc, attribute,
                            read, writ);
                    courseList.addCourse(eng);
                } else if (disc.equalsIgnoreCase("Math")) {
                    System.out.println("Is it STEM related?");
                    String input1 = userIn.nextLine();
                    boolean stem = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        stem = true;
                    }
                    System.out.println("What is the instruction type?");
                    String type = userIn.nextLine();
                    MathCourse math = new MathCourse(crn, name, disc, stem, type);
                    courseList.addCourse(math);
                } else {
                    System.out.println("Is it Area E eligible?");
                    String input1 = userIn.nextLine();
                    boolean areaE = false;
                    if (input1.equalsIgnoreCase("yes")) {
                        areaE = true;
                    }
                    System.out.println("Is it recorded, online, or in-person?");
                    String type = userIn.nextLine();
                    HistoryCourse hist = new HistoryCourse(crn, name, disc, areaE, type);
                    courseList.addCourse(hist);
                }
            } else if (menuNum == 4) {
                System.out.println("Please enter the CRN you wish to remove:");
                int crn = menuScan.nextInt();
                courseList.removeCourse(crn);
            } else {
                done = true;
                PrintWriter output = null;
                try {
                    output = new PrintWriter("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\" +
                            "Homework1\\courses");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                for (Course course : courseList.getCourseListItems()) {
                    output.println(course.getCourseCategory());
                    output.println(course.getCourseCrn());
                    output.println(course.getCourseName());

                    if (course.getCourseCategory().equalsIgnoreCase("English")) ;
                }
            }
        }
    }

    public ArrayList<Course> getCourseListItems() {
        return courseListItems;
    }

    public void printCourseListItems() {
        for (Course cs : courseListItems) {
            System.out.println(cs);
        }
    }

    public Course searchCourse(int crn) {
        Course currentCourse = null;
        for (Course course : courseListItems) {
            if (course.getCourseCrn() == crn) {
                currentCourse = course;
            }
        }
        return currentCourse;
    }

    public Course searchCourse(String name) {
        Course currentCourse = null;
        for (Course course : courseListItems) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                currentCourse = course;
            }
        }
        return currentCourse;
    }

    public void addCourse(Course cs) {
        courseListItems.add(cs);
    }

    public void removeCourse(int crn) {
//        for (int i = 0; i < courseListItems.size(); i++) {
//            Course currentCourse = courseListItems.get(i);
//            if (currentCourse.getCourseCrn() == crn){
//                courseListItems.remove(currentCourse);
//            }
//        }
        Course currentCourse = searchCourse(crn);
        courseListItems.remove(currentCourse);
    }

    public void removeCourse(String name) {
        for (int i = 0; i < courseListItems.size(); i++) {
            Course currentCourse = courseListItems.get(i);
            if (currentCourse.getCourseName().equalsIgnoreCase(name)) {
                courseListItems.remove(currentCourse);
            }
        }
    }
}
