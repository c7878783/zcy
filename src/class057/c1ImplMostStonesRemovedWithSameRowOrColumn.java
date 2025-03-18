package class057;

import java.util.HashMap;

public class c1ImplMostStonesRemovedWithSameRowOrColumn {

    class Solution {

        public static HashMap<Integer, Integer> rowFirst = new HashMap<>();
        public static HashMap<Integer, Integer> colFirst = new HashMap<>();
        public static int MAXN = 1001;
        public static int[] father = new int[MAXN];
        public static int sets;

        public static void build(int n){
            rowFirst.clear();
            colFirst.clear();
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
            sets = n;
        }

        public static int find(int i){
            if (i != father[i]){
                i = find(father[i]);
            }
            return i;//这种写法和c2的做法，缺少了隐式的路径压缩，在某些连接少的情况下可以通过，但是连接长会超出时间
        }

        public static void union(int i, int j){
            int fx = find(i);
            int fy = find(j);
            if (fx != fy){
                father[fx] = fy;
                sets--;
            }
        }

        public int removeStones(int[][] stones) {
            int n = stones.length;
            build(n);
            for (int i = 0; i < n; i++) {
                int row = stones[i][0];
                int col = stones[i][1];
                if (!rowFirst.containsKey(row)){
                    rowFirst.put(row, i);
                }else {
                    union(i, rowFirst.get(row));
                }
                if (!colFirst.containsKey(col)){
                    colFirst.put(col, i);
                }else {
                    union(i, colFirst.get(col));
                }
            }
            return n - sets;
        }
    }
}
