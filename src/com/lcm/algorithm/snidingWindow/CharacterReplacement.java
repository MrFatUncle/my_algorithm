/**
 * FileName: CharacterReplacement
 * Author:   liaocm
 * Date:     2021/3/5 10:05
 * Description: 424.字符串替换后的最大长度
 * History:
 */
package com.lcm.algorithm.snidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class CharacterReplacement {

    public static void main(String[] args) {
        String e = "ABABBCBD";
        //求子字符串中 其它元素数量<=k 的最长字符串
        System.out.println(myCharacterReplacement(e, 2));
    }

    private static int myCharacterReplacement(String s, int k) {
        int length = s.length();

        StrCount<String> strCount = new StrCount<>();
        int ans = 0;

        int j = 0;
        for (int i = 0; i < length; i++) {
            strCount.put(String.valueOf(s.charAt(i)), 1);

            while(strCount.getLessCount() > k) {
                strCount.put(String.valueOf(s.charAt(j)), -1);
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    private static class StrCount<String> {

        private Map<String, Integer> map = new LinkedHashMap<>();

        public void put(String key, int value) {
            Integer count = map.get(key);
            map.put(key, null == count ? value : count + value);
            if(map.get(key) <= 0) {
                map.remove(key);
            }
            if(map.size() <= 1) {
                return;
            }
            //排序
            HashMap<String, Integer> finalOut = new LinkedHashMap<>();
            map.entrySet()
                    .stream()
                    .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                    .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
            map = finalOut;
        }

        public int getLessCount() {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();

            int result = 0;
            Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
            iterator.next();
            while(iterator.hasNext()) {
                result += iterator.next().getValue();
            }
            return result;
        }

    }

}
