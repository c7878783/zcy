package class051;

import java.util.Arrays;

public class c4ImplFindKthSmallestPairDistance {

    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int l = 0, r = nums[n - 1] - nums[0], m; l <= r; ) {
                m = l + ((r - l) >> 1);
                //如果当前 m 允许的数对个数 cnt ≥ k，说明 m 可能是答案，但仍有可能存在更小的 m，所以 r = m - 1。
                //否则 cnt < k，说明 m 太小了，不足以构造 k 个数对，需要增大 m，所以 l = m + 1。
                //为什么要找 f(m) ≥ k？
                //如果 f(m) < k，说明 m 太小，不足以包含 k 个数对，应该增大 m（l = m + 1）。
                //如果 f(m) >= k，说明 m 够大了，但是可能还有更小的 m 也符合条件，所以要缩小 m（r = m - 1）。
                //最终 l 就会收敛到最小的 m，满足 f(m) ≥ k。
                //关键在于，当m取当前这个数值的时候，满足了k，也就是说它可能是答案，所以记录，但是还有可能有更好的答案，所以再寻找
                //而当不满足k的时候，他就不可能是答案
                //关键在于它满足了一个可能是答案的条件
                if (f(nums, m) >= k){
                    // 过度满足，说明不超过m的点有点多了，找个小点的m去
                    // 不能用<=，不超过m的点有点少了，这种情况去更多的地方找可能会错过=k的值
                    // f定成m个，当差值小于m时，能找到多少对
                    // 要找的是第 k 小的数对距离**，这要求的是最小的 m，使得 f(m) ≥ k
                    // 错误方法（f(m) ≤ k 的最大 m）在遇到重复数值时，可能会直接跳过正确答案，而正确方法（f(m) ≥ k 的最小 m）可以正确收敛。\
                    // f(m) ≤ k 时，我们执行 l = m + 1，相当于“跳过”当前 m，继续找更大的 m。
                    // 但如果 m 正好是正确答案，而 l = m + 1，就直接跳到下一个 m' > m，导致正确答案被跳过。(数量一旦超了，就不记录了)
                    // 特别是当 m 处于一段重复数值区间时，l = m + 1 会直接跳过整个重复区间。
                    // 但使用>=的时候，数量超了我们也会记录，并且尝试减少，如果一减少就不行了，说明不应该减少，自然也就会返回重复的m了
                    // <=错误示例:nums = [1, 3, 3, 3, 6], k = 4
                    ans = m;
                    r = m - 1;
                }else {
                    l = m + 1;
                }
            }
            return ans;
        }

        public static int f(int[] nums, int limit){
            int ans = 0;
            for (int l = 0, r = 0; l < nums.length; l++){
                // 如果下一个和我的差也在limit内，把他包含进来
                while (r + 1 < nums.length && nums[r + 1] - nums[l] <= limit){
                    r++;
                }
                ans += r - l;
            }
            return ans;
        }
    }
}
