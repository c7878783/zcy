package class013;


/**
 * 1.队列：
 *      加入次数要确定
 *      初始化、是否空、加入、从前头取、读前头、读后头、size
 * 2.栈：
 *      留存在栈内的最大数量要确定
 *      初始化、是否空、psuh、pop、peek、size
 */
public class Impl {

    public static class Queue{
        public int[] queue;
        int l;
        int r;


        public Queue(int n) {

            queue = new int[n];
            l = 0;
            r = 0;
        }

        public boolean isEmpty() {
            return l==r;
        }

        public void offer(int num){
            queue[r++] = num;
        }

        public int poll(){
            return queue[l++];
        }
        public int head(){
            return queue[l];
        }
        public int size(){
            return r-l;
        }
    }

    public static class Stack{
        int[] stack;
        int size = 0 ;

        public boolean isEmpty(){
            return size == 0;
        }
        public void Stack(int n){
            stack = new int[n];
        }
        public void push(int num){
            stack[size++] = num;
        }
        public int pop(){
            return stack[--size];
        }
        public int peek(){
            return stack[size - 1];
        }
        public int size(){
            return size;
        }
    }

    class MyCircularQueue {
        int[] queue;
        int l, r, size, limit;

        public MyCircularQueue(int n){
            limit = n;
            queue = new int[n];
            l = r = 0 ;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public boolean isFull(){
            return size == limit;
        }
        public boolean enQueue(int num){
            if (isFull()){
                return false;
            }else {
                queue[r] = num;
                r = (r == (limit -1) )?0 : (r+1);
                size++;
                return true;
            }
        }
        public boolean deQueue(){
            if (isEmpty()){
                return false;
            }else {
                l = (l == (limit - 1))?0 : (l+1);
                size--;
                return true;
            }
        }
        public int front(){
            if(isEmpty()){
                return -1;
            }else {
                return queue[l];
            }
        }
        public int rear(){
            if (isEmpty()){
                return -1;
            }else {
             return queue[(r == 0)?(limit - 1) : (r - 1)];
            }
        }
    }
}
