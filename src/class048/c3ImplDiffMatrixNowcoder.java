package class048;

import java.io.*;
import java.util.Arrays;

public class c3ImplDiffMatrixNowcoder {

    public static int n, m, q;
    public static int MAXN = 1005;
    public static long[][] diff = new long[MAXN][MAXN];//long类型很重要，因为有可能会很大的数值

    public static void add(int a, int b, int c, int d, int k){
        diff[a][b] += k;
        diff[c + 1][b] -= k;
        diff[a][d + 1] -= k;
        diff[c + 1][d + 1] += k;
    }

    public static void build(){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){//这个数的前缀和这样处理：左边的+右边的-左上的
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
            }
        }
    }

    public static void clear(){
        //考虑到在add方法里，会对矩阵范围外最多一个位置增加数值，所以那个地方也要清理
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++){
                diff[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            in.nextToken();
            q = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    in.nextToken();
                    add(i, j, i, j, (int) in.nval);
                }
            }
            for (int i = 0, a, b, c, d, k; i < q; i++) {
                in.nextToken();a = (int) in.nval;
                in.nextToken();b = (int) in.nval;
                in.nextToken();c = (int) in.nval;
                in.nextToken();d = (int) in.nval;
                in.nextToken();k = (int) in.nval;
                add(a, b, c, d, k);
            }
            build();
            for (int i = 1; i <= n; i++) {
                out.print(diff[i][1]);
                for (int j = 2; j <= m; j++) {
                    out.print(" " + diff[i][j]);
                }
                out.println();
            }
            clear();
        }
        out.flush();
        out.close();
        br.close();
    }



}
