package class053;

import java.util.Arrays;

public class c2ImplRemoveDuplicateLetters {


    class Solution {

        public static int MAXN = 26;
        public static char[] stack = new char[MAXN];
        public static int[] cnt = new int[MAXN];
        public static boolean[] enter = new boolean[MAXN];
        public static int r;
        public String removeDuplicateLetters(String s) {
            r = 0;
            Arrays.fill(cnt, 0);
            Arrays.fill(enter, false);
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                cnt[c - 'a']++;
            }
            for (char c : charArray) {
                if (!enter[c - 'a']) {
                    while (r > 0 && stack[r - 1] > c && cnt[stack[r - 1] - 'a'] > 0) {
//                        enter[stack[r - 1] - 'a'] = false;
//                        r--;
                        enter[stack[--r] - 'a'] = false;
                    }
                    stack[r++] = c;
                    enter[c - 'a'] = true;
                }
                cnt[c - 'a']--;
            }
            return String.valueOf(stack, 0, r);
        }
    }


}
