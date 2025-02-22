package class034;

public class ImplReverseNodeInkGroup {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null){
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastTimeEnd = start;
        while (lastTimeEnd.next != null){
            start = lastTimeEnd.next;
            end = teamEnd(start, k);
            if ( end == null){
                return head;
            }
            reverse(start, end);

            lastTimeEnd.next = end;//上一组的最后指针指向的是已经变成end的start，需要将他改变成已经变成这组start的end
            lastTimeEnd = start;
        }


        return head;
    }

    public static ListNode teamEnd(ListNode s, int k){
        while ( --k != 0 && s != null){
            s = s.next;
        }
        return s;
    }

    public static void reverse(ListNode s, ListNode e){
        e = e.next;
        ListNode cur = s, next = null, pre = null;
        while (cur != e){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }

}
