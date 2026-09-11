import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveEngine {

    public static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Composite score calculation: 10 * CGPA + 0.5 * codingScore[cite: 6]
        public double getCompositeScore() {
            return (this.cgpa * 10.0) + (this.codingScore * 0.5);
        }

        public String getName() {
            return name;
        }

        // Sort descending by composite score using Arrays.sort[cite: 6]
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    // Direct cutoff: CGPA >= 7.5 qualifies directly[cite: 6]
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Combined cutoff: Borderline CGPA [6.5, 7.5) with codingScore >= 60[cite: 6]
    public static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5 && codingScore >= 60);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            // Check direct CGPA qualification or borderline combined criteria[cite: 6]
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] ranked = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(ranked); // Relies on compareTo[cite: 6]

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(ranked[i].getName())
                    .append(" (")
                    .append(String.format("%.1f", ranked[i].getCompositeScore()))
                    .append(")");

            if (i < ranked.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // Output: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)[cite: 6]
    }
}