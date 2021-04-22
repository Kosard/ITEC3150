package Week_8_Midterm;

import java.io.*;
import java.util.ArrayList;

/**
 * Class: Driver
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/9/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class ReadGames {
    public static void main(String[] args) {
        System.out.println(readGameObjects());
    }

    public static ArrayList<Game> readGameObjects() {
        ArrayList<Game> gamesList = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Midterm\\games.dat");
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    Game currentGame = (Game) ois.readObject();
                    gamesList.add(currentGame);
                }
            } catch (EOFException e) {
                System.out.println();
            }
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gamesList;
    }
}
