package class060;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class c2ImplLoudAndRich {


    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<Integer>());
            }
            int[] indegree = new int[n];
            for (int[] r : richer) {
                graph.get(r[0]).add(r[1]);
                indegree[r[1]]++;
            }
            int[] queue = new int[n];
            int l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0){
                    queue[r++] = i;
                }
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = i;
            }
            while (l < r){
                int cur = queue[l++];
                for (Integer next : graph.get(cur)) {
                    if (quiet[ans[next]] > quiet[ans[cur]]){
                        ans[next] = ans[cur];
                    }
                    if (--indegree[next] == 0){
                        queue[r++] = next;
                    }
                }
            }
        return ans;
        }
    }
}
