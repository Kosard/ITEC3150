package Week_6;

/**
 * Class: Async_KevinF
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: February 24, 2021
 * <p>
 * This class contains two inner classes and a main method. The outer class also creates an Adder object in order to
 * use its respective sum attribute.
 * <p>
 * Purpose: To show how a class that starts asynchronous threads behaves.
 */
public class Async_KevinF {
    //Adder object that will be used to reference the sum variable
    private static Adder adder = new Adder();

    /**
     * This is the main method that will create a Task object and call a method that starts asynchronous threads
     *
     * @param args
     */
    public static void main(String[] args) {
        //Create a Task object
        AddTask task = new AddTask();

        //Call to method that starts asynchronous threads and prints sum value
        startAsyncThreads(1000, task);
    }

    /**
     * This method starts the specified number of threads using the AddTask object.
     *
     * @param numOfThreads # of threads to start
     * @param task         Object that is passed to Thread's constructor
     */
    public static void startAsyncThreads(Integer numOfThreads, AddTask task) {
        //Loop to create specified number of threads
        for (int i = 0; i < numOfThreads; i++) {
            //Create thread object with Task as parameter
            Thread thread = new Thread(task);

            //Call to start method
            thread.start();
            System.out.println("Starting thread #" + thread.getId() + ", With a current sum of: " + adder.getSum());

        }
        //Print sum
        System.out.println("Sum with Asynchronous threads = " + adder.getSum());
    }

    /**
     * This inner class implements Runnable, which means it contains the run method that is called when a thread is
     * started.
     */
    private static class AddTask implements Runnable {
        /**
         * This method calls the Adder inner class's method that adds one to its main attribute.
         */
        @Override
        public void run() {
            //Call to Adder's addNumber method
            adder.addNumber(1);
        }
    }

    /**
     * This inner class has the main attribute to keep track of its contents, sum. It also has a getter method for its
     * attribute, and a method that adds a specified number to its main attribute.
     */
    private static class Adder {
        //Main attribute to store data
        private Integer sum = 0;

        /**
         * This is a getter method
         *
         * @return sum attribute
         */
        public Integer getSum() {
            return sum;
        }

        /**
         * This method takes an Integer parameter and adds it to the main attribute of its class.
         *
         * @param num Integer that will be added to main attribute
         */
        public void addNumber(Integer num) {
            sum = sum + num;
        }
    }
}
