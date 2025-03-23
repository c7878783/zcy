package class059;

import java.util.ArrayList;
import java.util.Arrays;

public class c4ImplAlienDictionary {

    class Solution {
        public String alienOrder(String[] words) {
            int[] indegree = new int[26];
            Arrays.fill(indegree, -1);
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    indegree[word.charAt(i) - 'a'] = 0;
                }
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0, j, len; i < words.length - 1; i++) {
                String cur = words[i];
                String next = words[i + 1];
                j = 0;
                len = Math.min(cur.length(), next.length());
                for (;j < len; j++){
                    if (cur.charAt(j) != next.charAt(j)){
                        graph.get(cur.charAt(j) - 'a').add(next.charAt(j) - 'a');
                        indegree[next.charAt(j) - 'a']++;
                        break;
                    }
                }
                if (j < cur.length() && j == next.length()){
                    return "";
                }
            }
            int[] queue = new int[26];
            int l = 0, r = 0;
            int kinds = 0;
            for (int i = 0; i < 26; i++) {
                if (indegree[i] != -1){
                    kinds++;
                }
                if (indegree[i] == 0){
                    queue[r++] = i;
                }
            }
            StringBuilder builder = new StringBuilder();
            while (l < r){
                int cur = queue[l++];
                builder.append((char) (cur + 'a'));
                for (Integer i : graph.get(cur)) {
                    if (--indegree[i] == 0){
                        queue[r++] = i;
                    }
                }
            }
            return builder.length() == kinds ? builder.toString() : "";
        }
    }

}
