package class027;

import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;

public class ImplMinimum {

    public static int halveArray1(int[] nums){
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> (b.compareTo(a)));
        double sum = 0;
        for (int num : nums) {
            heap.add((double) num);
            sum += num;
        }

        sum /= 2;
        int ans = 0;
        for (double minus = 0, cur; minus < sum; ans++, minus += cur){
            cur = heap.poll() / 2;
            heap.add(cur);
        }
        return ans;
    }

    public static int MAXN = 10001;
    public static long[] heap = new long[MAXN];
    public static int size;

    public static int halveArray(int[] nums){
        size = nums.length;
        long sum = 0;
        for (int i = size - 1; i >= 0; i--){
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum /= 2;
        int ans = 0;
        for (long minus = 0; minus < sum; ans++) {
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }
        return ans;
    }

    public static void heapify(int i){
        int l = i * 2 + 1;
        while (l < size){
//            int best = (l + 1) < size && heap[l] > heap[l + 1]? l : l + 1;//错误写法， 如果条件1否了，给个l + 1有什么用？
            int best = l + 1 < size && heap[l + 1] > heap[l] ? l + 1 : l;//需要满足前两个条件才能讲l + 1视为 best
            best = heap[i] > heap[best]? i : best;
            if (best == i){
                break;
            }
            swap(best, i);
            i = best;
            l = 2 * i + 1;
        }
    }

    public static void swap(int i, int j) {
        long tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

}
