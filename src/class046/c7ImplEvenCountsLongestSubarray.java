package class046;

import java.util.Arrays;

public class c7ImplEvenCountsLongestSubarray {
    class Solution {
        public int findTheLongestSubstring(String s) {
            int n = s.length();
            int[] map = new int[32];
            Arrays.fill(map, -2);
            map[0] = -1;
            int ans = 0;
            for (int i = 0, status = 0, m; i < n; i++){
                m = move(s.charAt(i));
                if (m != -1){
                    status ^= 1 << m;
                }
                if (map[status] != -2){
                    ans = Math.max(ans, i - map[status]);
                }else {
                    map[status] = i;
                }
            }
            return ans;
        }

        public static int move(char cha){
            switch (cha){
                case 'a': return 0;
                case 'e': return 1;
                case 'i': return 2;
                case 'o': return 3;
                case 'u': return 4;
                default: return -1;
            }
        }
    }

}
