package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals(quit)) {
                int num1Decimal = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + " is number: " + (num1Decimal != -1) + " , value: " + (num1Decimal != -1 ? num1Decimal : "Invalid"));

                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    int num2Decimal = Ex1.number2Int(num2);
                    System.out.println("num2= " + num2 + " is number: " + (num2Decimal != -1) + " , value: " + (num2Decimal != -1 ? num2Decimal : "Invalid"));

                    System.out.println("Enter a base for output: (a number [2,16]) ");
                    int base = sc.nextInt();

                    if (num1Decimal != -1 && num2Decimal != -1) {
                        System.out.println(num1 + " + " + num2 + " = " + (num1Decimal + num2Decimal));
                        System.out.println(num1 + " * " + num2 + " = " + (num1Decimal * num2Decimal));

                        int n1n2 = num1Decimal * num2Decimal;
                        int num1num2 = num1Decimal + num2Decimal;
                        int maxValue = Math.max(num1Decimal, Math.max(num2Decimal, Math.max(n1n2,num1num2)));

                        System.out.println("Max value over [" + num1 + "," + num2 + "," + n1n2 + "," + num1num2 + "] is: " + maxValue);
                    }
                }
            }
        }
        System.out.println("Quitting now...");
        sc.close();
    }
}
