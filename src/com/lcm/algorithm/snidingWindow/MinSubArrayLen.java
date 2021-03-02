/**
 * FileName: MinSubArrayLen
 * Author:   liaocm
 * Date:     2021/3/1 16:54
 * Description: 209.长度最小的子数组
 * History:
 */
package com.lcm.algorithm.snidingWindow;

public class MinSubArrayLen {

    public static void main(String[] args) {
        int[]nums = new int[]{10,2,3};
        int target = 6;
        int i = minSubArrayLen2(target, nums);
        System.out.println(i);


    }

    private static int minSubArrayLen(int target, int[] nums) {
        if(null == nums || nums.length == 0) {
            return 0;
        }

        int min = 0;
        //1.寻找初始窗口
        int total = 0;
        int length = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            if(total >= target) {
                length = i + 1;
                break;
            }
        }
        if(length == 0) {
            return 0;
        }
        if(total == target) {
            min = length;
        }

        //2.找到初始窗口后向右滑动
        for(int i = 1; i < nums.length; i++) {
            if(i + length > nums.length) {
                break;
            }
            total = total - nums[i - 1] + nums[i + length];
            if(total >= target) {
                continue;
            }
            if(total < target) {

                while(true) {


                }
            }
        }


        return min;
    }

    private static int minSubArrayLen2(int target, int[] nums) {
        int min = 0;
        while(++min <= nums.length) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                if(i >= min) {
                    break;
                }
                total += nums[i];
            }
            if(total >= target) {
                return min;
            }
            for (int i = 1; i < nums.length; i++) {

                if(i + min - 1 > nums.length - 1) {
                    break;
                }
                total = total - nums[i - 1] + nums[i + min - 1];
                if(total >= target) {
                    return min;
                }
            }

        }
        return 0;
    }
}