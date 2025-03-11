package class052;

import com.sun.source.tree.BreakTree;

public class c2DailyTemperatures {


    class Solution {
        public static int MAXN = 100001;
        public static int[] stack = new int[MAXN];
        public static int r;
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            r = 0;
            int cur;
            for (int i = 0; i < n; i++) {
                while (r > 0 && temperatures[i] > temperatures[stack[r - 1]]){
                    cur = stack[--r];
                    ans[cur] = i - cur;
                }
                stack[r++] = i;
            }
            return ans;
        }

    }
}
