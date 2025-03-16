package class056;

import com.sun.source.tree.BreakTree;

public class c3ImplCouplesHoldingHands {

    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            build(n / 2);
            for (int i = 0; i < n; i += 2) {
                union(row[i] / 2, row[i + 1]  / 2);
            }

            return n / 2 - sets;//每混了两对，就要换一次，混n对，换n-1次，n / 2是一共的对数，sets每混两对减去一次，二者之差就是操作次数
        }

        public static int MAXN = 31;
        public static int[] father = new int[MAXN];
        public static int[] stack = new int[MAXN];
        public static int sets;

        public static void build(int m){
            for (int i = 0; i < m; i++) {
                father[i] = i;
            }
            sets = m;
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
        public static void union(int x, int y){
            int fx = find(x);
            int fy = find(y);
            if (fx != fy){
                father[fx] = fy;
                sets--;
            }

        }
    }
}
