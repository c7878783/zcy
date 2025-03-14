package class055;

public class c1ImplShortestSubarrayWithSumAtLeastK {
    class Solution {

        public static int MAXN = 100001;
        public static long[] sum = new long[MAXN];
        public static int[] deque = new int[MAXN];
        public static int h, t;
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            h = t = 0;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {


                while (h < t && sum[i] - sum[deque[h]] >= k){
                    ans = Math.min(ans, i - deque[h++]);
                }

                while (h < t && sum[deque[t - 1]] >= sum[i]){
                    t--;
                }

                deque[t++] = i;
            }
            return ans == Integer.MAX_VALUE? -1 : ans;
        }
    }

}
