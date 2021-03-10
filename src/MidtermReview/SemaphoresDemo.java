package MidtermReview;

import java.util.concurrent.Semaphore;

/**
 * Class: SemaphoresDemo
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
public class SemaphoresDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);

        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");

        mt1.start();
        mt2.start();

        mt1.join();
        mt2.join();

        System.out.println("count: " + Shared.count);
    }
}

class Shared {
    static int count = 0;
}

class MyThread extends Thread {
    Semaphore sem;
    String threadName;

    public MyThread(Semaphore sem, String threadName) {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if (this.getName().equalsIgnoreCase("A")) {
            System.out.println("Starting " + threadName);

            try {
                System.out.println(threadName + " is waiting for a permit.");

                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                for (int i = 0; i < 5; i++) {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println(threadName + " releases permit.");
            sem.release();
        } else {
            System.out.println("Starting " + threadName);
            try {
                System.out.println(threadName + " is waiting for a permit.");

                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                for (int i = 0; i < 5; i++) {
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println(threadName + " releases the permit.");
            sem.release();
        }
    }
}
