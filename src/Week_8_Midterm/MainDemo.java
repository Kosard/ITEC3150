package Week_8_Midterm;

import java.util.Scanner;

/**
 * Class: MainDemo
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 3/9/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class MainDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num1 = in.nextInt();
        System.out.println("Enter another number: ");
        int num2 = in.nextInt();

        Calculus.Calculator calculator = new Calculus.Calculator();
        calculator.calculateSum(num1, num2);

        Calculus calc = new Calculus();
        Calculus.MyCalculator mycalc = calc.new MyCalculator();
        mycalc.calculateSum(num1, num2);
    }
}
