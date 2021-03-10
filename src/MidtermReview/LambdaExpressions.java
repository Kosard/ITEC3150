package MidtermReview;

import java.util.ArrayList;

/**
 * Class:
 *
 * @author
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written:
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class LambdaExpressions {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> {
            System.out.println(n);
        });
    }
}
