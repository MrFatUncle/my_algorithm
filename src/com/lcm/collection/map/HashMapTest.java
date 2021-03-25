/**
 * FileName: HashMapTest
 * Author:   liaocm
 * Date:     2021/2/20 11:12
 * Description:
 * History:
 */
package com.lcm.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);

        Map<Integer, Integer> map1 = new ConcurrentHashMap<>();

        map1.put(1, 1);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
    }
}
