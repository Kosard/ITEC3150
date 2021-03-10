package Sum;

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
    private static final int NUMOFTHREADS = 10;
    private static int[] array1 = {1, 2, 3, 4, 5, 100}; //115
    private static int[] array2 = {2, 6, 5, 7, 2, 5}; //27
    private static int[] array3 = {11, 65, 4, 3, 2, 9,}; //94
    //grandtot = 543
    private static int[] array4 = {111, 33, 22, 55, 77, 9}; //307

    public static void main(String[] args) throws InterruptedException {
        //AddRunnable[] mythreadarray = {new AddRunnable(array1), new AddRunnable((array2)), new AddRunnable(array3), new AddRunnable(array4)};
        //AddRunnable addable = new AddRunnable(array1);
        int threadCount = 1;

        AddRunnable addable = new AddRunnable(array1);
        AddRunnable addable2 = new AddRunnable(array2);
        AddRunnable addable3 = new AddRunnable(array3);
        AddRunnable addable4 = new AddRunnable(array4);

        ExecutorService pool = Executors.newFixedThreadPool(NUMOFTHREADS);
        pool.execute(addable);
        pool.execute(addable2);
        pool.execute(addable3);
        pool.execute(addable4);

        pool.shutdown();


//        for (int i = 0; i < NUMOFTHREADS; i++) {
//           // Thread thread = new Thread(mythreadarray[i]);
//            Thread thread = new Thread(addable);
//            thread.start();
//            System.out.println("Thread id is: " + thread.getId() + ". Thread # " + threadCount);
//            threadCount++;
//            System.out.println(AddRunnable.sum);
//
//        }
    }

    static class AddRunnable implements Runnable {
        private static final Lock lock = new ReentrantLock();
        private static int sum = 0;
        private static int[] array;

        public AddRunnable(int[] array) {
            AddRunnable.array = array;
        }

        public static int getSum() {
            return sum;
        }

//         public static void setSum(int sum) {
//             lock.lock();
//             try {
//                 AddThread.sum = sum;
//             } finally {
//                 lock.unlock();
//             }
//         }

        public static void addElements(int[] array) {
            lock.lock();
            try {
                for (int j : array) {
                    System.out.println("Adding " + j + " to array");
                    sum = sum + j;
                }
            } finally {
                lock.unlock();
            }
        }

        public static void addNum(int num) {
            lock.lock();
            try {
                sum += num;
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            addElements(array);
            System.out.println("Current sum: " + sum);
        }
    }
}
