package class051;

public class c2ImplSplitArrayLargestSum {

    class Solution {
        public int splitArray(int[] nums, int k) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            long ans = 0;
            for (long l = 0, m, r = sum, need; l <= r;){
                m = l + ((r - l) >> 1);
                need = f(nums, m);
                if (need <= k){//我们认为需要的最小数组和满足条件，就记录
                    ans = m;
                    r = m - 1;
                }else {
                    l = m + 1;
                }
            }
            return (int) ans;//不返回long是因为题目规定了必须返回int
        }

        public static int f(int[] nums, long limit){
            int parts = 1;
            int sum = 0;
            for (int num : nums) {
                if (num > limit){
                    return Integer.MAX_VALUE;
                }
                if (sum + num > limit){
                    parts++;
                    sum = num;
                }else {
                    sum += num;
                }
            }
            return parts;
        }
    }
}
