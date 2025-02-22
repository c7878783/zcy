package class034;

public class ImplSortList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode sortList(ListNode head) {
        int n = 0;
        ListNode cur = head;

        while (cur != null){
            n++;
            cur = cur.next;
        }

        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < n; step <<= 1){
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l1, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, l2, r1, r2);
            head = start;
            lastTeamEnd = end;
            while (next != null){
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1,l2,r1,r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }
        }
        return head;
    }

    public static ListNode findEnd(ListNode s, int step){
        while (s.next != null && --step != 0){
            s = s.next;
        }
        return s;
    }

    public static ListNode start;
    public static ListNode end;

    public static void merge(ListNode l1, ListNode l2, ListNode r1, ListNode r2){

        ListNode pre = null;
        if (l1.val <= l2.val){
            start = l1;
            pre = l1;
            l1 = l1.next;
        }else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1.next != null && l2.next != null){
            if (l1.val <= l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = l2;
                l2 = l2. next;
            }
        }
        if (l1.next != null){
            pre.next = l1;
            end = r1;
        }else {
            pre.next = l2;
            end = r2;
        }

    }

}
