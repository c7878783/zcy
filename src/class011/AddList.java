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
