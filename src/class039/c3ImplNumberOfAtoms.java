package class039;

import java.util.TreeMap;

public class c3ImplNumberOfAtoms {

    class Solution {

        public static int where;

        public String countOfAtoms(String formula) {
            where = 0;
            TreeMap<String, Integer> map = f(formula.toCharArray(), 0);
            StringBuilder ans = new StringBuilder();
            for (String key : map.keySet()) {
                ans.append(key);
                int cnt = map.get(key);
                if (cnt > 1){
                    ans.append(cnt);
                }
            }
            return ans.toString();
        }

        public static TreeMap<String, Integer> f(char[] s, int i){
            TreeMap<String, Integer> ans = new TreeMap<>();
            StringBuilder name = new StringBuilder();
            TreeMap<String, Integer> pre = null;
            int cnt = 0;
            while (i < s.length && s[i] != ')'){
                if (s[i] >= 'A' && s[i] <= 'Z' || s[i] == '('){
                    fill(ans, name, pre, cnt);
                    name.setLength(0);
                    pre = null;
                    cnt = 0;
                    if (s[i] >= 'A' && s[i] <= 'Z'){
                        name.append(s[i++]);
                    }else {
                        pre = f(s, i + 1);
                        i = where + 1;
                    }
                } else if (s[i] >= 'a' && s[i] <= 'z') {
                    name.append(s[i++]);
                }else {
                    cnt = cnt * 10 + s[i++] - '0';
                }
            }
            fill(ans, name, pre, cnt);
            where = i;
            return ans;
        }

        public static void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt){

            if (name.length() > 0 || pre != null){
                cnt = cnt == 0? 1 : cnt;
                if (name.length() > 0){
                    String key = name.toString();
                    ans.put(key, ans.getOrDefault(key, 0) + cnt);
                }else {
                    for (String key : pre.keySet()) {
                        ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);
                    }
                }
            }

        }
    }

}
