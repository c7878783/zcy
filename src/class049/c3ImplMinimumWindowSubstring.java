package class049;

public class c3ImplMinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()){
                return "";
            }
            char[] str = s.toCharArray();
            char[] tar = t.toCharArray();
            int[] cnts = new int[256];
            for (char c : tar) {
                cnts[c]--;
            }
            int len = Integer.MAX_VALUE;
            int start = 0;
            for (int l = 0, r = 0, debt = t.length(); r < s.length(); r++){
                if (cnts[str[r]]++ < 0){
                    debt--;
                }
                if (debt == 0){
                    while (cnts[str[l]] > 0){
                        cnts[str[l++]]--;
                    }
                    if (r - l + 1 < len){
                        start = l;
                        len = r - l + 1;
                    }
                }
            }
            return len == Integer.MAX_VALUE? "" : s.substring(start, start + len);
        }
    }
}
