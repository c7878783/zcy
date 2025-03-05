package class049;

import java.util.Arrays;

public class c2ImpllongestSubstringWithoutRepeatingChar {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] str = s.toCharArray();
            int n = str.length;
            int[] last = new int[256];
            Arrays.fill(last, -1);
            int ans = 0;
            for (int l = 0, r = 0; r < n; r++) {
                l = Math.max(l, last[str[r]] + 1);
                ans = Math.max(ans, r - l + 1);
                last[str[r]] = r;
            }
            return ans;
        }
    }
}
