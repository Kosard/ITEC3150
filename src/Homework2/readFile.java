package Homework2;

import Homework1.Course;

import java.io.*;
import java.util.ArrayList;

public class readFile {
    public static void main(String[] args) {
        ArrayList<Course> courseList = new ArrayList<>();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework2\\courses.dat"));

            System.out.println(ois.read());
            while (ois.read() != -1) {
                Course course = (Course) ois.readObject();
                courseList.add(course);
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Course c : courseList) {
            System.out.println(c);
        }
    }
}
