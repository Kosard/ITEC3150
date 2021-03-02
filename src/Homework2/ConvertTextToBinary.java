package Homework2;

import Homework1.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Class: ConvertTextToBinary
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: February 14, 2021
 * <p>
 * This is a driver class, which means it contains the main that will do the conversion from text to binary.
 * <p>
 * Purpose: This class reads from a selected text file. As it reads from the text file, it will write object data into
 * a binary file, thus converting it from a text to binary file.
 */
public class ConvertTextToBinary {
    private ArrayList<Course> courseList = new ArrayList<>();
    /**
     * The main method calls the convertFile() method, which is the one that is doing the conversion
     *
     * @param args
     */
    public static void main(String[] args) {
        //Create converter object
        ConvertTextToBinary converter = new ConvertTextToBinary();

        //method call to read text file without Scanner
        converter.readTextFile();

        //method call to write binary data
        converter.writeBinaryFile();
    }

    public void readTextFile() {
        FileReader fr;
        BufferedReader bf;

        try {
            fr = new FileReader("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
            bf = new BufferedReader(fr);

            while (bf.ready()) {
                String courseDiscipline = bf.readLine();
                int courseCRN = Integer.parseInt(bf.readLine());
                String courseName = bf.readLine();

                if (courseDiscipline.equalsIgnoreCase("English")) {
                    //Store attributes specific to English Course
                    String classification = bf.readLine();
                    String temp = bf.readLine();
                    boolean read = Boolean.parseBoolean(temp);
                    temp = bf.readLine();
                    boolean writ = Boolean.parseBoolean(temp);

                    //store in temporary list
                    courseList.add(new EnglishCourse(courseCRN, courseName, courseDiscipline, classification, read, writ));
                }

                if (courseDiscipline.equalsIgnoreCase("Math")) {
                    //Store attributes specific to Math Course
                    String temp = bf.readLine();
                    boolean stem = Boolean.parseBoolean(temp);
                    String type = bf.readLine();

                    courseList.add(new MathCourse(courseCRN, courseName, courseDiscipline, stem, type));


                } else if (courseDiscipline.equalsIgnoreCase("History")) {
                    //Store attributes specific to History Course
                    String temp = bf.readLine();
                    boolean areaE = Boolean.parseBoolean(temp);
                    String type = bf.readLine();

                    courseList.add(new HistoryCourse(courseCRN, courseName, courseDiscipline, areaE, type));
                }
            }
            //Closing the streams
            fr.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBinaryFile() {
        ObjectOutputStream oos;

        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream("courses.dat"));

            for (Course c : courseList) {
                oos.writeObject(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
