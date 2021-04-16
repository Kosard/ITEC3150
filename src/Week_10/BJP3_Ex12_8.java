package Week_10;

/**
 * Class: BJP3_Ex12_8
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
public class BJP3_Ex12_8 {
    public static void main(String[] args) {
        System.out.println(multiplyEvens(1));
        System.out.println(multiplyEvens(2));
        System.out.println(multiplyEvens(3));
        System.out.println(multiplyEvens(4));
    }

    public static int multiplyEvens(int n) {
        if (n == 1) {
            return 2;
        } else {
            return multiplyEvens(n - 1) * (n * 2);
        }
    }
}
