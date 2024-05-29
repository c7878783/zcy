package class016;

public class Impl {
    int[] queue;
    int l, r, limit, size;

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == limit;
    }

    public void Queue(int n) {
        limit = n;
        queue = new int[n];
        l = r =0;
    }

    public boolean insertRear(int n){
        if (isFull()){
            return false;
        }else {
            queue[r] = n;
            r = (r == (limit - 1))? 0 : (r + 1);
            size++;
            return true;
        }
    }
    public boolean insertFront(int n){
        if (isFull()){
            return false;
        }else {
            l = (l == 0)? (limit - 1) : (l - 1);
            queue[l] = n;
            size++;
            return true;
        }
    }

    public boolean deRear(){
        if (isEmpty()){
            return false;
        }else {
            r = (r == 0)? limit - 1 : r - 1 ;
            size--;
            return true;
        }
    }
    public boolean deFront(){
        if (isEmpty()){
            return false;
        }else {
            l = (l == limit -1 )? 0 : l + 1;
            size--;
            return true;
        }
    }
    public int getFront(){
        if (isEmpty()){
            return -1;
        }else {
            return queue[l];
        }
    }
    public int getRear(){
        if (isEmpty()){
            return -1;
        }else {
            return queue[(r == 0)?limit - 1 : r - 1];
        }
    }
}
