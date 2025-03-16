package class056;

import java.io.*;

public class c1ImplUnionFindNowCoder {

    public static int MAXN = 1000001;
    public static int[] father = new int[MAXN];
    public static int[] size = new int[MAXN];
    public static int[] stack = new int[MAXN];
    public static int n;


    public static void build(){
        for (int i = 0; i <= n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int i){
        int size = 0;
        while (father[i] != i){
            i = father[i];
            stack[size++] = i;
        }
        while (size > 0){
            father[stack[--size]] = i;
        }
        return i;
    }

    public static boolean isSameSet(int i, int j){
        return find(i) == find(j);
    }

    public static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if (fx != fy){
            if (size[fx] >= size[fy]){
                father[fy] = fx;
                size[fx] += size[fy];
            }else {
                father[fx] = fy;
                size[fy] += size[fx];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            build();
            in.nextToken();
            int m = (int) in.nval;//in.nval出来的数字一定要先承接住，如果直接在for循环里使用i<in.nval会出错
            for (int i = 0, op; i < m; i++) {
                in.nextToken();
                op = (int) in.nval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (op == 1){
                    out.println(isSameSet(x, y)? "Yes" : "No");
                }
                if (op == 2){
                    union(x, y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}
