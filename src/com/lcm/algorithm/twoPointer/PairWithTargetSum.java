package com.lcm.algorithm.twoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: PairWithTargetSum
 * Author:   liaocm
 * Date:     2021/2/19 15:09
 * Description: 力扣1.两数之和
 * History:
 */
public class PairWithTargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 4, 5, 3, 0};
        int target = 6;

        int[] ints = twoSum(nums, target);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    /**
     * 简单粗暴法
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }

    /**
     * hash法
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumHash(int[] nums, int target) {

        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}
