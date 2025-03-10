package class045;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class c3ImplWordSearchII {


    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            build(words);
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, 1, ans);
                }
            }
            clear();
            return ans;
        }

        public static int dfs(char[][] board, int i, int j, int t, List<String> ans){
            if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 0){
                return 0;
            }
            char tmp = board[i][j];
            int road = tmp - 'a';
            t = tree[t][road];//数沿着tmp这个字符走一个看看，有没有单词对这个字符有需求
            if (pass[t] == 0){
                return 0;
            }
            int fix = 0;
            if (end[t] != null){
                ans.add(end[t]);
                fix++;
                end[t] = null;
            }
            board[i][j] = 0;
            fix += dfs(board, i + 1, j, t, ans);
            fix += dfs(board, i - 1, j, t, ans);
            fix += dfs(board, i, j + 1, t, ans);
            fix += dfs(board, i, j - 1, t, ans);
            pass[t] -= fix;
            board[i][j] = tmp;
            return fix;
        }

        public static int MAXN = 10001;
        public static int[][] tree = new int[MAXN][26];
        public static int[] pass = new int[MAXN];
        public static String[] end = new String[MAXN];
        public static int cnt;

        public static void build(String[] words){
            cnt = 1;
            for (String word : words) {
                int cur = 1;
                pass[cur]++;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (tree[cur][path] == 0){
                        tree[cur][path] = ++cnt;
                    }
                    cur = tree[cur][path];
                    pass[cur]++;
                }
                end[cur] = word;
            }
        }

        public static void clear(){
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
                pass[i] = 0;
                end[i] = null;
            }
        }
    }

}