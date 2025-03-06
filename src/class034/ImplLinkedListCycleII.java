package class034;

public class ImplLinkedListCycleII {

    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next ==null || head.next.next ==null){
            return null;
        }


        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast){
            if (fast.next == null || fast.next.next == null) {//有可能没有的情况
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }

}
