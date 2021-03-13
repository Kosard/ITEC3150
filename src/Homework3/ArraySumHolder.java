package Homework3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class: ArraySumHolder
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: March 3, 2021
 * <p>
 * This class contains important fields such as the sum and arrays that will be used later when launching threads.
 * <p>
 * Purpose: To create a foundation of fields and methods in order to reference them in the driver class.
 */
public class ArraySumHolder {
    //Constants for calculations
    private final int NUM_OF_ARRAYS = 1000000;
    private final int BIG_ARRAY_SIZE = 9000000;

    //Lock for synchronizing threads
    private final Lock lock = new ReentrantLock();

    //Total sum field
    private double sum = 0;
    //9m doubles array field
    private double[] bigArray;

    //2D array to hold the pieces of the big array
    private double[][] splitArray;

    //Constructor
    public ArraySumHolder() {
        bigArray = createRandomArray();
        splitArray = splitBigArray(bigArray, NUM_OF_ARRAYS);
    }

    //Getters
    public double[][] getSplitArray() {
        return splitArray;
    }

    public int getNUM_OF_ARRAYS() {
        return NUM_OF_ARRAYS;
    }

    public double getSum() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(sum));
    }

    //Setter
    public void setSum(double sum) {
        this.sum = sum;
    }


    /**
     * This method creates an array of random doubles from 0 to 100
     *
     * @return an array of random doubles
     */
    public double[] createRandomArray() {
        //Set array size according to field
        double[] array = new double[BIG_ARRAY_SIZE];

        //Create random number generator
        Random rand = new Random();

        //Add random doubles to the array
        for (int i = 0; i < array.length; i++) {
            array[i] = (rand.nextDouble() * 100 + 1);
        }
        return array;
    }

    /**
     * This method splits an array into several mini arrays
     *
     * @param bigArray   the array to be split
     * @param numOfArray the number of arrays coming from the big array
     * @return a 2D array that holds all the split pieces of the big array
     */
    public double[][] splitBigArray(double[] bigArray, int numOfArray) {
        //Store number of elements per array part
        int numOfElements = bigArray.length / numOfArray;

        //Initialize 2D array
        double[][] arrArr = new double[numOfArray][numOfElements];

        //Copy parts of the big array into a smaller array several times
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

    /**
     * This method adds all the elements of a provided array
     *
     * @param array array whose elements will be added together
     */
    public void addElements(double[] array) {
        //Lock the resource
        lock.lock();
        try {
            //Set the sum equal to itself plus the added elements of an array
            for (double j : array) {
                setSum(getSum() + j);
            }
        } finally {
            //Release the lock
            lock.unlock();
        }
    }
}
