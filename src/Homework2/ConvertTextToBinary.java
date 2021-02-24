package Homework2;

import Homework1.EnglishCourse;
import Homework1.HistoryCourse;
import Homework1.MathCourse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

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
    /**
     * The main method calls the convertFile() method, which is the one that is doing the conversion
     *
     * @param args
     */
    public static void main(String[] args) {
        //Call to method that converts the text file to binary
        convertFile();
    }

    /**
     * This method reads from a predetermined text file location and then writes it as a binary (.dat) file, thus
     * converting it from text to binary.
     */
    public static void convertFile() {
        try {
            //Opening Reader and Output streams
            FileReader fr = new FileReader("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
            BufferedReader bf = new BufferedReader(fr);
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("courses.dat"));

            //Iterate through each line of the text file
            while (bf.ready()) {
                //Store attributes common to all Courses
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

                    //Write English object to binary file
                    oos.writeObject(new EnglishCourse(courseCRN, courseName, courseDiscipline, classification, read, writ));
                }

                if (courseDiscipline.equalsIgnoreCase("Math")) {
                    //Store attributes specific to Math Course
                    String temp = bf.readLine();
                    boolean stem = Boolean.parseBoolean(temp);
                    String type = bf.readLine();

                    //Write Math object to binary file
                    oos.writeObject(new MathCourse(courseCRN, courseName, courseDiscipline, stem, type));
                } else if (courseDiscipline.equalsIgnoreCase("History")) {
                    //Store attributes specific to History Course
                    String temp = bf.readLine();
                    boolean areaE = Boolean.parseBoolean(temp);
                    String type = bf.readLine();

                    //Write History object to binary file
                    oos.writeObject(new HistoryCourse(courseCRN, courseName, courseDiscipline, areaE, type));
                }
            }
            //Closing the streams
            fr.close();
            bf.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
