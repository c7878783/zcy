package class046;

import java.util.HashMap;

public class c3ImplNumberOfSubarraySumEqualsAim {

    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int ans = 0;
            for (int i = 0, sum = 0; i < nums.length; i++) {
                sum += nums[i];
                ans += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }

}
