public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signals recorded.");
            return;
        }

        char maxStreakColor = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    maxStreakColor = currentColor;
                }
                currentColor = signalLog.charAt(i);
                currentStreakLength = 1;
            }
        }

        // Account for a streak extending to the very end of the string
        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            maxStreakColor = currentColor;
        }

        System.out.println("Longest Streak: '" + maxStreakColor + "' repeated " + maxStreakLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}