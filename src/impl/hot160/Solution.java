package impl.hot160;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> listA = new ArrayList<>();
        while (headA != null) {
            listA.add(headA);
            headA = headA.next;
        }
        ArrayList<ListNode> listB = new ArrayList<>();
        while (headB != null) {
            listB.add(headB);
            headB = headB.next;
        }
        int sizea = listA.size();
        int sizeb = listB.size();
        int num = sizea < sizeb ? sizea : sizeb;

        if((listA.get(sizea - 1)) == listB.get(sizeb - 1) ){
            for (int i = 0; i < num; i++) {
                if(listA.get(sizea - i - 1) == listB.get(sizeb - i - 1)) {
                    if (i == (num - 1)){
                        return listA.get(sizea - i - 1);
                    }
                } else {
                    return listA.get(sizea - i);
                }
            }

        }

        return null;

    }
}