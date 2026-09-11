import java.util.HashMap;
import java.util.Map;

public class SubarraySumSolution {

    public static int subarraySum(int[] nums, int k) {
        // Map to store frequency of encountered prefix sums
        Map<Integer, Integer> prefixMap = new HashMap<>();
        // Base case: a prefix sum of 0 has occurred once (empty prefix)
        prefixMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists, that many valid subarrays end at this index
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }

            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2));

        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0));
    }
}