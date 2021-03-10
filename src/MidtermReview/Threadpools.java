package MidtermReview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class:
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
public class Threadpools {
    //1. Create a task(Runnable Object) to execute
//2. Create Executor Pool using Executors
//3. Pass tasks to Executor Pool
//4. Shutdown the Executor Pool
    static final int MAX_THREADS = 3;

    public static void main(String[] args) {
        {
            // creates five tasks
            Runnable r1 = new Task("task 1");
            Runnable r2 = new Task("task 2");
            Runnable r3 = new Task("task 3");
            Runnable r4 = new Task("task 4");
            Runnable r5 = new Task("task 5");

            // creates a thread pool with MAX_T no. of
            // threads as the fixed pool size(Step 2)
            ExecutorService pool = Executors.newFixedThreadPool(MAX_THREADS);

            // passes the Task objects to the pool to execute (Step 3)
            pool.execute(r1);
            pool.execute(r2);
            pool.execute(r3);
            pool.execute(r4);
            pool.execute(r5);

            // pool shutdown ( Step 4)
            pool.shutdown();
        }
    }
}

class Task implements Runnable {
    private String name;

    public Task(String s) {
        name = s;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                Date d = new Date();
                SimpleDateFormat sft = new SimpleDateFormat("hh:mm:ss");
                if (i == 0) {
                    System.out.println("Initialization time for task name - " + name +
                            " = " + sft.format(d));
                } else {
                    System.out.println("Executing time for task name - " + name + " = "
                            + sft.format(d));
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
