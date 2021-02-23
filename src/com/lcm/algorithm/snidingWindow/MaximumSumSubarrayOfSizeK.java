package com.lcm.algorithm.snidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * FileName: MaximumSumSubarrayOfSizeK
 * 剑指offer 59
 * LeetCode 239.
 * Author:   liaocm
 * Date:     2021/2/5 11:31
 * Description: 239.滑动窗口的最大值
 * History:
 */
public class MaximumSumSubarrayOfSizeK {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] nums = new int[]{1,-1};
        int k = 1;

        int[] result = maxSlidingWindowPriorityQueue(nums, k);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    /**
     * 优先队列解法
     * @param nums
     * @param k
     * @return
     */
    private static int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //值不同，比大小，值相同，比下标
                return o1[0] != o2[0] ? o2[0] - o1[0] :o2[1] - o1[1];
            }
        });

        int[] result = new int[nums.length - k + 1];
        //先把前k个[元素, 下标]放入优先队列
        for(int i = 0; i < k; ++i) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        //取第一次的最大值
        result[0] = priorityQueue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            //当最大的元素的下标已经划过 if(ik < i)，poll掉
            while(null != priorityQueue.peek() && priorityQueue.peek()[1] < i - k + 1) {
                priorityQueue.poll();
            }

            priorityQueue.offer(new int[]{nums[i], i});

            result[i - k + 1] = priorityQueue.peek()[0];
        }

        return result;
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] returnArray = new int[nums.length - k + 1];
        int index = 0;
        int maxIndex = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {

            if(i + k - 1 > maxIndex) {
                break;
            }

            int max = nums[i];
            for(int j = i; j < k + i; j++) {

                if(max <= nums[j]) {
                    max = nums[j];
                }

            }
            returnArray[i] = max;

        }

        return returnArray;
    }
}
