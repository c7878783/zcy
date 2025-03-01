package class045;

import java.util.Arrays;

public class c2ImplTwoNumbersMaximumXor {

    class Solution {
        public static int findMaximumXOR(int[] nums) {
            build(nums);
            int ans = 0;
            for (int num : nums) {
                ans = Math.max(ans, maxXor(num));
            }
            clear();
            return ans;
        }

        public static int MAXN = 3000001;
        public static int[][] tree = new int[MAXN][2];
        public static int cnt;
        public static int high;

        public static int maxXor(int num){
            int ans = 0;
            int cur = 1;
            for (int i = high, status, want; i >= 0; i--){
                status = (num >> i) & 1;
                want = status ^ 1;
                if (tree[cur][want] == 0){//如果我想要的指向0节点，是空的
                    want ^= 1;
                }
                ans |= (status ^ want) << i;
                cur = tree[cur][want];
            }
            return ans;
        }
        public static void build(int[] nums){
            cnt = 1;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            high = 31 - Integer.numberOfLeadingZeros(max);
            for (int num : nums) {
                insert(num);
            }
        }

        public static void insert(int num){
            int cur = 1;
            for (int i = high, path; i >= 0; i--) {
                path = (num >> i) & 1;
                if (tree[cur][path] == 0){
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
            }
        }

        public static void clear(){
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
            }
        }
    }



}
