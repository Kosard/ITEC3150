package Week_2;

import java.util.Scanner;

public class Warmup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int sum = str1.length() + str2.length();
        System.out.println("The sum of the two strings is: " + sum);

        if (str1.compareTo(str2) > 0) {
            System.out.println(str1 + " is greater than " + str2);
        } else if (str1.compareTo(str2) < 0) {
            System.out.println(str2 + " is greater than " + str1);
        } else {
            System.out.println(str1 + " and " + str2 + " are lexicographically the same");
        }

        char[] arr1 = str1.toCharArray();
        arr1[0] = Character.toUpperCase(arr1[0]);
        System.out.print(new String(arr1) + " ");

        char[] arr2 = str2.toCharArray();
        arr2[0] = Character.toUpperCase(arr2[0]);
        System.out.print(new String(arr2));
    }
}
