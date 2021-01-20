package Week_1;

import java.io.File;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        File sourceFile = new File("C:\\Users\\kevin\\Documents\\pets.txt");

        Scanner reader = null;

        try {
            reader = new Scanner(sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (reader.hasNext()) {
            String petName;
            String ownerName;
            int petAge;
            String petType;

            String currentLine = reader.nextLine();
            if (currentLine.equalsIgnoreCase("cat")) {
            }
        }
    }
}
