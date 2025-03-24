package class056;

public class c4ImplSimilarStringGroups {

    class Solution {

        public static int MAXN = 301;
        public static int[] father = new int[MAXN];
        public static int[] stack = new int[MAXN];
        public static int sets;
        public static int numSimilarGroups(String[] strs) {
            int n = strs.length;
            int m = strs[0].length();
            build(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (find(i) != find(j)){
                        int diff = 0;
                        for (int k = 0; k < m && diff < 3; k++) {
                            if (strs[i].charAt(k) != strs[j].charAt(k)){
                                diff++;
                            }
                        }
                        if (diff == 0 || diff == 2){
                            union(i, j);
                        }
                    }

                }
            }
            return sets;
        }

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

        public static boolean isSameSet(int x, int y){
            int fx = find(x);
            int fy = find(y);
            return fx == fy;
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
