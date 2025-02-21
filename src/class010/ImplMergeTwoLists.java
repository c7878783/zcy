package class010;

import class009.ImplListReverse;

public class ImplMergeTwoLists {

    public static class ListNode{
        public int val;
        public ListNode next;
    }
    class Solution {

        public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
            if (head1 == null || head2 == null){
                return head1 == null ? head2 : head1;//一定要在这里先判断有没有一个是null，否则接下来的一个也不能用，因为有空。
            }
            ListNode head = head1.val < head2.val? head1 : head2;
            ListNode cur1 = head.next;
            ListNode cur2 = head == head1? head2 : head1;
            ListNode pre = head;
            while (cur1 != null && cur2 != null){
               if (cur1.val < cur2.val){
                    pre.next = cur1;
                    cur1 = cur1.next;
               }else {
                    pre.next = cur2;
                    cur2 = cur2.next;
               }
                pre = pre.next;
            }
            if (cur1 == null){
                pre.next = cur2;
            }
            if (cur2 == null){
                pre.next = cur1;
            }
            return head;
        }
    }
}
