package class035;

import java.util.HashMap;

public class ImplLRU {

    class LRUCache{
        class DoubleNode{
            public int key;
            public int val;
            public DoubleNode next;
            public DoubleNode last;

            public DoubleNode(int key, int val){
                this.key = key;
                this.val = val;
            }

        }
        class DoubleList{
            public DoubleNode head;
            public DoubleNode tail;

            public DoubleList(){
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newNode){
                if (newNode == null){
                    return;
                }
                if (head == null){
                    head = newNode;
                    tail = head;
                }else {
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }
            }

            public DoubleNode removeHead(){
                if (head == null){
                    return null;
                }
                DoubleNode ans = head;
                if (head == tail){
                    head = null;
                    tail = null;
                }else {
                    head = head.next;
                    ans.next = null;
                    head.last = null;
                }
                return ans;
            }

            public void moveNodeToTail(DoubleNode node){
                if (tail == node){
                    return;
                }
                if (head == node){
                    head = node.next;
                    head.last = null;
                }else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                tail.next = node;
                node.last = tail;
                node.next = null;//必须把node的下一个位置清空掉，不然会有遗留问题
                tail = node;
            }
        }

        private HashMap<Integer, DoubleNode> keyNodeMap;
        private DoubleList nodeList;
        //哈希表存储键和键对应的双向链表，双向链表用来保存LRU的顺序
        private final int capacity;

        public LRUCache(int cap){
            this.capacity = cap;
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
        }

        public int get(int key){
            if (keyNodeMap.containsKey(key)){
                DoubleNode ans = keyNodeMap.get(key);
                nodeList.moveNodeToTail(ans);
                return ans.val;
            }
            return -1;
        }

        public void put(int key, int val){
            if (keyNodeMap.containsKey(key)){
                DoubleNode node = keyNodeMap.get(key);
                node.val = val;
                nodeList.moveNodeToTail(node);
            }else {
                if (keyNodeMap.size() == capacity){
                    DoubleNode removeHead = nodeList.removeHead();
                    keyNodeMap.remove(removeHead.key);
                }
                DoubleNode node = new DoubleNode(key, val);
                nodeList.addNode(node);
                keyNodeMap.put(key, node);
            }
        }
    }


}
