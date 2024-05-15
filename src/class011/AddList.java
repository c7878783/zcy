package class011;

public class AddList {

    public ListNode Solution(ListNode h1, ListNode h2){

        ListNode ans = null;
        ListNode cur = null;
        int carry = 0;
        for (int sum;
             (h1 != null || h2 != null);
             h1 = (h1.next == null ? null: h1.next), h2 = (h2.next == null ? null: h2.next)) {
            sum = carry + (h1 == null? 0 : h1.value) + (h2 == null? 0 : h2.value);
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(sum % 10);
                cur = ans;
            }else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(1);
        }
        return ans;
    }
}


/*
class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode cur = null;
        int carry = 0;
        for (int sum;
             (l1 != null || l2 != null);
             l1 = (l1 == null ? null: l1.next), l2 = (l2  == null ? null: l2.next)) {
            sum = carry + (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val);
            carry = sum / 10;
            if (ans == null) {
                ans = new ListNode(sum % 10);
                cur = ans;
            }else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(1);
        }
        return ans;
    }
}*/
