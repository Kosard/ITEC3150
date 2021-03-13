package Homework3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class: AddThreadrunner
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/10/2021
 * <
 * This class creates a pool of threads that will keep creating threads until all the parts of the big array have been summed.
 * <
 * Purpose: To execute a large number of task in a short amount of time.
 */
public class AddThreadrunner {
    //Constant for number of threads executed
    private static final int NUM_OF_THREADS = 10;

    public static void main(String[] args) {
        //call to method
        executeThreads(NUM_OF_THREADS);
    }

    /**
     * This method creates a thread pool and a for loop that executes the runnable object
     *
     * @param numThreads number of threads to be active at a time
     */
    public static void executeThreads(int numThreads) {
        //Create a ArraySumHolder object for access to methods
        ArraySumHolder holder = new ArraySumHolder();

        //call to other class method
        double[][] splitArray = holder.getSplitArray();

        //Create a Thread pool
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        //Execute a thread for the duration of the split arrays
        for (int i = 0; i < splitArray.length; i++) {
            AddRunnable addable = new AddRunnable(holder, splitArray[i]);
            pool.execute(addable);
        }

        //Close the pool
        pool.shutdown();

        //Print the total sum
        System.out.println("The total sum of 9,000,000 doubles is: " + holder.getSum());
    }
}
