import java.util.Arrays;

public class FantasyScoreMultiplier {

    // Modifies caller array directly: captain gets 2x, vice-captain gets 1.5x[cite: 7]
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores)); // Output: [40.0, 110.0, 30.0, 93.0][cite: 7]
    }
}