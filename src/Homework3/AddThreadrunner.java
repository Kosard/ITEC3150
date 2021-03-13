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
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class AddThreadrunner {
    private static final int NUM_OF_THREADS = 10;

    public static void main(String[] args) {
        executeThreads(NUM_OF_THREADS);
    }

    public static void executeThreads(int numThreads) {
        ArraySumHolder holder = new ArraySumHolder();
        final int INCREMENT = holder.getNUM_OF_ARRAYS() / NUM_OF_THREADS;

        double[][] splitArray = holder.getSplitArray();
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < splitArray.length; i++) {
            AddRunnable addable = new AddRunnable(holder, splitArray[i]);
            pool.execute(addable);
        }

        pool.shutdown();

        System.out.println("The total sum of 9,000,000 doubles is: " + holder.getSum());
    }
}
