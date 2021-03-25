package com.lcm.algorithm.twoPointer;

import java.util.List;

/**
 * FileName: ThreeSumToZero
 * Author:   liaocm
 * Date:     2021/3/25 9:38
 * Description: 15.三数之和为0 .
 * History:
 */
public class ThreeSumToZero {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = myThreeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }

    private static List<List<Integer>> myThreeSum(int[] nums) {
        //先排序 升序

        //三个指针

        //如果重复 则跳过
        return null;
    }
}
