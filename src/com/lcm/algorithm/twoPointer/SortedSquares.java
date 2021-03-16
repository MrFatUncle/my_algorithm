/**
 * FileName: SortedSquares
 * Author:   liaocm
 * Date:     2021/3/16 10:24
 * Description: 977. 有序数组的平方
 * History:
 */
package com.lcm.algorithm.twoPointer;

public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};

        int[] ints = mySortedSquares(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 归并算法
     * @param nums
     * @return
     */
    private static int[] sortedSquares(int[] nums) {
        return null;
    }

    private static int[] mySortedSquares(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {
                if(Math.abs(nums[j]) > Math.abs(nums[j + 1])) {
                    //交换位置
                    int a = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = a;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        return nums;
    }

}
