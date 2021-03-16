/**
 * FileName: BubbleSort
 * Author:   liaocm
 * Date:     2021/3/16 11:01
 * Description: 1.冒泡排序
 * History:
 */
package com.lcm.algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {

    }

    private static int[] bubbleSort(int[] nums) {
        //第一次循环，将最值冒泡到最末尾

        //第二次循环，就不再冒泡到最末尾，而是最末尾的前一位，然后依次这样处理。。。

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    //交换位置
                    int a = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = a;
                }
            }
        }
        return nums;
    }

}
