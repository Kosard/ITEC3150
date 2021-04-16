package Week_10;

/**
 * Class: BJP3_Ex12_9
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/25/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class BJP3_Ex12_9 {
    public static void main(String[] args) {
        System.out.println(sumTo(10));
    }

    public static double sumTo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0");
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return (double) 1 / n;
        } else {
            return sumTo(n - 1) + (double) 1 / n;
        }
    }
}
