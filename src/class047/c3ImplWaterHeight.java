package class047;

import java.io.*;

public class c3ImplWaterHeight {


    public static int MAXN = 1000001;
    public static int n, m;
    public static int OFFSET = 30001;
    public static int[] arr = new int[OFFSET + MAXN + OFFSET];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0, v, x; i < n; i++){
                in.nextToken(); v = (int) in.nval;
                in.nextToken(); x = (int) in.nval;
                fall(v, x);
            }
            build();
            int start = OFFSET + 1;
            out.print(arr[start++]);
            for (int i = 2; i <= m; i++) {
                out.print(" " + arr[start++]);
            }
            out.println();
        }
        out.flush();
        out.close();
        br.close();

    }

    public static void fall(int v, int x){
        set(x - 3 * v + 1, x - 2 * v, 1, v, 1);
        set(x - 2 * v + 1, x, v - 1, -v, -1);
        set(x + 1, x + 2 * v, -v + 1, v, 1);
        set(x + 2 * v + 1, x + 3 * v - 1, v - 1, 1, -1);
    }
    public static void set(int l, int r, int s, int e, int d){
        arr[OFFSET + l] += s;
        arr[OFFSET + l + 1] += d - s;
        arr[OFFSET + r + 1] -= e + d;
        arr[OFFSET + r + 2] += e;
    }
    public static void build(){
        for (int i = 1; i <= OFFSET + m; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i <= OFFSET + m; i++) {
            arr[i] += arr[i - 1];
        }
    }
}
