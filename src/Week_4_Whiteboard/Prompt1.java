package Week_4_Whiteboard;

import java.util.Random;

public class Prompt1 {
    /**
     * Find the largest number in an array
     *
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int[] intArr = new int[100];
        int largestNum = 0;

        //populate the array
        for (int i : intArr) {
            intArr[i] = rand.nextInt(1000 + 1);
        }

        //find the largest number
        for (int i : intArr) {
            if (i > largestNum) {
                largestNum = i;
            }
        }
        System.out.println(largestNum);
    }
}
