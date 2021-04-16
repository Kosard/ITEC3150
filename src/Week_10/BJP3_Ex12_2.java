package Week_10;

/**
 * Class: BJP3_Ex12_2
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
public class BJP3_Ex12_2 {
    public static void main(String[] args) {
        System.out.println(writeNums(5));
        System.out.println(writeNums(12));
    }

    public static String writeNums(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Value cannot be less than 1");
        } else if (n == 1) {
            return String.valueOf(n);
        } else {
            return (writeNums(n - 1) + ", " + n);
        }
    }
}
