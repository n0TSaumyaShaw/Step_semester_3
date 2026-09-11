import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative two-pointer check from both ends towards the middle
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive comparison shrinking substring each call
    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // Approach 3: Convert to char array, reverse it, and compare to original
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return text.equals(new String(reversed));
    }

    private static String formatResult(boolean isPalin) {
        return isPalin ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        boolean iterResult = isPalindromeIterative(input);
        boolean recurResult = isPalindromeRecursive(input);
        boolean revResult = isPalindromeArrayReversal(input);

        System.out.println("Iterative: " + formatResult(iterResult) +
                " | Recursive: " + formatResult(recurResult) +
                " | Array Reversal: " + formatResult(revResult));

        scanner.close();
    }
}