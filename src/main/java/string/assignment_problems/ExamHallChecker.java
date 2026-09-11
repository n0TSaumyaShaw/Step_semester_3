public class ExamHallChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicates = false;

        // Compare every seat against subsequent seats to avoid redundant checks
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    hasDuplicates = true;
                    break; // Move to the next element once identified
                }
            }
        }

        if (!hasDuplicates) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] test1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(test1);

        int[] test2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(test2);
    }
}