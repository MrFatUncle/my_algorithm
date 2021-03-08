package com.lcm.algorithm.snidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * FileName: FruitsIntoBaskets
 * Author:   liaocm
 * Date:     2021/3/4 9:05
 * Description: 904.水果成栏
 * History:
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {
        //翻译一下，最长的连续的只有两种相同元素的子数组长度
        int[] tree = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        System.out.println(myTotalFruit(tree));
    }

    private static int totalFruitSimple(int[] tree) {
        return 0;
    }

    private static int myTotalFruit(int[] tree) {
        int ans = 0;
        if (null == tree || tree.length == 0) {
            return 0;
        }

        int fruitCount = 2; //果篮数量
        int start = 0;
        int end = 0;
        int totalNow = 0;
        Map<Integer, Integer> fruits = new HashMap<>(); //水果种类

        A:
        while (start < tree.length) {

            while (end < tree.length) {
                int fruit = tree[end];
                //判断水果种类是否一致
                Integer size = fruits.get(fruit);
                //一致则放入果篮
                if (null != size) {
                    totalNow++;
                    fruits.put(fruit, ++size);
                    end++;
                }
                //不一致则判断水果种类是否达到果篮数量、让后将start后移一位
                else {
                    //判断水果种类是否达到果篮数量
                    //未达到则直接放果篮
                    if (fruits.size() < fruitCount) {
                        totalNow++;
                        fruits.put(fruit, 1);
                        end++;
                    }
                    //终止 然后将start后移一位
                    else {
                        break;
                    }
                }
            }

            ans = Math.max(totalNow, ans);
            //判断start位的水果是否需要从果篮中移除
            Integer size = fruits.get(tree[start]);
            if (size <= 1) {
                fruits.remove(tree[start]);
            } else {
                fruits.put(tree[start], --size);
            }
            //将start后移一位
            start++;
            totalNow--;

            if (end >= tree.length) {
                break;
            }
        }

        return ans;
    }
}
