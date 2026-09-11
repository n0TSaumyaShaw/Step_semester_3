import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors_Game{

    // Determines the result of a single round
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                return "Invalid Move";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int totalRounds = 5;

        // 2D Array to record results for the summary table
        // Columns: [Round Number, Player Move, Computer Move, Result]
        String[][] history = new String[totalRounds][4];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Welcome to the College Coding Arcade ===");
        System.out.println("Playing " + totalRounds + " rounds of Rock-Paper-Scissors!\n");

        for (int round = 1; round <= totalRounds; round++) {
            System.out.print("Round " + round + " - Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine().trim();

            // Validate user input
            while (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid choice. Please enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine().trim();
            }

            // Capitalize properly for neat display
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();

            // Generate computer move randomly
            String computerMove = moves[random.nextInt(moves.length)];

            // Evaluate round outcome
            String result = playRound(playerMove, computerMove);

            // Update stats
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Store details in history table
            history[round - 1][0] = String.valueOf(round);
            history[round - 1][1] = playerMove;
            history[round - 1][2] = computerMove;
            history[round - 1][3] = result;

            System.out.println("Computer chose: " + computerMove);
            System.out.println("Outcome: " + result + "\n");
        }

        // Print Summary Table
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-14s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8s | %-12s | %-14s | %-15s%n",
                    history[i][0], history[i][1], history[i][2], history[i][3]);
        }
        System.out.println("---------------------------------------------------------------");

        // Calculate Win Percentage
        double winPercentage = ((double) wins / totalRounds) * 100.0;

        // Print Final Summary
        System.out.printf("Final Summary (after %d rounds):%n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);

        scanner.close();
    }
}