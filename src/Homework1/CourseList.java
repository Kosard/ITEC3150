package Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseList {
    private ArrayList<Course> courseListItems = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        File sourceFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses");
        PrintWriter output = null;

        for (int i = 0; i < 5; i++) {
            list.add("test " + i);
        }

        try {
            output = new PrintWriter(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String s : list) {
            output.println(s);
        }

        output.close();
    }
}
