package Homework2;

import Homework1.EnglishCourse;
import Homework1.HistoryCourse;
import Homework1.MathCourse;

import java.io.*;

public class ConvertTextToBinary {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (
                ObjectInputStream inputStream = new ObjectInputStream(
                        new FileInputStream("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework1\\courses.txt"));

                ObjectOutputStream outputStream = new ObjectOutputStream(
                        new FileOutputStream("courses.dat"))
        ) {
            while (true) {
                String courseDiscipline = inputStream.readUTF();
                int courseCRN = inputStream.read();
                String courseName = inputStream.readUTF();

                if (courseDiscipline.equalsIgnoreCase("English")) {
                    String classification = inputStream.readUTF();
                    String temp = inputStream.readUTF();
                    boolean read = Boolean.parseBoolean(temp);
                    temp = inputStream.readUTF();
                    boolean writ = Boolean.parseBoolean(temp);

                    outputStream.writeObject(new EnglishCourse(courseCRN, courseName, courseDiscipline, classification, read, writ));
                }

                if (courseDiscipline.equalsIgnoreCase("Math")) {
                    String temp = inputStream.readUTF();
                    boolean stem = Boolean.parseBoolean(temp);
                    String type = inputStream.readUTF();

                    outputStream.writeObject(new MathCourse(courseCRN, courseName, courseDiscipline, stem, type));
                } else if (courseDiscipline.equalsIgnoreCase("History")) {
                    String temp = inputStream.readUTF();
                    boolean areaE = Boolean.parseBoolean(temp);
                    String type = inputStream.readUTF();

                    outputStream.writeObject(new HistoryCourse(courseCRN, courseName, courseDiscipline, areaE, type));
                }
            }
        }
    }
}
