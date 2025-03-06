package class050;

public class c5ImplContainerWithMostWater {

    class Solution {
        public int maxArea(int[] height) {
            int ans = 0;
            for (int l = 0, r = height.length - 1; l < r;){
                ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
                if (height[l] <= height[r]){
                    l++;
                }else {
                    r--;
                }
            }
            return ans;
        }
    }

}
