package com.lcm.algorithm.twoPointer;

/**
 * FileName: RemoveDuplicates
 * Author:   liaocm
 * Date:     2021/3/9 10:33
 * Description: 80.去重2
 * History:
 */
public class RemoveDuplicatesII {

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 4}));
    }

    private static int removeDuplicates(int[] nums) {
        int index = 1;
        int sameCount = 1;

        for (int i = 1; i < nums.length; i++) {

            if(nums[i] == nums[i - 1]) {
                sameCount++;
                if(sameCount <= 2) {
                    nums[index++] = nums[i - 1];
                }
            } else {
                sameCount = 1;
                nums[index++] = nums[i];
            }
        }

        return index;
    }

    private static int removeDuplicatesBetter(int[] nums) {
        return 0;
    }


}
