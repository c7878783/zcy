package impl.hot141;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        } else {
            return checkCir3(head);
        }
    }

    private boolean checkCir(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        while (head.next != null) {
            if (listNodes.contains(head.next)) {
                return true;
            } else {
                listNodes.add(head.next);
            }
            head = head.next;
        }
        return false;
    }

    private boolean checkCir2(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<ListNode>();
        while (head.next != null) {
            if (listNodes.add(head.next)) {
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
    private boolean checkCir3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return true;
    }
}
