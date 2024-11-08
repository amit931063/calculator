package com.example.calculator;

import java.util.Scanner;

public class CalculatorApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.println("Enter second number: ");
                double num2 = scanner.nextDouble();

                System.out.println("Choose operation: (+, -, *, /): ");
                char operation = scanner.next().charAt(0);

                double result;
                switch (operation) {
                    case '+':
                        result = add(num1, num2);
                        break;
                    case '-':
                        result = subtract(num1, num2);
                        break;
                    case '*':
                        result = multiply(num1, num2);
                        break;
                    case '/':
                        result = divide(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        continue;
                }
                System.out.println("Result: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Clear the invalid input
            }

            System.out.println("Do you want to perform another calculation? (yes/no): ");
            String continueCalc = scanner.next();
            if (!continueCalc.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }

    // Static methods for calculations
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
