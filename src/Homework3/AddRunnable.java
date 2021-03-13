package Homework3;

/**
 * Class: AddRunnable
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/10/2021
 *
 * This class implements Runnable, which means that it will play a role in the creation of threads.
 *
 * Purpose: To implement the logic behind a single add task
 */
public class AddRunnable implements Runnable {
    //Reference to other class
    private ArraySumHolder holder;
    //Temporary variable
    private double[] array;

    //Constructor
    public AddRunnable(ArraySumHolder holder, double[] array) {
        this.holder = holder;
        this.array = array;
    }

    /**
     * This method will execute when a thread is created
     */
    @Override
    public void run() {
        //call to other class's method
        holder.addElements(array);
    }
}
