package class028;

import java.io.*;
import java.util.Arrays;

public class ImplRadixSort {

    public static int BASE = 10;

    public static int MAXN = 100001;

    public static int arr[] = new int[MAXN];

    public static int help[] = new int[MAXN];

    public static int n;

    public static int[] cnts = new int[BASE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        sort();
        for (int i = 0; i < n - 1; i++) {
            out.print(arr[i] + " ");
        }
        out.println(arr[n]);
        out.flush();
        out.close();
        br.close();

    }

    public static int bits(int num){
        int ans = 0;
        while (num > 0){
            ans++;
            num /= BASE;
        }
        return ans;
    }

    public static void sort(){
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }
        bits(max);
        for (int i = 0; i < n; i++) {
            arr[i] += min;
        }
    }

    public static void radixSort(int bits){
        for (int offset = 1; bits > 0; offset *= BASE, bits--){
            Arrays.fill(cnts, 0);
            for (int i = 0; i < n; i++) {
                cnts[ arr[i] / offset % BASE]++;
            }
            for (int i = 1; i < cnts.length; i++){
                cnts[i] = cnts[i] + cnts[i - 1];
            }
            for (int i = n - 1; i >= 0 ; i--) {
                help[--cnts[arr[i] / offset % BASE]] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = help[i];
            }
        }

    }
}
