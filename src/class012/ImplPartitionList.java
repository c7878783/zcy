package class012;

import class011.ImplAddTwoNumbers;
import class011.ListNode;

public class ImplPartitionList {

    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.val < x){
                if (leftHead == null){
                    leftHead = head;
                }else {
                    leftTail.next = head;
                }
                leftTail = head;
            }else {
                if (rightHead == null){
                    rightHead = null;
                }else {
                    rightTail.next = head;
                }
                rightTail = rightTail.next;
            }
            head = next;
        }
        if (leftHead == null){
            return rightHead;
        }

        leftTail.next = rightHead;
        return leftHead;
    }
}
