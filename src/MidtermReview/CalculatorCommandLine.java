package MidtermReview;

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
public class CalculatorCommandLine {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        int result = 0;

        switch (args[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case 'x':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                break;
        }

        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    }
}
