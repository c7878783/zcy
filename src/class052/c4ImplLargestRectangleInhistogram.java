package class052;

public class c4ImplLargestRectangleInhistogram {

    class Solution {

        public static int r;
        public static int MAXN = 100001;
        public static int[] stack = new int[MAXN];


        public int largestRectangleArea(int[] heights) {
            r = 0;
            int n = heights.length;
            int ans = 0, cur, left;
            for (int i = 0; i < n; i++) {
                while (r > 0 && heights[stack[r - 1]] >= heights[i]){
                    cur = stack[--r];
                    left = r > 0? stack[r - 1]: - 1;
                    ans = Math.max(ans, heights[cur] * (i - left - 1));
                }
                stack[r++] = i;
            }
            while (r > 0){
                cur = stack[--r];
                left = r > 0? stack[r - 1]: -1;
                ans = Math.max(ans, heights[cur] * (n - left - 1));
            }

            return ans;
        }
    }
}
