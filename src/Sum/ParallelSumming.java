package Sum;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class: ParallelSumming
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written:
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class ParallelSumming {
    private static final int NUM_OF_THREADS = 10000;
    private static final int NUM_OF_ARRAYS = 1000000;
    private static final int ARRAY_SIZE = 9000000;

    public static void main(String[] args) throws InterruptedException {
        ParallelSumming par = new ParallelSumming();
        double[] randomArray = par.createRandomArray();
        double[][] splitArray = par.splitBigArray(randomArray, NUM_OF_ARRAYS);
        ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_THREADS);

        for (int i = 0; i < splitArray.length; i++) {
            AddRunnable addable = new AddRunnable(splitArray[i]);
            pool.execute(addable);
        }

        pool.shutdown();

//        System.out.println("Using MD Array");
//        double[][] list1 = par.splitBigArray(bigArray, 4);
//        for (int i = 0; i < list1.length; i++) {
//            System.out.println(Arrays.toString(list1[i]));
//        }
    }

    public double[] createRandomArray() {
        double[] array = new double[ARRAY_SIZE];
        Random rand = new Random();
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(df.format(rand.nextDouble() * 100 + 1));
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

    static class AddRunnable implements Runnable {
        private static final Lock lock = new ReentrantLock();
        private static double sum = 0;
        private double[] array;

        public AddRunnable(double[] array) {
            this.array = array;
        }

        public static void addElements(double[] array) {
            lock.lock();
            try {
                for (double j : array) {
                    sum = sum + j;
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            long threadID = Thread.currentThread().getId();
            addElements(array);
            System.out.println("Current sum: " + sum + " at threadID: " + threadID);
        }
    }
}
