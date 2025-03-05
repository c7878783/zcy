package class049;

import java.util.Arrays;

public class c7ImplLongestSubstringWithAtleastKrepeating {

    class Solution {
        public int longestSubstring(String s, int k) {
            char[] str = s.toCharArray();
            int n = str.length;
            int[] cnts = new int[256];
            int ans = 0;
            for (int require = 1; require <= 26; require++){
                Arrays.fill(cnts, 0);
                for (int l = 0, r = 0, collect = 0, satisfy = 0; r < n; r++){
                    cnts[str[r]]++;
                    if (cnts[str[r]] == 1){
                        collect++;
                    }
                    if (cnts[str[r]] == k){
                        satisfy++;
                    }
                    while (collect > require){
                        if (cnts[str[l]] == 1){
                            collect--;
                        }
                        if (cnts[str[l]] == k){
                            satisfy--;
                        }
                        cnts[str[l++]]--;
                    }
                    if (satisfy == require){
                        ans = Math.max(ans, r - l + 1);//满足更多的，到下一个require for循环中找
                    }
                }
            }
            return ans;
        }
    }
}
