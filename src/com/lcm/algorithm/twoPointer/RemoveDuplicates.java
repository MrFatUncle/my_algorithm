package com.lcm.algorithm.twoPointer;

/**
 * FileName: RemoveDuplicates
 * Author:   liaocm
 * Date:     2021/3/9 10:33
 * Description: 26.去重
 * History:
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        System.out.println(removeDuplicatesBetter(new int[]{1, 1, 2}));
        System.out.println(removeDuplicatesBetter(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    private static int removeDuplicates(int[] nums) {
        int index = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {

            while (nums[j] != nums[i]) {
                j++;
            }
            if (i == j) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    private static int removeDuplicatesBetter(int[] nums) {
        int index = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }


}
