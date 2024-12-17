import java.util.Scanner;

public class ExceptionHandling06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number (Num1): ");
            String input1 = sc.nextLine();
            System.out.print("Enter second number (Num2): ");
            String input2 = sc.nextLine();

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            int result = num1 / num2;
            System.out.println("The result of division is: " + result);

            int[] arr = new int[3];
            System.out.println("Accessing element at index 5: " + arr[5]);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }

        sc.close();
    }
}
