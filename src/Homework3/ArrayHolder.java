package Homework3;

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
public class ArrayHolder {
    int ARRAY_SIZE = 100; //9000000;
    private double[] randomArray;
    private double totalSum;
//    private static ArrayAdder adder = new ArrayAdder();

    public ArrayHolder() {
        randomArray = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        totalSum = 0;

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new AddTask());
        }
    }

    public static void main(String[] args) {
        ArrayHolder holder = new ArrayHolder();

    }

    public double[] createRandomArray() {
        double[] array = new double[ARRAY_SIZE];
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextDouble() * 10 + 1;
        }
        return array;
    }

    private class AddTask implements Runnable {
        Lock lock = new ReentrantLock();

//        private double[] tempArray;
//
//        public AddTask(double[] array){
//            this.tempArray = array;
//        }

        @Override
        public void run() {
            lock.lock();

            //adder.sum = adder.getSum() + 1;


            lock.unlock();
        }

    }

//    private static class ArrayAdder {
//        private double sum = 0;
//
//        public double getSum() {
//            return sum;
//        }
//
//        public void addToTotal(double[] array){
//            for (double d : array) {
//                sum += d;
//
//            }
//        }
//    }

//    private static class TotalSum {
//        private double totalSum;
//        private Lock lock;
//
//        public TotalSum (){
//            this.totalSum = 0;
//            this.lock = new ReentrantLock();
//        }
//
//        public double getTotalSum() {
//            return totalSum;
//        }
//    }
}
