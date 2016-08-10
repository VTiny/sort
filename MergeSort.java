package sort;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by pokerface_lx on 16/8/9.
 */
public class MergeSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        System.out.println("Merge  Sort:---" + Arrays.toString(nums));
    }

    private static void sort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int centerIndex = (leftIndex + rightIndex) / 2;
        sort(nums, leftIndex, centerIndex);
        sort(nums, centerIndex + 1, rightIndex);
        merge(nums, leftIndex, centerIndex, rightIndex);
    }

    public static void merge(int[] nums, int leftIndex, int centerIndex, int rightIndex) {
        int[] tempNums = new int[nums.length];
        int midIndex = centerIndex + 1;
        int tempIndex = leftIndex;
        int copyIndex = leftIndex;
        while (leftIndex <= centerIndex && midIndex <= rightIndex) {
            if (nums[leftIndex] <= nums[midIndex]) {
                tempNums[tempIndex++] = nums[leftIndex++];
            } else {
                tempNums[tempIndex++] = nums[midIndex++];
            }
        }
        while (leftIndex <= centerIndex) {
            tempNums[tempIndex++] = nums[leftIndex++];
        }
        while (midIndex <= rightIndex) {
            tempNums[tempIndex++] = nums[midIndex++];
        }
        while (copyIndex <= rightIndex) {
            nums[copyIndex] = tempNums[copyIndex++];
        }
    }
}
