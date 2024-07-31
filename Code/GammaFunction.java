public class GammaFunction {

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
        double x = 45;

        try {
            double gammaValue = gamma(x);
            System.out.println("Gamma(" + x + ") = " + gammaValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
