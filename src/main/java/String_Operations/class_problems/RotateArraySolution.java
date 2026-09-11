import java.util.Arrays;

public class RotateArraySolution {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        k = k % nums.length;
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(nums1, 3)));

        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(rotateArray(nums2, 3)));
    }
}