package class011;

import class010.ImplMergeTwoLists;

import java.util.IllegalFormatCodePointException;

public class ImplAddTwoNumbers {

    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        ListNode ans = null, cur = null;
        int carry = 0;
        for (
            int sum, val;//声明变量
            h1 == null || h2 == null;
            h1 = h1 ==null? null : h1.next,
            h2 = h2 ==null? null : h2.next
        ){
            sum = (h1 == null? 0 : h1.val)
                    + (h2 == null? 0 : h2.val)
                    + carry;
            val = sum % 10;
            carry = sum / 10;
            if (ans == null){
                ans = new ListNode(val);
                cur = ans;
            }else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }
        return ans;
    }
}
