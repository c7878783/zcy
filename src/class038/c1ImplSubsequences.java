package class038;

import java.util.*;


public class c1ImplSubsequences {
    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param s string字符串
         * @return string字符串一维数组
         */
        public String[] generatePermutation (String s) {
            // write code here
            char[] charArray = s.toCharArray();
            HashSet<String> set = new HashSet<>();
            StringBuilder builder = new StringBuilder();
            f(charArray, 0, builder, set);
            int size = set.size();
            String[] ans = new String[size];
            int i = 0;
            for (String string : set) {
                ans[i++] = string;
            }
            return ans;
        }

        public static void f(char[] s, int i, StringBuilder path, HashSet<String> set){
            if (i == s.length){
                set.add(path.toString());
            }else {
                path.append(s[i]);
                f(s, i + 1, path, set);
                path.deleteCharAt(path.length() - 1);
                f(s, i + 1, path, set);
            }
        }

        public String[] generatePermutation2 (String s) {
            // write code here
            char[] charArray = s.toCharArray();
            HashSet<String> set = new HashSet<>();
            f2(charArray, 0, 0, new char[charArray.length], set);
            int size = set.size();
            String[] ans = new String[size];
            int i = 0;
            for (String string : set) {
                ans[i++] = string;
            }
            return ans;
        }

        public static void f2(char[] s, int i, int size, char[] path, HashSet<String> set){
            if (i == s.length){
                set.add(String.valueOf(path, 0, size));
            }else {
                path[size] = s[i];
                f2(s, i + 1, size + 1, path, set);
                f2(s, i + 1, size, path, set);
            }
        }



    }


}