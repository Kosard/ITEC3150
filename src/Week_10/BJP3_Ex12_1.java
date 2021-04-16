package Week_10;

/**
 * Class: starString
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
public class BJP3_Ex12_1 {
    public static void main(String[] args) {
        System.out.println(starString(4));
        System.out.println(starString(3));
        System.out.println(starString(2));
        System.out.println(starString(1));
        System.out.println(starString(0));
        System.out.println(starString(-4));
    }

    public static String starString(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Value is less than 0");
        } else if (n == 0) {
            return "*";
        } else {
            return starString(n - 1) + starString(n - 1);
        }
    }
}
