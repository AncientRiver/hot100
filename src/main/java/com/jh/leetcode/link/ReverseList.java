package com.jh.leetcode.link;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode currentNode = new ListNode(head.val);
        head=head.next;
        while (head != null) {
            ListNode node=new ListNode(head.val);
            node.next=currentNode;
            currentNode=node;
            head=head.next;
        }
        return currentNode;
    }
}
