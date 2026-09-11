import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyAutoDraftEngine {

    public static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        // Ranks draftable players by batting average/fantasy points descending using Arrays.sort[cite: 7]
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }
    }

    // Established cutoff: 10 or more matches qualifies on experience alone regardless of fitness[cite: 7]
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined cutoff: at least 5 matches and not injured[cite: 7]
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return (matchesPlayed >= 5 && !injured);
    }

    public static String draftAndRank(Player[] players) {
        List<Player> draftable = new ArrayList<>();

        for (Player p : players) {
            // Check experience-only cutoff first, then combined rule[cite: 7]
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable.add(p);
            }
        }

        Player[] ranked = draftable.toArray(new Player[0]);
        Arrays.sort(ranked); // Relies on compareTo[cite: 7]

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ranked.length; i++) {
            sb.append(i + 1).append(". ").append(ranked[i].getName());
            if (i < ranked.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Output: 1. Rahul | 2. Virat | 3. Dev[cite: 7]
    }
}