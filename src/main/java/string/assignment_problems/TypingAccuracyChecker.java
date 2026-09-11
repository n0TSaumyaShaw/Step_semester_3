public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char origCharMismatch = ' ';
        char typedCharMismatch = ' ';

        for (int i = 0; i < totalChars; i++) {
            char origChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (origChar == typedChar) {
                matchedChars++;
            } else if (firstMismatchPos == -1) {
                // 1-based indexing for position display
                firstMismatchPos = i + 1;
                origCharMismatch = origChar;
                typedCharMismatch = typedChar;
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matchedChars, totalChars, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matchedChars, totalChars, accuracy, firstMismatchPos, origCharMismatch, typedCharMismatch);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}