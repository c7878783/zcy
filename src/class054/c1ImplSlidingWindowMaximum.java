package class054;

public class c1ImplSlidingWindowMaximum {

    class Solution {

        public static int MAXN = 100001;
        public static int[] deque = new int[MAXN];
        public static int h, t;
        public int[] maxSlidingWindow(int[] nums, int k) {
            h = t = 0;
            int n = nums.length;
            for (int i = 0; i < k - 1; i++) {
                while (h < t && nums[deque[t - 1]] <= nums[i]){
                    t--;
                }
                deque[t++] = i;
            }
            int m = n - k + 1;
            int[] ans = new int[m];
            for (int l = 0, r = k - 1; l < m; l++, r++) {//原本塞了两个，往里边塞边移动
                while (h < t && nums[deque[t - 1]] <= nums[r]){
                    t--;
                }
                deque[t++] = r;
                ans[l] = nums[deque[h]];//结算当前l和r包含的这三个数组成的最大值答案
                if (deque[h] == l){
                    h++;
                }
            }
            return ans;
        }
    }
}
