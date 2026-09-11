import java.util.Random;

public class BmiCalculator {

    // Classifies BMI into standard wellness categories
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Computes and prints the wellness report table
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random random = new Random();

        // Generate sample random data for live demo:
        // Height: 1.50m - 1.95m | Weight: 45kg - 110kg
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (0.45 * random.nextDouble());
            weights[i] = 45.0 + (65.0 * random.nextDouble());
        }

        printWellnessReport(heights, weights);
    }
}