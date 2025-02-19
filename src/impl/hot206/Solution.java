package impl.hot206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }else {
            return reverse2(head);
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode ans = new ListNode();
        ListNode n  = new ListNode(head.val);
        head = head.next;
        ans = n;
        while(head.next != null){
            ListNode t  = new ListNode(head.val, ans);
            head = head.next;
            ans = t;
        }
        ListNode k  = new ListNode(head.val, ans);
        ans = k;
        return ans;
    }

    public ListNode reverse2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}