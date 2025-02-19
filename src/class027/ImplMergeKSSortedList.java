package class027;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ImplMergeKSSortedList {

    public static class ListNode{
        public int val;
        public ListNode next;
    }


    public static ListNode mergeKSortedLists(ArrayList<ListNode> arr){
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode h : arr) {
            if (h != null){
                heap.add(h);
            }
        }
        if (heap.isEmpty()){
            return null;
        }

        ListNode h = heap.poll();
        ListNode pre = h;
        if (pre.next != null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (pre.next != null){
                heap.add(pre.next);
            }
        }
        return h;
    }


}
