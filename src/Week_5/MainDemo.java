package Week_5;

/**
 * Class: MainDemo
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Written: February 16, 2021
 * <p>
 * This is a driver class, which means it contains the main method.
 * <p>
 * Purpose: To show how a method from a static nested class can be accessed by another
 * entirely different class.
 */
public class MainDemo {
    /**
     * Method: main()
     * <p>
     * This method is the starting point of the program. It creates an object of the nested class from the
     * Outer class, and calls its method.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Create object from nested class by using dot notation
        Outer.StaticNestedClass outerNestedClass = new Outer.StaticNestedClass();
        //Call nested class method
        outerNestedClass.my_method();
    }
}
