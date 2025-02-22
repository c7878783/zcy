package class034;

import class154.Code02_Convict1;

import java.util.List;

public class ImplPalindromeLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = slow;
        ListNode cur = pre.next;
        ListNode next = null;
        pre.next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        boolean ans = true;
        ListNode left = head;
        ListNode right = pre;
        while (left != null && right != null){
            if (left.val != right.val){
                ans = false;
            }
            left =left.next;
            right = right.next;
        }
        cur = pre.next;
        pre.next = null;
        next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;
    }
}
