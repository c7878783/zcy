package class059;

import java.io.*;
import java.util.ArrayList;

public class c2ImplTopoSortDynamicNowcoder {

    public static int MAXN = 200001;
    public static int[] queue = new int[MAXN];
    public static int l, r;
    public static int[] indegree = new int[MAXN];
    public static int[] ans = new int[MAXN];
    public static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while (in.nextToken() != StreamTokenizer.TT_EOF){
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0, from, to; i < m; i++) {
                in.nextToken();
                from = (int) in.nval;
                in.nextToken();
                to = (int) in.nval;
                graph.get(from).add(to);
                indegree[to]++;
            }
            if (!topoSort(graph)){
                out.println(-1);
            }else {
                for (int i = 0; i < n - 1; i++) {
                    out.print(ans[i] + " ");
                }
                out.print(ans[n - 1]);
            }
        }

        out.flush();
        out.close();
        br.close();

    }

    public static boolean topoSort(ArrayList<ArrayList<Integer>> graph){
        l = r = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0){
                queue[r++] = i;
            }
        }
        int fill = 0;
        while (l < r){
            int cur = queue[l++];
            ans[fill++] = cur;
            for (Integer i : graph.get(cur)) {
                if (--indegree[i] == 0){
                    queue[r++] = i;
                }
            }
        }
        return fill == n;
    }

}
