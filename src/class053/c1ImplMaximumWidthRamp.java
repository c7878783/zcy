package class053;

public class c1ImplMaximumWidthRamp {

    class Solution {

        public static int MAXN = 50001;
        public static int[] stack = new int[MAXN];
        public static int r;
        public int maxWidthRamp(int[] nums) {
            r = 1;
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                if (nums[stack[r - 1]] > nums[i]){//相等就不必了，栈里的更靠左
                    stack[r++] = i;
                }
            }
            int ans = 0;
            for (int i = n - 1, left; i >= 0; i--) {
                while (r > 0 && nums[stack[r - 1]] <= nums[i] ){
                    left = stack[--r];
                    ans = Math.max(ans, i - left);
                }
            }
            return ans;
        }
    }
}
