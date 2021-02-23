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

//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        int[][] intervals = new int[][]{{1, 4}, {0, 1}};

        int[][] result = myMerge(intervals);

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

    }

    public static int[][] myMerge(int[][] intervals) {
        if(null == intervals) {
            return null;
        }
        if(intervals.length < 2) {
            return intervals;
        }
        int resultLength = intervals.length;
        for(int i = 0; i < intervals.length - 1; i++) {
            boolean merged = false;
            INNER:
            for(int j = i + 1; j < intervals.length; j++) {
                int[] ints = checkAndMerge(intervals[i], intervals[j]);
                if(null != ints) {
                    intervals[j] = ints;
                    merged = true;
                    break INNER;
                }
            }
            if(merged) {
                resultLength--;
                intervals[i] = null;
            }
        }

        int[][] results = new int[resultLength][2];
        int index = 0;
        for (int[] interval : intervals) {
            if(null != interval) {
                results[index++] = interval;
            }
        }


        return results;
    }

    private static int[] checkAndMerge(int[] intervalA, int[] intervalB) {
        int a1 = intervalA[0];
        int a2 = intervalA[1];
        int b1 = intervalB[0];
        int b2 = intervalB[1];
        //区间合并6种场景
        //1. A在B的左边
        if(a2 < b1) {
            return null;
        }
        //2. A在B的右边
        if(a1 > b2) {
            return null;
        }
        //3. A在B的左边，并且A与B相交
        if(a1 <= b1 && a2 >= b1 && a2 <= b2) {
            return new int[]{a1, b2};
        }
        //4. A在B的右边，并且A与B相交
        if(b1 <= a1 && b2 >= a1 && b2 <= a2) {
            return new int[]{b1, a2};
        }
        //5. A完全包含B
        if(a1 <= b1 && a2 >= b2) {
            return new int[]{a1, a2};
        }
        //6. B完全包含A
        if(b1 <= a1 && b2 >= a2) {
            return new int[]{b1, b2};
        }

        return null;
    }


}
