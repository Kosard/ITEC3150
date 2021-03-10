package MidtermReview;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Class:
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written:
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Write a porgram that reads the scores form the file and displays their total and average
 */
public class Exercise12_23 {
    public static void main(String[] args) {
        URL url;
        Scanner in = null;
        int sum = 0;
        int count = 0;

        try {
            url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            in = new Scanner(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (in.hasNext()) {
            String currentLine = in.nextLine();
            String[] splitLine = currentLine.split(" ");
            for (String s : splitLine) {
                sum += Integer.parseInt(s);
                count++;
            }
        }

        System.out.println("The total sum is " + sum);
        int average = sum / count;
        System.out.println("The average is " + average);
    }
}
