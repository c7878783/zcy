package class052;

public class c3ImplSumOfSubarrayMinimums {

    class Solution {

        public static int MOD = 1000000007;
        public static int MAXN = 30001;
        public static int r;
        public static int[] stack = new int[MAXN];
        public int sumSubarrayMins(int[] arr) {
            r = 0;
            long ans = 0;
            for (int i = 0, cur; i < arr.length; i++) {
                // >=还是等于，等于的时候要不要弹
                // 可以弹，比如有两个5，先结算旧的5，旧的5在栈中下面的位置假如数值是2，那就结算这个2后面到5，然后在结算5到新的5
                // 然后新的5进来，还是压着2，当进来一个比5小的数的时候，弹到这个新的5，会结算新的5到2，其中包含了旧的5的数组
                while (r > 0 && arr[stack[r - 1]] >= arr[i]){
                    cur = stack[--r];
                    int left = r > 0? stack[r - 1]: -1;
                    ans = (ans + (long) (cur - left) * (i - cur) * arr[cur]) % MOD;
                }
                stack[r++] = i;
            }
            while (r > 0){
                int cur = stack[--r];
                int left = r > 0? stack[r - 1] : -1;
                // 关于最后这一块的逻辑：
                // 在残留在stack中的数值，右边不会有比他们还小或相等的了，因为如果有，他们早该弹出了，所以他们当前位置到右侧数组尽头构成的子数组
                // ，都应该算进来
                // 左侧如果有压着的，那压着的就是离自己最近的最小，没有，那就是一直到数组的开头都要包含进来
                ans = (ans + (long) (cur - left) * (arr.length - cur) * arr[cur]) % MOD;
            }
            return (int) ans;
        }
    }
}
