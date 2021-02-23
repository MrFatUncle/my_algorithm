package com.lcm.algorithm.mergeIntervals;

/**
 * FileName: MergeIntervals
 * Author:   liaocm
 * Date:     2021/2/22 9:28
 * Description: 56.合并区间
 * History:
 */
public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = myMerge(intervals);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

    }

    public static int[][] myMerge(int[][] intervals) {
        int index = 0;

        int[][] results = new int[intervals.length][2];

//        for(int i = index)

        return null;
    }


}
