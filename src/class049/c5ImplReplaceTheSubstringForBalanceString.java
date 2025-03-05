package class049;

public class c5ImplReplaceTheSubstringForBalanceString {

    class Solution {
        public int balancedString(String s) {
            int n = s.length();
            int[] str = new int[n];
            int[] cnts = new int[4];
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'Q'){
                    str[i] = 0;
                } else if (c == 'W') {
                    str[i] = 1;
                } else if (c == 'E') {
                    str[i] = 2;
                }else {
                    str[i] = 3;
                }
                cnts[str[i]]++;
            }
            int debt = 0;
            for (int i = 0; i < cnts.length; i++) {
                if (cnts[i] < n / 4){
                    cnts[i] = 0;
                }else {
                    cnts[i] = n / 4 - cnts[i];
                    debt -= cnts[i];
                }
            }
            if (debt == 0){
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            for (int l = 0, r = 0; r < n; r++) {
                if (cnts[str[r]]++ < 0) {
                    debt--;

                }
                if (debt == 0){
                    while (cnts[str[l]] > 0){
                        cnts[str[l++]]--;
                    }
                    ans = Math.min(ans, r - l + 1);
                }
            }
            return ans;
        }
    }
}
