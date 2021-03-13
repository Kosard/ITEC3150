package Homework3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class:
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: March 3, 2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class ArraySumHolder {
    private final int NUM_OF_ARRAYS = 1000000;
    private final int BIG_ARRAY_SIZE = 9000000;
    private final Lock lock = new ReentrantLock();
    private double sum = 0;
    private double[] bigArray;
    private double[][] splitArray;

    public ArraySumHolder() {
        bigArray = createRandomArray();
        splitArray = splitBigArray(bigArray, NUM_OF_ARRAYS);
    }

    public double[][] getSplitArray() {
        return splitArray;
    }

    public int getNUM_OF_ARRAYS() {
        return NUM_OF_ARRAYS;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double[] createRandomArray() {
        double[] array = new double[BIG_ARRAY_SIZE];
        Random rand = new Random();
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < array.length; i++) {
            //array[i] = Double.parseDouble(df.format(rand.nextDouble() * 100 + 1));
            array[i] = i;
        }
        return array;
    }

    public double[][] splitBigArray(double[] bigArray, int numOfArray) { //4
        int numOfElements = bigArray.length / numOfArray; //6
        double[][] arrArr = new double[numOfArray][numOfElements]; //4 rows and 1 column
        int leftIndex = 0;
        for (int i = 0; i < numOfArray; i++) {
            double[] temp = new double[numOfElements];
            System.arraycopy(bigArray, leftIndex, temp, 0, numOfElements);
            for (int j = 0; j < numOfElements; j++) {
                arrArr[i][j] = temp[j];
            }
            leftIndex += numOfElements;
        }
        return arrArr;
    }

    public void addElements(double[] array) {
        lock.lock();
        try {
            for (double j : array) {
                //System.out.println("Adding " + j + " to array");
                //sum = sum + j;
                setSum(getSum() + j);
            }
        } finally {
            lock.unlock();
        }
    }
}
