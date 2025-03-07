package class051;

import java.io.*;

public class c3ImplRobotPassThroughBuilding {

    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            int l = 0;
            int r = 0;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
                r = Math.max(r, arr[i]);
            }
            int ans = compute(l ,r, r);
            out.println(ans);
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int compute(int l, int r, int max){
        int m, ans = - 1;
        while (l <= r){
            m = l + ((r - l ) >> 1);
            if (f(m, max)){//我们认为能走完，就满足条件，记录
                ans = m;
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static boolean f(int energy, int max){
        for (int i = 0; i < n; i++) {
            if (energy <= arr[i]){
                energy -= arr[i] - energy;
            }else {
                energy += energy - arr[i];
            }
            if (energy >= max){
                return true;
            }
            if (energy <= 0){
                return false;
            }
        }
        return true;

    }
}
