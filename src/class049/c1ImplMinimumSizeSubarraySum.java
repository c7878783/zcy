package class049;

public class c1ImplMinimumSizeSubarraySum {


    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            for (int l = 0, r = 0; r < nums.length; r++) {
                sum += nums[r];
                while (sum - nums[l] >= target){
                    sum -= nums[l++];
                }

                if (sum >= target){
                    ans = Math.min(ans, r - l + 1);
                }

            }
            return ans == Integer.MAX_VALUE? 0 : ans;
        }
    }
}
