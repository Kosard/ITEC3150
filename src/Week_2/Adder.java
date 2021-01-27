package Week_2;

import java.util.Scanner;

class Adder extends Arithmetic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        Adder adder = new Adder();
        System.out.println("My superclass is: Arithmetic");
        System.out.print(adder.add(num1, num2) + " ");
    }
}
