package class050;

public class c3ImplTrappingRainWater {

    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] lmax = new int[n];
            int[] rmax = new int[n];
            lmax[0] = height[0];
            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(height[i], lmax[i - 1]);
            }
            rmax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--){
                rmax[i] = Math.max(height[i], rmax[i + 1]);
            }

            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans += Math.max(0, Math.min(lmax[i - 1], rmax[i + 1]) - height[i]);
            }
            return ans;
        }

        public int trap2(int[] nums) {
            int l = 1, r = nums.length - 2, lmax = nums[0], rmax = nums[nums.length - 1];
            int ans = 0;
            while (l <= r){
                if (lmax <= rmax){
                    ans += Math.max(0, lmax - nums[l]);//结算这个点的值
                    lmax = Math.max(lmax, nums[l++]);//把这个点的值计算到侧边最大值中
                }else {
                    ans += Math.max(0, rmax - nums[r]);
                    rmax = Math.max(rmax, nums[r--]);
                }
            }
            return ans;
        }
    }
}
