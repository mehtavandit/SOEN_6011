import java.util.Scanner;

public class Gamma_Function2 {
    public static double gamma(double x) {
        if (x <= 0.0) {
            throw new IllegalArgumentException("Gamma function is not defined for non-positive numbers.");
        }

        double term;
        double product = 1.0;
        double oneOverX = 1.0 / x;

        int maxIterations = 100000000;

        for (int n = 1; n <= maxIterations; n++) {
            term = Math.pow(1.0 + 1.0 / n, x) / (1.0 + x / n);
            product *= term;
        }

        return oneOverX * product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a positive number to compute gamma function (enter -1 to exit): ");

            // Check if there's a next double input
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }

            double x = scanner.nextDouble();

            if (x == -1) {
                System.out.println("Exiting...");
                break;
            }

            try {
                double gammaValue = gamma(x);
                System.out.println("Gamma(" + x + ") = " + gammaValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Consume the newline character left in the buffer
            scanner.nextLine();
        }

        scanner.close();
    }
}
