package Homework3;

/**
 * Class: AddRunnable
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
public class AddRunnable implements Runnable {
    ArraySumHolder holder;
    double[] array;

    public AddRunnable(ArraySumHolder holder, double[] array) {
        this.holder = holder;
        this.array = array;
    }

    @Override
    public void run() {
        //long threadID = Thread.currentThread().getId();
        holder.addElements(array);
        //System.out.println("Current sum: " + holder.getSum() + " . ThreadID: " + threadID + " .");
    }
}
