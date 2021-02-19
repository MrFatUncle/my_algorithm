package com.lcm.algorithm.fastSlowPointer;

/**
 * FileName: LinkedListCycle
 * Author:   liaocm
 * Date:     2021/2/19 17:21
 * Description: 141.环形链表
 * History:
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }

    private static boolean hasCycle(ListNode head) {
        if(null == head) {
            return false;
        }
        ListNode node = head.next;
        if(null == node) {
            return false;
        }
        ListNode fastNode = node.next;
        if(null == fastNode) {
            return false;
        }

        while(node != fastNode) {
            node = node.next;
            if(null == node) {
                return false;
            }

            if(null == fastNode.next || null == fastNode.next.next) {
                return false;
            }
            fastNode = fastNode.next.next;
        }

        return true;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}