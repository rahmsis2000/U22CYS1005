import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1 = getValidNumber(input, "Please enter the first number (0-99):");
        int num2 = getValidNumber(input, "Please enter the second number (0-99):");
        char operation = getValidOperation(input);

        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = (num2 != 0) ? num1 / num2 : 0;
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operation.");
                return;
        }

        System.out.println("The result is: " + result);
    }

    private static int getValidNumber(Scanner input, String prompt) {
        int number;
        do {
            System.out.println(prompt);
            while (!input.hasNextInt()) {
                System.out.println("Error: Please enter a valid number.");
                input.next(); // Clear invalid input
            }
            number = input.nextInt();
        } while (number < 0 || number > 99);

        return number;
    }

    private static char getValidOperation(Scanner input) {
        char operation;
        do {
            System.out.println("Please enter the operation (+, -, *, /):");
            while (!input.hasNext()) {
                System.out.println("Error: Please enter a valid operation (+, -, *, /).");
                input.next(); // Clear invalid input
            }
            operation = input.next().charAt(0);
        } while (operation != '+' && operation != '-' && operation != '*' && operation != '/');

        return operation;
    }
}
