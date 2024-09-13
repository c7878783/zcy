package class012;

public class Impl {

    public static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    /**
     * head.next不置空，在赋值的时候会把val和next共同给到LisNode。需要将每个节点从原链表中取出，做分离。
     */
    class Solution{
        public ListNode PartitionList(ListNode head, int x){
            ListNode ans = null;
            ListNode leftHead = null;
            ListNode leftTail = null;
            ListNode rightHead = null;
            ListNode rightTail = null;
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
                        rightHead = head;
                    }else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = next;
            }
            if (leftHead == null){
                return rightHead;
            }
            leftTail.next = rightHead;
            ans = leftHead;
            return ans;

        }
    }

}
