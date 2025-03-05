package class049;

import java.util.Arrays;

public class c6ImplSubarraysWithKDifferentIntegers {

    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            return numOfMostKinds(nums, k) - numOfMostKinds(nums, k - 1);
        }

        public static int MAXN = 200001;
        public static int[] cnts = new int[MAXN];

        public static int numOfMostKinds(int[] arr, int k){
            Arrays.fill(cnts, 1, arr.length + 1, 0);
            int ans = 0;
            for (int l = 0, r = 0, collect = 0; r < arr.length; r++){
                if (++cnts[arr[r]] == 1){
                    collect++;
                }
                while (collect > k){
                    if (--cnts[arr[l++]] == 0){
                        collect--;
                    }
                }
                ans += r - l + 1;
            }
            return ans;
        }
    }
}
