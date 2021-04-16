package Week_10;

/**
 * Class: BJP3_Ex12_11
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
public class BJP3_Ex12_11 {
    public static void main(String[] args) {
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("this is fun", 1));
        System.out.println(repeat("wow", 0));
        System.out.println(repeat("hi ho! ", 5));
    }

    public static String repeat(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0");
        } else if (n == 0) {
            return "";
        } else if (n == 1) {
            return s;
        } else {
            return s + repeat(s, n - 1);
        }
    }
}
