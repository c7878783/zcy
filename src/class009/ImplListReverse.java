package class009;

public class ImplListReverse {

    public static  class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
        return pre;//最后head是空的，他指向了末尾的下一个
        }
    }

    public static class DoubleListNode{
            public int val;
            public DoubleListNode next;
            public DoubleListNode pre;

            public DoubleListNode(int val){
                this.val = val;
            }
    }

    class Solution2 {

        public static DoubleListNode reverseDoubleList(DoubleListNode head) {
            DoubleListNode pre = null;
            DoubleListNode next = null;
            while (head != null){
                next = head.next;
                head.next = pre;
                pre = head;
                pre.pre = next;
                head = next;
            }
            return pre;//最后head是空的，他指向了末尾的下一个
        }
    }
}
