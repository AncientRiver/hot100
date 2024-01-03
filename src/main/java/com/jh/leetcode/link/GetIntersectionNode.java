package com.jh.leetcode.link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取两个链表交集节点
 * 我走过的路+你走过的路=你走过的路+我走过的路=交叉点
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        ListNode headA = new ListNode(1);
        headA.next = listNode;
        ListNode headB = new ListNode(0);
        headB.next = listNode;


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa1 = headA, pa2 = headB;
        while (pa1 != pa2) {
            pa1 = pa1 == null ? headB : pa1.next;
            pa2 = pa2 == null ? headA : pa2.next;
        }
        return pa1;
    }
}
