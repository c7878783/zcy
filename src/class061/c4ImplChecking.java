package class061;

import java.lang.reflect.Array;
import java.util.Arrays;

public class c4ImplChecking {


    class Solution {

        public static int MAXN = 100001;
        public static int[][] question = new int[MAXN][4];
        public static int[] father = new int[MAXN];


        public static void build(int n){
            for (int i = 0; i <= n; i++) {
                father[i] = i;
            }
        }

        public static int find(int i){
            if (i != father[i]){
                father[i] = find(father[i]);
            }
            return father[i];
        }

        public static void union(int i, int j){
            father[find(i)] = find(j);//一定要找到合集父节点，不然有可能会断开集合关系
        }

        public static boolean isSameSet(int i, int j){
            return find(i) == find(j);
        }

        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            build(n);
            Arrays.sort(edgeList, (a, b) -> (a[2] - b[2]));
            int m = edgeList.length;
            int k = queries.length;
            for (int i = 0; i < k; i++) {
                question[i][0] = queries[i][0];
                question[i][1] = queries[i][1];
                question[i][2] = queries[i][2];
                question[i][3] = i;
            }
            Arrays.sort(question, 0, k,  (a, b) -> (a[2] - b[2]));
            boolean[] ans = new boolean[k];
            for (int i = 0, j = 0; i < k; i++) {
                for (; j < m && edgeList[j][2] < question[i][2]; j++){
                    union(edgeList[j][0], edgeList[j][1]);
                }
                ans[question[i][3]] = isSameSet(question[i][0], question[i][1]);
            }

            return ans;
        }
    }


}
