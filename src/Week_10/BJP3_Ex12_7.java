package Week_10;

/**
 * Class: BJP3_Ex12_7
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
public class BJP3_Ex12_7 {
    public static void main(String[] args) {
        System.out.println(writeChars(1));
        System.out.println(writeChars(2));
        System.out.println(writeChars(3));
        System.out.println(writeChars(4));
        System.out.println(writeChars(5));
        System.out.println(writeChars(6));
        System.out.println(writeChars(7));
        System.out.println(writeChars(8));
    }

    public static String writeChars(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Value cannot be less than 1");
        } else if (n == 1) {
            return "*";
        } else if (n == 2) {
            return "**";
        } else {
            return "<" + writeChars(n - 2) + ">";
        }
    }
}
