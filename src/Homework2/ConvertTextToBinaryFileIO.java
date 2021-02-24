package Homework2;

import Homework1.EnglishCourse;
import Homework1.HistoryCourse;
import Homework1.MathCourse;

import java.io.*;

public class ConvertTextToBinaryFileIO {
    public static void main(String[] args) {
        File textFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
        File outFile = new File(
                "coursesTest.dat");
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(textFile));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));

            while (dis.available() > 0) {
                System.out.println(dis.readLine());
            }
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }

    public static void writeCourseDataStream() {
        File textFile = new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt");
        File outFile = new File(
                "coursesTest.dat");
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(textFile));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));

            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
