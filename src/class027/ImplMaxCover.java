package class027;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ImplMaxCover {

    public static int MAXN = 50001;

    public static int[][] line = new int[MAXN][2];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int[] heap = new int[MAXN];
    public static int size;

    public static int compute(){
        size = 0;

        Arrays.sort(line, 0, n, (a, b) -> (a[0] - b[0]));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heap[0] <= line[i][0]){
                pop();
            }
            add(line[i][1]);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    public static void add(int x){
        heap[size] = x;
        int i = size++;
        while (heap[i] < heap[(i - 1) / 2]){
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
    public static void pop(){
        swap(0, --size);
        int i = 0, l = 1;
        while ( l < size){
            int best = (l + 1) < size && heap[l] < heap[l+1]? l : l + 1;
            best = heap[i] < heap[best]? i : best;
            if (best == i){
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static int minMeetingRooms(int[][] meeting) {
        int n = meeting.length;
        Arrays.sort(meeting, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek() <= meeting[i][0]){
                heap.poll();
            }
            heap.add(meeting[i][1]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }

}
