package com.whn.linkedList;

public class ReverseListN {

    ListNode successor = null;

    public ListNode reverseListN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseListN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
