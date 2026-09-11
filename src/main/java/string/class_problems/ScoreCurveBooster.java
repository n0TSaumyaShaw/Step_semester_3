import java.util.Arrays;

public class ScoreCurveBooster {

    // Modifies the original array in-place by adding the flat bonus[cite: 6]
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores)); // Output: [80, 95, 70][cite: 6]
    }
}