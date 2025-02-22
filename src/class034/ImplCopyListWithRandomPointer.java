package class034;

public class ImplCopyListWithRandomPointer {
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy = null;
        while (cur != null){
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null? cur.random.next : null;
            cur = next;
        }
        Node ans = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null? next.next : null;
            cur = next;
        }
        return ans;
    }
}
