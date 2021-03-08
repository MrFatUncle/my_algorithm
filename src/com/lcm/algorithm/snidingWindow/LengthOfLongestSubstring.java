package com.lcm.algorithm.snidingWindow;

import java.util.*;

/**
 * FileName: LengthOfLongestSubstring
 * Author:   liaocm
 * Date:     2021/3/3 11:20
 * Description: 3.无重复字符的最长子串
 * History:
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        List<Integer> results = new ArrayList<>();

        char[] chars = s.toCharArray();
        if(chars.length == 1) {
            return 1;
        }
        int start = 0;
        int end = 0;
        //dvdfd
        A:
        while(start <= chars.length - 1) {

            B:
            while(end <= chars.length - 1) {
                String key = String.valueOf(chars[end]);
                Integer index = map.get(key);
                if(null == index) {
                    result++;
                    map.put(key, end);
                    end++;
                } else {
                    break;
                }
            }
            results.add(map.size());
            map.remove(String.valueOf(chars[start]));
            start++;
            if(end >= chars.length) {
                break;
            }
        }
        if(results.size() == 0) {
            return 0;
        }
        return Collections.max(results);
    }
}


